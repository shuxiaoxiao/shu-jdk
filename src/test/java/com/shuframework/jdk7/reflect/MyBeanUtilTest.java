package com.shuframework.jdk7.reflect;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.shuframework.jdk7.lang.DateFormatUtil;
import com.shuframework.testmodel.BookInfo;
import com.shuframework.testmodel.BookInfo2;

public class MyBeanUtilTest {

	@Test
	public void test1() {
		String propertyName = "name";
		String value = "aa";
		//这样操作的对象不是同一个
		MyBeanUtil.setProperty(BookInfo.class, propertyName, value);
		Object property = MyBeanUtil.getProperty(BookInfo.class, propertyName);
		System.out.println(property);
	}
	
	@Test
	public void test2() {
		String propertyName = "name";
		String value = "aa";
//		BookInfo bookInfo = BookInfo.class.newInstance();
		BookInfo bookInfo = MyBeanUtil.newInstance(BookInfo.class);
		MyBeanUtil.setProperty(bookInfo, propertyName, value);
		Object property = MyBeanUtil.getProperty(bookInfo, propertyName);
		System.out.println(property);
	}
	
	@Test
	public void test3() {
		String propertyName = "name";
		String value = "aab";
//		BookInfo bookInfo = BookInfo.class.newInstance();
		BookInfo bookInfo = MyBeanUtil.newInstance(BookInfo.class);
		MyBeanUtil.setPropertyByField(bookInfo, propertyName, value);
		Object property = MyBeanUtil.getPropertyByField(bookInfo, propertyName);
		System.out.println(property);
	}
	
	@Test
	public void test5() {
		String propertyName = "name";
		String value = "aab";
//		BookInfo bookInfo = BookInfo.class.newInstance();
		BookInfo bookInfo = MyBeanUtil.newInstance(BookInfo.class);
		MyBeanUtil.setProperty(bookInfo, propertyName, value);
		Object property = MyBeanUtil.getPropertyByField(bookInfo, propertyName);
		System.out.println(property);
	}
	
	@Test
	public void property_test1() {
		String propertyName = "createTime";
		BookInfo bookInfo = MyBeanUtil.newInstance(BookInfo.class);
		MyBeanUtil.setProperty(bookInfo, propertyName, new Date());
		Object property = MyBeanUtil.getProperty(bookInfo, propertyName);
//		Object property = MyBeanUtil.getPropertyByField(bookInfo, propertyName);
		System.out.println(property);
		Date createTime = (Date)property;
		System.out.println(DateFormatUtil.dateToStr(createTime));
	}
	@Test
	public void property_test2() {
		String propertyName = "createTime";
		BookInfo bookInfo = MyBeanUtil.newInstance(BookInfo.class);
		MyBeanUtil.setProperty(bookInfo, propertyName, new Date());
//		Object property = MyBeanUtil.getProperty(bookInfo, propertyName);
		Object property = MyBeanUtil.getPropertyByField(bookInfo, propertyName);
		System.out.println(property);
		Date createTime = (Date)property;
		System.out.println(DateFormatUtil.dateToStr(createTime));
	}
	
	@Test
	public void mapToBean_test1() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("name", "a");
		map.put("createTime", new Date());
		map.put("bookInfo2", new BookInfo2(2, "bb"));
		
		BookInfo bookInfo = new BookInfo();
		MyBeanUtil.mapToBean(map, bookInfo);
		System.out.println(bookInfo);
		System.out.println(bookInfo.getBookInfo2());
	}
	
	@Test
	public void beanToMap_test1() {
		BookInfo bookInfo = new BookInfo(1, "aa", new Date());
		Map<String, Object> map = MyBeanUtil.beanToMap(bookInfo);
		System.out.println(map);
	}
	
	@Test
	public void beanToMap_test2() {
		BookInfo bookInfo = new BookInfo(1, "aa");
		bookInfo.setBookInfo2(new BookInfo2(2, "bb"));
		Map<String, Object> map = MyBeanUtil.beanToMap(bookInfo);
		System.out.println(map);
	}

}
