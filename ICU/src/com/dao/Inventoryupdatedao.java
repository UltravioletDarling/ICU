package com.dao;


import java.sql.Connection;
import java.sql.Statement;

import com.util.DBConnection;


public class Inventoryupdatedao {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement statement = null;
	
	
	public static boolean inventoryupdate(String itemid,String adminid,String name,String stock,String aquired,
			String expiry,String udosage,String type,String maintenance) {
		
		try {
			 con = DBConnection.createConnection();
		     statement = con.createStatement();
		     String sql = "update icudb set ItemID='"+itemid+"',AdminID='"+adminid+"',Name='"+name+"',AvailableUnits='"+stock+"',AquiredDate='"+aquired+"', ExpiryDate='"+expiry+"',UnitDosage='"+udosage+"',ItemType='"+type+"' ,NextMaintenance='"+maintenance+"' " + " where ItemID='"+itemid+"'";
		     int rs = statement.executeUpdate(sql);
		     
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
