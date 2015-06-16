package com.aisho.restdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Staff {
	
	private String attrSin = "Sin";
	private String attrName = "Name";
	
	private String name;
	private String sin;
	private StaffQueries sq;
	
	public Staff() {}
	
	/**
	 * Constructor
	 * @param n name of the staffer
	 * @param s sin of the staffer
	 */
	public Staff(String n, String s) {
		name = n;
		sin = s;
	}
	
	/**
	 * Runs a query to return all stuff in an arraylist
	 * @return ArrayList<Staff>
	 */
	public ArrayList<Staff> getStaffFromDB() {
		ArrayList<Staff> s = new ArrayList<>();
		sq = new StaffQueries();
		ResultSet rs = sq.selectStaff();
		try {
			while (rs.next()) {
				s.add(new Staff(rs.getString(attrName), rs.getString(attrSin)));
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception in StaffQuery: " + e.getMessage());
		}
		return s;
	}
	
	public String getName() { return name; }
	
	public String getSin() { return sin; }

	public void print() {
		System.out.println("Name: " + name + " Sin: " + sin);
	}
}
