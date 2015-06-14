package com.aisho.restdb;
import java.sql.*;

public class Connect {
	
	private static java.sql.Connection con;
	
	public static void main(String[] args){
		

		
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
			System.out.println("\nConnected to Oracle!");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM authors";
			ResultSet rs = st.executeQuery(sql);
			System.out.println("Here");
			System.out.println(rs.next());
			if(rs.next()){
				System.out.println("HERE!!!");
				System.out.println(rs.getInt("SIN")+" " + rs.getString("NAME"));
		}
			st.close();

		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());

		}
		
		
		
	}
	
}
