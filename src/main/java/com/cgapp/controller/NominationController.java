package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Nomination;
import com.cgapp.service.NominationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cgapp")
public class NominationController {

	@Autowired
	private NominationService nominationservice;

	@RequestMapping("/testnom")
	public String testNom() {
		return "Success";
	}

	@PostMapping("/nomination")
	public String createNominee(@RequestBody Nomination nomination) {

		String timestamp = nominationservice.timestamp();
		nomination.setEmpTimestamp(timestamp);
		nominationservice.createNomination(nomination);

		return "nomination added";
	}

	@GetMapping("/nominations")
	public List<Nomination> getNomination() {
		return nominationservice.getNomination();
	}
}
