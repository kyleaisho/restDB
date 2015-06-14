package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class MenuQueries extends QueryBase {

	/**
	 * @param rName The name of the recipe the menu item stems from
	 * @param mName The name of the new menu item
	 * @param price The price of the menu item
	 */
	private void enterMenuItem(String rName, String mName, float price) {
		//Somewhat tricky since there is no exact table for menu items. There's Recipe_To_Menu
		//which goes between recipe name and menu name. There's also Menu_Price, which matches
		//the RECIPE name to its price on the menu, rather than the menu name
		
		//Assumption that all items exist on the menu only if they exist in the Recipe_To_Menu table?
	}
	
	/**
	 * @param rName The name of the recipe corresponding to the menu item
	 * @param mName The new name for the menu item 
	 * @param price The new price of the menu item
	 */
	private void modifyMenuItem(String rName, String mName, float price) {
		
	}
	
	/**
	 * @param rName The name of the recipe corresponding to the menu item
	 * 
	 */
	private void deleteMenuItem(String rName) {
		
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testMenuQueries() {
		Connection con = TestHelper.connect();
		ResultSet rs = sqlSelect(con, "*", "Recipe", "");
		printResultSet(rs);
	}
}
