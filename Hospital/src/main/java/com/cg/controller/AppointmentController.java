package com.cg.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.entities.Appointment;

@RestController
@RequestMapping("/appoiment")

public class AppointmentController {

	@Autowired
	RestTemplate rest;

//Accessing the service from admin microservice
	@GetMapping("/getAllAppointments")
	public List<Appointment> getAppointments() {

		Appointment[] appointments = rest.getForObject("http://localhost/admin-service/appoin/getAllAppointments",
				Appointment[].class);
		return Arrays.asList(appointments);

	}

}
