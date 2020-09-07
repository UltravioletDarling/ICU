package com.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
 
    public static Connection createConnection()throws ClassNotFoundException,SQLException
    {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/icudb"; //ICU DATABASE
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
    
    //test comment
    //TEST COMMENT 2
    
}