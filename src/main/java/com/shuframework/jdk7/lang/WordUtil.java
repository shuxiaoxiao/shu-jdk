package com.shuframework.jdk7.lang;

/**
 * 单词的工具类，其实可以合并到StringUtil
 * @author shu
 *
 */
public class WordUtil {

	/**
	 * 首字母大写其它字母小写,去掉了分隔符
	 * <p> capitalizeFully("abc_ABc", '_')	结果是AbcAbc </p>
	 * <p> capitalizeFully("abc_ABC_bcd", '_')	结果是AbcAbcBcd </p>
	 * <p> capitalizeFully("abc_ABC,bcd", new char[]{'_',','})	结果是AbcAbcBcd </p>
	 * 
	 * @param str
	 * @param delimiters 分隔符数组
	 * @return
	 */
	public static String capitalizeFully(String str, final char... delimiters) {
		//允许delimiters 为null，对字符串进行转换
		final int delimLen = delimiters == null ? -1 : delimiters.length;
		if (str == null || str.length() == 0 || delimLen == 0 ) {
			return str;
		}
		if(delimLen == -1){
			return capitalize(str);
		}
		String lowerStr = str.toLowerCase();
		StringBuilder sb = new StringBuilder();
		String delimiter = "";
//		//由于每次都判断，该种方法效率低
//		for (int i = 0, max = delimiters.length; i < max; i++) {
//			if(i == max - 1){
//				delimiter = delimiter + "\\" + delimiters[i];
//			}else{
//				delimiter = delimiter + "\\" + delimiters[i] + "|";
//			}
//		}
		//split 的多分隔符实现，采用的实际是正则表达式, \\为转义符, |为连接接符类似+
		for (char c : delimiters) {
			delimiter = delimiter + "\\\\" + c + "|";
		}
		//去掉最后的一个连接符
		delimiter = delimiter.substring(0, delimiter.length() -1);
		String[] splitStrArr = lowerStr.split(delimiter);
		for (String splitStr : splitStrArr) {
			sb.append(Character.toUpperCase(splitStr.charAt(0)));
			sb.append(splitStr.substring(1));
		}
		return sb.toString();
	}

	/**
	 * 首字母大写,其它字母小写
	 * <p> capitalizeFully("abc)	结果是Abc </p>
	 * <p> capitalizeFully("abc_ABc")	结果是Abc_ABc </p>
	 * @param str
	 * @return
	 */
	public static String capitalizeFully(String str) {
//		if (str == null || str.length() == 0) {
//			return str;
//		}
		if (StringUtil.isEmpty(str)) {
			return str;
		}
		String lowerStr = str.toLowerCase();
		StringBuilder sb = new StringBuilder(lowerStr.length());
		sb.append(Character.toUpperCase(lowerStr.charAt(0)));
		sb.append(lowerStr.substring(1));
		return sb.toString();
//		return capitalizeFully(str, null);
	}

	/**
	 * 首字母大写,其它字母小写
	 * @param str
	 * @return
	 */
	public static String capitalize(String str) {
		return changeFirstCharacterCase(str, true);
	}

	/**
	 * 首字母小写
	 * @param str
	 * @return
	 */
	public static String uncapitalize(String str) {
		return changeFirstCharacterCase(str, false);
	}

	/**
	 * 转换首字母，其他字母不变
	 * @param str
	 * @param capitalize
	 * @return
	 */
	private static String changeFirstCharacterCase(String str, boolean capitalize) {
//		if (str == null || str.length() == 0) {
//			return str;
//		}
		if (StringUtil.isEmpty(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str.length());
		if (capitalize) {
			sb.append(Character.toUpperCase(str.charAt(0)));
		}else {
			sb.append(Character.toLowerCase(str.charAt(0)));
		}
		sb.append(str.substring(1));
		return sb.toString();
	}

}
