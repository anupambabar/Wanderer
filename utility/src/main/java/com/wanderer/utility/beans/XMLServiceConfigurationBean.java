package com.wanderer.utility.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anupam.babar
 */
@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLServiceConfigurationBean {
	
	@XmlElement(name = "service")
	private List<ServiceConfigBean> serviceConfigBean;

	public List<ServiceConfigBean> getServiceBean() {
		return serviceConfigBean;
	}

	public void setServiceBean(List<ServiceConfigBean> serviceConfigBean) {
		this.serviceConfigBean = serviceConfigBean;
	}

	@Override
	public String toString() {
		return "XMLConfiguration [serviceConfigBean = " + serviceConfigBean + "]";
	}

}
