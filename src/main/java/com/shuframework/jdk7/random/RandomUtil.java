package com.shuframework.jdk7.random;

import java.util.Random;

/**
 * 产生随机数（推荐使用这个来替换MathUtil）<br/>
 * 底层都是java.util.Random类, 线程安全, 但是多线程下可能性能比较低, 因为Random用了很多CAS的类，ThreadLocalRandom根本没有用到 <br/>
 * 生成的随机数是线性可预测的, 所以在安全性要求比较高的场合，应当使用SecureRandom。
 * @author	shu
 */
public class RandomUtil {
	//Random 的性能不太高，而且可能被预测
	//http://blog.csdn.net/hengyunabc/article/details/9913143

	/**
	 * 返回的范围是[0,num)
	 * @Title: random
	 * @param @param num
	 * @return int    返回类型
	 */
	public static int random(int num){
		Random random = new Random();
		return random.nextInt(num);
	}
	
	/**
	 * 返回的范围是[-2^31, (2^31 - 1))，可能产生负数
	 * @Title: random
	 * @return int    返回类型
	 */
	public static int random2Int(){
		Random random = new Random();
		return random.nextInt();
	}
	
	/**
	 * 返回的范围是[0,num)
	 * Because class Random uses a seed with only 48 bits, this algorithm will not return all possible long values.
	 * @Title: random
	 * @return int    返回类型
	 */
	public static long random2Long(){
		Random random = new Random();
		return random.nextLong();
	}
	
	/**
	 * 返回的范围是[start,end)
	 * @Title: random
	 * @param  start	范围起始值
	 * @param  end	范围终止值
	 * @return int    返回类型
	 */
	public static int random(int start,int end){
//		Random random = new Random();
//		return random.nextInt(end - start) + start;
//		return random(end - start) + start; //返回[start, end)
//		return random(end - start + 1) + start;	//返回[start, end]
		return random(end - start) + start;
	}
	
	/**
	 * 返回的几位数之间的值, length范围 [1,10) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[10, 100) 即10-99之间的值<br>
	 * 如length=3,返回[100, 1000) 即100-999之间的值<br>
	 * 
	 * @param @param length	几位数
	 * @return int
	 */
	public static int randomByLength2Int(int length) {
		int start = 0;
		if (length == 1){
			return random(10);
		} else if (length > 1 && length < 10) {
			// 由于10^0 =1,所以单独处理
			start = (int) Math.pow(10, (length - 1));
		} else {
			throw new IllegalArgumentException("超过范围, length范围是[1,10)");
		}
		int end = (int) Math.pow(10, length);
		
		return random(start, end);
	}
	
	//randomByLength2Long 暂时完成不了，由于random.nextLong()给不了种子值
	
	/**
	 * 返回的几位数之间的值, length范围 [1, +∞) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[10, 100) 即10-99之间的值<br>
	 * 如length=3,返回[100, 1000) 即100-999之间的值<br>
	 * 
	 * @param @param length	几位数
	 * @return int
	 */
	public static String randomByLength2Str(int length){
		String randomId = "";
		int restLength = 0;
		int limitLength = 9;
		if(length < 1){
			throw new IllegalArgumentException("超过范围, length范围是[1,+∞)");
		}else if(length <= limitLength){
			restLength = length;
		}else{
			int count = length / limitLength;
			for (int i = 0; i < count; i++) {
				randomId = randomId + randomByLength2Int(limitLength);
			}
			//加上不满长度的部分
			restLength = length - count * limitLength;
		}
		
		if(restLength != 0){
			randomId = randomId + randomByLength2Int(restLength);
		}
		
		return randomId;
	}

	
	/**
	 * 返回的几位数的值, 位数不够则补零, length范围 [1,10) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[00, 100) 即00-99之间的值<br>
	 * 如length=3,返回[000, 1000) 即000-999之间的值<br>
	 * 
	 * @param @param length	几位数
	 * @return int
	 */
	public static String randomByLength2StrFillZeroHasLimit9(int length) {
		if (length > 0 && length < 10) {
			int end = (int) Math.pow(10, length);
			int num = random(end);
			return fillZero(num, length);
		} else {
			throw new IllegalArgumentException("超过范围, length范围是[1,10)");
		}
	}
	
	/**
	 * 返回的几位数的值, 位数不够则补零, length范围 [1,19) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[00, 100) 即00-99之间的值<br>
	 * 如length=3,返回[000, 1000) 即000-999之间的值<br>
	 * 
	 * @param @param length	几位数
	 * @return int
	 */
	public static String randomByLength2StrFillZeroHasLimit19(int length) {
		if (length > 0 && length < 10) {
			int end = (int) Math.pow(10, length);
			int num = random(end);
			return fillZero(num, length);
		} else {
			throw new IllegalArgumentException("超过范围, length范围是[1,10)");
		}
	}
	
	//觉得冗余可以调用StringUtil.fillZero
	private static String fillZero(int num, int length) {
		return String.format("%0" + length + "d", num);
	}
	
	/**
	 * 返回的几位数的值, 位数不够则补零, length范围 [1, +∞] <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[00, 100) 即00-99之间的值<br>
	 * 如length=3,返回[000, 1000) 即000-999之间的值<br>
	 * 
	 * @param @param length	几位数
	 * @return int
	 */
	public static String randomByLength2StrFillZero(int length){
		String randomId = "";
		int restLength = 0;
		int limitLength = 9;
		if(length < 1){
			throw new IllegalArgumentException("超过范围, length范围是[1,+∞)");
		}else if(length <= limitLength){
			restLength = length;
		}else{
			int count = length / limitLength;
			for (int i = 0; i < count; i++) {
				randomId = randomId + randomByLength2StrFillZeroHasLimit9(limitLength);
			}
			//加上不满长度的部分
			restLength = length - count * limitLength;
		}
		
		if(restLength != 0){
			randomId = randomId + randomByLength2StrFillZeroHasLimit9(restLength);
		}
		
		return randomId;
	}

}
