package com.shuframework.jdk7.lang;

import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void getTime() {
		Date date1 = DateFormatUtil.strToDate("2018-01-10 15:10:10");
		System.out.println(date1.getTime());
		
		Date date2 = new Date();
		System.out.println(date2.getTime());
	}
	
	@Test
	public void getInts_test1() {
		Date date = new Date();//2017-01-10 15:10:10  周二 
		int year = DateUtil.getYear(date);
		int month = DateUtil.getMonth(date);
		int day = DateUtil.getDay(date);
		int daysOfMonth = DateUtil.getActualDaysOfMonth(date);
		int week = DateUtil.getWeek(date);
		int week2 = DateUtil.getWeek2Zh(date);
		boolean isWeekend = DateUtil.isWeekend(date);
		
		System.out.println(year);//2017
		System.out.println(month);//1
		System.out.println(day);//10
		System.out.println(daysOfMonth);//31
		System.out.println(week);//3
		System.out.println(week2);//2
		System.out.println(isWeekend);//false
	}
	
	@Test
	public void addDay_test1() {
		Date today = new Date();
		//后一天
		Date date1 = DateUtil.addDay(today, 1);
		System.out.println(DateFormatUtil.dateToStr(date1));
		//后一天
		Date date3 = DateUtil.addDay(today, 0);
		System.out.println(DateFormatUtil.dateToStr(date3));
		//前一天
		Date date2 = DateUtil.addDay(today, -1);
		System.out.println(DateFormatUtil.dateToStr(date2));
	}
	

	@Test
	public void getStartTimeOrEndTime() {
		Date date = new Date();//2017-01-10 15:10:10  周二 
		//2017-1-10 0:00:00
		Date startTime =  DateUtil.getStartTime(date);
		System.out.println(DateFormatUtil.dateToStr(startTime));
		//2017-1-11 0:00:00
		Date endTime =  DateUtil.getEndTime(date);
		System.out.println(DateFormatUtil.dateToStr(endTime));
		
		
	}
	
	
	@Test
	public void getDate_test1() throws DatatypeConfigurationException {
		Date date = new Date();//2017-01-10 15:10:10  周二 
//		//2017-2-1 0:00:00
//		Date nextMonthDate = DateUtil.getFirstDayOfNextMonth(date);
//		System.out.println(DateFormatUtil.dateToStr(nextMonthDate));
//		
//		//2016-12-1 0:00:00
//		Date lextMonthDate = DateUtil.getFirstDayOfLastMonth(date);
//		System.out.println(DateFormatUtil.dateToStr(lextMonthDate));
		
		//2017-1-1 0:00:00
		Date newDate1 =  DateUtil.getFirstDayOfMonth(date, 1);
		System.out.println(DateFormatUtil.dateToStr(newDate1));
		
		Date date2 = DateFormatUtil.strToDate("2016-10-10 11:03:20");
		//2016-1-1 0:00:00
		Date newDate2 =  DateUtil.getFirstDayOfMonth(date2, 1);
		System.out.println(DateFormatUtil.dateToStr(newDate2));
		
		//2017-1-1 0:00:00
		Date newDate3 =  DateUtil.getFirstDayOfMonth(date);
		System.out.println(DateFormatUtil.dateToStr(newDate3));
		
		//2016-10-1 0:00:00
		Date newDate4 =  DateUtil.getFirstDayOfMonth(date2);
		System.out.println(DateFormatUtil.dateToStr(newDate4));
		
		//2017-1-1 0:00:00
		Date newDate5 =  DateUtil.getFirstDayOfMonth(1);
		System.out.println(DateFormatUtil.dateToStr(newDate5));
		
	}



}
