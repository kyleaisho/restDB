package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class OrderQueries extends QueryBase {

	/**
	 * @param cid The cid of the customer who is ordering
	 * @param order The order of the given cid
	 */
	private void enterOrder(int cid, String order) {
		
	}
	
	/**
	 * @param cid The cid of the customer who is ordering
	 * @param sin The sin of the staff member who is waiting
	 */
	private void enterService(int cid, int sin) {
		
	}
	
	/**
	 * @param cid The cid of the customer who is ordering
	 * @param order The order of the given cid
	 */
	private void checkOrderAvailable(int cid, String order) {
		
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testOrderQueries() {
		Connection con = TestHelper.connect();
		ResultSet rs = sqlSelect(con, "*", "Recipe", "");
		printResultSet(rs);
	}
}
