package com.aisho.restdb;
import java.sql.*;

public class Connect {
	
	private static java.sql.Connection con;
	private static Connect connectionClass;
	//private static String uname = "";
	//private static String pword = "";
	
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
			String login = "ora_".concat("x1i8");
			String pass = "a".concat("55386114");
			con = DriverManager.getConnection(connectURL,login,pass);
		
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
		
		public static java.sql.Connection getConnection() {
			return con;
		}
		/*
		/**
		 * Sets the username and password for the db
		 * @return 
		 static void loginToDB(String u, String p) {
			uname = u;
			pword = p;
		}
		
		*/
		
	}
	

