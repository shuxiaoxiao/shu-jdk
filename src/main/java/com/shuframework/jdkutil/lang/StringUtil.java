package com.shuframework.jdkutil.lang;

import com.shuframework.jdkutil.enums.SeparatorTypeEnum;

import java.util.Collection;
import java.util.Iterator;

/**
 * String 的工具类
 * 
 * @author shu
 */
public class StringUtil {
	
	/** 前缀 */
	public final static String TYPE_PREFIX = "prefix";
	/** 后缀 */
	public final static String TYPE_SUFFIX = "suffix";
	/** 默认分隔符（,） */
	private static final String SEPARATOR_DEFAULT = SeparatorTypeEnum.COMMA.getValue();
	/** 点（.） */
	private static final String SEPARATOR_POINT = SeparatorTypeEnum.POINT.getValue();
	
	/**
	 * 获得文件后缀, ""表示无后缀,如返回doc 或 xls等
	 * @param str
	 * @return
	 */
	public static String getSuffix(String str) {
		int index = str.lastIndexOf(".");
		if (index != -1) {
			String suffix = str.substring(index + 1);
			return suffix;
		} else {
			return "";
		}
	}
	
	/**
	 * 获得文件后缀, ""表示无后缀,如返回.doc 或.xls等
	 * @param str
	 * @return
	 */
	public static String getSuffixHasPoint(String str) {
		int index = str.lastIndexOf(".");
		if (index != -1) {
			String suffix = str.substring(index);
			return suffix;
		} else {
			return "";
		}
	}
	
	/**
	 * 添加addName的前缀或后缀
	 * 
	 * @param oldFileName
	 * @param addName
	 * @param type  TYPE_PREFIX(前缀)、TYPE_SUFFIX(后缀)
	 * @return
	 */
	public static String renameByAdd(String oldFileName, String addName, String type) {
		String newName = "";
		if(TYPE_PREFIX.equals(type)){
			newName = addName + oldFileName;
		}
		if(TYPE_SUFFIX.equals(type)){
			//截取后缀
			String suffix = "";
			String temp = oldFileName;
			int index = oldFileName.lastIndexOf(".");
			if (index != -1) {
				temp = oldFileName.substring(0, index);
				suffix = oldFileName.substring(index);
			}
			newName = temp + addName + suffix;
		}
		return newName;
	}
	
	/**
	 * 移除removeName的前缀或后缀
	 * oldFileName 不包含removeName 则返回oldFileName
	 *
	 * @param oldFileName
	 * @param removeName
	 * @param type  TYPE_PREFIX(前缀)、TYPE_SUFFIX(后缀)
	 * @return
	 */
	public static String renameByRemove(String oldFileName, String removeName, String type) {
		if (!oldFileName.contains(removeName)){
			return oldFileName;
		}
		String newName = "";
		if(TYPE_PREFIX.equals(type)){
			newName = oldFileName.substring(removeName.length());
		}
		if(TYPE_SUFFIX.equals(type)){
			//截取后缀
			String suffix = "";
			String temp = oldFileName;
			int index = oldFileName.lastIndexOf(".");
			if (index != -1) {
				temp = oldFileName.substring(0, index);
				suffix = oldFileName.substring(index);
			}
			//截掉temp中的removeName
			int endIndex = temp.length() - removeName.length();
			temp = temp.substring(0, endIndex);
			newName = temp + suffix;
		}
		return newName;
	}
	//SystemUtil.getNewFilename  获得新的文件名
	
	
	/**
	 * 判断是否为null或空串（去空格了），是返回 true
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		//当str = null时为true，后面的不执行了，所以str = null时不会执行trim()，所以就没问题
		return str == null || str.trim().length() == 0;
	}
//	
//	/**
//	 * 判断是否不为null或非空串（去空格了），是返回 true
//	 * @param str
//	 * @return
//	 */
//	public static boolean isNotEmpty(String str){
//		
//		return !isEmpty(str);
//	}
	
	/**
	 * 转换空串，如str是空串或null 则转成num，不为空就是本身
	 * @param str
	 * @param num
	 * @return
	 */
	public static String parseEmpty(String str, String num){
		if(isEmpty(str)){
			return num;
		}
		
		return str;
	}
	
	/**
	 * 对数字补零，
	 * <p>数字1，补零到3位，则返回001</p>
	 * <p>数字-1，补零到3位，则返回-01</p>
	 * @param num
	 * @param length
	 * @return
	 */
	public static String fillLeftZero(int num, int length) {
		return String.format("%0" + length + "d", num);
	}

	/**
	 * 去掉所有空格
	 * @param str
	 * @return
	 */
	public static String trimAll(String str){
		return str.replace(" ", "");
	}

	/**
	 * 多个字符串拼接, 底层是StringBuilder的append实现
	 * @param str
	 * @return
	 */
	public static String append(Object... str){
		StringBuilder sb = new StringBuilder();
		for (Object s : str) {
			sb.append(s);
		}
		return sb.toString();
	}

	/**
	 * 多个字符串拼接, 底层是StringBuilder的append实现
	 * @param str
	 * @return
	 */
	public static String appendHasTrim(String... str){
		StringBuilder sb = new StringBuilder();
		for (String s : str) {
			sb.append(trimAll(s));
		}
		return sb.toString();
	}

