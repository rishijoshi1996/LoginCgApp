package com.cgapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cgapp.entity.TrainingCatalog;
import com.cgapp.service.TrainingCatalogService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class TrainingCatalogController {

	@Autowired
	private TrainingCatalogService trainingservice;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


	@PostMapping(path = "/trainings", consumes = "application/json")
	public ResponseEntity<List<TrainingCatalog>> createTraining(@RequestBody List<TrainingCatalog> trainingcatalog) {
		List<TrainingCatalog> tc = trainingservice.createTrainingCatalog(trainingcatalog);
		logger.info("Traininig Details Added");
		return new ResponseEntity<List<TrainingCatalog>>(tc, HttpStatus.CREATED);
	}

	@GetMapping(path = "/trainings", produces = "application/json")
	public List<TrainingCatalog> getTraining() {
		logger.info("Succesfull");
		return trainingservice.getTraining();
	}

	@DeleteMapping(path = "/trainings")
	public String deleteAll() {
		return trainingservice.deleteAll();
	}

	@DeleteMapping(path = "/trainings/{tid}")
	public String deleteOne(@PathVariable("tid") int id) {
		return trainingservice.deleteOne(id);
	}
	
}
