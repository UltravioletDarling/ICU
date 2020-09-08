package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.TreatmentDetails;
import com.util.DBConnectionRAZ;

public class TreatmentDetailsDAO implements ITreatmentDetailsDAO{
	
	public void addTreatmentDetails(TreatmentDetails treatmentDetails) throws ClassNotFoundException
    {
		 
   	 Connection con = null;
        PreparedStatement preparedStatement = null;
    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String query = "insert into treatmentdetails" + "(treatmentDetailsID, patientID, doctorID, bP, hR, sPO2, fintake, foutput) values "
            + " (?,?,?,?,?,?,?,?)";
            
            preparedStatement = con.prepareStatement(query);
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


}
