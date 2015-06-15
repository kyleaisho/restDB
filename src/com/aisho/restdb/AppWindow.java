package com.aisho.restdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
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

import javax.swing.JTextPane;
import javax.swing.JScrollBar;

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
	
	private static int numOfCards = 0;
	private JPanel recipeCard;
	private JPanel customerCard;
	private JPanel staffCard;
	private JPanel stockCard;
	private JPanel blankCard;
	private CardLayout layout;
	private JTextPane textPane;
	

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
		

		final JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 116, 764, 252);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		setUpCards(mainPanel);
		
		JRadioButton rdbtnAdministrator = new JRadioButton("Administrator");
		rdbtnAdministrator.setBounds(453, 6, 141, 23);
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
		JButton btnRecipes = new JButton("Recipes");
		btnRecipes.setBounds(453, 36, 117, 29);
		getContentPane().add(btnRecipes);
		btnRecipes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, RECIPE);
			}
			
		});
		
		final JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(580, 76, 117, 29);
		getContentPane().add(btnStaff);
		btnStaff.setVisible(false);
		btnStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, STAFF);
			}
			
		});
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(580, 36, 117, 29);
		getContentPane().add(btnCustomers);
		btnCustomers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, CUSTOMER);
			}
			
		});
		
		JButton btnStock = new JButton("Stock");
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
		
		textPane = new JTextPane();
		getContentPane().add(textPane);
		
		JScrollPane jsp = new JScrollPane(textPane);
		jsp.setBounds(10, 379, 732, 181);
		getContentPane().add(jsp);
		
		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Order Click " + txtTableNumber.getText() + " " + txtCustomerId.getText() + " " + txtMenuItem.getText());
			}
			
		});
		
		btnStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layout.show(mainPanel, STOCK);
			}
			
		});
		
		rdbtnAdministrator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Toggle the button's visibility
				btnStaff.setVisible(!btnStaff.isVisible());
				
			}
			
		});
		if (true) copySystemStream();
	}

	/**
	 * Set up the cards for a jpanel
	 * @param mainPanel
	 */
	private void setUpCards(JPanel mainPanel) {
		
		blankCard = new JPanel();
		numOfCards++;
		
		recipeCard = new JPanel();
		numOfCards++;
		
		customerCard = new JPanel();
		numOfCards++;
		
		staffCard = new JPanel();
		numOfCards++;
		
		stockCard = new JPanel();
		numOfCards++;
		
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
		
		mainPanel.add(customerCard, CUSTOMER);
		customerCard.setLayout(null);
		mainPanel.add(staffCard, STAFF);
		staffCard.setLayout(null);
		mainPanel.add(stockCard, STOCK);
		stockCard.setLayout(null);
			
		
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
		JLabel lblRecipes = new JLabel(RECIPE);
		lblRecipes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipes.setBounds(206, 16, 328, 16);
		recipeCard.add(lblRecipes);	
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
	 * Overrides the system streams to write to text
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
}
