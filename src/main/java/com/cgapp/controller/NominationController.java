package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.dto.NominationRepository;
import com.cgapp.dto.TrainingCatalogRepository;
import com.cgapp.entity.Employees;
import com.cgapp.entity.Nomination;
import com.cgapp.entity.TrainingCatalog;

@RestController
public class NominationController {

	@Autowired
	private NominationRepository nominationrepo;
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private TrainingCatalogRepository catalogrepo;
	

	@RequestMapping("/testnom")
	public String testNom() {
		return "Success";
	}
	
	@PostMapping("/createnominee")
	public String createNominee(@RequestBody Nomination nomination) {
		
		Employees emp = emprepo.findOne(102);
		nomination.setEmployees(emp);
		TrainingCatalog catalog = catalogrepo.findOne(501);
		nomination.setTrainingcatalog(catalog);
		nominationrepo.save(nomination);
		
		return "nomination added";
	}
}
