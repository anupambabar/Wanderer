package com.wanderer.utility.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author anupam.babar
 */
public class CacheUtil {

	private static final Logger logger = LoggerFactory.getLogger(CacheUtil.class);

	private static final Map<String, Object> MAP = new HashMap<String, Object>();
	private static final CacheUtil INSTANCE = new CacheUtil();

	private CacheUtil() {
	}

	public static CacheUtil getInstance() {
		logger.info("Cache Instance created.");
		return INSTANCE;
	}

	/**
	 * @param key
	 * @param value
	 */
	public void add(String key, Object value) {
		MAP.put(key, value);
	}

	/**
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return MAP.get(key);
	}

	/**
	 * @param key
	 */
	public void remove(String key) {
		MAP.remove(key);
	}

	/**
	 * Not yet sure about the functionality to be added
	 */
	public void shutdown() {

		// Not yet sure about the functionality to be added
	}
}
