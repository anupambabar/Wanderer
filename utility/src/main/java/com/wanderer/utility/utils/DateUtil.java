package com.wanderer.utility.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author anupam.babar
 */
public class DateUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private DateUtil() {
	}

	/**
	 * @return
	 */
	public static Date getDate() {
		return new Date();
	}

	/**
	 * @param timestamp
	 * @return
	 */
	public static int getTimestampDay(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * @param timestamp
	 * @return
	 */
	public static int getTimestampDate(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.DATE);
	}

	/**
	 * @param timestamp
	 * @return
	 */
	public static int getTimestampMonth(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.MONTH);
	}

	/**
	 * @param timestamp
	 * @return
	 */
	public static int getTimestampYear(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		return cal.get(Calendar.YEAR);
	}

	/**
	 * @param monthNumber
	 * @return
	 */
	public static String getMonthNameFromMonthNumber(int monthNumber) {
		String month = "";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (monthNumber >= 0 && monthNumber <= 11) {
			month = months[monthNumber];
		}
		return month;
	}

	/**
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}

	/**
	 * @return
	 */
	public static Date getCurrentDate() {
		return new java.util.Date();
	}

	/**
	 * @return
	 */
	public static String getShortDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String shortDate = sdf.format(new Date());
		shortDate = shortDate.replace("/", "");
		shortDate = shortDate.substring(0, 2) + shortDate.substring(2, 4) + shortDate.substring(6, 8);
		return shortDate;
	}

	/**
	 * @param otpGeneratedOn
	 * @param expMin
	 * @return
	 *//*
		 * public static String getTimeDifferneceinMinutes(long otpGeneratedOn,
		 * int expMin) { long duration = TimeUnit.MINUTES.toMillis(expMin); long
		 * diff = DateUtil.getCurrentTimestamp().getTime() - otpGeneratedOn; if
		 * (duration > diff) return AppConstants.RESULT_SUCCESS; else return
		 * AppConstants.RESULT_FAILURE; }
		 */
	/**
	 * @param timestamp
	 * @return
	 */
	public static int getTimeDifferenceInDays(Timestamp timestamp) {

		int difference = 0;
		if (timestamp.after(getCurrentTimestamp())) {
			long diff = timestamp.getTime() - getCurrentTimestamp().getTime();
			difference = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
		return difference;
	}

	/**
	 * @param dateString
	 * @param sourceDateFormat
	 * @param destinationDateFormat
	 * @return
	 */
	public static String formatDate(String dateString, String sourceDateFormat, String destinationDateFormat) {

		String result = "";
		try {
			SimpleDateFormat sdfDestination = new SimpleDateFormat(destinationDateFormat);
			DateFormat sdfSource = new SimpleDateFormat(sourceDateFormat);
			Date formattedDate = sdfSource.parse(dateString);
			if (isNullOrEmpty(dateString)) {
				result = "";
			}
			result = sdfDestination.format(formattedDate);
		} catch (Exception e) {
			logger.error("Exception in DateUtil.formatDate() : ", e);
		}

		return result;
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param one
	 * @param two
	 * @return
	 */
	public static double getDueDaysPercentage(Timestamp one, Timestamp two) {

		double percentage;

		if (getCurrentTimestamp().before(two)) {

			long totalDiff = two.getTime() - one.getTime();
			int totalDueDays = (int) TimeUnit.DAYS.convert(totalDiff, TimeUnit.MILLISECONDS);

			long diff = getCurrentTimestamp().getTime() - one.getTime();
			int dueDays = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

			percentage = (dueDays * 100.0f) / totalDueDays;
		} else {
			percentage = 100;
		}

		return round(percentage, 2);
	}

	/**
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * @param date
	 * @return
	 */
	public static Timestamp getTimestampFromString(String date) {
		return Timestamp.valueOf(date);
	}

	/**
	 * @param date
	 * @return
	 */
	public static String getCardCompleteExpiryDate(String date) {
		String day = "01";
		String month = date.substring(0, 2);
		String year = date.substring(3);
		String strDate = year + "-" + month + "-" + day + " 00:00:00.000";
		return strDate;
	}

	/**
	 * @param date
	 * @return
	 */
	public static String getCardDates(String date) {
		String day = date.substring(0, 2);
		String month = date.substring(3, 5);
		String year = date.substring(6);
		String strDate = year + "-" + month + "-" + day + " 00:00:00.000";
		return strDate;
	}
}
