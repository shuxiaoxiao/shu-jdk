package com.shuframework.jdk7.lang;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

/**
 * 数字格式化 示例
 * @author shu
 *
 */
public class NumberFormatDemo {
	double numDouble = 0.131492653;
//	double numDouble = 0.1234512;
	double numDouble2 = 10.131415926537;

	//保留小数的几种方式
	@Test
	public void test_BigDecimal() {
		BigDecimal num = BigDecimalUtil.round(numDouble+"", 2);
		System.out.println(num); //0.13
		
//		//推荐用上面的方式
//		BigDecimal num2 = new BigDecimal(numDouble+"");
//		numDouble = num2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//		System.out.println(numDouble); //0.13
	}
	
	@Test
	public void test_DecimalFormat() {
		DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(numDouble));//0.13  10.13
	}
	
	/**
     * String.format打印最简便
     */
	@Test
    public void test_StringFormat() {
        System.out.println(String.format("%.2f", numDouble));
    }
	
	
	@Test
	public void test_NumberFormat() {
//		NumberFormat nf = NumberFormat.getPercentInstance();// 含%
		NumberFormat nf = NumberFormat.getNumberInstance();// 纯数字
		nf.setMinimumFractionDigits(2);//这个表示小数位, 最少保留3位
		//numDouble 0.1234512
		System.out.println(nf.format(numDouble));//0.123451  6
//		System.out.println(nf.format(numDouble));//0.12345  5
//		System.out.println(nf.format(numDouble));//0.1235  4
//		System.out.println(nf.format(numDouble));//0.123  3
//		System.out.println(nf.format(numDouble));//0.123  2
//		System.out.println(nf.format(numDouble));//0.123  1
	}
	
//	@Test
//	public void test2() {
//		NumberFormat nt2 = NumberFormat.getNumberInstance();// 纯数字
//		nt2.setMaximumFractionDigits(num1);
//		System.out.println(num1);
//	}
	
}
