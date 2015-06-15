package com.aisho.restdb;

public class Main {
	
	public static void main(String[] args) {
		StaffQueries.enterStaff(6666667, "'Ahrshia'");
		StaffQueries.deleteStaff(6666667);
		StaffQueries.enterStaff(666662320, "'Adfdfdia'");
		StaffQueries.deleteStaff(666662320);
		
		//Test your queries here. Leave the below area commented out!
		//RecipeQueries rq = new RecipeQueries();
		//rq.testRecipeQueries();
	}
}