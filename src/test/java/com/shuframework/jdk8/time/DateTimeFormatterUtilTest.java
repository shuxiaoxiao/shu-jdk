package com.shuframework.jdk8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

public class DateTimeFormatterUtilTest {

	@Test
	public void test() {
		String dateTimeStr = "2017-12-13 12:20:30";
		final String datePattern ="yyyy-MM-dd HH:mm:ss";
		LocalDate localDate = DateTimeFormatterUtil.strToDate(dateTimeStr, datePattern);
		System.out.println(localDate);
		
		LocalDateTime localDateTime = DateTimeFormatterUtil.strToDateTime(dateTimeStr, datePattern);
		System.out.println(localDateTime);
	}
	
	@Test
	public void test2() {
		String dateTimeStr = "2017-12-13";
		final String datePattern ="yyyy-MM-dd";
//		String dateTimeStr = "2017-12-13 12:20:30";
//		final String datePattern ="yyyy-MM-dd HH:mm:ss";
		LocalDateTime localDateTime = DateTimeFormatterUtil.strToDateTime(dateTimeStr, datePattern);
		System.out.println(localDateTime);
	}

}
