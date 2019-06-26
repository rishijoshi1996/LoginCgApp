package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Nomination;
import com.cgapp.service.NominationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NominationController {

	@Autowired
	private NominationService nominationservice;

	@PostMapping(path = "/nominations", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Nomination> createNominee(@RequestBody Nomination nomination) {
		nominationservice.createNomination(nomination);
		return new ResponseEntity<Nomination>(nomination, HttpStatus.CREATED);
	}

	@GetMapping(path = "/nominations", produces = "application/json")
	public List<Nomination> getNomination() {
		return nominationservice.getNomination();
	}
	
	@GetMapping(path = "/nominations/{empId}",produces = "application/json")
	public ResponseEntity<List<Nomination>> getNominationByEmpId(@PathVariable("empId") int empId ){
		List<Nomination> noms =  nominationservice.getNominationByEmpId(empId);
		return new ResponseEntity<List<Nomination>>(noms,HttpStatus.OK);
	}
	
	@GetMapping(path = "/nominations/manager/{empId}",produces = "application/json")
	public ResponseEntity<List<Nomination>> getNominationOfEmployees(@PathVariable("empId") int empId)
	{
		List<Nomination> noms =  nominationservice.getNominationOfEmployees(empId);
		return new ResponseEntity<List<Nomination>>(noms,HttpStatus.OK);
	}
	
	@PutMapping(path = "/nominations/status/{nomId}/{status}", produces = "application/json")
	public ResponseEntity<String> changeEmployeeStatus(@PathVariable("nomId") int nomId,@PathVariable("status") String status){	
		String result = nominationservice.changeStatus(nomId, status);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
