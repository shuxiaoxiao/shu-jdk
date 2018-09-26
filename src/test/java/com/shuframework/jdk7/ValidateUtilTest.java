package com.shuframework.jdk7;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class ValidateUtilTest {

	@Test
	public void isDateTime_test2() {
//		String str = "2017-01-01"; //false
//		String str = "2017-01-01 00:10:00"; //true
		String str = "2017-01-01 00:61:00"; //false
		System.out.println(ValidateUtil.isDateTime(str));
	}
	
	@Test
	public void isDate_test1() {
		String str = "2017-01-01";
		System.out.println(ValidateUtil.isDate(str));
	}
	
	@Test
	public void matchRegex_test() {
		//true
		String str1 = "sysUser,get,dd,aa,bb,cc";
		String str2 = "sysUser,get";
		String str3 = "get";
		//false
		String str11 = "sysUser,get,dd,aa,bb,cc,";
		String str12 = "sysUser,get,";
		String str13 = "get,";
		System.out.println(ValidateUtil.matchRegex(",", str1));
		System.out.println(ValidateUtil.matchRegex(",", str2));
		System.out.println(ValidateUtil.matchRegex(",", str3));
		System.out.println(ValidateUtil.matchRegex(",", str11));
		System.out.println(ValidateUtil.matchRegex(",", str12));
		System.out.println(ValidateUtil.matchRegex(",", str13));
	}
	
	@Test
	public void matchRegex_test2() {
//		String str = "/sysUser/queryPersonInfoDetail";
		String str = "sysUser,#get";
//		String str = "get";
//		String str = "get,#";
		System.out.println(ValidateUtil.matchRegex(",#", str));
	}
	
	@Test
	public void map_test2() {
		Map<String, Double> map = new HashMap<>();
		Integer num = 1;
		map.put("a", num.doubleValue());
		map.put("b", null);
		System.out.println("map:"+map);
		int n = map.get("a").intValue();
		int n2 = map.get("b").intValue();
		System.out.println(n);
		System.out.println(n2);
	}
	
	@Test
	public void matchMethod_test() {
		String str1 = "getPersonInfoDetail";
		String str2 = "sysUser/get";
		String str3 = "sysUser/get/info";
		String str4 = "/get";
		String str5 = "/sysUser/getPersonInfoDetail";
		String str6 = "/sysUser/get/info";
		System.out.println(ValidateUtil.matchMethod("get", str1));
		System.out.println(ValidateUtil.matchMethod("get", str2));
		System.out.println(ValidateUtil.matchMethod("get", str3));
		System.out.println(ValidateUtil.matchMethod("get", str4));
		System.out.println(ValidateUtil.matchMethod("get", str5));
		System.out.println(ValidateUtil.matchMethod("get", str6));
	}
	
	@Test
	public void match_test() {
//		String regex = "/*\\w*/*get[/A-Za-z0-9]*";
//		String regex = "/*\\w*/*get([/A-Za-z0-9]*)";
		String regex = "[/\\w]*/*get[/\\w]*";
		String str1 = "getPersonInfoDetail";
		String str2 = "sysUser/get";
		String str3 = "sysUser/get/info";
		String str4 = "/get";
		String str5 = "/sysUser/getPersonInfoDetail";
		String str6 = "/sysUser/get/info";
		String str7 = "/sysUser/get/info/ddfd";
		String str8 = "/sysUser/get/info//ddfd";
		String str9 = "/sysUser/info/get//ddfd";
		System.out.println(ValidateUtil.match(regex, str1));
		System.out.println(ValidateUtil.match(regex, str2));
		System.out.println(ValidateUtil.match(regex, str3));
		System.out.println(ValidateUtil.match(regex, str4));
		System.out.println(ValidateUtil.match(regex, str5));
		System.out.println(ValidateUtil.match(regex, str6));
		System.out.println(ValidateUtil.match(regex, str7));
		System.out.println(ValidateUtil.match(regex, str8));
		System.out.println(ValidateUtil.match(regex, str9));
	}
	
	
	@Test
	public void checkStrLength_test() {
		String str = "";
//		boolean required = true;
		boolean required = false;
		int limitLength = 5;
		
		boolean flag = ValidateUtil.checkStrLength(str, required, limitLength);
		System.out.println(flag);
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
	public void isNumber_test2() {
		String numStr1 = "0.010";
		System.out.println(ValidateUtil.isNumber(numStr1));
		String numStr2 = "-.2000";
		System.out.println(ValidateUtil.isNumber(numStr2));
		String numStr3 = "-0.210";
		System.out.println(ValidateUtil.isNumber(numStr3));
	}
	
	@Test
	public void isPosttiveFloat_test1() {
		String numStr1 = "0.010";
		System.out.println(ValidateUtil.isPosttiveFloat(numStr1));
		String numStr2 = "-.2000";
		System.out.println(ValidateUtil.isPosttiveFloat(numStr2));
		String numStr3 = "12";
		System.out.println(ValidateUtil.isPosttiveFloat(numStr3));
	}
	
	@Test
	public void isNegativeFloat_test1() {
		String numStr1 = "0.010";
		System.out.println(ValidateUtil.isNegativeFloat(numStr1));
		String numStr2 = "-.2000";
		System.out.println(ValidateUtil.isNegativeFloat(numStr2));
		String numStr3 = "-1.2";
		System.out.println(ValidateUtil.isNegativeFloat(numStr3));
	}
	
	@Test
	public void isFloat_test1() {
		String numStr1 = "0.010";
		System.out.println(ValidateUtil.isFloat(numStr1));
		String numStr2 = "-.2000";
		System.out.println(ValidateUtil.isFloat(numStr2));//false
		String numStr3 = "-0.210";
		System.out.println(ValidateUtil.isFloat(numStr3));
		
		//整数不算 小数 即必须有小数点
		String numStr4 = "2";
		System.out.println(ValidateUtil.isFloat(numStr4));
		String numStr5 = "-10";
		System.out.println(ValidateUtil.isFloat(numStr5));
	}
	
	@Test
	public void isFloat_test2() {
		String numStr1 = "0.010";
		System.out.println(ValidateUtil.isFloat(numStr1, 1));
//		String numStr2 = "0.0";
//		System.out.println(ValidateUtil.isFloat(numStr2, 1));
//		System.out.println(ValidateUtil.isFloat(numStr2, 2));
//		String numStr3 = "-0.210";
//		System.out.println(ValidateUtil.isFloat(numStr3, 2));
//		System.out.println(ValidateUtil.isFloat(numStr3, 3));
		
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

	
	@Test
	public void test_String() {
		BigDecimal num = new BigDecimal("0");
		if(num.equals("0")){ // 不成功
			System.out.println(true);
		}
		if(num.doubleValue()<= 0){
			System.out.println(true);
		}
	}
	
	@Test
	public void test2_String() {
		BigDecimal num = new BigDecimal("1.0145");
		BigDecimal result = num.divide(BigDecimal.ONE, 0, BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
		BigDecimal result2 = num.divide(BigDecimal.ONE, 2, BigDecimal.ROUND_UP);
		System.out.println(result2);
	}
	
}
