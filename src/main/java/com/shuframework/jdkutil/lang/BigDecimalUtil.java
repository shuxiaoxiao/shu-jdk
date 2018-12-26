package com.shuframework.jdkutil.lang;

import java.math.BigDecimal;

/**
 * 浮点数（小数）的精确计算,空串默认为0，被除数为1 <br>
 * 如果要转成XX类型，使用XXValue()方法。如double类型，使用doubleValue() <br>
 * 
 * 利用double作为参数的构造函数，无法精确构造一个BigDecimal对象，需要自己指定一个上下文的环境，也就是指定精确位。
 * 而利用String对象作为参数传入的构造函数能精确的构造出一个BigDecimal对象。
 *
 * 除法默认是四舍五入，当然有向上，向下取整（只是没用）
 * 
 * @author shuheng
 */
public class BigDecimalUtil {

	private BigDecimalUtil(){}

	/** 字符串默认值为0 */
	private static final String STR_VALUE_0 = "0";
	/** 字符串默认值为1 */
	private static final String STR_VALUE_1 = "1";

	/**
	 * 字符串转成BigDecimal, 有"" 或null已被转成0
	 * @param str
	 * @return
	 */
	public static BigDecimal strToBd0(String str){
		str = StringUtil.parseEmpty(str, STR_VALUE_0);
		BigDecimal bd = new BigDecimal(str);
		return bd;
	}
	
	/**
	 * 字符串转成BigDecimal, 有"" 或null已被转成1
	 * @param str
	 * @return
	 */
	public static BigDecimal strToBd1(String str){
		str = StringUtil.parseEmpty(str, STR_VALUE_1);
		BigDecimal bd = new BigDecimal(str);
		return bd;
	}
	

	/**
	 * 加法, 如果num1是null默认为0, num2 有"" 或null已被转成0
	 * 
	 * @param num1 	第1个值为BigDecimal表示形式
	 * @param num2 	第2个值为字符串表示形式
	 * @return
	 */
	public static BigDecimal add(BigDecimal num1, String num2) {
		if(num1 == null){
			num1 = BigDecimal.ZERO;
		}
		
		BigDecimal bd2 = strToBd0(num2);
		return num1.add(bd2);
	}
	
	/**
	 * 多个数累加 <br>
	 * 空或者长度小于2都报参数异常, num 有"" 或null已被转成0
	 *
	 * @param nums 	Stirng类型的可变参数
	 * @return
	 */
	public static BigDecimal add(String... nums) {
		//空，或者长度小于2都报参数异常
		if(nums == null || nums.length < 2){
			throw new IllegalArgumentException("可变参数长度不能小于2");
		}

		BigDecimal sum = BigDecimal.ZERO;
		for (String n : nums) {
			//由于这样每次都是申明，然后创建，但测试结果差距不明显
			sum = sum.add(strToBd0(n));
		}
		return sum;
	}

//	//用该方法速度慢需要50+毫秒 (stream加速不明显,不推荐)
//	public static BigDecimal add2(String... nums) {
//		//空，或者长度小于2都报参数异常
//		if(nums == null || nums.length < 2){
//			throw new IllegalArgumentException("可变参数长度不能小于2");
//		}
//
//		BigDecimal sum = Arrays.stream(nums).map(str -> strToBd0(str)).reduce(BigDecimal.ZERO, BigDecimal::add);
//		return sum;
//	}

//	public static BigDecimal add(String... nums) {
//		//空，或者长度小于2都报参数异常
//		if(nums == null || nums.length < 2){
//			throw new IllegalArgumentException("可变参数长度不能小于2");
//		}
//
//		BigDecimal sum = BigDecimal.ZERO;
//		BigDecimal numBd = null;
//		for (String n : nums) {
//			n = StringUtil.parseEmpty(n, STR_VALUE_0);
//			numBd = new BigDecimal(n);
//			sum = sum.add(numBd);//返回的是新对象, 需要重新指向其引用
////			//由于这样每次都是申明，然后创建，还是建议上面的统一申明
////			sum = sum.add(strToBd0(n));
//		}
//		return sum;
//	}

