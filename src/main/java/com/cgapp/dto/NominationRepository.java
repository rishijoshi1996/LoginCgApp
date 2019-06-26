package com.cgapp.dto;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgapp.entity.Employees;
import com.cgapp.entity.Nomination;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Integer> {

	List<Nomination> findByEmployees(Employees employees);
	
	List<Nomination> findByEmployeesInAndStatus(Set<Employees> employees,String status);
	
}
