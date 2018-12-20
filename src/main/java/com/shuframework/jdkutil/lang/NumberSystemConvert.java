package com.shuframework.jdkutil.lang;

import com.shuframework.jdkutil.enums.NumberSystemEnum;

/**
 * 进制转换
 * 二进制(binary system) 由0,1组成。以0b开头（0是数字零）
 * 八进制(octonary number system) 由0,1 ... 7组成。以0开头（0是数字零）
 * 十进制(decimalism) 由0,1 ... 9组成。整数默认是十进制
 * 十六进制 (hexadecimal)
 * 	由0,1 ... 9, a,b,c,d,e,f组成。以0x开头（0是数字零,出现的字母大小写都行）
 * 
 * @author shu
 *
 */
public class NumberSystemConvert {
	
	/** 二进制 */
	public static final int binary_2 = 2;

	/**
	 * 将十进制转成二进制, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toBinaryString(Integer num) {
		return Integer.toBinaryString(num);
	}
	
	/**
	 * 将十进制转成二进制, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toBinaryString(Long num) {
		return Long.toBinaryString(num);
	}


	/**
	 * 将十进制转成八进制, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toOctalString(Integer num) {
		return Integer.toOctalString(num);
	}

	/**
	 * 将十进制转成八进制, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toOctalString(Long num) {
		return Long.toOctalString(num);
	}

	/**
	 * 将十进制转成十六进制, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toHexString(Integer num) {
		return Integer.toHexString(num);
	}

	/**
	 * 将十进制转成十六进制, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toHexString(Long num) {
		return Long.toHexString(num);
	}
	
	/**
	 * 将十进制转成任意进制, 范围是[2, 36], 不在范围内以10进制转换即返回当前值, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toAnyString(Integer num, int radix) {
		return Integer.toString(num, radix);
	}
	
	/**
	 * 将十进制转成任意进制, 范围是[2, 36], 不在范围内以10进制转换即返回当前值, 返回字符串
	 * 
	 * @param num
	 * @return
	 */
	public static String toAnyString(Long num, int radix) {
		return Long.toString(num, radix);
	}
	
//	/**
//	 * 将十进制转成任意进制, 范围是[2, 36], 不在范围内以10进制转换即返回当前值, 返回Integer
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Integer toAnyInt(Integer num, int radix) {
//		Integer hexNum = Integer.parseInt(toAnyString(num, radix));
//		return hexNum;
//	}
//	
//	/**
//	 * 将十进制转成任意进制, 范围是[2, 36], 不在范围内以10进制转换即返回当前值, 返回Long
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Long toAnyLong(Long num, int radix) {
//		Long anyNum = Long.parseLong(toAnyString(num, radix));
//		return anyNum;
//	}
	
	/**
	 * 将radix进制的num数 转为toRadix进制的数 <br>
	 * 注意 0x10 + "";//本身就是16进制, 那么会被翻译为16, 然后再来转为10进制, 直接申明为"10"
	 * @param num
	 * @param radix
	 * @param toRadix
	 * @return
	 */
	public static String anytoAnyString(String num, NumberSystemEnum radix, NumberSystemEnum toRadix) {
		Integer decNum = Integer.valueOf(num, radix.getCode());
		return Integer.toString(decNum, toRadix.getCode());
	}
	
	/**
	 * 将字节数组转成十六进制的字符串
	 * @param b
	 * @return
	 */
	public static String bytesToHexString(byte[] b) {
		int length = b.length;
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				sb.append(0);//char 0 与 int 0结果一样
			}
			sb.append(hex);
		}
		return sb.toString();
	}

	//第二种方式实现：将字节数组转成十六进制的字符串
//	public static String bytesToHexString2(byte[] b) {
//		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
//		// 把密文转换成十六进制的字符串形式
//		int j = b.length;
//		char str[] = new char[j * 2];
//		int k = 0;
//		for (int i = 0; i < j; i++) {
//			byte byte0 = b[i];
//			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//			str[k++] = hexDigits[byte0 & 0xf];
//		}
//		return new String(str);
//	}

	public static void main(String[] args) {
		byte[] data = {'a','b','c',1,2,3};
		String s1 = bytesToHexString(data);
//		String s2 = bytesToHexString2(data);
		System.out.println(s1);
//		System.out.println(s2);
	}

}
