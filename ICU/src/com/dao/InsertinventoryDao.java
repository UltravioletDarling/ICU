package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.bean.inventoryitem;
import com.util.DBConnection;
import java.sql.Statement;

public class InsertinventoryDao {
	
	public static boolean addItem(String itemID,String adminID,String itemName,String itemStock,String aquiredDate,String expiryDate,String unitDosage,String itemType,String maintenanceDate)
     {
		 boolean isSuccess = false;
		 
    	 Connection con = null;
   
         
         try {
             con = DBConnection.createConnection();
             java.sql.Statement stmt = con.createStatement();
             String query = "insert into inventory values('"+itemID+"','"+adminID+"','"+itemName+"','"+itemStock+"','"+aquiredDate+"','"+expiryDate+"','"+unitDosage+"','"+itemType+"','"+maintenanceDate+"')";
             int res = stmt.executeUpdate(query);
            
             
             if(res > 0) {
                 isSuccess = true;
             } else {
                 isSuccess = false;
             }
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return isSuccess;
		
	}

}
