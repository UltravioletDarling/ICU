package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.inventoryitem;
import com.util.DBConnection;

public class InventoryDao {
	public static List<inventoryitem> getDetails(String itemID) throws SQLException{
		ArrayList<inventoryitem> item = new ArrayList<>();

		Connection con = null;
	    Statement statement = null;
	    ResultSet rs = null;
	    
	    try {
	    	con = DBConnection.createConnection();
	        statement = con.createStatement();
	        String sql = "select* from icudb where ItemID='"+itemID+"'";
	        rs = statement.executeQuery(sql);
	        
	        if(rs.next()) {
	        	       	
	        	String itemid = rs.getString(1);
	        	String adminid = rs.getString(2);
	        	String name = rs.getString(3);
	        	String stock = rs.getString(4);
	        	String aquired = rs.getString(5);
	        	String expiry = rs.getString(6);
	        	String udosage = rs.getString(7);
	        	String type = rs.getString(8);
	        	String maintenance = rs.getString(9);
	        	
	        	inventoryitem inventoryitem= new inventoryitem(itemid,adminid,name,stock,aquired,expiry,udosage,type,maintenance);
	        	item.add(inventoryitem);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return item;
	}

}
