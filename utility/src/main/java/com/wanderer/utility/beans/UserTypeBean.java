/**
 * 
 */
package com.wanderer.utility.beans;

import java.sql.Timestamp;

/**
 * @author anupam babar
 * @desc This class represents the user types such as admin, user etc.
 */
public class UserTypeBean {

	private int userTypeId;
	private String userType;
	private Timestamp createdDate;
	private Timestamp updatedDate;

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
		return "UserType [userTypeId=" + userTypeId + ", userType=" + userType + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}

}
