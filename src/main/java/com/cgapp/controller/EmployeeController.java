package com.cgapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Employees;
import com.cgapp.exception.EmployeeNotFoundException;
import com.cgapp.service.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService empservice;

	@PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Employees>> creatEmployee(@RequestBody List<Employees> employee) {
		List<Employees> emplist = empservice.createEmployees(employee);

		return new ResponseEntity<List<Employees>>(emplist, HttpStatus.CREATED);
	}

	@GetMapping(path = "/employees", produces = "application/json")
	public List<Employees> getEmployee() {
		logger.info("Successfull");

		return empservice.getEmployees();
	}

	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employees> findEmp(@PathVariable int id) {
		Employees employee = empservice.findEmp(id);

		if (employee == null) {
			logger.info("Id Not found");
			throw new EmployeeNotFoundException(id);
		}
		return new ResponseEntity<Employees>(employee, HttpStatus.OK);
	}

	@DeleteMapping(path = "/employees")
	public String deleteAll() {
		return empservice.deleteAll();
	}

	@DeleteMapping(path = "/employees/{empid}")
	public String deleteOne(@PathVariable("empid") int id) {
		return empservice.deleteOne(id);
	}

}
