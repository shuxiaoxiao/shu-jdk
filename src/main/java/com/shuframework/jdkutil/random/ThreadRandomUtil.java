package com.shuframework.jdkutil.random;

import java.util.concurrent.ThreadLocalRandom;

import com.shuframework.jdkutil.lang.StringUtil;

/**
 * 多线程并发生成随机数
 * 底层是java.util.concurrent.ThreadLocalRandom
 * @author shu
 *
 */
public class ThreadRandomUtil {

	private ThreadRandomUtil(){}
	
	//线程安全,产生一个静态对象,多线程竞争资源时不浪费资源
	static ThreadLocalRandom threadRandom = ThreadLocalRandom.current();
	
	/**
	 * 返回的范围是[0,num)
	 * @param seedNum	随机数种子
	 * @return
	 */
	public static int random(int seedNum){
		return threadRandom.nextInt(seedNum);
	}
	
	/**
	 * 返回的范围是[start,end)
	 * @param start
	 * @param end
	 * @return
	 */
	public static int random(int start,int end){
		return threadRandom.nextInt(start, end);
	}

	/**
	 * 返回的几位数之间的值, length范围 [1,10) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[10, 100) 即10-99之间的值<br>
	 * 如length=3,返回[100, 1000) 即100-999之间的值<br>
	 *
	 * @param length 几位数
	 * @return int
	 */
	public static int randomByLength(int length) {
		int start = 0;
		if (length == 1) {
			return random(10);
		} else if (length > 1 && length < 10) {
			// 由于10^0 =1,所以单独处理
			start = pow10(length - 1);
		} else {
			throw new IllegalArgumentException("超过范围, length范围是[1,10)");
		}
		int end = pow10(length);

		return random(start, end);
	}

	/**
	 * 返回的几位数的值, 位数不够则补零, length范围 [1,10) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[00, 100) 即00-99之间的值<br>
	 * 如length=3,返回[000, 1000) 即000-999之间的值<br>
	 *
	 * @param length 几位数
	 * @return String
	 */
	public static String randomFillZero(int length) {
		if (length > 0 && length < 10) {
			int end = pow10(length);
			int num = random(end);
			return StringUtil.fillLeftZero(num, length);
		} else {
			throw new IllegalArgumentException("超过范围, length范围是[1,10)");
		}
	}

	/**
	 * 10的次方, length范围 [1,10)
	 *
	 * @param length
	 * @return
	 */
	private static int pow10(int length) {
		return (int) Math.pow(10, length);
	}
	
}
