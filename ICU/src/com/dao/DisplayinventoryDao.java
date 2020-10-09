package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.inventoryitem;
import com.util.DBConnection;


public class DisplayinventoryDao implements Inventorylistinterfacedao {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

public ArrayList<inventoryitem> getdetails() {
    	
		ArrayList<inventoryitem> inventorylist = new ArrayList<inventoryitem>();

		Connection con = null;
	    Statement statement = null;
	    
	    try {
	    	con = DBConnection.createConnection();
	        statement = con.createStatement();
	        String sql = "select* from inventory";
	        rs = statement.executeQuery(sql);
	        
	        
	        while(rs.next()) {
	        	       	
	        	String itemid = rs.getString(1);
	        	String adminid = rs.getString(2);
	        	String name = rs.getString(3);
	        	String stock = rs.getString(4);
	        	String aquired = rs.getString(5);
	        	String expiry = rs.getString(6);
	        	String udosage = rs.getString(7);
	        	String type = rs.getString(8);
	        	String maintenance = rs.getString(9);
	        	
	        	inventoryitem inventoryitem = new inventoryitem(itemid, adminid, name, stock, aquired, expiry, udosage, type, maintenance);
	        	itemid = inventoryitem.getItemid();
	        	System.out.println(inventoryitem.getItemid());
	        	inventorylist.add(inventoryitem);
	        }
	        
	        con.close();
    	    stmt.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	    System.out.println("");
		return inventorylist;
	}

@Override
public void addItem(inventoryitem inventoryitem) throws ClassNotFoundException {
	// TODO Auto-generated method stub
	
}

@Override
public inventoryitem getinventoryitemID(String itemid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<inventoryitem> getinventryitem() {
	// TODO Auto-generated method stub
	return null;
}

}
