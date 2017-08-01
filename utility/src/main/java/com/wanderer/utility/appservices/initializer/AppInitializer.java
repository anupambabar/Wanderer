package com.wanderer.utility.appservices.initializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wanderer.utility.beans.ActionBean;
import com.wanderer.utility.beans.RequestActionConfigBean;
import com.wanderer.utility.beans.ServiceConfigBean;
import com.wanderer.utility.beans.XMLRequestActionConfigurationBean;
import com.wanderer.utility.beans.XMLServiceConfigurationBean;
import com.wanderer.utility.constants.AppConstants;
import com.wanderer.utility.utils.CacheUtil;
import com.wanderer.utility.utils.PropertyReaderUtil;
import com.wanderer.utility.utils.XmlUtil;

/**
 * 
 * @author anupam.babar
 */
@Component
public class AppInitializer {

	private static final Logger logger = LoggerFactory.getLogger(AppInitializer.class);

	/**
	 * This method is used to initialize required variables at start up
	 */
	@SuppressWarnings("restriction")
	@PostConstruct
	public void initializeApp() {
		try {

			// Load Properties
			PropertyReaderUtil.getInstance();
			// Load service-config.xml
			loadServiceConfig();
			// Load Request-Action Config
			loadRequestActionConfig();

		} catch (Exception e) {
			logger.error("Error starting application. Please check config data-", e);
		}
	}

	/**
	 * Load Request Action Configuration
	 */
	@SuppressWarnings("restriction")
	private void loadRequestActionConfig() {

		List<RequestActionConfigBean> requestActionConfigBeanList = new ArrayList<RequestActionConfigBean>();
		Map<String, RequestActionConfigBean> requestActionMap = new HashMap<String, RequestActionConfigBean>();

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(XMLRequestActionConfigurationBean.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			XMLRequestActionConfigurationBean configuration = (XMLRequestActionConfigurationBean) jaxbUnmarshaller.unmarshal(getClass().getClassLoader()
					.getResourceAsStream(PropertyReaderUtil.getInstance().getValue(AppConstants.REQUEST_ACTION_CONFIG_XML)));

			requestActionConfigBeanList = configuration.getRequestActionConfigBeanList();

			if (!requestActionConfigBeanList.isEmpty()) {
				for (RequestActionConfigBean requestActionConfigBean : requestActionConfigBeanList) {
					requestActionMap.put(requestActionConfigBean.getName(), requestActionConfigBean);
				}
			}
		} catch (JAXBException e) {
			logger.error("JAXBException in loadRequestActionConfig() : ", e);
		}
		CacheUtil.getInstance().add(PropertyReaderUtil.getInstance().getValue(AppConstants.REQUEST_ACTION_CONFIG_XML_DATA), requestActionMap);
	}

	/**
	 * This method is used to load service configuration xml
	 */
	@SuppressWarnings("restriction")
	public void loadServiceConfig() {
		Map<String, Object> serviceMap = new HashMap<String, Object>();

		try {
			XMLServiceConfigurationBean xmlConfiguration = (XMLServiceConfigurationBean) XmlUtil.xmlToJava(XMLServiceConfigurationBean.class,
					getClass().getClassLoader().getResourceAsStream(PropertyReaderUtil.getInstance().getValue(AppConstants.SERVICE_CONFIG_XML)));

			List<ServiceConfigBean> list = xmlConfiguration.getServiceBean();

			for (ServiceConfigBean serviceConfigBean : list) {

				List<ActionBean> actionBeans = serviceConfigBean.getAction();
				if (actionBeans != null) {
					for (ActionBean actionBean : actionBeans) {
						if (actionBean != null) {
							serviceMap.put(serviceConfigBean.getName() + AppConstants.SEPERATOR + actionBean.getName(), actionBean.getMethod());
						}
						if (actionBean != null && actionBean.getInputVO() != null) {
							serviceMap.put(serviceConfigBean.getName() + AppConstants.SEPERATOR + actionBean.getName() + AppConstants.SEPERATOR
									+ AppConstants.INPUT, actionBean.getInputVO());
						}
					}
				}
				serviceMap.put(serviceConfigBean.getName() + AppConstants.SEPERATOR + AppConstants.CLASS, serviceConfigBean.getClassName());
			}
		} catch (JAXBException e) {
			logger.error("JAXBException in loadServiceConfig() : ", e);
		}
		CacheUtil.getInstance().add(PropertyReaderUtil.getInstance().getValue(AppConstants.SERVICE_CONFIG_XML_DATA), serviceMap);
	}

}