	//效率不高，因为有类型转换
//	public static String join(final Collection<?> collection) {
//		if (ValidateUtil.isEmpty(collection)) {
//			return "";
//		}
//		return collection.stream().map(obj -> String.valueOf(obj))
//				.collect(Collectors.joining(SEPARATOR_DEFAULT));
//	}
//
//	public static String join(final Object[] arr) {
//		if (ValidateUtil.isEmpty(arr)) {
//			return "";
//		}
//		return Stream.of(arr).map(obj -> String.valueOf(obj))
//				.collect(Collectors.joining(SEPARATOR_DEFAULT));
//	}

	/**
	 * 数组转为字符串, 出现null,值不会拼接
	 *
	 * @param array		数组
	 * @return
	 */
	public static String join(final Object[] array) {
		return join(array, SEPARATOR_DEFAULT);
	}
	/**
	 * 数组转为字符串, 出现null,值不会拼接
	 *
	 * @param array		数组
	 * @param separator 分隔符
	 * @return
	 */
	public static String join(final Object[] array, final String separator) {
		return join(array, separator, 0, array.length);
	}

	/**
	 * 数组转为字符串, 出现null,值不会拼接
	 *
	 * @param array 		数组
	 * @param separator 	分隔符
	 * @param startIndex 	开始下标
	 * @param endIndex 		结束下标
	 * @return
	 */
	public static String join(final Object[] array, final String separator, final int startIndex, final int endIndex) {
		if (array == null) {
			return null;
		}
		final int noOfItems = endIndex - startIndex;
		if (noOfItems <= 0) {
			return "";
		}
		final StringBuilder buf = new StringBuilder(noOfItems * 16);
		for (int i = startIndex; i < endIndex; i++) {
			//这个判断, 巧妙的实现了去头去尾（先加分隔符，但是第一次不会）
			if (i > startIndex) {
				buf.append(separator);	//得到的格式：1,2,3
			}
			Object obj = array[i];
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	public static String join(final Collection<?> collection) {
		return join(collection, SEPARATOR_DEFAULT);
	}

	/**
	 * 集合转为字符串, 出现null,值不会拼接
	 *
	 * @param collection
	 * @param separator
	 * @return
	 */
	public static String join(final Collection<?> collection, final String separator) {
		if (collection == null || collection.size() == 0) {
			return null;
		}
		Iterator iterator = collection.iterator();
		Object first = iterator.next();
		// two or more elements
		StringBuilder buf = new StringBuilder(256); // Java default is 16, probably too small
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			buf.append(separator);
			Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	/**
	 * 首字母大写其它字母小写,去掉了分隔符(分隔符隔开的 都会首字母都会大写)
	 * <p> capitalizeFully("abc_ABc", null)	结果是AbcAbc </p>
	 * <p> capitalizeFully("abc_ABc", '_')	结果是AbcAbc </p>
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
			return capitalizeFully(str);
		}

		String delimiter = "";
		//由于每次都判断，该种方法效率低（但实际一般是一个所以还好）
		for (int i = 0, max = delimiters.length; i < max; i++) {
			if(i == max - 1){
				delimiter += "\\" + delimiters[i];
			}else{
				delimiter += "\\" + delimiters[i] + "|";
			}
		}
//		//split 的多分隔符实现，采用的实际是正则表达式, \为转义符, |为连接接符类似+
//		for (char c : delimiters) {
//			delimiter += "\\" + c + "|";
//		}
//		//去掉最后的一个连接符
//		delimiter = delimiter.substring(0, delimiter.length() -1);

		String lowerStr = str.toLowerCase();
		StringBuilder sb = new StringBuilder();
		String[] splitStrArr = lowerStr.split(delimiter);
		for (String splitStr : splitStrArr) {
			sb.append(Character.toUpperCase(splitStr.charAt(0)));
			sb.append(splitStr.substring(1));
		}
		return sb.toString();
	}

	/**
	 * 首字母大写,其它字母小写
	 * <p> capitalizeFully("abc")	结果是Abc </p>
	 * <p> capitalizeFully("abc_Abc")	结果是Abc_ABc </p>
	 * @param str
	 * @return
	 */
	public static String capitalizeFully(String str) {
//		if (StringUtil.isEmpty(str)) {
//			return str;
//		}
//		String lowerStr = str.toLowerCase();
//		StringBuilder sb = new StringBuilder(lowerStr.length());
//		sb.append(Character.toUpperCase(lowerStr.charAt(0)));
//		sb.append(lowerStr.substring(1));
//		return sb.toString();
		return changeFirstCharacterCase(str.toLowerCase(), true);
	}

	/**
	 * 首字母大写
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
	 * 首字母小写
	 * @param clazz
	 * @return
	 */
	public static String uncapitalize(Class<?> clazz) {
		//clazz.getName();// 全路径
		String className = clazz.getSimpleName();//只是类名
		return changeFirstCharacterCase(className, false);
	}

	/**
	 * 转换首字母，其他字母不变
	 * @param str
	 * @param capitalize
	 * @return
	 */
	private static String changeFirstCharacterCase(String str, boolean capitalize) {
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
