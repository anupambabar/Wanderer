package com.wanderer.core.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * This entity is used for login credentials mapped to DB
 * 
 * 
 * @author anupam.babar
 */
@NamedQueries({
		@NamedQuery(name = "getCustomerByCif", query = "SELECT u FROM CustomerUserEntity u WHERE u.cif = :cifNumber"),
		@NamedQuery(name = "getCustomerByCustId", query = "SELECT u FROM CustomerUserEntity u WHERE u.id = :customerId"),
		@NamedQuery(name = "getCustomerByUsername", query = "SELECT u FROM CustomerUserEntity u WHERE u.userName = :username"),
		@NamedQuery(name = "getCustomerInfo", query = "SELECT u FROM CustomerUserEntity u WHERE u.cif = :cifNumber AND u.mobile = :mobileNumber"),
		@NamedQuery(name = "getCustomerInfoByMobile", query = "SELECT u FROM CustomerUserEntity u WHERE u.mobile = :mobileNumber"),
		@NamedQuery(name = "getCustomerInfoByLeadId", query = "SELECT u FROM CustomerUserEntity u WHERE u.leadId = :leadId"),
		@NamedQuery(name = "getCustomerDetails", query = "SELECT u FROM CustomerUserEntity u")})
@Entity
@Table(name = "CUSTOMERS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomerUserEntity_seq")
	@SequenceGenerator(name = "CustomerUserEntity_seq", sequenceName = "CUSTOMERS_SEQ")
	@Column(name = "ID")
	private int id;

	@Column(name = "LEADID")
	private int leadId;

	@Column(name = "CIF")
	private String cif;

	@Column(name = "SALUTATION")
	private String salutation;

	@Column(name = "CUSTOMERNAME")
	private String custName;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String passWord;

	@Column(name = "MPIN")
	private String mpin;

	@Column(name = "IMAGE")
	@Lob
	private byte[] image;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "STATUSID")
	private int statusId;

	@Column(name = "ISMPINLOCKED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isMpinLocked;

	@Column(name = "ISPASSWORDLOCKED")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPasswordLocked;

	@Column(name = "MOBILELASTLOGGEDON")
	private Timestamp mobileLastLoggedOn;

	@Column(name = "ISQUICKBALANCE")
	private char isQuickBalance;

	@Column(name = "WEBLASTLOGGENON")
	private Timestamp webLastLoggedOn;

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

	@Column(name = "TEMPPASSWORD")
	private String tempPassWord;

	@Column(name = "TEMPMPIN")
	private String tempMpin;
	
	@Column(name = "ENABLEWELCOMEPOPUP")
	private char enableWelcomePopup;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isMpinLocked() {
		return isMpinLocked;
	}

	public void setIsMpinLocked(boolean isMpinLocked) {
		this.isMpinLocked = isMpinLocked;
	}

	public boolean isPasswordLocked() {
		return isPasswordLocked;
	}

	public void setIsPasswordLocked(boolean isPasswordLocked) {
		this.isPasswordLocked = isPasswordLocked;
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

	public void setMpinLocked(boolean isMpinLocked) {
		this.isMpinLocked = isMpinLocked;
	}

	public void setPasswordLocked(boolean isPasswordLocked) {
		this.isPasswordLocked = isPasswordLocked;
	}

	public char getIsQuickBalance() {
		return isQuickBalance;
	}

	public void setIsQuickBalance(char isQuickBalance) {
		this.isQuickBalance = isQuickBalance;
	}

	public Timestamp getMobileLastLoggedOn() {
		return mobileLastLoggedOn;
	}

	public void setMobileLastLoggedOn(Timestamp mobileLastLoggedOn) {
		this.mobileLastLoggedOn = mobileLastLoggedOn;
	}

	public Timestamp getWebLastLoggedOn() {
		return webLastLoggedOn;
	}

	public void setWebLastLoggedOn(Timestamp webLastLoggedOn) {
		this.webLastLoggedOn = webLastLoggedOn;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getMpin() {
		return mpin;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	public String getTempPassWord() {
		return tempPassWord;
	}

	public void setTempPassWord(String tempPassWord) {
		this.tempPassWord = tempPassWord;
	}

	public String getTempMpin() {
		return tempMpin;
	}

	public void setTempMpin(String tempMpin) {
		this.tempMpin = tempMpin;
	}

	public char getEnableWelcomePopup() {
		return enableWelcomePopup;
	}

	public void setEnableWelcomePopup(char enableWelcomePopup) {
		this.enableWelcomePopup = enableWelcomePopup;
	}

	
	

}
