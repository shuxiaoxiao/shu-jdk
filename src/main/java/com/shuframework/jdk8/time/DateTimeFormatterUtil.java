package com.shuframework.jdk8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * jdk8 日期转换
 * 	需要注意的是转换时, 格式长的可以变为短的时间, 
 * 
 * @author shu
 *
 */
public class DateTimeFormatterUtil {

	/**日期格式为yyyy-MM-dd HH:mm:ss.SSS*/
	public static final String YMD_HMS_S ="yyyy-MM-dd HH:mm:ss.SSS";
	/**日期格式为yyyy-MM-dd HH:mm:ss*/
	public static final String YMD_HMS ="yyyy-MM-dd HH:mm:ss";
	/**日期格式为yyyy-MM-dd*/
	public static final String YMD ="yyyy-MM-dd";
	
	
	public static LocalDate strToDate(String dateStr) {
		return strToDate(dateStr, YMD);
	}
	
	public static LocalDate strToDate(String dateStr, String datePattern) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
		TemporalAccessor dateTemp = format.parse(dateStr);
		return LocalDate.from(dateTemp);
	}
//	//与strToDate实现一样
//	public static LocalDate strToDate2(String dateStr, String datePattern) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
//		LocalDate localDate = LocalDate.parse(dateStr, format);
//		return localDate;
//	}
	
	public static LocalDateTime strToDateTime(String dateTimeStr) {
		return strToDateTime(dateTimeStr, YMD_HMS);
	}
	
	public static LocalDateTime strToDateTime(String dateTimeStr, String datePattern) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
		TemporalAccessor dateTemp = format.parse(dateTimeStr);
		return LocalDateTime.from(dateTemp);
	}
//	//与strToDateTime实现一样
//	public static LocalDateTime strToDateTime2(String dateTimeStr, String datePattern) {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern(datePattern);
//		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, format);
//		return LocalDateTime.from(localDateTime);
//	}
}
