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
 * This entity is used for user sessions
 * 
 * @author mahendra.sud
 */
@NamedQueries({
	@NamedQuery(name = "getSessionValidBySessionIDMobile",
			query = "SELECT u FROM UserSessionsEntity u WHERE u.sessionToken = :sessionID and cif = :cifNumber and productTypeId = :channelid and u.userDeviceId = :deviceid"),
			@NamedQuery(name = "getsessionByCif",
			query = "SELECT u FROM UserSessionsEntity u WHERE u.customerId = :customerId order by createdOn desc"),
			@NamedQuery(name = "getSessionCheckForUser",
			query = "SELECT u FROM UserSessionsEntity u WHERE u.customerId = :customerId and sessionToken= :sessionId and clientIP = :clientIP and isActive='Y' order by createdOn desc"),
			@NamedQuery(name = "getSessionByDeviceId",
			query = "SELECT u FROM UserSessionsEntity u WHERE isActive='Y'  and userDeviceId = :deviceId order by createdOn desc"),
			@NamedQuery(name = "getSessionCifDetails",
			query = "SELECT u FROM UserSessionsEntity u WHERE u.customerId = :customerId and sessionToken= :sessionId and isActive='Y' order by createdOn desc"),
			@NamedQuery(name = "getActiveSessionByCifAndChannel",
			query = "SELECT u FROM UserSessionsEntity u WHERE u.userDeviceId = 1 AND u.customerId = :customerId AND u.channelID = :channelid AND u.isActive = :isActive"),
			@NamedQuery(name = "getActiveSessionByCifAndChannelAndDeviceId",
			query = "SELECT u FROM UserSessionsEntity u WHERE u.customerId = :customerId AND u.channelID = :channelid AND u.isActive = :isActive AND u.userDeviceId = :deviceid ORDER BY u.createdOn DESC")
})

@Entity
@Table(name = "CUSTOMERSESSIONS")
public class UserSessionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UserSessionsEntity_seq")
	@SequenceGenerator(
	    name="UserSessionsEntity_seq",
	    sequenceName="CUSTOMERSESSIONS_SEQ"
	)
	@Column(name = "ID")
	private int id;

	@Column(name = "USERDEVICEID")
	private int userDeviceId;
	
	@Column(name = "STARTTIME")
	private Timestamp startTime;

	@Column(name = "ENDTIME")
	private Timestamp endTime;
	
	@Column(name = "CUSTOMERID")
	private int customerId;
	
	@Column(name = "CHANNELID")
	private int channelID;

	@Column(name = "CLIENTIP")
	private String clientIP;

	@Column(name = "LANID")
	private String lanID;

	@Column(name = "PROXYID")
	private String proxyID;

	@Column(name = "HOSTNAME")
	private String hostName;

	@Column(name = "USERAGENT")
	private String userAgent;

	@Column(name = "BROWSER")
	private String browser;

	@Column(name = "OS")
	private String os;

	@Column(name = "SESSIONTOKEN")
	private String sessionToken;

	@Column(name = "LATITUDE")
	private String latitude;

	@Column(name = "LONGITUDE")
	private String longitude;

	@Column(name = "CREATEDBY")
	private int createdBy;

	@Column(name = "CREATEDON")
	private Timestamp createdOn;

	@Column(name = "UPDATEDBY")
	private int updatedBy;

	@Column(name = "ENDEDBY")
	private String endBy;

	@Column(name = "UPDATEDON")
	private Timestamp updatedOn;

	@Column(name = "ISACTIVE")
	private char isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserDeviceId() {
		return userDeviceId;
	}

	public void setUserDeviceId(int userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getChannelID() {
		return channelID;
	}

	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public String getLanID() {
		return lanID;
	}

	public void setLanID(String lanID) {
		this.lanID = lanID;
	}

	public String getProxyID() {
		return proxyID;
	}

	public void setProxyID(String proxyID) {
		this.proxyID = proxyID;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEndBy() {
		return endBy;
	}

	public void setEndBy(String endBy) {
		this.endBy = endBy;
	}
	
	
}
