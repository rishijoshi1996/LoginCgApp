package com.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.entity.Employees;
import com.cgapp.exception.EmployeeNotFoundException;

/**
 * 
 * @author risjoshi
 *
 */
@Service("empservice")
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;

	// Create new Employee
	public Employees createEmployees(Employees employee) {
		Employees manager = emprepo.findOne(101);
		employee.setManager(manager);
		return emprepo.save(employee);

	}

	// Fetch All Employees
	public List<Employees> getEmployees() throws EmployeeNotFoundException {
		return emprepo.findAll();
	}

	public Employees findEmp(int id) {
		try {
			return emprepo.findOne(id);
		} catch (EmployeeNotFoundException e) {

			throw new EmployeeNotFoundException(id);
		}
	}
	
	public List<Employees> getManager(){
		return emprepo.getEmployeesQuery();
	}

}
