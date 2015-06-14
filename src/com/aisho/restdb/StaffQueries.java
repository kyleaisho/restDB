package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class StaffQueries extends QueryBase {

	/**
	 * @param sin The sin of the new staff member
	 * @param name The name of the new staff member
	 */
	private void enterStaff(int sin, String name) {
		
	}
	
	/**OPTIONAL QUERY
	 * @param sin The new sin of the staff member
	 * @param name The new name of the staff member
	 */
	private void modifyStaff(int sin, String name) {
		
	}
	
	/**
	 * @param sin The sin of the new staff member
	 * @param name The name of the new staff member
	 */
	private void deleteStaff(int sin) {
		//Should kick off the cascade effect with associated recipes
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testStaffQueries() {
		Connection con = TestHelper.connect();
		ResultSet rs = sqlSelect(con, "*", "Recipe", "");
		printResultSet(rs);
	}
}
