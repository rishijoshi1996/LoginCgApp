package com.cgapp.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgapp.entity.Employees;

@Repository("emprepo")
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
	
	Employees findByEmpUserName(String empUserName);
	Employees findByEmpPassword(String empPassword);
	
	Employees findByEmpId(Integer empId);
}
