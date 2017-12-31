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
	public static String convertCode(String str, String formEncoding, String toEncoding) {
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

	/**
	 * 判断是否Utf8Url编码
	 * 
	 * @param text
	 * @return
	 */
	public static final boolean isUtf8Url(String text) {
		text = text.toLowerCase();
		int p = text.indexOf("%");
		if (p != -1 && text.length() - p > 9) {
			text = text.substring(p, p + 9);
		}
		return Utf8codeCheck(text);
	}

	/**
	 * 编码是否有效
	 * 
	 * @param text
	 * @return
	 */
	private static final boolean Utf8codeCheck(String text) {
		String sign = "";
		if (text.startsWith("%e"))
//			for (int i = 0, p = 0; p != -1; i++) { i未被使用
			for (int p = 0; p != -1; ) {
				p = text.indexOf("%", p);
				if (p != -1)
					p++;
				sign += p;
			}
		return sign.equals("147-1");
	}

	/**
	 * Utf8URL编码
	 * 
	 * @param s
	 * @return
	 */
	public static final String encodeUtf8URL(String text) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < text.length(); i++) {

			char c = text.charAt(i);
			if (c >= 0 && c <= 255) {
				result.append(c);
			} else {

				byte[] b = new byte[0];
				try {
					b = Character.toString(c).getBytes(CharsetConstant.CHARSET_UTF8);
				} catch (Exception ex) {
				}

				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					result.append("%" + Integer.toHexString(k).toUpperCase());
				}

			}
		}

		return result.toString();
	}

	/**
	 * Utf8URL解码
	 * 
	 * @param text
	 * @return
	 */
	public static final String decodeUtf8URL(String text) {
		String result = "";
		int p = 0;

		if (text != null && text.length() > 0) {
			text = text.toLowerCase();
			p = text.indexOf("%e");
			if (p == -1)
				return text;

			while (p != -1) {
				result += text.substring(0, p);
				text = text.substring(p, text.length());
				if (text == "" || text.length() < 9)
					return result;

				result += codeToWord(text.substring(0, 9));
				text = text.substring(9, text.length());
				p = text.indexOf("%e");
			}

		}

		return result + text;
	}

	/**
	 * utf8URL编码转字符
	 * 
	 * @param text
	 * @return
	 */
	private static final String codeToWord(String text) {
		String result;

		if (Utf8codeCheck(text)) {
			byte[] code = new byte[3];
			code[0] = (byte) (Integer.parseInt(text.substring(1, 3), 16) - 256);
			code[1] = (byte) (Integer.parseInt(text.substring(4, 6), 16) - 256);
			code[2] = (byte) (Integer.parseInt(text.substring(7, 9), 16) - 256);
			try {
				result = new String(code, CharsetConstant.CHARSET_UTF8);
			} catch (UnsupportedEncodingException ex) {
				result = null;
			}
		} else {
			result = text;
		}

		return result;
	}

}
