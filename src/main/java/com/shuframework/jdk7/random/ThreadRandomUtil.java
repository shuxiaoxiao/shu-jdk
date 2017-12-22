package com.shuframework.jdk7.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 多线程并发生成随机数
 * 底层是java.util.concurrent.ThreadLocalRandom
 * @author shu
 *
 */
public class ThreadRandomUtil {

	private ThreadRandomUtil(){}
	
	/** int类型的长度限制为10 */
	private static final int LIMIT_INT_LENGTH = 9;
	
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
	 * 返回的范围是[-2^31, (2^31 - 1))，可能产生负数
	 * @return
	 */
	public static int random2Int(){
		return threadRandom.nextInt();
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
//		int limitLength = 9;
		if(length < 1){
			throw new IllegalArgumentException("超过范围, length范围是[1,+∞)");
		}else if(length <= LIMIT_INT_LENGTH){
			restLength = length;
		}else{
			int count = length / LIMIT_INT_LENGTH;
			for (int i = 0; i < count; i++) {
				randomId = randomId + randomByLength2Int(LIMIT_INT_LENGTH);
			}
			//加上不满长度的部分
			restLength = length - count * LIMIT_INT_LENGTH;
		}
		
		if(restLength != 0){
			randomId = randomId + randomByLength2Int(restLength);
		}
		
		return randomId;
	}
	
	//TODO 补零的方法未加
	
}
