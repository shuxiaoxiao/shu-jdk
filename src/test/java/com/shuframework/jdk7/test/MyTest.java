package com.shuframework.jdk7.test;

import org.junit.Test;

public class MyTest {

	@Test
	public void test() {
		StringBuffer sb1 = new StringBuffer("1");
		StringBuffer sb2 = new StringBuffer("2");
		test2(sb1, sb2);
		System.out.println(sb1);
		System.out.println(sb2);
	}
	
	
	void test2(StringBuffer sb1, StringBuffer sb2){
		sb2 = sb1;
		sb1 = new StringBuffer("11");
	}
}
