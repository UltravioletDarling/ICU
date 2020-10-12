package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.inventoryitem;
import com.util.DBConnection;


public class DisplayinventorybyidDao {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean validate(String itemid) {
		
		try {
			con = DBConnection.createConnection();
			stmt = con.createStatement();
			String sql = "select * from inventory where ItemID='"+itemid+"'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<inventoryitem> getdetailsbyid(String itemid) {
		
		ArrayList<inventoryitem> inventorylist = new ArrayList<>();
		
		try {
			
			con = DBConnection.createConnection();
			stmt = con.createStatement();
			String sql = "select * from inventory where ItemID='"+itemid+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String itemid1 = rs.getString(1);
	        	String adminid = rs.getString(2);
	        	String name = rs.getString(3);
	        	String stock = rs.getString(4);
	        	String aquired = rs.getString(5);
	        	String expiry = rs.getString(6);
	        	String udosage = rs.getString(7);
	        	String type = rs.getString(8);
	        	String maintenance = rs.getString(9);
				
			
	    		inventoryitem inventoryitem = new inventoryitem(itemid, adminid, name, stock, aquired, expiry, udosage, type, maintenance);
	        	inventorylist.add(inventoryitem);
			}
			
		} catch (Exception e) {
			
		}
		
		return inventorylist;	
	}
	
	
//Delete method	
	
public static boolean deleteitem(String itemid) {
		
		try {
			con = DBConnection.createConnection();
		    stmt = con.createStatement();
		    String sql = "delete from inventory where ItemID='"+itemid+"'";
		    int rs = stmt.executeUpdate(sql);
		     
		    if(rs>0) {
		    	isSuccess = true;
		    }
		    else {
		    	isSuccess = false;
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	
	

}
