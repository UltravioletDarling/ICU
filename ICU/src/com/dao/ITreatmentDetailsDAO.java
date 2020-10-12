package com.dao;

import java.util.ArrayList;

import com.bean.TreatmentDetails;
import com.bean.TreatmentDetails_investigations;
import com.bean.TreatmentDetails_medicine;
import com.bean.TreatmentDetails_supportSystems;

public interface ITreatmentDetailsDAO {
	
	public int addTreatmentDetails(TreatmentDetails TreatmentDetails) throws ClassNotFoundException;

	public TreatmentDetails getTreatmentDetailsByID(String treatmentdetailsID);
	
	public ArrayList<TreatmentDetails> getTreatmentDetails();
	
	
	public void addTreatmentDetails_medicine(TreatmentDetails_medicine treatmentDetails_medicine) throws ClassNotFoundException;
	
	public ArrayList<TreatmentDetails_medicine> getTreatmentDetails_medicineByID(String treatmentdetailsID);
	
	
	public void addTreatmentDetails_supportSystems(TreatmentDetails_supportSystems treatmentDetails_supportSystems) throws ClassNotFoundException;
	
	public ArrayList<TreatmentDetails_supportSystems> getTreatmentDetails_supportSystemsByID(String treatmentdetailsID);
	

			
	public void addTreatmentDetails_investigations(TreatmentDetails_investigations treatmentDetails_investigations) throws ClassNotFoundException;
			
	public ArrayList<TreatmentDetails_investigations> getTreatmentDetails_investigationsByID(String treatmentdetailsID);
	

	public void DeleteTreatmentDetails_medicineByID(String treatmentDetails_medicine);
	public void DeleteTreatmentDetails_supportSystemsByID(String treatmentDetails_supportSystems);
	public void DeleteTreatmentDetails_investigationsByID(String treatmentDetails_investigations);
	public void DeleteTreatmentDetails_allByID(String treatmentdetailsID);
}
