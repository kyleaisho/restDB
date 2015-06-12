package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;
//for reading from the command line
import java.io.*;

public class QueryBase {
	
	/**
	 * @param con The connection object created to access the Oracle DB.
	 * @param table The name of the table.
	 * @param args The tuple to be inserted. This is an arbitrary length of objects separated by commas,
	 * e.g. 2, "Server", 3.5
	 */
	protected void sqlInsert(Connection con, String table, Object... args) {
		
		PreparedStatement ps;
		try {			
			ps = con.prepareStatement("INSERT INTO " + table + " VALUES ("+ args + ")");
			
			  ps.executeUpdate();

			  // commit work 
			  con.commit();

			  ps.close();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    try {
		
		    	// undo the insert
		    	con.rollback();	
		    }
		    
		    catch (SQLException ex2) {		    
		    	System.out.println("Message: " + ex2.getMessage());
		    	System.exit(-1);
		    }
		}
	}
}
