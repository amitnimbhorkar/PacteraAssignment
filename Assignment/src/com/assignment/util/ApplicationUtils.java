package com.assignment.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ApplicationUtils {

	public static float convertKelvinToCelcius(float tempratureInFloat) {
		return (float) (tempratureInFloat - 273.15);
	}

	public static String convertDateToStringInReqFormat(Long inputDate, final String dateformat) {
		Date date = new Date((inputDate * 1000));
		DateFormat format = new SimpleDateFormat(dateformat);
		format.setTimeZone(TimeZone.getTimeZone(IApplicationConstants.DEFAULT_TIMEZONE));
		return format.format(date);
	}
}
