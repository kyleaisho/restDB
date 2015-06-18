package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class StaffQueries extends QueryBase {

	/**
	 * @param sin The sin of the new staff member
	 * @param name The name of the new staff member
	 */
	protected static void enterStaff(String sin, String name) {
		sqlInsert("Staff",sin + "," + name);
	}
	
	/**OPTIONAL QUERY
	 * @param sin The new sin of the staff member
	 * @param name The new name of the staff member
	 */
	private void modifyStaff(String sin, String name) {
		
	}
	
	/**
	 * @param sin The sin of the new staff member
	 * @param name The name of the new staff member
	 */
	protected static void deleteStaff(String sin) {
		sqlDelete("Staff","SIN = " + sin);
	}
	
	/**
	 * @param sin The sin of the new staff member
	 * @param name The name of the new staff member
	 */
	protected static void enterCustomer(String name) {
		sqlInsert("Customer", "countCID.nextval," + name);
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected ResultSet selectStaff() {
		ResultSet rs = sqlSelect( "*", "Staff", "");
		return rs;
	}
	
	protected static ResultSet whoHasOrderedEverything(){
		String s = "";
		ResultSet rs = sqlSelect("C.Name","Customer C", "Where NOT EXISTS((Select RM.mName From Recipe_To_Menu RM) Minus( Select OP.mName From Order_Placed_Ordered OP Where OP.CID = C.CID))");
		return rs;
	}
}
