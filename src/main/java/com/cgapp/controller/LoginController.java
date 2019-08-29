package com.cgapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	public static Employees loggedUser = new Employees();

	@Autowired
	private LoginService loginservice;

	@PostMapping(path = "/api/loginapp", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employees> checkLogin(@RequestBody Employees emp) {

		Employees employee = loginservice.checkLogin(emp);

		if (employee == null)
			throw new LoginException("Employee not found for userid : " + emp.getEmpUserName());
		else if (!employee.getEmpPassword().equals(emp.getEmpPassword()))
			throw new LoginException("Password is Invalid");
		else {
			logger.info("loggedUserEmail - "+employee.getEmpEmail());
			loggedUser = employee;
			return new ResponseEntity<Employees>(employee, HttpStatus.OK);
		}
	}
}
