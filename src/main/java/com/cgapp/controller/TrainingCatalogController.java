package com.cgapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cgapp")
public class TrainingCatalogController {

//	@Autowired
//	private TrainingCatalogService trainingservice;

	@GetMapping(path = "/")
	public String catalogTes() {
		return "Root Url";
	}

	@GetMapping(path = "/testcatalog")
	public String catalogTest() {
		return "Test";
	}

	/*
	 * @PostMapping("/training") public String createTraining(@RequestBody
	 * TrainingCatalog trainingcatalog) {
	 * trainingservice.createTrainingCatalog(trainingcatalog);
	 * 
	 * return "Training Added"; }
	 */
//	
//	@GetMapping("/trainings")
//	public List<TrainingCatalog> getTraining(){
//		
//		return trainingservice.getTraining();
//	}
}
