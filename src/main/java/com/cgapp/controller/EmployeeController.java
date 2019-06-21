package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.entity.Employees;
import com.cgapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;

	@RequestMapping("/testemp")
	public String testEmp() {
		return "test emp";
	}

	/**
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping("/createemp")
	public String creatEmployee(@RequestBody Employees employee) {
		empservice.createEmployees(employee);
		return "Employee Added";
	}

	@GetMapping("/getemployee")
	public List<Employees> getEmployee() {

		return empservice.getEmployees();
	}
	
	@GetMapping("/findemp/{id}")
	public Employees findEmp(@PathVariable int id) {
		return empservice.findEmp(id);
	}
}
