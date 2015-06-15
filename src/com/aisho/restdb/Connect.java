package com.aisho.restdb;
import java.sql.*;

public class Connect {
	
	private static java.sql.Connection con;
	private static Connect connectionClass;
	
	/**
	  * Constructor.
	  * 
	  * Makes a connection to Our Oracle Database
	  */
	
	Connect(){
		
		connectionClass = this;
		
		try 
		{
			// Load the Oracle JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (Exception e)
		{
			System.out.println(e + "Could not find Oracle Driver");
		}

		String connectURL = "jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug"; 

		try 
		{
			con = DriverManager.getConnection(connectURL,"ora_x1i8","a55386114");
		
		}
		catch (SQLException ex)
		{
			System.out.println(ex.getMessage()+ "Could not connect");

		}
	}
		
	/**
	 * Checks if we are connected to our Database if not creates
	 * a new connection from our Connect class
	 */
		public static Connect getInstance()
		{
			
			if ( connectionClass == null )
			{
				connectionClass = new Connect();
			}
			return connectionClass;
			
		}
		
		/**
		 * Gets our connection code from the connection we made
		 */
		
		public java.sql.Connection getConnection() {
			return con;
		}
		
		
		
	}
	

