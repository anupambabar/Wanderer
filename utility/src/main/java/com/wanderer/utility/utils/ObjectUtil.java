/**
 * 
 */
package com.wanderer.utility.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author anupam.babar
 *
 */
public class ObjectUtil {

	private static final Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

	private ObjectUtil() {
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object cloneObject(Object obj) {

		Object clone = null;

		try {
			clone = obj.getClass().newInstance();
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				field.set(clone, field.get(obj));
			}

		} catch (Exception e) {
			logger.error("Exception in cloneObject() : ", e);
		}
		return clone;
	}

	/**
	 * @param value
	 * @param size
	 * @return
	 */
	public static final String zeroPad(String value, int size) {
		String s = "000000000000000000" + value;
		return s.substring(s.length() - size);
	}

	/**
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal getCommaAddedBigDecimal(BigDecimal bigDecimal) {

		DecimalFormat df = new DecimalFormat("#,##0.00");
		String strDecimal = df.format(bigDecimal);

		return new BigDecimal(strDecimal);
	}

}
