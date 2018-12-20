package com.shuframework.jdkutil.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import com.shuframework.jdkutil.lang.StringUtil;

/**
 * 安全性很高的随机数
 * @author shu
 *
 */
public class SecureRandomUtil {

	private SecureRandomUtil(){}
	
	private static SecureRandom secureRandom;
	
	static {
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
//	/** int类型的长度限制为10 */
	private static final int LIMIT_INT_LENGTH = 9;
	
	/**
	 * 返回的范围是[0,num)
	 * @param seedNum	随机数种子
	 * @return
	 */
	public static int random(int seedNum){
		//建议采用静态对象来执行
//		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		return secureRandom.nextInt(seedNum);
	}
	
	/**
	 * 返回的范围是[-2^31, (2^31 - 1))，可能产生负数
	 * @return
	 */
	@Deprecated
	public static int random2Int(){
		return secureRandom.nextInt();
	}
	
	/**
	 * 返回的范围是[start, end)
	 * @param start
	 * @param end
	 * @return
	 */
	public static int random(int start, int end){
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
	
	/**
	 * 返回的几位数的值, 位数不够则补零, length范围 [1,10) <br>
	 * 如length=1,返回[0, 10) 即0-9之间的值<br>
	 * 如length=2,返回[00, 100) 即00-99之间的值<br>
	 * 如length=3,返回[000, 1000) 即000-999之间的值<br>
	 * 
	 * @param length	几位数
	 * @return String
	 */
	public static String randomFillZeroHasLimit(int length) {
		if (length > 0 && length < 10) {
			int end = (int) Math.pow(10, length);
			int num = random(end);
			return StringUtil.fillLeftZero(num, length);
		} else {
			throw new IllegalArgumentException("超过范围, length范围是[1,10)");
		}
	}
	
}
