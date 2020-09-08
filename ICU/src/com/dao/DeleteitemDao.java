package com.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.util.DBConnection;

public class DeleteitemDao {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement statement = null;
	
	public static boolean deleteitem(String itemid) {
		
		try {
			con = DBConnection.createConnection();
		    statement = con.createStatement();
		    String sql = "delete from icudb where ItemID='"+itemid+"'";
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
