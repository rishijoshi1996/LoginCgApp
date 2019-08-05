package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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



	@PostMapping(path = "/trainings", consumes = "application/json")
	public ResponseEntity<List<TrainingCatalog>> createTraining(@RequestBody List<TrainingCatalog> trainingcatalog) {
		List<TrainingCatalog> tc = trainingservice.createTrainingCatalog(trainingcatalog);
		return new ResponseEntity<List<TrainingCatalog>>(tc, HttpStatus.CREATED);
	}

	@GetMapping(path = "/trainings", produces = "application/json")
	public List<TrainingCatalog> getTraining() {

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
