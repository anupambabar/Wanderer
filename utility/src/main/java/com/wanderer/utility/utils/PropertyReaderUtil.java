package com.wanderer.utility.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author anupam.babar
 */
public class PropertyReaderUtil {

	private static final Logger logger = LoggerFactory.getLogger(PropertyReaderUtil.class);

	private static PropertyReaderUtil instance = null;
	private Properties appProperties;
	private Properties envProperties;
	InputStream appInput = null;
	InputStream envInput = null;

	private PropertyReaderUtil() throws IOException {
		logger.info("Reading property file");

		appProperties = new Properties();
		appInput = getClass().getClassLoader().getResourceAsStream("application.properties");
		envProperties = new Properties();
		envInput = getClass().getClassLoader().getResourceAsStream("env-" + System.getProperty("WANDERER_ENV") + ".properties");
		envProperties.load(envInput);
		appProperties.load(appInput);
		appProperties.putAll(envProperties);

		logger.info("Property file read successfully");
	}

	public static PropertyReaderUtil getInstance() {
		if (null == instance) {
			try {
				instance = new PropertyReaderUtil();
			} catch (Exception e) {
				logger.error("Error while reading property file", e);
			}
		}
		return instance;
	}

	/**
	 * @return
	 */
	public static boolean refreshInstance() {
		boolean isRefreshed = false;
		try {
			instance = new PropertyReaderUtil();
			isRefreshed = true;
		} catch (IOException e) {
			logger.error("Error while reading property file", e);
		}
		return isRefreshed;
	}

	/**
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return appProperties.getProperty(key);
	}

	public Properties getProperties() {
		return appProperties;
	}

}
