package com.bean;

public class TreatmentDetails {
	
	private int treatmentDetailsID;
	private int patientID;
	private int doctorID;
	private double bP;
	private int hR;
	private double sPO2;
	private double fintake;
	private double foutput;
	
	public int getTreatmentDetailsID() {
		return treatmentDetailsID;
	}
	public void setTreatmentDetailsID(int treatmentDetailsID) {
		this.treatmentDetailsID = treatmentDetailsID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public double getbP() {
		return bP;
	}
	public void setbP(double bP) {
		this.bP = bP;
	}
	public int gethR() {
		return hR;
	}
	public void sethR(int hR) {
		this.hR = hR;
	}
	public double getsPO2() {
		return sPO2;
	}
	public void setsPO2(double sPO2) {
		this.sPO2 = sPO2;
	}
	public double getFintake() {
		return fintake;
	}
	public void setFintake(double fintake) {
		this.fintake = fintake;
	}
	public double getFoutput() {
		return foutput;
	}
	public void setFoutput(double foutput) {
		this.foutput = foutput;
	}

}
