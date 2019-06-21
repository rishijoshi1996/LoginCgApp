package com.cgapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author risjoshi
 *
 */
@Entity
@Table(name = "nomination")
public class Nomination {

	@Id
	@Column(name = "nomination_id")
	private int nominationId;

	@Column(name = "status")
	private String status;

	@Column(name = "device_id")
	private String deviceId;

	@Column(name = "emp_timestamp")
	private String empTimestamp;

	@Column(name = "mgr_timestamp")
	private String mgrTimestamp;

	// Relation Mapping
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employees employees;

	@ManyToOne
	@JoinColumn(name = "training_id")
	private TrainingCatalog trainingcatalog;

	//Getters and setters
	public TrainingCatalog getTrainingcatalog() {
		return trainingcatalog;
	}

	public void setTrainingcatalog(TrainingCatalog trainingcatalog) {
		this.trainingcatalog = trainingcatalog;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Nomination() {
	}

	public int getNominationId() {
		return nominationId;
	}

	public void setNominationId(int nominationId) {
		this.nominationId = nominationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getEmpTimestamp() {
		return empTimestamp;
	}

	public void setEmpTimestamp(String empTimestamp) {
		this.empTimestamp = empTimestamp;
	}

	public String getMgrTimestamp() {
		return mgrTimestamp;
	}

	public void setMgrTimestamp(String mgrTimestamp) {
		this.mgrTimestamp = mgrTimestamp;
	}

}
