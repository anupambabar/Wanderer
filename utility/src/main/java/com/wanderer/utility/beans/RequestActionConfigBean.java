/**
 * 
 */
package com.wanderer.utility.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anupam.babar
 */
@XmlRootElement(name = "service")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestActionConfigBean {

	@XmlElement
	private String name;

	@XmlElement
	private String action;

	@XmlElement
	private String subaction;

	@XmlElement
	private String deviceid;
	
	
	
	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the subaction
	 */
	public String getSubaction() {
		return subaction;
	}

	/**
	 * @param subaction
	 *            the subaction to set
	 */
	public void setSubaction(String subaction) {
		this.subaction = subaction;
	}
}
