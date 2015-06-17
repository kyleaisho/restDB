package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ComplexQueries extends QueryBase {

	/**
	 * @param date1 The starting date to consider
	 * @param date2 The ending date
	 */
	private double checkGrossSales(String date1, String date2) {
		ResultSet rs = sqlSelect("mName", "Order_Placed_Ordered", "WHERE order_date<='" + date2 + "' AND order_date>='" + date1 + "'");
		List<String> nameList = new ArrayList<String>();
		int i = 0;
		List<Double> priceList = new ArrayList<Double>();
		int j = 0;
		double sum = 0;
		
		//Get the list of mNames from all the orders
		try {
			while(rs.next()) {
				String name = rs.getString(1).trim();
				nameList.add(i, name);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Get the individual prices of each of the mNames
		for (String name: nameList) {
			ResultSet rs2 = sqlSelect("Price", "Menu_Price", "WHERE rName=(SELECT rName FROM Recipe_To_Menu WHERE mName='" + name + "')");

			try {
				rs2.next();
				priceList.add(j, rs2.getDouble(1));
				j++;
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Sum the individual prices
		for (Double price: priceList) {
		    sum += price;
		}
		return sum;
	}
	
	/**OPTIONAL QUERY
	 * @param date1 The starting date to consider
	 * @param date2 The ending date
	 */
	private void checkFoodCosts(SimpleDateFormat date1, SimpleDateFormat date2) {
		//Not sure if SimpleDateFormat is the best/only way for handling dates in our case
		
	}
	
	/**OPTIONAL QUERY
	 * @param date1 The starting date to consider
	 * @param date2 The ending date
	 * @param rows The number of tuples to return
	 */
	private void checkPopularItems(SimpleDateFormat date1, SimpleDateFormat date2, int rows) {
		//Not sure if SimpleDateFormat is the best/only way for handling dates in our case
		
	}
	
	/**
	 * Returns either the most popular or least popular menu item depending on the input.
	 * Quirk: The menu item has to be ordered at least once for checkPopularItem to consider it. This
	 * is because menu items that have never been ordered before do not show up in the Order_Placed_Ordered table.
	 * 
	 * @param maxOrMin One of "max" or "min". Will return either the most or least popular menu item, respectively.
	 */
	private List<String> checkPopularItem(String maxOrMin) {
		List<String> nameList = new ArrayList<String>();
		int i = 0;
		
		switch (maxOrMin) {
		case "max": ResultSet rs = sqlSelect("mName, names", "(SELECT mName, COUNT(*) AS names FROM Order_Placed_Ordered GROUP BY mName)", 
					"WHERE names=(SELECT MAX(names) from (SELECT mName, COUNT(*) AS names FROM Order_Placed_Ordered GROUP BY mName))");
					try {
						while(rs.next()) {
							String name = rs.getString(1).trim();
							int count = rs.getInt(2);
							String result = name + "," + count;
							nameList.add(i, result);
							i++;
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} break;
		
		case "min": ResultSet rs2 = sqlSelect("mName, names", "(SELECT mName, COUNT(*) AS names FROM Order_Placed_Ordered GROUP BY mName)", 
				"WHERE names=(SELECT MIN(names) from (SELECT mName, COUNT(*) AS names FROM Order_Placed_Ordered GROUP BY mName))");
			try {
				while(rs2.next()) {
					String name = rs2.getString(1).trim();
					int count = rs2.getInt(2);
					String result = name + "," + count;
					nameList.add(i, result);
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} break;
		
		default: System.out.println(maxOrMin + " is not one of: 'max' or 'min'!");
		}
		return nameList;
	}
	
	//OPTIONAL QUERY
	private void checkMostFrequentCustomer() {
		
	}
	
	/**
	 * Returns the total number of orders between the given dates.
	 * 
	 * @param date1 The starting date to consider
	 * @param date2 The ending date
	 */
	private int checkTotalOrders(String date1, String date2) {
		int totalOrders = 0;

		
		ResultSet rs = sqlSelect("COUNT(*)", "Order_Placed_Ordered", "WHERE order_date>='" + date1 + "' AND order_date<='" + date2 + "'");
			
		try {
			rs.next();
			totalOrders = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalOrders;
		
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testComplexQueries() {
		Double result = checkGrossSales("2013-11-02 12:07:11.927", "2015-05-30 15:00:00.000");
		System.out.println(result);
		
		List<String> result2 = checkPopularItem("max");
		for (String r: result2) {
			System.out.println(r);
		}
		
		List<String> result3 = checkPopularItem("min");
		for (String r: result3) {
			System.out.println(r); 
		} 
		
		int result4 = checkTotalOrders("2013-11-02 12:07:11.927", "2015-05-30 15:00:00.000");
		System.out.println(result4);
	}
}
