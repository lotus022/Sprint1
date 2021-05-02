package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entities.TreatmentHistory;
import com.cg.exception.TreamentHistoryNotFound;
import com.cg.services.ITreatmentHistory;

@RestController
@RequestMapping("/treatment-history")
public class TreatmentController {

	private static final Logger logger = LoggerFactory.getLogger(TreatmentController.class);

	RestTemplate restTemplate;
	@Autowired
	ITreatmentHistory tService;
	//
	@PostMapping("/addPatientHistory")
	public ResponseEntity<List<TreatmentHistory>> addTreatmentInformation(TreatmentHistory treatmentHistory) {
		logger.info("Controller add patient treatment history service............");

		try {
			return new ResponseEntity<>(tService.addTreatmentInformation(treatmentHistory), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTreatmentHistory/{id}")
	public ResponseEntity<TreatmentHistory> getTreatmentInformation(@PathVariable Integer id) {

		logger.info("Controller get treatmentHistory service bby id............");
		try {
			return new ResponseEntity<>(tService.getTreatmentInformation(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/viewPatientHistoryofAll")
	public ResponseEntity<List<TreatmentHistory>> viewTreatmentHistory() {
		logger.info("Controller vew all TratmentHistory................");
		List<TreatmentHistory> treatmentHistory = null;
		try {
			treatmentHistory = tService.viewTreatmentHistory();
			if (treatmentHistory.isEmpty()) {
				throw new TreamentHistoryNotFound("No records found");
			}
		} catch (Exception e) {
			return new ResponseEntity<List<TreatmentHistory>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<TreatmentHistory>>(treatmentHistory, HttpStatus.OK);
	}

	@PostMapping("/UpdateTreatmentHistory")
	public TreatmentHistory updateTreatment(@RequestBody TreatmentHistory treatment) {
		logger.info("Controller Update tratment History fro service......");
		return tService.updateTreatment(treatment);
	}
}
