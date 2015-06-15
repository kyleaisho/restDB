package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class TestHelper {
	

    /*
     * connects to Oracle database named ug using user supplied username and password
     */ 
    protected static Connection connect() {
    	
    	
    	String connectURL = "jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug"; 
    	String username = "ora_xxxx"; //Set your Oracle username here
    	String password = "a12345678"; //Set your password here
    		

    	try {
    		
    		// Load the Oracle JDBC driver. Requires the classes12.zip folder added as an External
    		// JAR into your local RestDB project
    		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

    		Connection con;
    		
    		if (username == "ora_xxxx") {
    			System.out.println("Username not set in TestHelper.java!");
    			System.exit(0);
    		}
    		
    		if (password == "a12345678") {
    			System.out.println("Password not set in TestHelper.java!");
    			System.exit(0);
    		}
    		
    		con = DriverManager.getConnection(connectURL,username,password);
    		System.out.println("Connected to Oracle!");
    		return con;
	
    	}
    	catch (SQLException ex) {
    		System.out.println("Couldn't connect to the Oracel DB! Message: " + ex.getMessage());
    		return null;
      }
    }
}
