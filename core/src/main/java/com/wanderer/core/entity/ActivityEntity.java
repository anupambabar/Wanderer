package com.wanderer.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author anupam.babar
 */

@NamedQueries({
	@NamedQuery(name = "getActivityCodeByName", 
			query = "SELECT u FROM ActivityMasterEntity u WHERE u.name = :name"),
			
			@NamedQuery(name = "getAllActivities", 
			query = "SELECT u FROM ActivityMasterEntity u")
})
@Entity
@Table(name = "ACTIVITIES")
public class ActivityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ActivityMasterEntity_seq")
	@SequenceGenerator(name = "ActivityMasterEntity_seq", sequenceName = "ACTIVITIES_SEQ")
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	@Column(name = "DISPLAYNAME")
	private String displayName;

	@Column(name = "CREATEDBY")
	private int createdBy;

	@Column(name = "CREATEDON")
	private Timestamp createdOn;

	@Column(name = "UPDATEDBY")
	private int updatedBy;

	@Column(name = "UPDATEDON")
	private Timestamp updatedOn;

	@Column(name = "ISACTIVE")
	private char isActive;

	@Column(name = "SESSIONCHECK")
	private char sessionCheck;
	
	@Column(name = "MAXREQ")
	private int maxReq;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public char getSessionCheck() {
		return sessionCheck;
	}

	public void setSessionCheck(char sessionCheck) {
		this.sessionCheck = sessionCheck;
	}

	public int getMaxReq() {
		return maxReq;
	}

	public void setMaxReq(int maxReq) {
		this.maxReq = maxReq;
	}

	
}
