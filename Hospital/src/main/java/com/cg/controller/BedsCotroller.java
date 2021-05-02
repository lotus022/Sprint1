package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entities.Beds;
import com.cg.exception.BedNotfoundException;
import com.cg.services.IBedService;
import com.cg.services.ITreatmentHistory;

@RestController
@RequestMapping("/hospital")
public class BedsCotroller {

	private static final Logger logger = LoggerFactory.getLogger(BedsCotroller.class);

	RestTemplate restTemplate;
	@Autowired
	IBedService bedservice;
	@Autowired
	ITreatmentHistory treatmentHistory;

	// Adding the Patient beds
	@PostMapping("/addBeds")
	public ResponseEntity<Beds> addBeds(Beds bed) {
		logger.info("Conroller bed adding.....");
		try {
			return new ResponseEntity<>(bedservice.addBeds(bed), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//View Patient Beds
	@GetMapping("/vewAllBed")
	public ResponseEntity<List<Beds>> viewBeds() throws BedNotfoundException {
		logger.info("Bedcontroller to view all beds................");
		try {
			return new ResponseEntity<>(bedservice.viewBeds(), HttpStatus.OK);
		} catch (Exception e) {
			throw new BedNotfoundException("There is no bed in database....");
		}
	}

	// Edit the Patient beds
	@PostMapping("/editBed")
	public ResponseEntity<Beds> editBeds(Beds bed) {
		logger.info("Controller To edit bed ............");

		try {
			return new ResponseEntity<>(bedservice.editBeds(bed), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//Delete Patient beds
	@DeleteMapping("/RemoveBed/{id}")
	public String removeBeds(@PathVariable Integer id) throws BedNotfoundException {
	
		logger.info("BedController Remove beds...........");
		try {
			return bedservice.removeBeds(id);
		} catch (Exception e) {
			throw new BedNotfoundException("Bed with given id not found");

		}

	}

}
