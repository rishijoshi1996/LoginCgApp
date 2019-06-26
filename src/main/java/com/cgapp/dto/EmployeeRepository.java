package com.cgapp.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgapp.entity.Employees;

@Repository("emprepo")
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {


	@Query("SELECT m FROM Employees m")
	List<Employees> getEmployeesQuery();
}
