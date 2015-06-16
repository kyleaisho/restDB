package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class StockQueries extends QueryBase {

	/**
	 * @param sName The name of the new stock item
	 * @param qty The quantity of the new stock item
	 * @param unitPrice The unit price of the new stock item
	 */
	protected static void addStock(String sName, int qty, float unitPrice) {
		ResultSet rs=sqlSelect("sName,Quantity","Stock","");
		boolean haveIt = false;
		int howMuch = 0;
		try {
			while(rs.next()){
				System.out.println(sName);
				System.out.println("'".concat(rs.getString(1)).trim().concat("'"));
				System.out.println("'".concat(rs.getString(1)).trim().concat("'").compareTo(sName));
				if("'".concat(rs.getString(1)).trim().concat("'").compareTo(sName)==0){
					haveIt=true;
					howMuch=rs.getInt(2);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(haveIt == true){
			int amount = howMuch + qty;
			sqlUpdate("Stock", "Quantity = "+ amount , "sName = "+sName);
		}
		else{
			sqlInsert("Stock",sName + "," + qty + "," + unitPrice);
		}
	
	}
	
	/**
	 * @param sName The name of the stock item
	 * @param qty The new quantity of the stock item
	 * @param unitPrice The new unit price of the stock item
	 */
	protected static void modifyStock(String item) {
		sqlUpdate("Stock", "Stock.Quantity = Stock.Quantity - 1 ","Sname = "+ item);
		
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
