package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class StockQueries extends QueryBase {

	/**
	 * @param sName The name of the new stock item
	 * @param qty The quantity of the new stock item
	 * @param unitPrice The unit price of the new stock item
	 */
	private void addStock(int sName, int qty, float unitPrice) {
		
	}
	
	/**
	 * @param sName The name of the stock item
	 * @param qty The new quantity of the stock item
	 * @param unitPrice The new unit price of the stock item
	 */
	private void modifyStock(int sName, int qty, float unitPrice) {
		//Can be used to add or subtract from the current stock
		//unitPrice might be unnecessary if we never need to modify it? 
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testStockQueries() {
		Connection con = TestHelper.connect();
		ResultSet rs = sqlSelect("*", "Recipe", "");
		printResultSet(rs);
	}
}
