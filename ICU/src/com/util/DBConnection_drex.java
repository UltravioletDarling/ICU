package com.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection_drex {
 
    public static Connection createConnection()throws ClassNotFoundException,SQLException
    {
    Connection con = null;

    String url = "jdbc:mysql://localhost:3306/customers";
    String username = "root";
    String password = "root";
 
    try
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Post establishing a DB connection - "+con);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    
    return con;
    }
}
//  check database connetion
	
//	public static void main(String[] args) {
//		try {
//			new DBConnect().createConnection();
//			System.out.println("Sucess");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch(SQLException e){
//			e.printStackTrace();
//		}
//	}