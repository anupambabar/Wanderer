package com.wanderer.utility.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anupam.babar
 */
@XmlRootElement(name = "action")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActionBean {

	@XmlAttribute
	private String name;
	@XmlAttribute
	private String method;
	@XmlAttribute
	private String inputVO;
	@XmlAttribute
	private String output;

	public String getInputVO() {
		return inputVO;
	}

	public void setInputVO(String inputVO) {
		this.inputVO = inputVO;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "ActionPOJO [name=" + name + ", method=" + method + ", inputVO=" + inputVO + ", output=" + output + "]";
	}

}
