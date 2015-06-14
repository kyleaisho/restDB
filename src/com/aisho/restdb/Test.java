package com.aisho.restdb;
import java.sql.*;

public class Test {
	
	 static java.sql.Connection con = Connect.getInstance().getConnection();

	public static void main(String[] args) {
		Statement stmt;
		ResultSet rs;
		System.out.println(con);
		
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM Staff";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("SIN")+" " + rs.getString("NAME"));
		}
			
			stmt.close();
			
			
		}
		catch (SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
		}
		return;
		
		

	}

}
