package com.cg.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class TreatmentHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer patientId;
	private TreatmentStatus treatmentStatus;
	@NotEmpty(message = "Doctor name should not be empty")
	@Size(max = 20, min = 2, message = "Name should be of 5-20 character")
	private String doctorName;
	private String report;
	private String diagnosis;
	private LocalDate startDate;
	private LocalDate endDate;
	private String medicalCondition;
	public TreatmentHistory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TreatmentHistory [patientId=" + patientId + ", treatmentStatus=" + treatmentStatus + ", doctorName="
				+ doctorName + ", report=" + report + ", diagnosis=" + diagnosis + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", medicalCondition=" + medicalCondition + "]";
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public TreatmentStatus getTreatmentStatus() {
		return treatmentStatus;
	}
	public void setTreatmentStatus(TreatmentStatus treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TreatmentHistory(Integer patientId, TreatmentStatus treatmentStatus,
			@NotEmpty(message = "Doctor name should not be empty") @Size(max = 20, min = 2, message = "Name should be of 5-20 character") String doctorName,
			String report, String diagnosis, LocalDate startDate, LocalDate endDate, String medicalCondition) {
		super();
		this.patientId = patientId;
		this.treatmentStatus = treatmentStatus;
		this.doctorName = doctorName;
		this.report = report;
		this.diagnosis = diagnosis;
		this.startDate = startDate;
		this.endDate = endDate;
		this.medicalCondition = medicalCondition;
	}

	



}
