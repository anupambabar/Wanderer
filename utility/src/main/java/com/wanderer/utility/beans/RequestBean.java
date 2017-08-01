package com.wanderer.utility.beans;

/**
 * 
 * @author anupam.babar
 */
public class RequestBean {

	private String action;
	private String subAction;
	private Object inputParam;
	private String deviceId;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSubAction() {
		return subAction;
	}

	public void setSubAction(String subAction) {
		this.subAction = subAction;
	}

	public Object getInputParam() {
		return inputParam;
	}

	public void setInputParam(Object inputParam) {
		this.inputParam = inputParam;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
