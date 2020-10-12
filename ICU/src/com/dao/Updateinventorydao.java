package com.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.inventoryitem;
import com.util.DBConnection;

public class Updateinventorydao implements Inventorylistinterfacedao{
	

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean updateinventory(String itemID,String adminID,String itemName,String itemStock,String aquiredDate,String expiryDate,String unitDosage,String itemType,String maintenanceDate) {
    	
    	try {
    		
    		con = DBConnection.createConnection();
    		stmt = con.createStatement();
    		String sql = "update inventory set ItemID='"+itemID+"',AdminID='"+adminID+"',Name='"+itemName+"',AvailableUnits='"+itemStock+"',ExpiryDate='"+expiryDate+"',UnitDosage='"+unitDosage+"',Type='"+itemType+"',NextMaintenance='"+maintenanceDate+"' "
    				+ "where id='"+itemID+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }

@Override
public void addItem(inventoryitem inventoryitem) throws ClassNotFoundException {
	
}

@Override
public inventoryitem getinventoryitemID(java.lang.String itemid) {
	return null;
}

@Override
public ArrayList<inventoryitem> getdetails() {
	return null;
}

}
