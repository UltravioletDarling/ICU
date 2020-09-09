package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bean.TreatmentDetails;
import com.util.DBConnectionRAZ;

public class TreatmentDetailsDAO implements ITreatmentDetailsDAO{
	
	public void addTreatmentDetails(TreatmentDetails treatmentDetails) throws ClassNotFoundException
    {
		 
		Connection con = null;
        PreparedStatement preparedStatement = null;
    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql = "insert into treatmentdetails" + "(treatmentDetailsID, patientID, doctorID, bP, hR, sPO2, fintake, foutput) values "
            + " (?,?,?,?,?,?,?,?)";
            
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, treatmentDetails.getTreatmentDetailsID());
            preparedStatement.setString(2, treatmentDetails.getPatientID());
            preparedStatement.setString(3, treatmentDetails.getDoctorID());
            preparedStatement.setInt(4, treatmentDetails.getbP());
            preparedStatement.setInt(5, treatmentDetails.gethR());
            preparedStatement.setDouble(6, treatmentDetails.getsPO2());
            preparedStatement.setDouble(7, treatmentDetails.getFintake());
            preparedStatement.setDouble(8,treatmentDetails.getFoutput());
      
            
            int i= preparedStatement.executeUpdate();
            System.out.println(i);
            
           
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
    }
	
	
	public TreatmentDetails getTreatmentDetailsByID(String treatmentdetailsID) {

		return actionOnTreatmentDetails(treatmentdetailsID).get(0);
	}
	
	

	
	public ArrayList<TreatmentDetails> getTreatmentDetails() {
		
		return actionOnTreatmentDetails(null);
	}
	
	
	
	private ArrayList<TreatmentDetails> actionOnTreatmentDetails(String treatmentdetailsID) {
		
			//declare variables
			ArrayList<TreatmentDetails> treatmentDetailsList = new ArrayList<TreatmentDetails>();
			String sql;
			Connection connection = null;		
			Statement statement = null;
			//execution		
			try {
			//establish connection	
			connection = DBConnectionRAZ.getConnection();
			//statement 
			statement = connection.createStatement();
				//check what action to take with if statement 
			if(treatmentdetailsID!= null && !treatmentdetailsID.isEmpty()) {
				 sql = "select * from treatmentdetails where treatmentDetailsID = " + treatmentdetailsID ;
			}else {
				sql ="select * from treatmentdetails";
			}
			//execute query
			ResultSet resultSet = statement.executeQuery(sql);
			
			//sort query result in to array list
			while(resultSet.next()) {
				TreatmentDetails treatmentDetails = new TreatmentDetails();
				treatmentDetails.setTreatmentDetailsID(resultSet.getInt(1));
				treatmentDetails.setPatientID(resultSet.getString(2));
				treatmentDetails.setDoctorID(resultSet.getString(3));
				treatmentDetails.setbP(resultSet.getInt(4));
				treatmentDetails.sethR(resultSet.getInt(5));
				treatmentDetails.setsPO2(resultSet.getDouble(6));
				treatmentDetails.setFintake(resultSet.getDouble(7));
				treatmentDetails.setFoutput(resultSet.getDouble(8));
				treatmentDetailsList.add(treatmentDetails);
			}
			//close statement and connection
			if (statement != null) statement.close();
			if (connection != null) connection.close();
			
	
		}catch(Exception e){
			
		}
		return treatmentDetailsList;
	}
	
	
}


