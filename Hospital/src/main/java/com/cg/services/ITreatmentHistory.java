package com.cg.services;

import java.util.List;

import com.cg.entities.TreatmentHistory;

public interface ITreatmentHistory {

	public List<TreatmentHistory> addTreatmentInformation(TreatmentHistory treatmentHistory);

	public TreatmentHistory getTreatmentInformation(Integer id);

	public TreatmentHistory updateTreatment(TreatmentHistory treatment);

	public List<TreatmentHistory> viewTreatmentHistory();
	
}
