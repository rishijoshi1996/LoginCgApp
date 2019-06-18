package com.cgapp.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgapp.entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

}