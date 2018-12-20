package com.shuframework.jdkutil.lang;

import org.junit.Test;

public class MathUtilTest {

	@Test
	public void max_test() {
		int max = MathUtil.max(3, 2, 5, 4, 8);
		System.out.println(max);
	}

	@Test
	public void min_test() {
		int min = MathUtil.min(3, 2, 5, 4, 8);
		System.out.println(min);
	}

	@Test
	public void ceil_test() {
		int num1 = MathUtil.ceil2Int(1.1);
		int num2 = MathUtil.ceil2Int(1.6);
		long num3 = MathUtil.ceil2Long(1.1);
		long num4 = MathUtil.ceil2Long(1.6);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);

		int num11 = MathUtil.ceil2Int(-1.1);
		int num12 = MathUtil.ceil2Int(-1.6);
		long num13 = MathUtil.ceil2Long(-1.1);
		long num14 = MathUtil.ceil2Long(-1.6);
		System.out.println(num11);
		System.out.println(num12);
		System.out.println(num13);
		System.out.println(num14);
	}

	@Test
	public void floor_test() {
		int num1 = MathUtil.floor2Int(1.1);
		int num2 = MathUtil.floor2Int(1.6);
		long num3 = MathUtil.floor2Long(1.1);
		long num4 = MathUtil.floor2Long(1.6);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);

		int num11 = MathUtil.floor2Int(-1.1);
		int num12 = MathUtil.floor2Int(-1.6);
		long num13 = MathUtil.floor2Long(-1.1);
		long num14 = MathUtil.floor2Long(-1.6);
		System.out.println(num11);
		System.out.println(num12);
		System.out.println(num13);
		System.out.println(num14);
	}

	@Test
	public void sqrt_test() {
		int num1 = MathUtil.sqrt2Int(4);
		int num2 = MathUtil.sqrt2Int(5);
		System.out.println(num1);
		System.out.println(num2);

		double num11 = MathUtil.sqrt(4);
		double num12 = MathUtil.sqrt(5);
		System.out.println(num11);
		System.out.println(num12);
		
		double num111 = MathUtil.sqrt(4.0);
		double num112 = MathUtil.sqrt(5.0);
		System.out.println(num111);
		System.out.println(num112);
	}

}
