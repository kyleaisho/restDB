package com.aisho.restdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.CardLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

public class AppWindow extends JFrame {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private static final String TITLE = "Restaurant DB";
	private static final String CONSOLE_TITLE = "(RestDB) -> ";
	
	private static final String RECIPE = "Recipe";
	private static final String STAFF = "Staff";
	private static final String CUSTOMER = "Customers";
	private static final String STOCK = "Stock";
	private static final String HOME = "Home";
	
	private JTextField txtTableNumber;
	private JTextField txtCustomerId;
	private JTextField txtMenuItem;
	
	private JPanel recipeCard;
	private JPanel customerCard;
	private JPanel staffCard;
	private JPanel stockCard;
	private JPanel blankCard;
	private CardLayout layout;
	private JPanel consolePanel;
	private JPanel blankConsoleCard;
	private JPanel showConsoleCard;
	private CardLayout consoleLayout;
	private JTextPane textPane;
	private JScrollPane jsp;
	private JTextField txtCsid;
	private JTextField txtStudentid;
	
	// Query objects
	private JTable staffTable;
	private JTextField txtItem;
	private JTextField txtItem_1;
	private JTextField txtItem_2;
	private JTextField txtQty;
	private JTextField txtQty_1;
	private JTextField txtQty_2;
	private JLabel lblUnitPrice;
	private JTextField txtPrice;
	private JTextField txtPrice1;
	private JTextField txtPrice2;
	private JPanel mainPanel;
	private JTable recipesTable;
	private JButton btnAddToMenu;
	private JButton btnDelRecipe;
	private JButton btnNewRecipe;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow frame = new AppWindow();
					frame.setVisible(true);
					frame.setTitle(TITLE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		getContentPane().setLayout(null);
		

		mainPanel = new JPanel();
		mainPanel.setBounds(10, 116, 764, 252);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		setUpCards(mainPanel);
		
		final JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setBounds(114, 2, 141, 23);
		getContentPane().add(rdbtnAdministrator);
		
		
		
		JLabel lblPlaceOrder = new JLabel("Place Order");
		lblPlaceOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceOrder.setBounds(17, 6, 85, 16);
		getContentPane().add(lblPlaceOrder);
		
		txtTableNumber = new JTextField();
		txtTableNumber.setText("Table Number");
		txtTableNumber.setBounds(17, 34, 134, 28);
		getContentPane().add(txtTableNumber);
		txtTableNumber.setColumns(10);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setText("Customer ID");
		txtCustomerId.setBounds(161, 34, 134, 28);
		getContentPane().add(txtCustomerId);
		txtCustomerId.setColumns(10);
		
		txtMenuItem = new JTextField();
		txtMenuItem.setText("Menu Item");
		txtMenuItem.setBounds(305, 34, 134, 28);
		getContentPane().add(txtMenuItem);
		txtMenuItem.setColumns(10);
		
		
		//Create buttons
		final JButton btnRecipes = new JButton("Recipes");
		btnRecipes.setBounds(453, 36, 117, 29);
		getContentPane().add(btnRecipes);
		btnRecipes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, RECIPE);
				populateRecipeCard();
			}
			
		});
		
		final JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(580, 76, 117, 29);
		getContentPane().add(btnStaff);
		btnStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, STAFF);
				populateStaffCard();
			}
			
		});
		
		final JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(580, 36, 117, 29);
		getContentPane().add(btnCustomers);
		btnCustomers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, CUSTOMER);
			}
			
		});
		
		final JButton btnStock = new JButton("Stock");
		btnStock.setBounds(453, 76, 117, 29);
		getContentPane().add(btnStock);
		btnStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, STOCK);
			}
			
		});
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(17, 76, 117, 29);
		getContentPane().add(btnOrder);
		
		
		// Set all buttons to inactive until DB connect happens
		btnRecipes.setEnabled(false);
		btnStock.setEnabled(false);
		btnStaff.setEnabled(false);
		btnOrder.setEnabled(false);
		btnCustomers.setEnabled(false);
		
		consolePanel = new JPanel();
		consolePanel.setBounds(10, 380, 764, 169);
		getContentPane().add(consolePanel);
		consolePanel.setLayout(new CardLayout(0, 0));
		
		txtCsid = new JTextField();
		txtCsid.setText("csID");
		txtCsid.setBounds(268, 3, 117, 28);
		getContentPane().add(txtCsid);
		txtCsid.setColumns(10);
		
		txtStudentid = new JTextField();
		txtStudentid.setText("studentID");
		txtStudentid.setBounds(395, 2, 134, 28);
		getContentPane().add(txtStudentid);
		txtStudentid.setColumns(10);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(536, 2, 117, 29);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connect.loginToDB(txtCsid.getText().toString(), txtStudentid.getText().toString()); 
				Connect.getInstance();
				btnLogin.setEnabled(false);
				btnRecipes.setEnabled(true);
				btnCustomers.setEnabled(true);
				btnStock.setEnabled(true);
				if (rdbtnAdministrator.isSelected())
					btnStaff.setEnabled(true);
			}
			
		});
		
		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtTableNumber.getText() + " " + txtCustomerId.getText() + " " + txtMenuItem.getText());
			}
			
		});
		
		btnStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, STOCK);
			}
			
		});
		setUpConsolePanel();
		
		rdbtnAdministrator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Toggle the button's visibility
				btnStaff.setEnabled(!btnStaff.isEnabled() && btnRecipes.isEnabled());
				
				consoleLayout.next(consolePanel);
				copySystemStream();
				
			}
			
		});
	}

	/**
	 * Set up the cards for a jpanel
	 * @param mainPanel
	 */
	private void setUpCards(JPanel mainPanel) {
		
		blankCard = new JPanel();
		recipeCard = new JPanel();
		customerCard = new JPanel();
		staffCard = new JPanel();
		stockCard = new JPanel();
		
		layout = (CardLayout) mainPanel.getLayout();
		layout.show(mainPanel, HOME);
		
		
		// Create the individual Cards
		setupRecipeCard();
		setupCustomerCard();
		setpStaffCard();
		setupStockCard();
		
		
		mainPanel.add(blankCard, HOME);
		mainPanel.add(recipeCard, RECIPE);
		recipeCard.setLayout(null);
		
		recipesTable = new JTable();
		recipesTable.setBounds(6, 62, 752, 184);
		
		JScrollPane recipeScroll = new JScrollPane(recipesTable);
		recipeScroll.setBounds(6, 62, 752, 184);
		recipeCard.add(recipeScroll);
		
		mainPanel.add(customerCard, CUSTOMER);
		customerCard.setLayout(null);
		mainPanel.add(staffCard, STAFF);
		staffCard.setLayout(null);
		
		staffTable = new JTable();
		staffTable.setBounds(0, 37, 764, 215);
		
		JScrollPane scrollPane = new JScrollPane(staffTable);
		scrollPane.setBounds(0, 37, 764, 215);
		staffCard.add(scrollPane);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setBounds(514, 6, 117, 29);
		staffCard.add(btnAddStaff);

		btnAddStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeStaff as = new ChangeStaff();
				as.addStaff();
				populateStaffCard();
			}
			
		});
		
		JButton btnDelSelected = new JButton("Del Selected");
		btnDelSelected.setBounds(643, 6, 117, 29);
		staffCard.add(btnDelSelected);
		btnDelSelected.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangeStaff cs = new ChangeStaff();
				int sel = staffTable.getSelectedRow();
				cs.delStaff(staffTable.getValueAt(sel, 0).toString());
				populateStaffCard();
			}
		});
		
		populateStockCard();
	}
	
	private void populateStockCard() {
		// Create an arraylist to hold similar values for txt fields
		final ArrayList<JTextField> items = new ArrayList<JTextField>();
		final ArrayList<JTextField> qties = new ArrayList<JTextField>();
		final ArrayList<JTextField> prices = new ArrayList<JTextField>();

		
		mainPanel.add(stockCard, STOCK);
		stockCard.setLayout(null);
		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.setBounds(537, 200, 117, 29);
		stockCard.add(btnAddStock);
		btnAddStock.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < items.size(); i++) {
					// Insert into the tables
					addStock(items.get(i).getText(), qties.get(i).getText(), prices.get(i).getText());
					// Remove the values from the text fields
					items.get(i).setText(null);
					qties.get(i).setText(null);
					prices.get(i).setText(null);
				}
			}});
		
		JLabel lblStockName = new JLabel("Stock Name");
		lblStockName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockName.setBounds(48, 52, 117, 16);
		stockCard.add(lblStockName);
		
		txtItem = new JTextField();
		txtItem.setToolTipText("item1");
		txtItem.setBounds(58, 73, 134, 28);
		stockCard.add(txtItem);
		txtItem.setColumns(10);
		items.add(txtItem);
		
		txtItem_1 = new JTextField();
		txtItem_1.setBounds(58, 105, 134, 28);
		stockCard.add(txtItem_1);
		txtItem_1.setColumns(10);
		items.add(txtItem_1);
		
		txtItem_2 = new JTextField();
		txtItem_2.setBounds(58, 137, 134, 28);
		stockCard.add(txtItem_2);
		txtItem_2.setColumns(10);
		items.add(txtItem_2);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(236, 52, 94, 16);
		stockCard.add(lblQuantity);
		
		txtQty = new JTextField();
		txtQty.setBounds(206, 73, 134, 28);
		stockCard.add(txtQty);
		txtQty.setColumns(10);
		qties.add(txtQty);
		
		txtQty_1 = new JTextField();
		txtQty_1.setBounds(206, 105, 134, 28);
		stockCard.add(txtQty_1);
		txtQty_1.setColumns(10);
		qties.add(txtQty_1);
		
		txtQty_2 = new JTextField();
		txtQty_2.setBounds(206, 137, 134, 28);
		stockCard.add(txtQty_2);
		txtQty_2.setColumns(10);
		qties.add(txtQty_2);
		
		lblUnitPrice = new JLabel("Unit Price");
		lblUnitPrice.setBounds(391, 52, 87, 16);
		stockCard.add(lblUnitPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(363, 73, 134, 28);
		stockCard.add(txtPrice);
		txtPrice.setColumns(10);
		prices.add(txtPrice);
		
		txtPrice1 = new JTextField();
		txtPrice1.setBounds(363, 105, 134, 28);
		stockCard.add(txtPrice1);
		txtPrice1.setColumns(10);
		prices.add(txtPrice1);
		
		txtPrice2 = new JTextField();
		txtPrice2.setBounds(363, 137, 134, 28);
		stockCard.add(txtPrice2);
		txtPrice2.setColumns(10);
		prices.add(txtPrice2);
		
	}

	/**
	 * Console panel with a card layout so we can toggle between visible or not visible 
	 * when toggled as the administrator
	 */
	private void setUpConsolePanel() {
		blankConsoleCard = new JPanel();
		showConsoleCard = new JPanel();
		showConsoleCard.setBounds(10, 380, 764, 169);
		consolePanel.add(blankConsoleCard, blankConsoleCard.getName());
		consolePanel.add(showConsoleCard, showConsoleCard.getName());
		consoleLayout = (CardLayout) consolePanel.getLayout();
		consoleLayout.show(consolePanel, blankConsoleCard.getName());
		showConsoleCard.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 380, 764, 169);
		jsp = new JScrollPane(textPane);
		jsp.setBounds(0, 0, 764, 169);
		showConsoleCard.add(jsp);
		
	}

	private void setupStockCard() {
		JLabel lblStock = new JLabel(STOCK);
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(206, 16, 328, 16);
		stockCard.add(lblStock);	
		
	}

	private void setpStaffCard() {
		JLabel lblStaff = new JLabel(STAFF);
		lblStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaff.setBounds(206, 16, 328, 16);
		staffCard.add(lblStaff);
		
	}

	private void setupCustomerCard() {
		JLabel lblMenu = new JLabel(CUSTOMER);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(206, 16, 328, 16);
		customerCard.add(lblMenu);
	}

	private void setupRecipeCard() {
		
		btnNewRecipe = new JButton("New Recipe");
		btnNewRecipe.setBounds(467, 6, 117, 29);
		recipeCard.add(btnNewRecipe);
		
		JLabel lblRecipes = new JLabel(RECIPE);
		lblRecipes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipes.setBounds(206, 16, 328, 16);
		recipeCard.add(lblRecipes);	
		
		btnAddToMenu = new JButton("Add To Menu");
		btnAddToMenu.setBounds(586, 6, 117, 29);
		recipeCard.add(btnAddToMenu);
		

		btnDelRecipe = new JButton("Del Recipe");
		btnDelRecipe.setBounds(586, 32, 117, 29);
		recipeCard.add(btnDelRecipe);
		
	}
	
	/**
	 * Updates the text pane with new text
	 * @param text
	 */
	private void updateTextPanel(final String text) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Document document = textPane.getDocument();
				try {
					if (text.length() > 2)
						document.insertString(document.getLength(), CONSOLE_TITLE, null);
					document.insertString(document.getLength(), text, null);
				}
				catch (BadLocationException ble){
					System.out.println(ble.getMessage());
				}
				textPane.setCaretPosition(document.getLength() - 1);
			}
		});
	}

	
	/**
	 * Overrides the system streams to write to textPane
	 */
	private void copySystemStream() {
		OutputStream os = new OutputStream() {

			
			@Override
			public void write(int b) throws IOException {
				updateTextPanel(String.valueOf((char) b));
				
			}
			
			@Override
		    public void write(byte[] b, int off, int len) throws IOException {
		      updateTextPanel(new String(b, off, len));
		    }
		 
		    @Override
		    public void write(byte[] b) throws IOException {

		    	write(b, 0, b.length);
		    }
		};
		
		System.setOut(new PrintStream(os, true));
		System.setErr(new PrintStream(os, true));
	}
	
	/**
	 * Sets up the table for the recipes to be shown
	 */
	public void populateRecipeCard() {
		
		btnAddToMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = recipesTable.getSelectedRow();
				String rname = (String) recipesTable.getValueAt(row, 0);
				String mname = getDataDialog("Enter the menu name");
				Double price = Double.parseDouble(getDataDialog("What should the price be?").trim());
				MenuQueries mq = new MenuQueries();
				mq.enterMenuItem(rname.trim(), mname.trim(), price);
				
			}
			
		});
		
		btnNewRecipe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rName = getDataDialog("Whats the Recipe Name");
				String sin = getDataDialog("Whats the SIN of the Chef?");
				String ing = getDataDialog("Enter the ingredients separated by a comma");
				
				RecipeQueries rq = new RecipeQueries();
				rq.enterRecipe(rName, Integer.parseInt(sin), ing);
				
			}
			
		});
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn(new String [] {"Name"});
		model.addColumn(new String [] {"Ingredients"});
		String [] headers = new String [] { "Name", "Ingredients"};
		model.setColumnIdentifiers(headers);
		recipesTable.setModel(model);
		ResultSet rs = QueryBase.sqlSelect("*", "Recipes", "");
		try {
			while (rs.next()) {
				model.addRow(new Object [] { rs.getString(1), rs.getString(2)});
			}
		} catch (SQLException e) {
			QueryBase.printSQLException(e);
		}
	}
	
	/**
	 * Adds all the staff to the staff card
	 */
	public void populateStaffCard() {	
		Staff s = new Staff();
		ArrayList<Staff> staff = s.getStaffFromDB();
		DefaultTableModel model = new DefaultTableModel();
		staffTable.setModel(model);
		model.addColumn(new String [] {"SIN"});
		model.addColumn(new String [] {"Name"});
		String [] header = new String [] {"SIN" , "Name"};
		model.setColumnIdentifiers(header);
		for (int i = 0; i < staff.size(); i++) {
			final Staff st = staff.get(i);
			model.addRow(new Object [] {st.getSin(), st.getName()});
		}
		
	}
	
	/**
	 * Displays a dialog showing the user information
	 * @param msg The message you want displayed
	 */
	public void showInfoDialog(String msg) {
		JOptionPane.showMessageDialog(rootPane, msg);
	}
	
	/**
	 * Displays a dialog for user input. 
	 * @param msg Message for the user, include any formatting details
	 * @return a string exactly as the user entered it
	 */
	public String getDataDialog(String msg) {
		return JOptionPane.showInputDialog(msg);
	}
	
	/**
	 * Creates stock entries in the DB
	 * @param text
	 */
	private void addStock(String name, String qty, String price) {
		if (!name.isEmpty() || !qty.isEmpty() || !price.isEmpty()) {
			int q = Integer.parseInt(qty);
			float p = Float.parseFloat(price);
			if (q < 0 || p < 0) {
				showInfoDialog("Enter positive values!");
				return;
			}
			StockQueries.addStock(StockQueries.sqlStringify(name), q, p);
		}
	}
}
