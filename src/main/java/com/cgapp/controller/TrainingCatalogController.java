package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.dto.TrainingCatalogRepository;
import com.cgapp.entity.TrainingCatalog;

@RestController
public class TrainingCatalogController {

	@Autowired
	private TrainingCatalogRepository trainingrepo;
	
	@RequestMapping("/testcatalog")
	public String catalogTest() {
		return "Test";
	}
	
	@PostMapping("/createtraining")
	public String createTraining(@RequestBody TrainingCatalog trainingcatalog) {
		 trainingrepo.save(trainingcatalog);
		
		return "Training Added";
	}
	
	@GetMapping("/gettraining")
	public List<TrainingCatalog> getTraining(){
		
		return trainingrepo.findAll();
	}
}
