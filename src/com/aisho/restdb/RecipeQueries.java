package com.aisho.restdb;
//We need to import the java.sql package to use JDBC
import java.sql.*;

public class RecipeQueries extends QueryBase {

	/**
	 * @param rName The name of the new recipe
	 * @param sin The sin of the staff member who added the recipe
	 * @param ingredients A list of ingredients needed to make the recipe
	 */
	private void enterRecipe(String rName, int sin, String ingredients) {
		// Will need to enter the ingredients:
		//- as a list in the Recipes table
		//- individual tuples in the Requires table
	}
	
	/**
	 * OPTIONAL QUERY
	 * @param rName The current name of the recipe to be changed
	 * @param newName The new name of the recipe
	 * @param sin The new sin of the staff member who added the recipe
	 * @param ingredients A new list of ingredients needed to make the recipe
	 */
	private void modifyRecipe(String oldName, String newName, int sin, String ingredients) {
		// Will need to modify the ingredients:
		//- in the list in the Recipes table
		//- in the individual tuples in the Requires table
	}
}
