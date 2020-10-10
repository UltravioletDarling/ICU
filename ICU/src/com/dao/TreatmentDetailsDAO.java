package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bean.TreatmentDetails;
import com.bean.TreatmentDetails_medicine;
import com.util.DBConnectionRAZ;

public class TreatmentDetailsDAO implements ITreatmentDetailsDAO{
	
	
	public int addTreatmentDetails(TreatmentDetails treatmentDetails) throws ClassNotFoundException
    {
		 
		int i=0;
		Connection con = null;
//        Statement statement = null;
        PreparedStatement preparedStatement = null;
    
        
        try {
//            con = DBConnectionRAZ.getConnection();
//            String sql = "insert into treatmentdetails" + "(treatmentDetailsID, patientID, doctorID, bP, hR, sPO2, fintake, foutput) values "
//            + " ("+ treatmentDetails.getTreatmentDetailsID() + "," + treatmentDetails.getPatientID()+","+ treatmentDetails.getDoctorID()+","
//            		+ treatmentDetails.getbP()+","+treatmentDetails.gethR()+","+treatmentDetails.getsPO2()+","+treatmentDetails.getFintake()+","
//            		+treatmentDetails.getFoutput()+ ")";
//            
//
//            System.out.println(sql);
//            statement = con.createStatement(); 
//            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = statement.getGeneratedKeys();
//            if (rs.next()) {
//               i = rs.getInt(1);
//            }

            con = DBConnectionRAZ.getConnection();
            String sql = "insert into treatmentdetails" + "(treatmentDetailsID, patientID, doctorID, bP, hR, sPO2, fintake, foutput) values "
            + " (?,?,?,?,?,?,?,?)";
            
            preparedStatement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, treatmentDetails.getTreatmentDetailsID());
            preparedStatement.setString(2, treatmentDetails.getPatientID());
            preparedStatement.setString(3, treatmentDetails.getDoctorID());
            preparedStatement.setInt(4, treatmentDetails.getbP());
            preparedStatement.setInt(5, treatmentDetails.gethR());
            preparedStatement.setDouble(6, treatmentDetails.getsPO2());
            preparedStatement.setDouble(7, treatmentDetails.getFintake());
            preparedStatement.setDouble(8,treatmentDetails.getFoutput());
      
            
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            System.out.println(i);
            if (rs.next()) {
              i = rs.getInt(1);
           }
            System.out.println(i);
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }       
        return i;
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
	
	
	
	public ArrayList<TreatmentDetails_medicine> getTreatmentDetails_medicineByID(String treatmentdetailsID){
		
		//declare variables
		ArrayList<TreatmentDetails_medicine> treatmentDetails_medicineList = new ArrayList<TreatmentDetails_medicine>();
		String sql;
		Connection connection = null;		
		Statement statement = null;
		//execution		
		try {
		//establish connection	
		connection = DBConnectionRAZ.getConnection();
		//statement 
		statement = connection.createStatement();
		//SQL line
		sql = "select * from treatmentdetails_medicine where treatmentDetailsID = " + treatmentdetailsID ;
		//execute query
		ResultSet resultSet = statement.executeQuery(sql);
		
		//sort query result in to array list
		while(resultSet.next()) {
			TreatmentDetails_medicine TreatmentDetails_medicine = new TreatmentDetails_medicine();
			TreatmentDetails_medicine.setTreatmentDetails_medicineID(resultSet.getInt(1));
			TreatmentDetails_medicine.setTreatmentDetailsID(resultSet.getInt(2));
			TreatmentDetails_medicine.setItemId(resultSet.getString(3));
			TreatmentDetails_medicine.setDosage(resultSet.getString(4));

			treatmentDetails_medicineList.add(TreatmentDetails_medicine);
		}
		//close statement and connection
		if (statement != null) statement.close();
		if (connection != null) connection.close();
		

		}catch(Exception e){
		
		}
		return treatmentDetails_medicineList;
		
		
	}


	@Override
	public void addTreatmentDetails_medicine(TreatmentDetails_medicine treatmentDetails_medicine)
			throws ClassNotFoundException {
		Connection con = null;
//        Statement statement = null;
		 PreparedStatement preparedStatement = null;
    try {
        con = DBConnectionRAZ.getConnection();
        String sql = "insert into treatmentdetails_medicine" + "( idtreatmentdetails_medicine, treatmentDetailsID, itemID, dosage) values "
              + " (?,?,?,?)";
        
        preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, treatmentDetails_medicine.getTreatmentDetails_medicineID());
        preparedStatement.setInt(2, treatmentDetails_medicine.getTreatmentDetailsID());
        preparedStatement.setString(3, treatmentDetails_medicine.getItemId());
        preparedStatement.setString(4, treatmentDetails_medicine.getDosage());
       
        preparedStatement.executeUpdate();
       
        System.out.println(sql);
    }
    catch(SQLException e)
    {
    	
       e.printStackTrace();
    }       
    
//        
//        try {
//            con = DBConnectionRAZ.getConnection();
//            String sql = "insert into treatmentdetails_medicine" + "( idtreatmentdetails_medicine, treatmentDetailsID, itemID, dosage) values "
//            + " ("+ treatmentDetails_medicine.getTreatmentDetails_medicineID() + "," + treatmentDetails_medicine.getTreatmentDetailsID()+","+ treatmentDetails_medicine.getItemId()+","
//            		+ treatmentDetails_medicine.getDosage()+")";
//            
//
//            System.out.println(sql);
//            statement = con.createStatement(); 
//            statement.executeUpdate(sql);
//           // ResultSet rs = statement.getGeneratedKeys();
//            //if (rs.next()) {
//            //   i = rs.getInt(1);
//            //}
//            
//        
//           
//         
//           
//        }
//        catch(SQLException e)
//        {
//        	
//           e.printStackTrace();
//        }       
//		
	}
	
}


