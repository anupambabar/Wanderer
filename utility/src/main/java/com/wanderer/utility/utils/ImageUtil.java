package com.wanderer.utility.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author anupam.babar
 *
 */
public class ImageUtil {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ImageUtil.class);
	
	private ImageUtil(){
	}

	/**
	 * @param image
	 * @return
	 */
	public static String getStringFromLob(byte[] image) {
		Base64 base64 = new Base64();
		String result = null;
		byte[] encodeBase64;
		try {
			encodeBase64 = (byte[]) base64.encode(image);
			result = new String(encodeBase64, "UTF-8");
		} catch (Exception e) {
			logger.error("Exception in getStringFromLob() : ", e);
		}
		return result;
	}
	
	/**
	 * @param image
	 * @return
	 */
	public static byte[] getLobFromString(String image) {
		Base64 base64 = new Base64();
		byte[] result = null;
		byte[] decodeBase64;
		try {
			decodeBase64 = base64.decode(image);
			result = decodeBase64.clone();
		} catch (Exception e) {
			logger.error("Exception in getStringFromLob() : ", e);
		}
		
		return result;
	}
	
	/**
	 * @param image
	 * @return
	 */
	public static String getStringFromImage(MultipartFile image) {
		Base64 base64 = new Base64();
		String result = null;
		byte[] encodeBase64;
		try {
			encodeBase64 = base64.encode(image.getBytes());
			result = new String(encodeBase64, "UTF-8");
		} catch (Exception e) {
			logger.error("Exception in getStringFromImage() : ", e);
		}
		return result;
	}
}
