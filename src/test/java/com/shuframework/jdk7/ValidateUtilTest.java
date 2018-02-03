package com.shuframework.jdk7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class ValidateUtilTest {

	@Test
	public void match_test2() {
//		String regex = "^\\/?\\w+/get\\w*$";
		String str = "/sysUser/queryPersonInfoDetail";
//		String str = "sysUser/get";
//		String str = "/get";
		System.out.println(ValidateUtil.matchMethod("query", str));
	}
	
	@Test
	public void match_test() {
		String regex = "^\\/?\\w+/get\\w*$";
//		String str = "/sysUser/getPersonInfoDetail";
//		String str = "sysUser/get";
		String str = "/get";
		System.out.println(ValidateUtil.match(regex, str));
	}
	
	@Test
	public void isInteger_test() {
		String numStr1 = "0";
		System.out.println(ValidateUtil.isInteger(numStr1));//false
		String numStr2 = "2";
		System.out.println(ValidateUtil.isInteger(numStr2));
		String numStr3 = "10";
		System.out.println(ValidateUtil.isInteger(numStr3));
		String numStr4 = "-2";
		System.out.println(ValidateUtil.isInteger(numStr4));
		String numStr5 = "-10";
		System.out.println(ValidateUtil.isInteger(numStr5));
	}
	
	@Test
	public void isNumber_test() {
		String numStr1 = "0";
		System.out.println(ValidateUtil.isNumber(numStr1));
		String numStr2 = "2";
		System.out.println(ValidateUtil.isNumber(numStr2));
		String numStr3 = "10";
		System.out.println(ValidateUtil.isNumber(numStr3));
		String numStr4 = "-2";
		System.out.println(ValidateUtil.isNumber(numStr4));
		String numStr5 = "-10";
		System.out.println(ValidateUtil.isNumber(numStr5));
	}
	
	@Test
	public void isEmpty_Number() {
		System.out.println("---Integer---");
		Integer intNum1 = null;
		System.out.println(ValidateUtil.isEmpty(intNum1));
		Integer intNum2 = 0;
		System.out.println(ValidateUtil.isEmpty(intNum2));
		int intNum3 = 0;
		System.out.println(ValidateUtil.isEmpty(intNum3));
		Integer intNum4 = 200;
		System.out.println(ValidateUtil.isEmpty(intNum4));
		int intNum5 = 200;
		System.out.println(ValidateUtil.isEmpty(intNum5));
		
		System.out.println("---Long---");
		Long longNum1 = null;
		System.out.println(ValidateUtil.isEmpty(longNum1));
		Long longNum2 = 0L;
		System.out.println(ValidateUtil.isEmpty(longNum2));
		long longNum3 = 0L;
		System.out.println(ValidateUtil.isEmpty(longNum3));
		Long longNum4 = 200L;
		System.out.println(ValidateUtil.isEmpty(longNum4));
		long longNum5 = 200L;
		System.out.println(ValidateUtil.isEmpty(longNum5));
	}
	
	@Test
	public void isEmpty_Collection() {
		System.out.println("---List---");
		List<String> list1 = null;
		System.out.println(ValidateUtil.isEmpty(list1));
		List<String> list2 = new ArrayList<>();
		System.out.println(ValidateUtil.isEmpty(list2));
		
		list2.add("a");
		System.out.println(ValidateUtil.isEmpty(list2));
		
		System.out.println("---Set---");
		Set<String> set1 = null;
		System.out.println(ValidateUtil.isEmpty(set1));
		Set<String> set2 = new HashSet<>();
		System.out.println(ValidateUtil.isEmpty(set2));
		
		set2.add("b");
		System.out.println(ValidateUtil.isEmpty(set2));
		
		System.out.println("---Queue---");
		Queue<String> queue1 = null;
		System.out.println(ValidateUtil.isEmpty(queue1));
		Queue<String> queue2 = new ArrayDeque<>();
		System.out.println(ValidateUtil.isEmpty(queue2));
		
		queue2.add("q");
		System.out.println(ValidateUtil.isEmpty(set2));
	}
	
	@Test
	public void isEmpty_Array() {
		System.out.println("---父为Object的对象数组---");
		String[] array1 = null;
		System.out.println(ValidateUtil.isEmpty(array1));
		String[] array2 = new String[]{};//true
		System.out.println(ValidateUtil.isEmpty(array2));
		//这种是3个null
		String[] array3 = new String[3];//false
		System.out.println(ValidateUtil.isEmpty(array3));
		
		System.out.println("---父为不是Object的对象数组---");
		List<String>[] notObj1 = null;
		System.out.println(ValidateUtil.isEmpty(notObj1));
	}
	
	@Test
	public void isEmpty_String() {
		System.out.println("---isEmpty---");
		String str1 = null;
		System.out.println(ValidateUtil.isEmpty(str1));
		String str2 = "";
		System.out.println(ValidateUtil.isEmpty(str2));
		String str3 = " ";
		System.out.println(ValidateUtil.isEmpty(str3));//true
		String str4 = "a b";
		System.out.println(ValidateUtil.isEmpty(str4));
		String str5 = "ab";
		System.out.println(ValidateUtil.isEmpty(str5));
		
		System.out.println("---isEmptyUnTrim---");
		System.out.println(ValidateUtil.isEmptyUnTrim(str1));
		System.out.println(ValidateUtil.isEmptyUnTrim(str2));
		System.out.println(ValidateUtil.isEmptyUnTrim(str3));//false
		System.out.println(ValidateUtil.isEmptyUnTrim(str4));
		System.out.println(ValidateUtil.isEmptyUnTrim(str5));
	}

}
