package com.cgapp.Login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.entity.Employees;

@RunWith(SpringRunner.class)
public class EmployeeRepoTest {

	@Autowired
	private EmployeeRepository emprepotest;

	@Test
	public void checkEmployee() {

		Employees emp = new Employees(104, "Viraj", "viraj.ingawale", "viraj@capgemini.com", "986578675645", "A4", "Analyst", "Mumbai", "Apps-Europe");
		emprepotest.save(emp);
		
		Employees empFound= emprepotest.findOne(104);
		
		assertThat(empFound.getEmpId()).isEqualTo(emp.getEmpId());
	}
}
