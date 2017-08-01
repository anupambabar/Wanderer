package com.wanderer.utility.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wanderer.utility.constants.AppConstants;

/**
 * 
 * @author anupam.babar
 */
public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static ObjectMapper mapper = new ObjectMapper();

	private JsonUtil() {
	}

	static {
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setTimeZone(TimeZone.getTimeZone(PropertyReaderUtil.getInstance().getValue(AppConstants.TIME_ZONE)));
		DateFormat dateFormat = new SimpleDateFormat(PropertyReaderUtil.getInstance().getValue(AppConstants.DATE_FORMAT));
		mapper.setTimeZone(TimeZone.getTimeZone("IST"));
		mapper.setDateFormat(dateFormat);
	}

	/**
	 * @param jsonString
	 * @param classObj
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getObject(String jsonString, Class classObj) throws IOException {
		return mapper.readValue(jsonString, classObj);
	}

	/**
	 * @param jsonString
	 * @param classObj
	 * @param objectMapper
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getOffersObject(String jsonString, Class classObj, ObjectMapper objectMapper) throws IOException {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setTimeZone(TimeZone.getTimeZone("IST"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		objectMapper.setDateFormat(dateFormat);
		return objectMapper.readValue(jsonString, classObj);
	}

	/**
	 * @param jsonString
	 * @return
	 * @throws IOException
	 */
	public static String getJSONString(Object jsonString) throws IOException {
		return mapper.writeValueAsString(jsonString);
	}

	/**
	 * @param jsonString
	 * @param namingStrategy
	 * @return
	 * @throws IOException
	 */
	public static String getJSONString(Object jsonString, PropertyNamingStrategy namingStrategy) throws IOException {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.setPropertyNamingStrategy(namingStrategy);
		return objMapper.writeValueAsString(jsonString);
	}

	/**
	 * @param jsonString
	 * @param classObj
	 * @param namingStrategy
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getObject(String jsonString, Class classObj, PropertyNamingStrategy namingStrategy) throws IOException {
		ObjectMapper objMapper = new ObjectMapper();
		objMapper.setPropertyNamingStrategy(namingStrategy);
		return objMapper.readValue(jsonString, classObj);
	}

	/**
	 * @param inputParam
	 * @return
	 */
	public static String getRequestAction(String inputParam) {

		JSONParser jParser = new JSONParser();
		JSONObject reqObj;
		String requestAction = null;
		try {
			reqObj = (JSONObject) jParser.parse(inputParam);
			requestAction = (String) reqObj.get(AppConstants.REQUEST_KEY_REQUESTACTION);
		} catch (ParseException e) {
			logger.error("Exception in getRequestAction() : ", e);
		}

		return requestAction;
	}

	/**
	 * @param inputParam
	 * @return
	 */
	public static String getsessionId(String inputParam) {

		JSONParser jParser = new JSONParser();
		JSONObject reqObj;
		String requestAction = null;
		try {
			reqObj = (JSONObject) jParser.parse(inputParam);
			requestAction = (String) reqObj.get(AppConstants.REQUEST_KEY_SESSIONID);
		} catch (ParseException e) {
			logger.error("Exception in getsessionId() : ", e);
		}

		return requestAction;
	}

	/**
	 * @param inputParam
	 * @return
	 */
	public static int getUserId(String inputParam) {

		JSONParser jParser = new JSONParser();
		JSONObject reqObj;
		int userId = 0;
		try {
			reqObj = (JSONObject) jParser.parse(inputParam);
			userId = (Integer) reqObj.get(AppConstants.REQUEST_KEY_USERID);
		} catch (ParseException e) {
			logger.error("Exception in getUserId() : ", e);
		}

		return userId;
	}
	
	/**
	 * @param inputParam
	 * @return
	 */
	public static int getActivityId(String inputParam) {

		JSONParser jParser = new JSONParser();
		JSONObject reqObj;
		int activityId = 0;
		try {
			reqObj = (JSONObject) jParser.parse(inputParam);
			activityId = (Integer) reqObj.get(AppConstants.REQUEST_KEY_ACTIVITYID);
		} catch (ParseException e) {
			logger.error("Exception in getUserId() : ", e);
		}

		return activityId;
	}

}

class UnixTimestampDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		String unixTimestamp = parser.getText().trim();
		return new Date(TimeUnit.SECONDS.toMillis(Long.valueOf(unixTimestamp)));
	}
}
