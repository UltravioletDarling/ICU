package com.util;
 


import java.sql.Connection;
import java.sql.DriverManager;
/**
 * implementation class DBConnectRaz
 **/
public class DBConnectionRAZ {
	
	//declare and initialize variables needed for connection
	private static String url = "jdbc:mysql://localhost:3306/treatmentdetails";
	private static String userName = "root";
	private static String password = "1234";
	private static Connection con;

	public static Connection getConnection() {
		//try catch
		try {
			//establish connection
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			
		}
		catch (Exception e) {
			//error message
			System.out.println("Database connection failed!!!");
		}
		//return connection
		return con;
	}
}