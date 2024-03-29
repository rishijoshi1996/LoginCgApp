package com.cgapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cgapp.audit.Auditable;

/**
 * 
 * @author risjoshi
 *
 */
@Entity
@Table(name = "training_catalog")
@EntityListeners(AuditingEntityListener.class)
public class TrainingCatalog extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "training_id")
	private int trainingId;

	@Column(name = "training_name")
	private String trainingName;

	@Column(name = "training_audience")
	private String trainingAudience;

	@Column(name = "training_duration")
	private String trainingDuration;

	@Column(name = "training_location")
	private String trainingLocation;

	@Column(name = "training_type")
	private String trainingType;

	@Column(name = "training_start_date")
	private String trainingStartDate;

	@Column(name = "training_end_date")
	private String trainingEndDate;

	@Column(name = "training_start_time")
	private String trainingStartTime;

	@Column(name = "training_end_time")
	private String trainingEndTime;

	@Column(name = "training_links")
	private String trainingLinks;

	public TrainingCatalog() {
	}

//getter setter
	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getTrainingAudience() {
		return trainingAudience;
	}

	public void setTrainingAudience(String trainingAudience) {
		this.trainingAudience = trainingAudience;
	}

	public String getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(String trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	public String getTrainingLocation() {
		return trainingLocation;
	}

	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(String trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public String getTrainingEndDate() {
		return trainingEndDate;
	}

	public void setTrainingEndDate(String trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}

	public String getTrainingStartTime() {
		return trainingStartTime;
	}

	public void setTrainingStartTime(String trainingStartTime) {
		this.trainingStartTime = trainingStartTime;
	}

	public String getTrainingEndTime() {
		return trainingEndTime;
	}

	public void setTrainingEndTime(String trainingEndTime) {
		this.trainingEndTime = trainingEndTime;
	}

	public String getTrainingLinks() {
		return trainingLinks;
	}

	public void setTrainingLinks(String trainingLinks) {
		this.trainingLinks = trainingLinks;
	}

	//
	public TrainingCatalog(int trainingId, String trainingName, String trainingAudience, String trainingDuration,
			String trainingLocation, String trainingType, String trainingStartDate, String trainingEndDate,
			String trainingStartTime, String trainingEndTime, String trainingLinks) {
		super();
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.trainingAudience = trainingAudience;
		this.trainingDuration = trainingDuration;
		this.trainingLocation = trainingLocation;
		this.trainingType = trainingType;
		this.trainingStartDate = trainingStartDate;
		this.trainingEndDate = trainingEndDate;
		this.trainingStartTime = trainingStartTime;
		this.trainingEndTime = trainingEndTime;
		this.trainingLinks = trainingLinks;
	}

	
	
}
