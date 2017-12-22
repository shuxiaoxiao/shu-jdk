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

}
