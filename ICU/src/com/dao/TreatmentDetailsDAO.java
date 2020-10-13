package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bean.TreatmentDetails;
import com.bean.TreatmentDetails_investigations;
import com.bean.TreatmentDetails_medicine;
import com.bean.TreatmentDetails_supportSystems;
import com.util.DBConnection;
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



	@Override
	public void addTreatmentDetails_supportSystems(TreatmentDetails_supportSystems treatmentDetails_supportSystems)
			throws ClassNotFoundException {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		  try {
		      con = DBConnectionRAZ.getConnection();
		      String sql = "insert into treatmentdetails_supportsystems" + "( idtreatmentdetails_supportsystems, treatmentDetailsID, sytemname, amount) values "
		            + " (?,?,?,?)";
		      
		      preparedStatement = con.prepareStatement(sql);
		      preparedStatement.setInt(1, treatmentDetails_supportSystems.getTreatmentDetails_supportSystemsID());
		      preparedStatement.setInt(2, treatmentDetails_supportSystems.getTreatmentDetailsID());
		      preparedStatement.setString(3, treatmentDetails_supportSystems.getSystemName());
		      preparedStatement.setString(4, treatmentDetails_supportSystems.getAmount());
		     
		      preparedStatement.executeUpdate();
		     
		      System.out.println(sql);
		  }
		  catch(SQLException e)
		  {
		     e.printStackTrace();
		  }
	}



	@Override
	public ArrayList<TreatmentDetails_supportSystems> getTreatmentDetails_supportSystemsByID(String treatmentdetailsID) {
		
		
		ArrayList<TreatmentDetails_supportSystems> treatmentDetails_supportSystemsList = new ArrayList<TreatmentDetails_supportSystems>();
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
		sql = "select * from treatmentdetails_supportsystems where treatmentDetailsID = " + treatmentdetailsID ;
		//execute query
		ResultSet resultSet = statement.executeQuery(sql);
		
		//sort query result in to array list
		while(resultSet.next()) {
			TreatmentDetails_supportSystems TreatmentDetails_supportSystems = new TreatmentDetails_supportSystems();
			TreatmentDetails_supportSystems.setTreatmentDetails_supportSystemsID(resultSet.getInt(1));
			TreatmentDetails_supportSystems.setTreatmentDetailsID(resultSet.getInt(2));
			TreatmentDetails_supportSystems.setSystemName(resultSet.getString(3));
			TreatmentDetails_supportSystems.setAmount(resultSet.getString(4));

			treatmentDetails_supportSystemsList.add(TreatmentDetails_supportSystems);
		}
		//close statement and connection
		if (statement != null) statement.close();
		if (connection != null) connection.close();
		

		}catch(Exception e){
		
		}
		return treatmentDetails_supportSystemsList;
		
	}



	@Override
	public void addTreatmentDetails_investigations(TreatmentDetails_investigations treatmentDetails_investigations)
			throws ClassNotFoundException {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		  try {
		      con = DBConnectionRAZ.getConnection();
		      String sql = "insert into treatmentdetails_investigations" + "( idtreatmentdetails_investigations, treatmentDetailsID, investigationname, result) values "
		            + " (?,?,?,?)";
		      
		      preparedStatement = con.prepareStatement(sql);
		      preparedStatement.setInt(1, treatmentDetails_investigations.getTreatmentDetails_investigationsID());
		      preparedStatement.setInt(2, treatmentDetails_investigations.getTreatmentDetailsID());
		      preparedStatement.setString(3, treatmentDetails_investigations.getInvestigationname());
		      preparedStatement.setString(4, treatmentDetails_investigations.getResult());
		     
		      preparedStatement.executeUpdate();
		     
		      System.out.println(sql);
		  }
		  catch(SQLException e)
		  {
		     e.printStackTrace();
		  }
		
	}



	@Override
	public ArrayList<TreatmentDetails_investigations> getTreatmentDetails_investigationsByID(String treatmentdetailsID) {
		
		ArrayList<TreatmentDetails_investigations> treatmentDetails_investigationsList = new ArrayList<TreatmentDetails_investigations>();
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
		sql = "select * from treatmentdetails_investigations where treatmentDetailsID = " + treatmentdetailsID ;
		//execute query
		ResultSet resultSet = statement.executeQuery(sql);
		
		//sort query result in to array list
		while(resultSet.next()) {
			TreatmentDetails_investigations TreatmentDetails_investigations = new TreatmentDetails_investigations();
			TreatmentDetails_investigations.setTreatmentDetails_investigationsID(resultSet.getInt(1));
			TreatmentDetails_investigations.setTreatmentDetailsID(resultSet.getInt(2));
			TreatmentDetails_investigations.setInvestigationname(resultSet.getString(3));
			TreatmentDetails_investigations.setResult(resultSet.getString(4));

			treatmentDetails_investigationsList.add(TreatmentDetails_investigations);
		}
		//close statement and connection
		if (statement != null) statement.close();
		if (connection != null) connection.close();
		

		}catch(Exception e){
		
		}
		return treatmentDetails_investigationsList;
	}



	@Override
	public void DeleteTreatmentDetails_medicineByID(String treatmentDetails_medicineID) {
		
		Connection con = null;

        Statement statement = null;
    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql = "delete from treatmentdetails_medicine where idtreatmentdetails_medicine = "
            + treatmentDetails_medicineID ;
            
           
            
	        statement = con.createStatement();
            statement.executeUpdate(sql);
            con.close();
            statement.close();
           
            
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }       
        
		
	}



	@Override
	public void DeleteTreatmentDetails_supportSystemsByID(String treatmentDetails_supportSystemsID) {
		Connection con = null;

        Statement statement = null;
    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql = "delete from treatmentdetails_supportsystems where idtreatmentdetails_supportsystems = "
            + treatmentDetails_supportSystemsID ;
            
           
            
	        statement = con.createStatement();
            statement.executeUpdate(sql);
            con.close();
            statement.close();
           
            
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }  
		
	}



	@Override
	public void DeleteTreatmentDetails_investigationsByID(String treatmentDetails_investigationsID) {
		Connection con = null;

        Statement statement = null;
    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql = "delete from treatmentdetails_investigations where idtreatmentdetails_investigations = "
            + treatmentDetails_investigationsID ;
            
           
            
	        statement = con.createStatement();
            statement.executeUpdate(sql);
            con.close();
            statement.close();
           
            
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }  
	}



	@Override
	public void DeleteTreatmentDetails_allByID(String treatmentdetailsID) {
		Connection con = null;

        Statement statement = null;
    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql1 = "delete from treatmentdetails_investigations where treatmentDetailsID = " + treatmentdetailsID ;
            String sql2 = "delete from treatmentdetails_supportsystems where treatmentDetailsID = " + treatmentdetailsID ;
            String sql3 = "delete from treatmentdetails_medicine where treatmentDetailsID = " + treatmentdetailsID ;
            String sql4 = "delete from treatmentdetails where treatmentDetailsID = " + treatmentdetailsID ;
            
	        statement = con.createStatement();
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            
            con.close();
            statement.close();
           
            
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }  
	}



	@Override
	public TreatmentDetails UpdateTreatmentDetails(TreatmentDetails TreatmentDetails) {
		
		Connection con = null;
		Statement statement = null;

    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql = "update treatmentdetails set patientID = '" + TreatmentDetails.getPatientID()+ "', doctorID = '" + TreatmentDetails.getDoctorID()+"', bP = "+ TreatmentDetails.getbP()+ ", hR = "+ TreatmentDetails.gethR()+", sPO2= "+TreatmentDetails.getsPO2() + 
            ", fintake ="+ TreatmentDetails.getFintake()+", foutput= "+ TreatmentDetails.getFoutput() +" where treatmentDetailsID ="+ TreatmentDetails.getTreatmentDetailsID(); 
            

            System.out.println(sql);
            statement = con.createStatement(); 
            statement.executeUpdate(sql);
         
           
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }       
        return  getTreatmentDetailsByID(Integer.toString(TreatmentDetails.getTreatmentDetailsID()));
	}



	@Override
	public TreatmentDetails_medicine UpdateTreatmentDetails_medicine(TreatmentDetails_medicine treatmentDetails_medicine) {
		Connection con = null;
		Statement statement = null;

    
        
        try {
            con = DBConnectionRAZ.getConnection();
            String sql = "update treatmentdetails_medicine set itemID = '" + treatmentDetails_medicine.getItemId()+"', dosage = '"+ treatmentDetails_medicine.getDosage()+"' where idtreatmentdetails_medicine ="+ treatmentDetails_medicine.getTreatmentDetails_medicineID(); 
            

            System.out.println(sql);
            statement = con.createStatement(); 
            statement.executeUpdate(sql);
         
           
        }
        catch(SQLException e)
        {
        	
           e.printStackTrace();
        }       
        return  getTreatmentDetails_medicineSingle(Integer.toString(treatmentDetails_medicine.getTreatmentDetails_medicineID()));
	}



	@Override
	public TreatmentDetails_supportSystems UpdateTreatmentDetails_supportSystems(
			TreatmentDetails_supportSystems treatmentDetails_supportSystems) {
			Connection con = null;
			Statement statement = null;
	
	    
	        
	        try {
	            con = DBConnectionRAZ.getConnection();
	            String sql = "update treatmentdetails_supportsystems set sytemname = '" + treatmentDetails_supportSystems.getSystemName()+"', amount = '"+ treatmentDetails_supportSystems.getAmount()+"' where idtreatmentdetails_supportsystems ="+ treatmentDetails_supportSystems.getTreatmentDetails_supportSystemsID(); 
	            
	
	            System.out.println(sql);
	            statement = con.createStatement(); 
	            statement.executeUpdate(sql);
	         
	           
	        }
	        catch(SQLException e)
	        {
	        	
	           e.printStackTrace();
	        }       
	        return  getTreatmentDetails_supportSystemsSingle(Integer.toString(treatmentDetails_supportSystems.getTreatmentDetails_supportSystemsID()));
	}



	@Override
	public TreatmentDetails_investigations UpdateTreatmentDetails_investigations(
			TreatmentDetails_investigations treatmentDetails_investigations) {
			Connection con = null;
			Statement statement = null;
	
	    
	        
	        try {
	            con = DBConnectionRAZ.getConnection();
	            String sql = "update treatmentdetails_investigations set investigationname = '" + treatmentDetails_investigations.getInvestigationname()+"', result = '"+ treatmentDetails_investigations.getResult()+"' where idtreatmentdetails_investigations ="+ treatmentDetails_investigations.getTreatmentDetails_investigationsID(); 
	            
	
	            System.out.println(sql);
	            statement = con.createStatement(); 
	            statement.executeUpdate(sql);
	         
	           
	        }
	        catch(SQLException e)
	        {
	        	
	           e.printStackTrace();
	        }       
	        return  getTreatmentDetails_investigationsSingle(Integer.toString(treatmentDetails_investigations.getTreatmentDetails_investigationsID()));
	}



	@Override
	public TreatmentDetails_medicine getTreatmentDetails_medicineSingle(String treatmentDetails_medicineID) {
		
		String sql;
		Connection connection = null;		
		Statement statement = null;
		TreatmentDetails_medicine treatmentDetails_medicine =null;
		//execution		
		try {
		//establish connection	
		connection = DBConnectionRAZ.getConnection();
		//statement 
		statement = connection.createStatement();
		
		sql = "select * from treatmentdetails_medicine where idtreatmentdetails_medicine = " + treatmentDetails_medicineID ;
		System.out.println(sql);
		//execute query
		ResultSet resultSet = statement.executeQuery(sql);
		
		//sort query result in to array list
		while(resultSet.next()) {
		treatmentDetails_medicine = new TreatmentDetails_medicine();
		treatmentDetails_medicine.setTreatmentDetails_medicineID(resultSet.getInt(1));
		treatmentDetails_medicine.setTreatmentDetailsID(resultSet.getInt(2));
		treatmentDetails_medicine.setItemId(resultSet.getString(3));
		treatmentDetails_medicine.setDosage(resultSet.getString(4));
		System.out.println(treatmentDetails_medicine.getTreatmentDetails_medicineID());
		}
		//close statement and connection
		if (statement != null) statement.close();
		if (connection != null) connection.close();
		

	}catch(Exception e){
		
	}
	return treatmentDetails_medicine;
		
	}



	@Override
	public TreatmentDetails_supportSystems getTreatmentDetails_supportSystemsSingle(
			String treatmentDetails_supportSystemsID) {
			String sql;
			Connection connection = null;		
			Statement statement = null;
			TreatmentDetails_supportSystems treatmentDetails_supportSystems =null;
			//execution		
			try {
			//establish connection	
			connection = DBConnectionRAZ.getConnection();
			//statement 
			statement = connection.createStatement();
			
			sql = "select * from treatmentdetails_supportsystems where idtreatmentdetails_supportsystems = " + treatmentDetails_supportSystemsID ;
			System.out.println(sql);
			//execute query
			ResultSet resultSet = statement.executeQuery(sql);
			
			//sort query result in to array list
			while(resultSet.next()) {
				treatmentDetails_supportSystems = new TreatmentDetails_supportSystems();
				treatmentDetails_supportSystems.setTreatmentDetails_supportSystemsID(resultSet.getInt(1));
				treatmentDetails_supportSystems.setTreatmentDetailsID(resultSet.getInt(2));
				treatmentDetails_supportSystems.setSystemName(resultSet.getString(3));
				treatmentDetails_supportSystems.setAmount(resultSet.getString(4));
			System.out.println(treatmentDetails_supportSystems.getTreatmentDetails_supportSystemsID());
			}
			//close statement and connection
			if (statement != null) statement.close();
			if (connection != null) connection.close();
			
	
		}catch(Exception e){
			
		}
		return treatmentDetails_supportSystems;
		
	}



	@Override
	public TreatmentDetails_investigations getTreatmentDetails_investigationsSingle(
			String treatmentDetails_investigationsID) {
			String sql;
			Connection connection = null;		
			Statement statement = null;
			TreatmentDetails_investigations treatmentDetails_investigations =null;
			//execution		
			try {
			//establish connection	
			connection = DBConnectionRAZ.getConnection();
			//statement 
			statement = connection.createStatement();
			
			sql = "select * from treatmentdetails_investigations where idtreatmentdetails_investigations = " + treatmentDetails_investigationsID ;
			System.out.println(sql);
			//execute query
			ResultSet resultSet = statement.executeQuery(sql);
			
			//sort query result in to array list
			while(resultSet.next()) {
				treatmentDetails_investigations = new TreatmentDetails_investigations();
				treatmentDetails_investigations.setTreatmentDetails_investigationsID(resultSet.getInt(1));
				treatmentDetails_investigations.setTreatmentDetailsID(resultSet.getInt(2));
				treatmentDetails_investigations.setInvestigationname(resultSet.getString(3));
				treatmentDetails_investigations.setResult(resultSet.getString(4));
			System.out.println(treatmentDetails_investigations.getTreatmentDetails_investigationsID());
			}
			//close statement and connection
			if (statement != null) statement.close();
			if (connection != null) connection.close();
			
	
		}catch(Exception e){
			
		}
		return treatmentDetails_investigations;
	}








}