	/**
	 * 多个数累加<br>
	 * 空或者长度小于2都报参数异常, nums 有null已被转成0
	 *
	 * @param nums 	BigDecimal类型的可变参数
	 * @return
	 */
	public static BigDecimal add(BigDecimal... nums) {
		//空，或者长度小于2都报参数异常
		if(nums == null || nums.length < 2){
			throw new IllegalArgumentException("可变参数长度不能小于2");
		}
		
		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal numBd : nums) {
			if (numBd == null) {
				numBd = BigDecimal.ZERO;
			}
			sum = sum.add(numBd);//返回的是新对象, 需要重新指向其引用
		}
		return sum;
	}

	
	/**
	 * 减法, 如果num1是null默认为0, num2 有"" 或null已被转成0
	 * 
	 * @param num1 	第1个值为BigDecimal表示形式
	 * @param num2 	第2个值为字符串表示形式
	 * @return
	 */
	public static BigDecimal subtract(BigDecimal num1, String num2) {
		if(num1 == null){
			num1 = BigDecimal.ZERO;
		}
		
		BigDecimal bd2 = strToBd0(num2);
		return num1.subtract(bd2);
	}
	
	/**
	 * 减法, 空或者长度小于1都报参数异常, num 有"" 或null已被转成0
	 *
	 * @param num1	第一个数, 后面的参数都在其下累减
	 * @param nums	Stirng类型的可变参数
	 * @return
	 */
	public static BigDecimal subtract(String num1, String... nums) {
		//空，或者长度小于1都报参数异常
		if(nums == null || nums.length < 1)	{
			throw new IllegalArgumentException("可变参数长度不能小于1");
		}
		
		BigDecimal sum = strToBd0(num1);
		for (String n : nums) {
			//由于这样每次都是申明，然后创建，但测试结果差距不明显
			sum = sum.subtract(strToBd0(n));
		}
		return sum;
	}


	/**
	 * 乘法, 如果num1是null默认为0, num2 有"" 或null已被转成0
	 * 
	 * @param num1 	第1个值为BigDecimal表示形式
	 * @param num2 	第2个值为字符串表示形式
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal num1, String num2) {
		if(num1 == null){
			num1 = BigDecimal.ZERO;
		}
		
		BigDecimal bd2 = strToBd0(num2);
		return num1.multiply(bd2);
	}
	
	/**
	 * 多个数累乘<br>
	 * 空或者长度小于2都报参数异常, num 有"" 或null已被转成0
	 *
	 * @param nums 	Stirng类型的可变参数
	 * @return
	 */
	public static BigDecimal multiply(String... nums) {
		//空，或者长度小于2都报参数异常
		if(nums == null || nums.length < 2)	{
			throw new IllegalArgumentException("可变参数长度不能小于2");
		}
		
		BigDecimal sum = BigDecimal.ZERO;
		for (String n : nums) {
			//由于这样每次都是申明，然后创建，但测试结果差距不明显
			sum = sum.multiply(strToBd0(n));
		}
		return sum;
	}
	
	/**
	 * 多个数累乘<br>
	 * 空或者长度小于2都报参数异常, nums 有null已被转成0
	 *
	 * @param nums
	 * @return
	 */
	public static BigDecimal multiply(BigDecimal... nums) {
		//空，或者长度小于2都报参数异常
		if(nums == null || nums.length < 2){
			throw new IllegalArgumentException("可变参数长度不能小于2");
		}
		
		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal numBd : nums) {
			if (numBd == null) {
				numBd = BigDecimal.ZERO;
			}
			sum = sum.multiply(numBd);//返回的是新对象, 需要重新指向其引用
		}
		return sum;
	}


	/**
	 * 除法, 如果num1 有"" 或null已被转成0, num2转成1
	 * 
	 * @param num1 	第1个值的字符串表示形式
	 * @param num2 	第2个值的字符串表示形式
	 * @param scale 保留几位小数
	 * @return
	 */
	public static BigDecimal divide(String num1, String num2, int scale) {
		return strToBd0(num1).divide(strToBd1(num2), scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 除法, 如果num1是null默认为0, num2 有"" 或null已被转成1
	 * 
	 * @param num1 	第1个值为BigDecimal表示形式
	 * @param num2 	第2个值为字符串表示形式
	 * @param scale 保留几位小数
	 * @return
	 */
	public static BigDecimal divide(BigDecimal num1, String num2, int scale) {
		if(num1 == null){
			num1 = BigDecimal.ZERO;
		}
		
		BigDecimal bd2 = strToBd1(num2);
		return num1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 除法, 空或者长度小于1都报参数异常, num 有"" 或null已被转成1 【主要是一般不会遇到连除】
	 *
	 * @param num1	第一个数, 后面的参数都在其下累除
	 * @param scale	保留小数位
	 * @param nums	Stirng类型的可变参数
	 * @return
	 */
	public static BigDecimal divide(String num1, int scale, String... nums) {
		//空，或者长度小于1都报参数异常
		if(nums == null || nums.length < 1)	{
			throw new IllegalArgumentException("可变参数长度不能小于1");
		}

		BigDecimal sum = strToBd0(num1);
		for (String n : nums) {
			//由于这样每次都是申明，然后创建，但测试结果差距不明显
			sum = sum.divide(strToBd1(n), scale, BigDecimal.ROUND_HALF_UP);
		}
		return sum;
	}

	/**
	 * 保留小数
	 * 
	 * @param num	需要保留的数
	 * @param scale	保留几位小数
	 * @return
	 */
	public static BigDecimal round(BigDecimal num, int scale) {
		return num.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 保留小数
	 * 
	 * @param num	需要保留的数
	 * @param scale	保留几位小数
	 * @return
	 */
	public static BigDecimal round(String num, int scale) {
		return round(strToBd0(num), scale);
	}


	public static void main(String[] args) {
		String[] strArr = new String[1000000];
		for (int i = 0; i < 1000000; i++) {
			strArr[i] = i + 1 + "";
		}

//		long s2 = System.currentTimeMillis();
//		BigDecimal sum2 = add2(strArr);
//		long e2 = System.currentTimeMillis();

		long s1 = System.currentTimeMillis();
		BigDecimal sum1 = add(strArr);
		long e1 = System.currentTimeMillis();

		System.out.println("add:" + (e1-s1));
//		System.out.println("add2:" + (e2-s2));
	}
}
