package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class exampleDButil {
	
	
public static boolean yourCRUD() {
		
		boolean isSuccess = false;
		
		//database connection
		String url = "jdbc:mysql://localhost:3306/ICU";
		String user = "root";
		String pass = "root";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ICU", "root", "6334");
			java.sql.Statement stmt = con.createStatement();
			String sql = //SQL statement;
			int res = stmt.executeUpdate(sql);
			
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
