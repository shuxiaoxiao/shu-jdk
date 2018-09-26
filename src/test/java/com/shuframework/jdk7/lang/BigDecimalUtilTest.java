package com.shuframework.jdk7.lang;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalUtilTest {

	@Test
	public void test() {
		BigDecimal sum = BigDecimalUtil.add("2", "3");
//		BigDecimal sum = BigDecimalUtil.add("2", "3", "5");
		System.out.println(sum);
	}

	@Test
	public void addSum_test2() {
		long start1 = System.currentTimeMillis();
		BigDecimal sum1 = BigDecimalUtil.add("1","2","3","4","5","6","7","8","9");
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
//		System.out.println(sum1);
	}

//	@Test
//	public void addSum_test3() {
//		long start2 = System.currentTimeMillis();
//		BigDecimal sum2 = BigDecimalUtil.add2("11","12","13","14","15","16","17","18","19");
//		long end2 = System.currentTimeMillis();
//		System.out.println(end2 - start2);
////		System.out.println(sum2);
//	}

}
