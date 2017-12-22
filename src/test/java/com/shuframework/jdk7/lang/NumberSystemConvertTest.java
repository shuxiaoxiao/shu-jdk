package com.shuframework.jdk7.lang;

import org.junit.Test;

public class NumberSystemConvertTest {

	@Test
	public void test() {
		int num = 16;
		String binNumStr = NumberSystemConvert.toBinaryString(num);
		String octalNumStr = NumberSystemConvert.toOctalString(num);
		String hexNumStr = NumberSystemConvert.toHexString(num);
		System.out.println(binNumStr);
		System.out.println(octalNumStr);
		System.out.println(hexNumStr);
	}
	

	@Test
	public void test2() {
		String str = "abc"; //616263
//		String str = "abcabasdss"; //
//		byte[] b = {};
		String decNum = NumberSystemConvert.bytesToHexString(str.getBytes());
		System.out.println(decNum);
	}
	
	@Test
	public void test3() {
		//十六进制
//		int hexNum1 = 0xff;
//		System.out.println(hexNum1);
		char c = '0';
		System.out.println(c);
		int n = 0;
		System.out.println(n);
	}

}
