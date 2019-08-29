package com.cgapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cgapp.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author risjoshi
 *
 */
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Employees extends Auditable<String> {

	@Id
	@Column(name = "employee_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_username")
	private String empUserName;

	@Column(name = "emp_password")
	private String empPassword;

	@Column(name = "emp_email")
	private String empEmail;

	@Column(name = "emp_contact")
	private String empContact;

	@Column(name = "emp_job_title")
	private String empJobTitle;

	@Column(name = "emp_position")
	private String empPosition;

	@Column(name = "emp_loaction")
	private String empLocation;

	@Column(name = "emp_department")
	private String empDepartment;

	// Relation Mapping
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employees manager;

	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private Set<Employees> subordinates = new HashSet<Employees>();

	public Employees() {
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public String getEmpJobTitle() {
		return empJobTitle;
	}

	public void setEmpJobTitle(String empJobTitle) {
		this.empJobTitle = empJobTitle;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public Set<Employees> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<Employees> subordinates) {
		this.subordinates = subordinates;
	}

	public Employees(int empId) {
		
		this.empId = empId;
	}


	
	

	

	


}
