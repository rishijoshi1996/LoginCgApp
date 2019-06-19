package com.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.entity.Employees;

@Service("empservice")
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	
	public Employees createEmployees(Employees employee) {
		Employees manager = emprepo.findOne(101);
		employee.setManager(manager);
		 return emprepo.save(employee);
		 
	}
	
	public List<Employees> getEmployees(){
		return emprepo.findAll();
	}
	
}
