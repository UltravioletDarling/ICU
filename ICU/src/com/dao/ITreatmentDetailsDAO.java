package com.dao;

import java.util.ArrayList;

import com.bean.TreatmentDetails;
import com.bean.TreatmentDetails_medicine;

public interface ITreatmentDetailsDAO {
	
	public int addTreatmentDetails(TreatmentDetails TreatmentDetails) throws ClassNotFoundException;

	public TreatmentDetails getTreatmentDetailsByID(String treatmentdetailsID);
	
	public ArrayList<TreatmentDetails> getTreatmentDetails();
	
	
	public void addTreatmentDetails_medicine(TreatmentDetails_medicine treatmentDetails_medicine) throws ClassNotFoundException;
	
	public ArrayList<TreatmentDetails_medicine> getTreatmentDetails_medicineByID(String treatmentdetailsID);
	
	
}
