package com.aisho.restdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AppWindow extends JFrame {
	
	private static final int HEIGHT = 400;
	private static final int WIDTH = 600;
	private static final String TITLE = "Restaurant DB";
	private JTextField txtTableNumber;
	private JTextField txtCustomerId;
	private JTextField txtMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow frame = new AppWindow();
					frame.setVisible(true);
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
		txtCustomerId.setBounds(17, 70, 134, 28);
		getContentPane().add(txtCustomerId);
		txtCustomerId.setColumns(10);
		
		txtMenuItem = new JTextField();
		txtMenuItem.setText("Menu Item");
		txtMenuItem.setBounds(17, 110, 134, 28);
		getContentPane().add(txtMenuItem);
		txtMenuItem.setColumns(10);
		
		JButton btnRecipes = new JButton("Recipes");
		btnRecipes.setBounds(477, 56, 117, 29);
		getContentPane().add(btnRecipes);
		btnRecipes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		})
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(477, 98, 117, 29);
		getContentPane().add(btnStaff);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.setBounds(477, 139, 117, 29);
		getContentPane().add(btnCustomers);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(477, 180, 117, 29);
		getContentPane().add(btnStock);
	}
}
