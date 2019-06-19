package com.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgapp.dto.TrainingCatalogRepository;
import com.cgapp.entity.TrainingCatalog;

@Service
public class TrainingCatalogService {

	@Autowired
	private TrainingCatalogRepository trainingrepo;
	
	public TrainingCatalog createTrainingCatalog(TrainingCatalog trainingcatalog) {
		return trainingrepo.save(trainingcatalog);
	}
	
	public List<TrainingCatalog> getTraining(){
		return trainingrepo.findAll();
	}
}
