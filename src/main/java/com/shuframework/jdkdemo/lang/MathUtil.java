package com.shuframework.jdkdemo.lang;

import java.util.Arrays;

/**
 * 封装java.lang.Math的方法,Math不让继承，只能重写
 * 因为里面好多都是double的处理和返回double，为了方便封装一层进行强转（返回double就是为了超过整数范围）
 * 
 * @author shu
 *
 */
public class MathUtil {

	/**
	 * 返回2个数的最大值
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int max(int num1, int num2) {
		return Math.max(num1, num2);
	}
	
	/**
	 * 返回多个数的最大值
	 * @param nums
	 * @return
	 */
	public static int max(int... nums) {
		//空，或者长度小于2都报参数异常
		int maxLength = nums.length;
		if(nums == null || maxLength < 2)	throw new IllegalArgumentException("可变参数长度不能小于2");
		
//		//方式一：循环比较
//		int maxNum = nums[0];
//		for (int i = 1; i < maxLength; i++) {
//			int num = nums[i];
//			if(num > maxNum){
//				maxNum = num;
//			}
//		}
//		return maxNum;
		
		//方式二：排序后取最后一位数
		Arrays.sort(nums);//排序
		return nums[maxLength -1];
	}

	/**
	 * 返回2个数的最小值
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int min(int num1, int num2) {
		return Math.min(num1, num2);
	}
	
	/**
	 * 返回多个数的最小值
	 * @param nums
	 * @return
	 */
	public static int min(int... nums) {
		//空，或者长度小于2都报参数异常
		int maxLength = nums.length;
		if(nums == null || maxLength < 2)	throw new IllegalArgumentException("可变参数长度不能小于2");
		
//		//方式一：循环比较
//		int minNum = nums[0];
//		for (int i = 1; i < maxLength; i++) {
//			int num = nums[i];
//			if(num < minNum){
//				minNum = num;
//			}
//		}
//		return minNum;
		
		//方式二：排序后取第一位数
		Arrays.sort(nums);//排序
		return nums[0];
	}

	/**
	 * 返回num的绝对值结果 <br>
	 * @param num
	 * @return
	 */
	public static int abs(int num) {
		return Math.abs(num);
	}
	
	/**
	 * 返回num的绝对值结果 <br>
	 * @param num
	 * @return
	 */
	public static long abs(long num) {
		return Math.abs(num);
	}
	
	/**
	 * 向上取整 <br>
	 * 如 1.1, 1.6 都会返回2 (因为2大于1);  -1.1, -1.6都会返回-1 (因为-1大于-2)
	 * @param num
	 * @return
	 */
	public static int ceil2Int(double num) {
		return (int) Math.ceil(num);
	}
	
	/**
	 * 向上取整 <br>
	 * 如 1.1, 1.6 都会返回2 (因为2大于1);  -1.1, -1.6都会返回-1 (因为-1大于-2)
	 * @param num
	 * @return
	 */
	public static long ceil2Long(double num) {
		return (long) Math.ceil(num);
	}
	
	/**
	 * 向下取整 <br>
	 * 如 1.1, 1.6 都会返回1 (因为2大于1);  -1.1, -1.6都会返回-2 (因为-1大于-2)
	 * @param num
	 * @return
	 */
	public static int floor2Int(double num) {
		return (int) Math.floor(num);
	}
	
	/**
	 * 向下取整 <br>
	 * 如 1.1, 1.6 都会返回1 (因为2大于1);  -1.1, -1.6都会返回-2 (因为-1大于-2)
	 * @param num
	 * @return
	 */
	public static long floor2Long(double num) {
		return (long) Math.floor(num);
	}
	
	/**
	 * 返回 a^b的结果 <br>
	 * 如2的3次方pow2Int(2, 3)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int pow2Int(int num1, int num2) {
		return (int) Math.pow(num1, num2);
	}
	
	/**
	 * 返回 a^b的结果 <br>
	 * 如2的3次方pow2Long(2, 3)
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static long pow2Long(int num1, int num2) {
		return (long) Math.pow(num1, num2);
	}
	
	/**
	 * 四舍五入 , 原理是加0.5然后向下取整<br>
	 * 如 1.1返回1, 1.6 返回2;  -1.1返回-2, -1.6返回-1
	 * @param num
	 * @return
	 */
	public static int round2Int(float num) {
		return Math.round(num);
	}
	
	/**
	 * 四舍五入 , 原理是加0.5然后向下取整<br>
	 * 如 1.1返回1, 1.6 返回2;  -1.1返回-2, -1.6返回-1
	 * @param num
	 * @return
	 */
	public static int round2Int(double num) {
		return (int) Math.round(num);
	}
	
	/**
	 * 四舍五入 , 原理是加0.5然后向下取整<br>
	 * 如 1.1返回1, 1.6 返回2;  -1.1返回-2, -1.6返回-1
	 * @param num
	 * @return
	 */
	public static long round2Long(double num) {
		return Math.round(num);
	}
	
	/**
	 * 获得正平方根, 知道能初尽就用sqrt2Int(int num), 除不尽就用sqrt(int num)<br>
	 * 如 4返回2, 5返回2
	 * @param num
	 * @return
	 */
	public static int sqrt2Int(int num) {
		return (int) Math.sqrt(num);
	}
	
	/**
	 * 获得正平方根, 知道能初尽就用sqrt2Int(int num), 除不尽就用sqrt(int num)<br>
	 * 如 4返回2.0, 5返回2.23606797749979
	 * @param num
	 * @return
	 */
	public static double sqrt(int num) {
		return Math.sqrt(num);
	}
	
	/**
	 * 获得正平方根<br>
	 * 如 4.0返回2.0, 5.0返回2.23606797749979
	 * @param num
	 * @return
	 */
	public static double sqrt(double num) {
		return Math.sqrt(num);
	}
}
