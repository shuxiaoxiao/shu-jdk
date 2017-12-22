package com.shuframework.jdk7.lang;

import com.shuframework.jdk7.enums.NumberSystemEnum;

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

//	/**
//	 * 将十进制转成二进制, 返回Integer, 这个方法没用，可能还会误导
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Integer toBinaryInt(Integer num) {
//		Integer binaryNum = Integer.parseInt("0b" + toBinaryString(num));
//		return binaryNum;
//	}
//
//	/**
//	 * 将十进制转成二进制, 返回Long
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Long toBinaryLong(Long num) {
//		Long binaryNum = Long.parseLong(toBinaryString(num));
//		return binaryNum;
//	}

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
	
//	/**
//	 * 将十进制转成八进制, 返回Integer
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Integer toOctalInt(Integer num) {
//		Integer octalNum = Integer.parseInt(toOctalString(num));
//		return octalNum;
//	}
//
//	/**
//	 * 将十进制转成八进制, 返回Long
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Long toOctalLong(Long num) {
//		Long octalNum = Long.parseLong(toOctalString(num));
//		return octalNum;
//	}

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

//	/**
//	 * 将十进制转成十六进制, 返回Integer
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Integer toHexInt(Integer num) {
//		Integer hexNum = Integer.parseInt(toHexString(num));
//		return hexNum;
//	}
//
//	/**
//	 * 将十进制转成十六进制, 返回Long
//	 * 
//	 * @param num
//	 * @return
//	 */
//	public static Long toHexLong(Long num) {
//		Long hexNum = Long.parseLong(toHexString(num));
//		return hexNum;
//	}
	
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
	
//	/**
//	 * 十六进制转为十进制 <br>
//	 * 注意 0x10 + "";//本身就是16进制, 那么会被翻译为16, 然后再来转为10进制, 直接申明为"10"
//	 * @param num
//	 * @return
//	 */
//	public static String hextoDecString(String num) {
//		Integer decNum = Integer.valueOf(num, 16);
//		return Integer.toString(decNum, 10);
//	}
	
	/**
	 * 将radix进制的num数 转为toRadix进制的数 <br>
	 * 注意 0x10 + "";//本身就是16进制, 那么会被翻译为16, 然后再来转为10进制, 直接申明为"10"
	 * @param num
	 * @param radix
	 * @param toRadix
	 * @return
	 */
	public static String anytoAnyString(String num, int radix, int toRadix) {
		Integer decNum = Integer.valueOf(num, radix);
		return Integer.toString(decNum, toRadix);
	}
	
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
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				sb.append(0);//char 0 与 int 0结果一样
			}
			sb.append(hex);
		}
		return sb.toString();
	}
	//第二种方式实现：将字节数组转成十六进制的字符串
//	public static String bytesToHexString(byte[] b) {
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
	

}
