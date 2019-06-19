package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Nomination;
import com.cgapp.service.NominationService;

@RestController
public class NominationController {

	@Autowired
	private NominationService nominationservice;

	@RequestMapping("/testnom")
	public String testNom() {
		return "Success";
	}

	@PostMapping("/createnominee")
	public String createNominee(@RequestBody Nomination nomination) {

		nominationservice.createNomination(nomination);

		return "nomination added";
	}

	@GetMapping("/getnomination")
	public List<Nomination> getNomination() {
		return nominationservice.getNomination();
	}
}
