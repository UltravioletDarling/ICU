package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.bean.inventoryitem;


public class InventoryDBUtill {
	
	
public inventoryitem displayinventory(String itemid) {
		
	inventoryitem inventoryitem= new inventoryitem(itemid, itemid, itemid, itemid, itemid, itemid, itemid, itemid, itemid);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservations", "root", "");
			 java.sql.Statement stmt = con.createStatement();
    	    String sql = "select * from icudb where ItemID="+ itemid ;
    	    ResultSet res = stmt.executeQuery(sql);
    		
  
    		
    	    while(res.next()){
    	    	
    	    	inventoryitem.setItemid(res.getString(1));
    	    	inventoryitem.setAdminid(res.getString(2));
    	    	inventoryitem.setName(res.getString(3));
    	    	inventoryitem.setStock(res.getString(4));
    	    	inventoryitem.setAquired(res.getString(5));
    	    	inventoryitem.setExpiry(res.getString(6));
    	    	inventoryitem.setUdosage(res.getString(7));
    	    	inventoryitem.setType(res.getString(8));
    	    	inventoryitem.setMaintenance(res.getString(9));
			
		
    	    }
    	    con.close();
    	    stmt.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
		return inventoryitem;
	}

	
	


}
