package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;
//for reading from the command line
import java.io.*;

public class QueryBase {
	
	/**
	 * A basic insert query.
	 * 
	 * @param con The connection object created to access the Oracle DB.
	 * @param table The name of the table(s).
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
		    	System.out.println("Error found. Rolling back the insertion...");
		    	con.rollback();	
		    }
		    
		    catch (SQLException e2) {		    
		    	System.out.println("Message: " + e2.getMessage());
		    	System.exit(-1);
		    }
		}
	}
	
	/**
	 * A basic delete query.
	 * 
	 * @param con The connection object created to access the Oracle DB.
	 * @param table The name of the table(s).
	 * @param whereClause The SQL used in the where clause in the form of a string. Do not insert
	 * WHERE or semicolons.
	 */	
	protected void sqlDelete(Connection con, String table, String whereClause) {
		
		PreparedStatement ps;
		try {			
			ps = con.prepareStatement("DELETE FROM " + table + " WHERE "+ whereClause);
			ps.executeUpdate();

			// commit work 
			con.commit();
			ps.close();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    try {
		
		    	// undo the delete
		    	System.out.println("Error found. Rolling back the deletion...");
		    	con.rollback();	
		    }
		    
		    catch (SQLException e2) {		    
		    	System.out.println("Message: " + e2.getMessage());
		    	System.exit(-1);
		    }
		}
	}
	
	/**
	 * A basic update query.
	 * 
	 * @param con The connection object created to access the Oracle DB.
	 * @param table The name of the table(s).
	 * @param setClause The SQL used in the set clause in the form of a string. Do not insert
	 * SET.
	 * @param whereClause The SQL used in the where clause in the form of a string. Do not insert
	 * WHERE or semicolons.
	 */	
	protected void sqlUpdate(Connection con, String table, String setClause, String whereClause) {
		
		PreparedStatement ps;
		try {			
			ps = con.prepareStatement("UPDATE " + table + " SET " + setClause + " WHERE "+ whereClause);
			ps.executeUpdate();

			// commit work 
			con.commit();
			ps.close();
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    try {
		
		    	// undo the update
		    	System.out.println("Error found. Rolling back the update...");
		    	con.rollback();	
		    }
		    
		    catch (SQLException e2) {		    
		    	System.out.println("Message: " + e2.getMessage());
		    	System.exit(-1);
		    }
		}
	}
	
	/**
	 * A basic select query.
	 * 
	 * @param con The connection object created to access the Oracle DB.
	 * @param selectClause The select part of the query. Do not include the SELECT, e.g. "*", "x=3"
	 * @param table The name of the table(s).
	 * @param clause The part of the query that comes after the "FROM table " clause. Since any number
	 * of clauses can be omitted, you will have to type out the rest of the query manually. e.g. "WHERE x=3",
	 * "GROUP BY y", "WHERE x=3 GROUP BY y HAVING z=2". Do not include semicolons.
	 * @return result The result of the Select query in the form of a ResultSet object. Check the Javadoc for
	 * ResultSet for getter methods and other information.
	 */	
	protected ResultSet sqlSelect(Connection con, String selectClause, String table, String clause) {
;
		ResultSet result = null;
		try {			
			Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
			
			result = stmt.executeQuery("SELECT " + selectClause + " FROM " + table + " " + clause);
			  
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Prints out the given ResultSet object.
	 * 
	 * @param rs The ResultSet to be printed out.
	 */
	protected void printResultSet(ResultSet rs) {
		try {
		    ResultSetMetaData rsmd = rs.getMetaData();
		    System.out.println("querying SELECT * FROM XXX");
		    int columnsNumber = rsmd.getColumnCount();
		    while (rs.next()) {
		        for (int i = 1; i <= columnsNumber; i++) {
		            if (i > 1) System.out.print(",  ");
		            String columnValue = rs.getString(i);
		            System.out.print(columnValue + " " + rsmd.getColumnName(i));
		        }
		        System.out.println("");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
