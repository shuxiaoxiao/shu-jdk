package com.shuframework.jdk7.lang;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		String str = "abcabc";
		str = str.replace('b', 'd');
		System.out.println(str);//adcadc
	}

}
