package com.dao;

import java.util.ArrayList;

import com.bean.TreatmentDetails;

public interface ITreatmentDetailsDAO {
	
	public void addTreatmentDetails(TreatmentDetails TreatmentDetails) throws ClassNotFoundException;

	public TreatmentDetails getTreatmentDetailsByID(String treatmentdetailsID);
	
	ArrayList<TreatmentDetails> getTreatmentDetails();
	
	
}
