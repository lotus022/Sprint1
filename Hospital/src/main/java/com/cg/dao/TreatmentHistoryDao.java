package com.cg.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.TreatmentHistory;
@Repository("treatmentDao")
public interface TreatmentHistoryDao extends JpaRepository<TreatmentHistory, Integer>{
	/*
	 * boolean updatePatient(UUID fromString, String medicalCondition, String
	 * diagnosis, String doctorName, Date endDate, String report, Date startDate,
	 * String string);
	 */
}
