package com.cgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.entity.Employees;

@Service("loginservice")
public class LoginService {

	@Autowired
	private EmployeeRepository emprepo;

	public Employees checkLogin(Employees employee) {
		return emprepo.findByEmpUserName(employee.getEmpUserName());
	}
}
