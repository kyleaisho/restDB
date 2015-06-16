package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class MenuQueries extends QueryBase {

	/**
	 * @param rName The name of the recipe the menu item stems from
	 * @param mName The name of the new menu item
	 * @param price The price of the menu item
	 */
	protected void enterMenuItem(String rName, String mName, double price) {
		
		sqlInsert("Recipe_To_Menu", "'" + rName + "'" + "," + "'" + mName + "'");
		sqlInsert("Menu_Price", "'" + rName + "'" + "," + price);
		
		//Assumption that all items exist on the menu only if they exist in the Recipe_To_Menu table
		ResultSet rs = sqlSelect("Ingredients", "Recipes", "WHERE rName='" + rName + "'");
		
		String ingredients = "";
		try {
			rs.next();
			ingredients = rs.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 	List<String> ingredientList = Arrays.asList(ingredients.split(","));
		for (String ingredient: ingredientList) {
			ingredient = ingredient.trim();
			sqlInsert("Requires", "'" + ingredient + "','" + mName + "'");
		} 
	}
	
	/**
	 * @param rName The name of the recipe corresponding to the menu item
	 * @param mName The new name for the menu item 
	 * @param price The new price of the menu item
	 */
	protected void modifyMenuItem(String rName, String mName, double price) {
		String oldMenuName = "";
		
		ResultSet rs = sqlSelect("mName", "Recipe_To_Menu", "WHERE rName='" + rName + "'");
		
		try {
			rs.next();
			oldMenuName = rs.getString(1);
			oldMenuName = oldMenuName.trim();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlUpdate("Menu_Price", "price=" + price, "rName='" + rName + "'");
		
		//sqlUpdate("Recipe_To_Menu", "mName='" + mName + "'", "rName='" + rName + "'");
		sqlInsert("Recipe_To_Menu", "'" + rName + "'" + "," + "'" + mName + "'");
		sqlUpdate("Requires", "mName='" + mName + "'", "mName='" + oldMenuName + "'");
		sqlDelete("Recipe_To_Menu", "mName='" + oldMenuName + "'");
	}
	
	/**
	 * @param rName The name of the recipe corresponding to the menu item
	 * 
	 */
	protected void deleteMenuItem(String rName) {
		sqlDelete("Requires", "mName=(SELECT mName FROM Recipe_To_Menu WHERE rName='" + rName + "')");
		sqlDelete("Menu_Price", "rName='" + rName + "'");
		sqlDelete("Recipe_To_Menu", "rName='" + rName + "'");
	}
	
	//To be run from the main class. Insert anything you want to test here
	protected void testMenuQueries() {
		sqlInsert("Recipes", "'Cheese', 'Maple Sugar, Onions'");
		enterMenuItem("Cheese", "Holed Cheese", 3.50);
		ResultSet rs = sqlSelect("*", "Recipe_To_Menu", "");
		printResultSet(rs);
		ResultSet rs2 = sqlSelect("*", "Menu_Price", "");
		printResultSet(rs2);
		ResultSet rs3 = sqlSelect("*", "Requires", "");
		printResultSet(rs3);
		
		modifyMenuItem("Cheese", "New Cheese", 4.50);
		rs = sqlSelect("*", "Recipe_To_Menu", "");
		printResultSet(rs);
		rs2 = sqlSelect("*", "Menu_Price", "");
		printResultSet(rs2);
		rs3 = sqlSelect("*", "Requires", "");
		printResultSet(rs3);
		
		deleteMenuItem("Cheese");
		rs = sqlSelect("*", "Recipe_To_Menu", "");
		printResultSet(rs);
		rs2 = sqlSelect("*", "Menu_Price", "");
		printResultSet(rs2);
		rs3 = sqlSelect("*", "Requires", "");
		printResultSet(rs3);
	}
}
