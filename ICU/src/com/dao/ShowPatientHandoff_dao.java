package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;


import com.bean.PatientHandoff_bean;
import com.util.DBConnection;
//import java.sql.Statement;

public class ShowPatientHandoff_dao {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

public static List<PatientHandoff_bean> getCustomer(String id1) {
		
		ArrayList<PatientHandoff_bean> patient = new ArrayList<>();
		
		try {
			
			con = DBConnection.createConnection();
			stmt = con.createStatement();
			String sql = "select * from patient.patient_handoff_details where id='"+id1+"'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String status = rs.getString(2);
				String alergies = rs.getString(3);
				String critical_condition = rs.getString(4);
				String others = rs.getString(5);
				String checked_by = rs.getString(6);
				
				System.out.println(status);
				System.out.println(alergies);
				System.out.println(critical_condition);
				System.out.println(others);
				System.out.println("from db" + checked_by);
				
				
				PatientHandoff_bean cus = new PatientHandoff_bean(id,status,alergies,critical_condition,others,checked_by);
				patient.add(cus);
			}
			
		} catch (Exception e) {
			
		}
		
		return patient;	
	}
}
