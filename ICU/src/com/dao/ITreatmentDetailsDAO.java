package com.dao;

import java.util.ArrayList;

import com.bean.TreatmentDetails;
import com.bean.TreatmentDetails_investigations;
import com.bean.TreatmentDetails_medicine;
import com.bean.TreatmentDetails_supportSystems;

public interface ITreatmentDetailsDAO {
	
	//add details
	public int addTreatmentDetails(TreatmentDetails TreatmentDetails) throws ClassNotFoundException;
	public void addTreatmentDetails_medicine(TreatmentDetails_medicine treatmentDetails_medicine) throws ClassNotFoundException;
	public void addTreatmentDetails_supportSystems(TreatmentDetails_supportSystems treatmentDetails_supportSystems) throws ClassNotFoundException;
	public void addTreatmentDetails_investigations(TreatmentDetails_investigations treatmentDetails_investigations) throws ClassNotFoundException;
	
	//get details
	public ArrayList<TreatmentDetails> getTreatmentDetails();
	public TreatmentDetails getTreatmentDetailsByID(String treatmentdetailsID);
	public ArrayList<TreatmentDetails_medicine> getTreatmentDetails_medicineByID(String treatmentdetailsID);
	public ArrayList<TreatmentDetails_supportSystems> getTreatmentDetails_supportSystemsByID(String treatmentdetailsID);
	public ArrayList<TreatmentDetails_investigations> getTreatmentDetails_investigationsByID(String treatmentdetailsID);
	
	//delete details
	public void DeleteTreatmentDetails_medicineByID(String treatmentDetails_medicineID);
	public void DeleteTreatmentDetails_supportSystemsByID(String treatmentDetails_supportSystemsID);
	public void DeleteTreatmentDetails_investigationsByID(String treatmentDetails_investigationsID);
	public void DeleteTreatmentDetails_allByID(String treatmentdetailsID);
	
	//update details
	public TreatmentDetails UpdateTreatmentDetails(TreatmentDetails TreatmentDetails);
	public TreatmentDetails_medicine UpdateTreatmentDetails_medicine(TreatmentDetails_medicine treatmentDetails_medicine);
	public TreatmentDetails_supportSystems UpdateTreatmentDetails_supportSystems(TreatmentDetails_supportSystems treatmentDetails_supportSystems);
	public TreatmentDetails_investigations UpdateTreatmentDetails_investigations(TreatmentDetails_investigations treatmentDetails_investigations);
}
