package com.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.entity.Employees;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@RequestMapping("/testemp")
	public String testEmp() {
		return "test emp";
	}
	
	@PostMapping("/createemp")
	public String creatEmployee(@RequestBody Employees employee) {
		Employees manager = empRepo.findOne(101);
		employee.setManager(manager);
		empRepo.save(employee);
		return "Employee Added";
	}
	
	@GetMapping("/getemployee")
	public List<Employees> getEmployee() {
       return empRepo.findAll();
	}
}
