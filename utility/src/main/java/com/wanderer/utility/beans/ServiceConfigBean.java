package com.wanderer.utility.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anupam.babar
 */
@XmlRootElement(name="service")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceConfigBean {
	
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String className;
	
	
	@XmlElement
	private List<ActionBean> action;
	
	public List<ActionBean> getAction() {
		return action;
	}
	public void setAction(List<ActionBean> action) {
		this.action = action;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "ServiceConfigBean [name=" + name + ", className=" + className
				+ ", action=" + action + "]";
	}
	
	
}
