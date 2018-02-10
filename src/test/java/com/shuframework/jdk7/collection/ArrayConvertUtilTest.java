package com.shuframework.jdk7.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ArrayConvertUtilTest {

	@Test
	public void toString_test1() {
		String[] strArr2 = null; 
		String str3 = ArrayConvertUtil.toString(strArr2);
		System.out.println(str3);
		
		String[] strArr = {"a1", "a3", "a4", "a2", "a5"}; 
		String str1 = ArrayConvertUtil.toString(strArr);
		System.out.println(str1);
		
		Integer[] intArr = {1, 3, 4, 2, 5}; 
		String str2 = ArrayConvertUtil.toString(intArr);
		System.out.println(str2);
	}
	
	@Test
	public void toString2_test1() {
		String[] strArr2 = null; 
		String str3 = ArrayConvertUtil.toString2(strArr2);
		System.out.println(str3);
		
		String[] strArr = {"a1", "a3", "a4", "a2", "a5"}; 
		String str1 = ArrayConvertUtil.toString2(strArr);
		System.out.println(str1);
		
		Integer[] intArr = {1, 3, 4, 2, 5}; 
		String str2 = ArrayConvertUtil.toString2(intArr);
		System.out.println(str2);
	}
	
	@Test
	public void toString_test2() {
		List<String> strList3 = null; 
		String str3 = ArrayConvertUtil.toString(strList3);
		System.out.println(str3);
		List<String> strList2 = new ArrayList<>(); 
		String str2 = ArrayConvertUtil.toString(strList2);
		System.out.println(str2);
		
		List<String> strList = new ArrayList<>(); 
		strList.add("a1");
		strList.add("a3");
		strList.add("a4");
		strList.add("a5");
		strList.add("a2");
		String str1 = ArrayConvertUtil.toString(strList);
		System.out.println(str1);
		
		//set 无序
		Set<String> strSet = new HashSet<>(); 
		strSet.add("a1");
		strSet.add("b4");
		strSet.add("a3");
		strSet.add("a2");
		strSet.add("a5");
//		strSet.add("cc");
//		strSet.add("aa");
//		strSet.add("bb");
		String str5 = ArrayConvertUtil.toString(strSet);
		System.out.println(str5);
		System.out.println(strSet.toString());
	}
	
	@Test
	public void collection2Array_test1() {
		List<Object> strList = new ArrayList<>(); 
		strList.add("a1");
		strList.add("a3");
		strList.add("a4");
		strList.add("a5");
		strList.add("a2");
		
//		String[] strArr = ArrayConvertUtil.collection2Array(strList, String[].class);
		Object[] strArr = ArrayConvertUtil.collection2Array(strList, Object[].class);
		System.out.println(ArrayConvertUtil.toString(strArr));
		
//		//set 无序
//		Set<String> strSet = new HashSet<>(); 
//		strSet.add("a1");
//		strSet.add("b4");
//		strSet.add("a3");
//		strSet.add("a2");
//		strSet.add("a5");
////		strSet.add("cc");
////		strSet.add("aa");
////		strSet.add("bb");
//		String str5 = ArrayConvertUtil.toString(strSet);
//		System.out.println(str5);
	}
	
	
	@Test
	public void array2Str_test1() {
		String[] strArr = {"a1", "a3", "a4", "a2", "a5"};
		String str = ArrayConvertUtil.array2Str(strArr);
		//a1,a3,a4,a2,a5
		System.out.println(str);
	}
	
	@Test
	public void array2ListOfFixed_test1() {
		String[] strArr = {"a1", "a3", "a4", "a2", "a5"};
		List<String> list = ArrayConvertUtil.array2ListOfFixed(strArr);
		//[a1, a3, a4, a2, a5]
//		//java.lang.UnsupportedOperationException
//		list.add("a6");
		list.set(2, "a6");//[a1, a3, a6, a2, a5]
		System.out.println(list);
	}
	
//	@Test
//	public void array2ListOfVar_test1() {
//		String[] strArr = {"a1", "a3", "a4", "a2", "a5"};
//		List<String> list = new ArrayList<>();
//		ArrayConvertUtil.array2ListOfVar(strArr, list);
//		//[a1, a3, a4, a2, a5]
//		list.add("a6");//[a1, a3, a4, a2, a5, a6]
////		list.set(2, "a6");//[a1, a3, a6, a2, a5, a6]
//		System.out.println(list);
//	}
	
	@Test
	public void array2ListOfVar_test2() {
		String[] strArr = {"a1", "a3", "a4", "a2", "a5"};
		List<String> list = ArrayConvertUtil.array2ListOfVar(strArr);
		//[a1, a3, a4, a2, a5]
		list.add("a6");//[a1, a3, a4, a2, a5, a6]
//		list.set(2, "a6");//[a1, a3, a6, a2, a5, a6]
		System.out.println(list);
	}
	
	@Test
	public void str2Array_test1() {
//		String str1 = "1,2,3";
		String str1 = "1,2,3,";//java.lang.IllegalArgumentException: 字符串格式是x1,x2
		String[] strArr = ArrayConvertUtil.str2Array(str1);
		System.out.println(ArrayConvertUtil.toString(strArr));
	}
	
	@Test
	public void str2Array_test2() {
		String str1 = "1,#2,#3";
		String separator = ",#";
		String[] strArr = ArrayConvertUtil.str2Array(str1, separator);
		System.out.println(ArrayConvertUtil.toString(strArr));
	}
	
	@Test
	public void str2List_test1() {
		String str1 = "1, 2, 3";
		List<String> strList = Arrays.asList(str1.split(", "));
		System.out.println(strList);
	}
	
	@Test
	public void str2ListOfFixed_test2() {
		String str1 = "1,2,3";
		List<String> list = ArrayConvertUtil.str2ListOfFixed(str1);
//		//java.lang.UnsupportedOperationException
//		list.add("a6");
		System.out.println(list);
	}
	
	@Test
	public void str2ListOfVar_test1() {
		String str1 = "1,2,3";
		List<String> list = ArrayConvertUtil.str2ListOfVar(str1);
		list.add("a6");
		System.out.println(list);
	}
	
	@Test
	public void str2ListOfVar_test2() {
		String str1 = "1,2,3";
		List<String> list = ArrayConvertUtil.str2ListOfVar2(str1);
		list.add("a6");
		System.out.println(list);
	}
	

}
