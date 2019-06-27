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
	public List<Employees> createEmployees(List<Employees> employee) {
		
		for (Employees e : employee) {
			e.setManager(emprepo.findOne(e.getManager().getEmpId()));
		}
		return emprepo.save(employee);

	}

	// Fetch All Employees
	public List<Employees> getEmployees() throws EmployeeNotFoundException {
		return emprepo.findAll();
	}

	public Employees findEmp(int id) {
		return emprepo.findOne(id);

	}
	
	public String deleteAll() {
		 emprepo.deleteAll();
		 return "Deleted all";
	}
	
	public String deleteOne(int empId) {
		
		emprepo.delete(empId);
		return "Deleted one";
		
	}

}
