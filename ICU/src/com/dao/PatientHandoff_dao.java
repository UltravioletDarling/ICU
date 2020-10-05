package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.PatientHandoff_bean;
import com.util.DBConnection;
//import java.sql.Statement;

public class PatientHandoff_dao {
	
	public String insertData(PatientHandoff_bean patienthandoff_details) throws ClassNotFoundException
    {
   	 Connection con = null;
        PreparedStatement preparedStatement = null;
        int id = patienthandoff_details.getId();
        String status = patienthandoff_details.getStatus();
        String alergies = patienthandoff_details.getAlergies();
        String critical_condition = patienthandoff_details.getCritical_condition();
        String others = patienthandoff_details.getOthers();
        String checked_by = patienthandoff_details.getCheked_by();
        System.out.println(id);
        try {
            con = DBConnection.createConnection();
            String query = "insert into patient.patient_handoff_details values(?,?,?,?,?,?)"; //Insert user details into the table 'users'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, status);
            preparedStatement.setString(3, alergies);
            preparedStatement.setString(4, critical_condition);
            preparedStatement.setString(5, others);
            preparedStatement.setString(6, checked_by);
            
            int i= preparedStatement.executeUpdate();
            System.out.println(i);
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS";
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }

}
