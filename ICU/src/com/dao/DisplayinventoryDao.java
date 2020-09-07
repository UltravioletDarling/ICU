package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.inventoryitem;
import com.util.DBConnection;
import java.sql.Statement;

public class DisplayinventoryDao {
	 public String addItem(inventoryitem inventoryitem) throws ClassNotFoundException
     {
		 
    	 Connection con = null;
         PreparedStatement preparedStatement = null;
         String itemID = inventoryitem.getItemid();
         String adminID = inventoryitem.getAdminid(); 
         String itemName = inventoryitem.getName();
         String itemStock = inventoryitem.getStock();
         String aquiredDate = inventoryitem.getAquired();
         String expiryDate = inventoryitem.getExpiry();
         String unitDosage = inventoryitem.getUdosage();
         String itemType = inventoryitem.getType();
         String maintenanceDate = inventoryitem.getMaintenance();
         
         System.out.println(itemID);
         
         try {
             con = DBConnection.createConnection();
             String query = "insert into inventory values('"+itemID+"','"+adminID+"','"+itemName+"','"+itemStock+"','"+aquiredDate+"','"+expiryDate+"','"+unitDosage+"','"+itemType+"','"+maintenanceDate+"')";
             
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, itemID);
             preparedStatement.setString(2, adminID);
             preparedStatement.setString(3, itemName);
             preparedStatement.setString(4, itemStock);
             preparedStatement.setString(5, aquiredDate);
             preparedStatement.setString(6, expiryDate);
             preparedStatement.setString(7, unitDosage);
             preparedStatement.setString(8, itemType);
             preparedStatement.setString(9, maintenanceDate);
             
             int i= preparedStatement.executeUpdate();
             System.out.println(i);
             
             if (i!=0)  
             return "SUCCESS";
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "ERROR"; 
     }

}
