/**
 * 
 */
package com.wanderer.utility.beans;

import java.sql.Timestamp;

/**
 * @author anupam babar
 * @desc This class represents the user
 */
public class UserBean {

	private int userId;
	private String firstname;
	private String lastname;
	private int age;
	private String emailId;
	private String countryCode;
	private String phoneNo;
	private int userTypeId;
	private Timestamp createdDate;
	private Timestamp updatedDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", emailId=" + emailId
				+ ", countryCode=" + countryCode + ", phoneNo=" + phoneNo + ", userTypeId=" + userTypeId + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
