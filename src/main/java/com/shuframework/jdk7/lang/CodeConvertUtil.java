package com.shuframework.jdk7.lang;

import java.io.UnsupportedEncodingException;

import com.shuframework.jdk7.constant.CharsetConstant;

/**
 * 编码转换
 * @author shu
 *
 */
public class CodeConvertUtil {

	private CodeConvertUtil(){}
	
	/**
	 * 判断是否是ISO-8859-1
	 * @param str
	 * @return
	 * @throws 
	 */
	public static boolean isIso(String str) {
		return isAnyCode(str, CharsetConstant.CHARSET_ISO);
	}
	
	/**
	 * 判断是否是UTF-8
	 * @param str
	 * @return
	 * @throws 
	 */
	public static boolean isUTF8(String str) {
		return isAnyCode(str, CharsetConstant.CHARSET_UTF8);
	}
	
	/**
	 * 判断是否是GBK
	 * @param str
	 * @return
	 * @throws
	 */
	public static boolean isGBK(String str) {
		return isAnyCode(str, CharsetConstant.CHARSET_GBK);
	}
	
	/**
	 * 将str用encoding转一次, 然后解一次, 如果得到的结果与原来一样，说明就是这个编码
	 * @param str
	 * @param encoding
	 * @return
	 */
	private static boolean isAnyCode(String str, String encoding) {
		try {
			String newStr = new String(str.getBytes(encoding), encoding);
			if (str.equals(newStr)) {
				return true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 将str从formEncoding格式转为toEncoding格式
	 * @param str
	 * @param formEncoding
	 * @param toEncoding
	 * @return
	 */
	private static String convertCode(String str, String formEncoding, String toEncoding) {
		String resultStr = "";
		try {
			String newStr = new String(str.getBytes(formEncoding), toEncoding);
			resultStr = newStr;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return resultStr;
	}
	
	//检查下str的格式是否是formEncoding
//	private static String convertCode(String str, String formEncoding, String toEncoding) {
//		String resultStr = "";
//		try {
//			byte[] bytes = str.getBytes(formEncoding);
//			String newStr = new String(bytes, formEncoding);
//			//确定是这种编码后就转为另一种, 否则不转
//			if (str.equals(newStr)) {
//				resultStr = new String(bytes, toEncoding);
//			}else {
//				resultStr = str;
//			}
//			
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return resultStr;
//	}
	
	/**
	 * 将ISO-8859-1转为 UTF-8
	 * @param str
	 * @return
	 * @throws
	 */
	public static String isoToUTF8(String str) {
		return convertCode(str, CharsetConstant.CHARSET_ISO, CharsetConstant.CHARSET_UTF8);
	}
	
	/**
	 * 将ISO-8859-1转为GBK
	 * @param str
	 * @return
	 * @throws
	 */
	public static String isoToGBK(String str) {
		return convertCode(str, CharsetConstant.CHARSET_ISO, CharsetConstant.CHARSET_GBK);
	}
	
}
