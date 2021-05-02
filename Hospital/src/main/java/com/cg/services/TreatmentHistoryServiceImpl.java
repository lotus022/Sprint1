package com.cg.services;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.TreatmentHistoryDao;

import com.cg.entities.TreatmentHistory;
import com.cg.exception.BedNotfoundException;
import com.cg.exception.TreamentHistoryNotFound;
@Service("/treatmentService")
public class TreatmentHistoryServiceImpl implements ITreatmentHistory {
	Logger logger = LoggerFactory.getLogger(TreatmentHistoryServiceImpl.class);
	@Autowired
	TreatmentHistoryDao tHD;

	@Override
	public List<TreatmentHistory> addTreatmentInformation(TreatmentHistory treatmentHistory) {
		logger.info("To add patient treatment history service............");
		if(treatmentHistory==null) {
			throw new TreamentHistoryNotFound("No data in treatmentHistoryt......");
		} else {
		tHD.save(treatmentHistory);
		
		return tHD.findAll();
		}
	}


	@Override
	public TreatmentHistory getTreatmentInformation(Integer id) {
		// TODO Auto-generated method stub
		logger.info("To get treatmentHistory service bby id............");
		Optional<TreatmentHistory> treat=tHD.findById(id);
		if(!treat.isPresent()) {
			throw new TreamentHistoryNotFound("No trat ment found for given id");
		} else {
			return treat.get();
		}
	
	}


	@Override
	public List<TreatmentHistory> viewTreatmentHistory() {
		logger.info("for vew all TratmentHistory................");
		List<TreatmentHistory> tList = tHD.findAll();
		if (tList.isEmpty()) {
			throw new BedNotfoundException("History not found");
		}
		return tList;
	}




	@Override
	public TreatmentHistory updateTreatment(TreatmentHistory treatment) {
		logger.info("Update tratment History fro service......");
		if(treatment==null) {
			throw new TreamentHistoryNotFound("No data in treatmentHistoryt......");
		} else {
			tHD.save(treatment);
			return treatment;
		}
	       
	}

}
