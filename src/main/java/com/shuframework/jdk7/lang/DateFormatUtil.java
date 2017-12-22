package com.shuframework.jdk7.lang;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * 日期转换工具类
 * 	基于java.text.SimpleDateFormat，线程不安全
 * 
 * @author shu
 */
public class DateFormatUtil {
	/**日期格式为yyyy-MM-dd HH:mm:ss.SSS*/
	public static final String YMD_HMS_S ="yyyy-MM-dd HH:mm:ss.SSS";
	/**日期格式为yyyy-MM-dd HH:mm:ss*/
	public static final String YMD_HMS ="yyyy-MM-dd HH:mm:ss";
	/**日期格式为yyyy-MM-dd*/
	public static final String YMD ="yyyy-MM-dd";


	/**
	 * 将指定字符(String)串转换成日期 (Date),格式是yyyy-MM-dd HH:mm:ss <br>
	 * 如果发生错误，则返回 null, 格式不是yyyy-MM-dd HH:mm:ss也会返回null
	 * 
	 * @param dateStr	String 日期字符串
	 * @return Date
	 */
	public static Date strToDate(String dateStr) {
//		SimpleDateFormat sd = new SimpleDateFormat(YMD_HMS);
//		// return sd.parse(dateStr);//这样可能会出 类型现转换异常
//		return sd.parse(dateStr, new java.text.ParsePosition(0));
		return strToDate(dateStr, YMD_HMS);
	}
	
	/**
	 * 将指定字符(String)串转换成日期 (Date)<br/>
	 * 如果发生格式对不上差一部分，则返回 null。
	 * 如果发生格式对不上多一部分，则返回 datePattern的格式。
	 * <p>
	 * 	datePattern为yyyy-MM-dd，dateStr为""或"2017-01"，则返回null
	 * 	datePattern为yyyy-MM-dd，dateStr为"2017-01-01 12"，则返回"2017-01-01"对应的日期
	 * </p>
	 * 
	 * @param dateStr	String 日期字符串
	 * @param datePattern	String 日期格式
	 * @return Date
	 */
	public static Date strToDate(String dateStr, String datePattern) {
		SimpleDateFormat sd = new SimpleDateFormat(datePattern);
		// return sd.parse(dateStr);//这样可能会出 类型现转换异常
		return sd.parse(dateStr, new java.text.ParsePosition(0));
	}

	/**
	 * 将指定日期(Date)对象转换成 格式化字符串 (String),格式是yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date	Date 日期对象
	 * @return String
	 */
	public static String dateToStr(Date date) {
//		SimpleDateFormat sd = new SimpleDateFormat(YMD_HMS);
//		return sd.format(date);
		return dateToStr(date, YMD_HMS);
	}
	
	/**
	 * 将指定日期(Date)对象转换成 格式化字符串 (String)
	 * 
	 * @param date	Date 日期对象
	 * @param datePattern	String 日期格式
	 * @return String
	 */
	public static String dateToStr(Date date, String datePattern) {
		SimpleDateFormat sd = new SimpleDateFormat(datePattern);
		return sd.format(date);
	}
	
	/**
	 * 将指定时间戳(timestamp) 转换成 格式化日期(Date),格式是yyyy-MM-dd HH:mm:ss
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(long timestamp){
		return timestampToDate(timestamp, YMD_HMS);
	}
	
	/**
	 * 将指定时间戳(timestamp) 转换成 格式化日期(Date)
	 * @param timestamp		时间戳
	 * @param datePattern	日期格式
	 * @return
	 */
	public static Date timestampToDate(long timestamp, String datePattern){
		SimpleDateFormat sd = new SimpleDateFormat(datePattern);
		String dateStr = sd.format(timestamp);
		return sd.parse(dateStr, new java.text.ParsePosition(0));
	}
	
	/**
	 * 将指定XML日期(XMLGregorianCalendar)对象转换成 格式化字符串 (String),格式是yyyy-MM-dd HH:mm:ss.SSS
	 * 
	 * @param xmlDate	Date XML日期对象
	 * @return String
	 */
	public static String xmlDateToStr(XMLGregorianCalendar xmlDate) {
		return xmlDateToStr(xmlDate, YMD_HMS_S);
//		return xmlDate.toString();//转成的格式是2017-01-10T10:54:36.647+08:00
	}
	
	/**
	 * 将指定XML日期(XMLGregorianCalendar)对象转换成 格式化字符串 (String)
	 * 
	 * @param xmlDate	Date XML日期对象
	 * @param datePattern	String 日期格式
	 * @return String
	 */
	public static String xmlDateToStr(XMLGregorianCalendar xmlDate,String datePattern) {
		SimpleDateFormat sd = new SimpleDateFormat(datePattern);
		Calendar calendar = xmlDate.toGregorianCalendar();
		return sd.format(calendar.getTime());
	}
	
	/**
	 * 字符串 (String),格式是yyyy-MM-dd HH:mm:ss转换成XML日期(XMLGregorianCalendar)对象
	 * 
	 * @param dateStr	String 日期字符串
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar strToXmlDate(String dateStr) {
		return strToXmlDate(dateStr, YMD_HMS);
	}
	
	/**
	 * 字符串 (String) 转换成XML日期(XMLGregorianCalendar)对象
	 * 
	 * @param dateStr	String 日期字符串
	 * @param datePattern	String 日期格式
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar strToXmlDate(String dateStr, String datePattern) {
		return dateToXmlDate(strToDate(dateStr, datePattern));
	}

	/**
	 * 将指定XML日期(XMLGregorianCalendar)对象转换成 日期对象 (Date)
	 * 
	 * @param xmlDate	Date XML日期对象
	 * @return Date
	 */
	public static Date xmlDateToDate(XMLGregorianCalendar xmlDate) {
		return xmlDate.toGregorianCalendar().getTime();
	}
	
	/**
	 * 将指定日期对象 (Date)转换成 XML日期(XMLGregorianCalendar) 对象
	 * 
	 * @param date	Date 日期对象
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar dateToXmlDate(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar gc = null;
		try {
			gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gc;
	}

	/**
	 * 获得当前时间的str格式，格式为yyyyMMddHHmmss
	 * 
	 * @Title: todayStr
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public static String today2YyyyMMddHHmmss() {
		Date date = new Date();
		return dateToStr(date, "yyyyMMddHHmmss");
	}
	
	/**
	 * 获得当前时间的str格式，格式为yyyyMMddHHmmssSSS
	 * 
	 * @Title: todayStr
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public static String today2YyyyMMddHHmmssSSS() {
		Date date = new Date();
		return dateToStr(date, "yyyyMMddHHmmssSSS");
	}
	
	/**
	 * 获得当前时间的str格式，格式为yyMMddHHmmss
	 * 
	 * @Title: todayStr
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public static String today2YyMMddHHmmss() {
		Date date = new Date();
		return dateToStr(date, "yyMMddHHmmss");
	}
	
	/**
	 * 获得当前时间的str格式，格式为yyMMddHHmmssSSS
	 * 
	 * @Title: todayStr
	 * @param @return    设定文件
	 * @return String    返回类型
	 */
	public static String today2YyMMddHHmmssSSS() {
		Date date = new Date();
		return dateToStr(date, "yyMMddHHmmssSSS");
	}
	
}
