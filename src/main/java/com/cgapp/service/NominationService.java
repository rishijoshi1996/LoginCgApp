package com.cgapp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgapp.dto.EmployeeRepository;
import com.cgapp.dto.NominationRepository;
import com.cgapp.dto.TrainingCatalogRepository;
import com.cgapp.entity.Employees;
import com.cgapp.entity.Nomination;

@Service
public class NominationService {

	@Autowired
	private TrainingCatalogRepository trainingrepo;

	@Autowired
	private EmployeeRepository emprepo;

	@Autowired
	private NominationRepository nominationrepo;

	// create Nomination
	public Nomination createNomination(Nomination nomination) {

		nomination.setEmployees(emprepo.findOne(nomination.getEmployees().getEmpId()));
		nomination.setTrainingcatalog(trainingrepo.findOne(nomination.getTrainingcatalog().getTrainingId()));
		nomination.setEmpTimestamp(timestamp());
		return nominationrepo.save(nomination);
	}

	// Get all Nomination details
	public List<Nomination> getNomination() {
		return nominationrepo.findAll();
	}

	public List<Nomination> getNominationByEmpId(int empId) {
		return nominationrepo.findByEmployees(emprepo.findOne(empId));
	}

	public List<Nomination> getNominationOfEmployees(int empId) {

		Set<Employees> employeeList = emprepo.findOne(empId).getSubordinates();
		return nominationrepo.findByEmployeesInAndStatus(employeeList, "pending");
	}
	
	public List<Nomination> getNomEmployees(int empId){
		Set<Employees> employeesList = emprepo.findOne(empId).getSubordinates();
		return nominationrepo.findByEmployeesIn(employeesList);
	}

	public String changeStatus(int nomId, String status) {

		Nomination nomination = nominationrepo.findOne(nomId);
		nomination.setStatus(status);
		nomination.setMgrTimestamp(timestamp());
		nominationrepo.save(nomination);
		return "Status Updated to " + status;

	}

	// Timestamp Locale Date
	public String timestamp() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public String deleteAll() {
		nominationrepo.deleteAll();
		return "Deleted all";
	}

	public String deleteOne(int nId) {

		nominationrepo.delete(nId);
		return "Deleted one";

	}

}
