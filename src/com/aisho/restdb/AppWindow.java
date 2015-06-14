package com.aisho.restdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.CardLayout;

public class AppWindow extends JFrame {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private static final String TITLE = "Restaurant DB";
	
	private static final String RECIPE = "Recipe";
	private static final String STAFF = "Staff";
	private static final String MENU = "Menu";
	private static final String STOCK = "Stock";
	
	private JTextField txtTableNumber;
	private JTextField txtCustomerId;
	private JTextField txtMenuItem;
	
	private static int numOfCards = 0;
	private JPanel recipeCard;
	private JPanel menuCard;
	private JPanel staffCard;
	private JPanel stockCard;
	

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
		mainPanel.setBounds(10, 116, 764, 434);
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
				System.out.println("Recipe Click");
				recipeCard.setVisible(true);
			}
			
		});
		
		final JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(580, 76, 117, 29);
		getContentPane().add(btnStaff);
		btnStaff.setVisible(false);
		btnStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Staff Click");
			}
			
		});
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(580, 36, 117, 29);
		getContentPane().add(btnCustomers);
		btnCustomers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Customers Click");
			}
			
		});
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(453, 76, 117, 29);
		getContentPane().add(btnStock);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setBounds(17, 76, 117, 29);
		getContentPane().add(btnOrder);
		
		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Order Click " + txtTableNumber.getText() + " " + txtCustomerId.getText() + " " + txtMenuItem.getText());
			}
			
		});
		
		btnStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stock Click");
			}
			
		});
		
		rdbtnAdministrator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Toggle the button's visibility
				btnStaff.setVisible(!btnStaff.isVisible());
				
			}
			
		});
	}
	
	/**
	 * Set up the cards for a jpanel
	 * @param mainPanel
	 */
	private void setUpCards(JPanel mainPanel) {
		
		recipeCard = new JPanel();
		recipeCard.setVisible(false);
		numOfCards++;
		
		menuCard = new JPanel();
		menuCard.setVisible(false);
		numOfCards++;
		
		staffCard = new JPanel();
		staffCard.setVisible(false);
		numOfCards++;
		
		stockCard = new JPanel();
		stockCard.setVisible(false);
		numOfCards++;
		
		mainPanel.add(recipeCard, RECIPE);
		
		JLabel lblRecipe = new JLabel(RECIPE);
		recipeCard.add(lblRecipe);
		mainPanel.add(menuCard, MENU);
		mainPanel.add(staffCard, STAFF);
		mainPanel.add(stockCard, STOCK);
			
		
	}
}
