package com.cgapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Employees;
import com.cgapp.exception.LoginException;
import com.cgapp.service.LoginService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employees> checkLogin(@RequestBody Employees emp) {

		Employees employee = loginservice.checkLogin(emp);

		if (employee == null) {
			throw new LoginException(emp.getEmpUserName());
		}
		return new ResponseEntity<Employees>(employee, HttpStatus.OK);
	}
}
