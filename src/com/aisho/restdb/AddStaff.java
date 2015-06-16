package com.aisho.restdb;

import javax.swing.JOptionPane;

import com.aisho.restdb.Staff;
import com.aisho.restdb.StaffQueries;

public class AddStaff extends QueryBase{

	public AddStaff() {
		
	}
	
	public void addStaff() {
		String sin = JOptionPane.showInputDialog("Enter the SIN");
		String name = JOptionPane.showInputDialog("Enter the Name");
		StaffQueries.enterStaff(sqlStringify(sin), sqlStringify(name));
	}

}
