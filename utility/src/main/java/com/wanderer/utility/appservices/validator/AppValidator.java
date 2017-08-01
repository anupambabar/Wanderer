package com.wanderer.utility.appservices.validator;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author anupam.babar
 */
public class AppValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object object, Errors errors) {
	}

	/**
	 * @param fieldval
	 * @param fieldlabel
	 * @return
	 */
	public boolean checkValidEmail(String fieldval) {
		boolean checkstatus = false;
		Pattern p = Pattern.compile("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
		Matcher m = p.matcher(fieldval);
		boolean matchFound = m.matches();
		if (matchFound) {
			checkstatus = true;
		}
		return checkstatus;
	}

	/**
	 * @param phoneNum
	 * @return
	 */
	public static boolean validatePhoneNum(String phoneNum) {
		boolean result = false;
		if (phoneNum != null && phoneNum.matches("^[+]{0,1}[0-9 ()-]{3,25}$"))
			result = true;
		return result;
	}

	/**
	 * @param phoneNum
	 * @return
	 */
	public static boolean validateMobNum(String phoneNum) {
		boolean result = false;
		try {
			phoneNum = phoneNum.trim();
			Long.parseLong(phoneNum);
			if (phoneNum.contains(".") || phoneNum.contains("-"))
				throw new Exception();
			if (phoneNum.length() < 15) {
				result = true;
			}
		} catch (Exception e) {

		}
		return result;
	}

	/**
	 * @param fieldval
	 * @return
	 */
	public static boolean isSpecialChar(String fieldval) {
		boolean checkstatus = true;
		Pattern regex = Pattern.compile("[^A-Za-z0-9. ]");
		Matcher matcher = regex.matcher(fieldval);
		if (!matcher.find()) {
			checkstatus = false;
		}
		return checkstatus;
	}

	/**
	 * @param date
	 * @return
	 */
	public static boolean isValidDate(String date) {
		if (date == null) {
			return false;
		}
		if (date.length() != 10) {
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		format.setLenient(false);
		try {
			format.parse(date);
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
		return true;
	}

	/**
	 * @param cmp1
	 * @param cmp2
	 * @return
	 */
	public static boolean compareString(String cmp1, String cmp2) {
		if (cmp1 == null || cmp2 == null) {
			return false;
		}
		return cmp1.equals(cmp2);
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * @param name
	 * @return
	 */
	public boolean isAlpha(String name) {
		return name.matches("[a-zA-Z]+");
	}

	/**
	 * @param name
	 * @return
	 */
	public boolean isNumber(String name) {
		return name.matches("[0-9]+");
	}

}
