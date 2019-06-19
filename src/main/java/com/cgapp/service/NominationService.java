package com.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.dto.NominationRepository;
import com.cgapp.dto.TrainingCatalogRepository;
import com.cgapp.entity.Employees;
import com.cgapp.entity.Nomination;
import com.cgapp.entity.TrainingCatalog;

@Service
public class NominationService {

	
	@Autowired
	private NominationRepository nominationrepo;
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private TrainingCatalogRepository trainingrepo;
	
	public Nomination createNomination(Nomination nomination) {
		Employees emp = emprepo.findOne(102);
		nomination.setEmployees(emp);
		TrainingCatalog catalog = trainingrepo.findOne(501);
		nomination.setTrainingcatalog(catalog);
		return nominationrepo.save(nomination);
	}
	
	public List<Nomination> getNomination(){
		return nominationrepo.findAll();
	}
}
