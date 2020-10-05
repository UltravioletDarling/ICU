package com.bean;

public class PatientHandoff_bean {
	int id;
	String status;
	String alergies;
	String critical_condition;
	String others;
	String cheked_by;
	
	public PatientHandoff_bean() {}

	public PatientHandoff_bean(int id, String status, String alergies, String critical_condition, String others, String cheked_by) {
		this.id = id;
		this.status = status;
		this.alergies = alergies;
		this.critical_condition = critical_condition;
		this.others = others;
		this.cheked_by = cheked_by;
	}
	
	public int getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public String getAlergies() {
		return alergies;
	}
	public String getCritical_condition() {
		return critical_condition;
	}
	public String getOthers() {
		return others;
	}
	public String getCheked_by() {
		return cheked_by;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
