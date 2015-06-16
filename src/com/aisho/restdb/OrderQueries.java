package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class OrderQueries extends QueryBase {
	
	static java.util.Date date= new java.util.Date();
	static Calendar calendar = Calendar.getInstance();
	static Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
	
	

	/**
	 * @param cid The cid of the customer who is ordering
	 * @param order The order of the given cid
	 */
	protected static void enterOrder(int cid, String order) {
		if(checkOrderAvailable(cid,order)==true){
		sqlInsert("Order_Placed_Ordered","seq_no.nextval"+","+ cid + "," + "'"+currentTimestamp+"'"+ "," + order );
		}
		else{
			System.out.println("Can't make order");
		}
	}
	
	/**
	 * @param cid The cid of the customer who is ordering
	 * @param sin The sin of the staff member who is waiting
	 */
	protected static void enterService(int cid, int sin) {
		sqlInsert("Customer_Service",cid + "," + "'" + currentTimestamp + "'" + "," + sin);
	}
	
	/**
	 * @param cid The cid of the customer who is ordering
	 * @param order The order of the given cid
	 */
	
	
	protected static boolean checkOrderAvailable(int cid, String order) {
		boolean doneSomething = false;
		String check = "Order_Placed_Ordered.mName = Recipe_To_Menu.mName AND Recipe_To_Menu.mName = Requires.mName AND mName = " + order;
		ResultSet rs = sqlSelect("DISTINCT Requires.sName","Recipe_To_Menu,Order_Placed_Ordered,Requires", "where Recipe_To_Menu.mName = Order_Placed_Ordered.mName AND Requires.mName = Recipe_To_Menu.mName AND Order_Placed_Ordered.mName = " + order);
		try {
				while(rs.next()){
					System.out.println("We here");
					StockQueries.modifyStock("'"+rs.getString(1)+"'");
					doneSomething = true;
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(doneSomething == true){
			return true;
		}
		else{
			System.out.println("We not");
			return false;
		}
		
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testOrderQueries() {
		Connection con = TestHelper.connect();
		ResultSet rs = sqlSelect( "*", "Recipe", "");
		printResultSet(rs);
	}
}
