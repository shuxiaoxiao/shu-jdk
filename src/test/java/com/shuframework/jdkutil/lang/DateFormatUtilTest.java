package com.shuframework.jdkutil.lang;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

public class DateFormatUtilTest {
	
	@Test
	public void dateToXmlDate_test1() throws DatatypeConfigurationException {
		Date date = new Date();
		XMLGregorianCalendar xgcal = DateFormatUtil.dateToXmlDate(date);
		System.out.println(xgcal);//2017-01-10T11:43:20.237+08:00
	}
	
	@Test
	public void xmlDateToDate_test1() throws DatatypeConfigurationException {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal= DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		Date date = DateFormatUtil.xmlDateToDate(xgcal);
		System.out.println(date);//Tue Jan 10 11:40:18 CST 2017
	}
	
	@Test
	public void strToXmlDate_test1() throws DatatypeConfigurationException {
		String dateStr = "2017-01-10 11:26:05";
		XMLGregorianCalendar xmlDate = DateFormatUtil.strToXmlDate(dateStr);
		System.out.println(xmlDate);//2017-01-10T11:26:05.000+08:00
	}
	
	@Test
	public void strToXmlDate_test2() throws DatatypeConfigurationException {
		String dateStr = "2017-01-10 11:26:05.728";
		XMLGregorianCalendar xmlDate = DateFormatUtil.strToXmlDate(dateStr, "yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(xmlDate);//2017-01-10T11:26:05.728+08:00
	}
	
	@Test
	public void xmlDateToStr_test1() throws DatatypeConfigurationException {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal= DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		System.out.println(xgcal);//2017-01-10T11:26:05.728+08:00
		String dateStr = DateFormatUtil.xmlDateToStr(xgcal);
		System.out.println(dateStr);//2017-01-10 11:26:05.728
	}
	
	@Test
	public void xmlDateToStr_test2() throws DatatypeConfigurationException {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal= DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		System.out.println(xgcal);//2017-01-10T11:26:05.728+08:00
		String dateStr = DateFormatUtil.xmlDateToStr(xgcal, "yyyy-MM-dd HH:mm:ss");
		System.out.println(dateStr);//2017-01-10 11:26:05
	}
	
	@Test
	public void timestampToDate_test2() {
		long timestamp = System.currentTimeMillis();
		Date date = DateFormatUtil.timestampToDate(timestamp, "yyyy-MM-dd");
		System.out.println(date);//Wed Jan 18 00:00:00 CST 2017
	}
	
	@Test
	public void timestampToDate_test1() {
		long timestamp = System.currentTimeMillis();
		Date date = DateFormatUtil.timestampToDate(timestamp);
		System.out.println(date);//Wed Jan 18 11:31:18 CST 2017
	}
	
	@Test
	public void dateToStr_test1() {
		Date date = new Date();
		String dateStr = DateFormatUtil.dateToStr(date);
		System.out.println(dateStr);//2017-01-01 10:23:06
	}
	
	@Test
	public void dateToStr_test2() {
		Date date = new Date();
		String dateStr = DateFormatUtil.dateToStr(date, "yyyy-MM-dd");
		System.out.println(dateStr);//2017-01-01 
	}
	
	@Test
	public void strToDate_test1() {
		String dateStr = "";
//		String dateStr = "2017-01-01"; //返回也是null
		//由于需要yyyy-MM-dd HH:mm:ss 格式, 传入格式不满足,返回null
		Date date = DateFormatUtil.strToDate(dateStr);
		System.out.println(date);//null
	}
	
	@Test
	public void strToDate_test2() {
		String dateStr = "2017-01-01 12:00:00";
		Date date = DateFormatUtil.strToDate(dateStr);
		System.out.println(date);//Sun Jan 01 12:00:00 CST 2017
	}
	
	@Test
	public void strToDate_test3() {
		String dateStr = "2017-01-01";
		Date date = DateFormatUtil.strToDate(dateStr, "yyyy-MM-dd");
		//Sun Jan 01 00:00:00 CST 2017
		System.out.println(date);
	}
	
	@Test
	public void strToDate_test4() {
		//果发生格式对不上差一部分，则返回 null。
//		String dateStr = "";
		String dateStr = "2017-01";
		Date date = DateFormatUtil.strToDate(dateStr, "yyyy-MM-dd");
		System.out.println(date);//null
	}
	
	@Test
	public void strToDate_test5() {
		//如果发生格式对不上多一部分，则返回 datePattern的格式
		String dateStr = "2017-01-01 12"; 
		Date date = DateFormatUtil.strToDate(dateStr, "yyyy-MM-dd");
		System.out.println(date);//Sun Jan 01 00:00:00 CST 2017
	}

}
