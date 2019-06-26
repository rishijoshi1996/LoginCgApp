package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.TrainingCatalog;
import com.cgapp.service.TrainingCatalogService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TrainingCatalogController {

	@Autowired
	private TrainingCatalogService trainingservice;

	@PostMapping(path = "/trainings", produces = "application/json")
	public ResponseEntity<TrainingCatalog> createTraining(@RequestBody TrainingCatalog trainingcatalog) {
		TrainingCatalog tc = trainingservice.createTrainingCatalog(trainingcatalog);
		
		return new ResponseEntity<TrainingCatalog>(tc,HttpStatus.CREATED);
	}

	
	@GetMapping(path = "/trainings", produces = "application/json")
	public List<TrainingCatalog> getTraining(){
		
		return trainingservice.getTraining();
	}
}
