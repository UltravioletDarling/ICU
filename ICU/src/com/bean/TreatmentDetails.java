package com.bean;

public class TreatmentDetails {
	
	private int treatmentDetailsID;
	private String patientID;
	private String doctorID;
	private int bP;
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
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public int getbP() {
		return bP;
	}
	public void setbP(int bP) {
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
