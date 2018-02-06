package com.shuframework.jdk7.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.shuframework.jdk7.ValidateUtil;
import com.shuframework.jdk7.lang.StringUtil;

/**
 * 数组转换工具类
 * 	array、 String、 list之间的转换
 *
 * @author shu
 */
public class ArrayConvertUtil {
	
	/** 默认分隔符"," */
	private static final String SEPARATOR_DEFAULT = ",";
	/** 含有空格默认分隔符", " */
	private static final String SEPARATOR_DEFAULT_HAVEBLANK = ", ";
	
	/**
	 * 数组toString 得到的格式是[x1, x2]
	 * 
	 * @param array
	 * @return
	 */
	public static String toString(final Object[] array) {
//		if (ValidateUtil.isEmpty(array))	return "[]";
		if (ValidateUtil.isEmpty(array)) {
			return "[]";
		}

		// String str = StringUtil.join(array, SEPARATOR_DEFAULT);//[x1,x2]
		String str = StringUtil.join(array, SEPARATOR_DEFAULT_HAVEBLANK);// [x1, x2]
		StringBuilder sb = new StringBuilder(str.length() + 2);
		sb.append("[");
		sb.append(str);
		sb.append("]");
		return sb.toString();
	}
    
    /**
     * 数组toString 得到的格式是[x1, x2] (第二种方式, 与第一种实现区别不大, 不推荐实际项目使用)
     * 
     * @param array
     * @return
     */
    @Deprecated
    public static String toString2(final Object[] array) {
//    	if(ValidateUtil.isEmpty(array))	return "[]";
    	if(ValidateUtil.isEmpty(array)){
    		return "[]";
    	}
    	
    	int length = array.length;
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	for (int i = 0; i < length; i++) {
    		//先追加元素, 然后判断是否是最后
    		sb.append(array[i]);
    		if(i == length -1){
    			sb.append("]");
    		}else{
    			sb.append(SEPARATOR_DEFAULT_HAVEBLANK);
//    			sb.append(SEPARATOR_DEFAULT);
    		}
		}
    	return sb.toString();
    }
    
    /**
	 * 集合toString 得到格式是[x1, x2], 注意各集合的特别，特别是存储顺序和取出顺序是否一致 <br>
	 * (其实Collection 的子类都有重写toString, 所以这个方法只是为了了解底层的实现, 不推荐实际项目使用)
	 * 
	 * @param collection
	 * @return
	 */
    @Deprecated
    public static String toString(final Collection<?> collection) {
//    	if(ValidateUtil.isEmpty(collection))	return "[]";
    	if(ValidateUtil.isEmpty(collection)){
    		return "[]";
    	}
    	
    	Iterator<?> it = collection.iterator();
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
		while (true) {
			//先拿, 然后判断下一个
			sb.append(it.next());
			if (! it.hasNext()){
				return sb.append(']').toString();
			}
            sb.append(SEPARATOR_DEFAULT_HAVEBLANK);
//            sb.append(SEPARATOR_DEFAULT);
		}
		//这样不方便加","
//		while (it.hasNext()) {
//			buf.append(it.next());
//		}
    }
    
    /**
     * 数组转成String 得到的格式是 x1,x2
     * 
     * @param array
     * @return
     */
    public static String array2Str(final Object[] array) {
//    	if(ValidateUtil.isEmpty(array))	return "";
    	if(ValidateUtil.isEmpty(array)){
    		return "[]";
    	}
    	String str = StringUtil.join(array, SEPARATOR_DEFAULT);//[x1,x2]
//    	String str = StringUtil.join(array, SEPARATOR_DEFAULT_HAVEBLANK);//[x1, x2]
    	return str;
    }
    
    /**
     * 数组转成固定长度的集合, 
     * 得到的集合不能进行add/remove/clear方法会抛出UnsupportedOperationException异常, 
     * 因为得到的是个固定长度的集合, 只是转换接口, 后台的数据仍是数组
     * 
     * @param array
     * @return
     */
    public static <T> List<T> array2ListOfFixed(final T[] array) {
    	//返回对象是一个Arrays内部类，并没有实现集合的修改方法。Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
    	return Arrays.asList(array);
    }
    
    /**
     * 数组转成可变长度的集合 (用String做例子, 实质是创建集合循环add)
     * 
     * @param array
     * @return
     */
    private static List<String> array2ListOfVar(final String[] array) {
    	int size = Math.min(array.length * 2, 10);
    	List<String> list = new ArrayList<>(size);
    	for (String value : list) {
    		list.add(value);
		}
    	return list;
    }
    
    /**
     * 数组转成可变长度的集合 (实质是创建集合循环add)
     * 
     * @param array
     * @param list
     * @return
     */
    public static <T> void array2ListOfVar(final T[] array, List<T> list) {
    	//todo 此处可能用反射可以解决外部创建list的问题
    	for (T value : array) {
    		list.add(value);
    	}
    }
    
    /**
     * 集合转成String 得到的格式是 "x1,x2", 注意各集合的特别，特别是存储顺序和取出顺序是否一致
     * 
     * @param collection
     * @return
     */
    public static String collection2Str(final Collection<?> collection) {
    	if(ValidateUtil.isEmpty(collection))	return "";
//    	if(ValidateUtil.isEmpty(collection)){
//    		return "[]";
//    	}
    	
    	Iterator<?> it = collection.iterator();
    	StringBuilder sb = new StringBuilder();
		while (true) {
			//先拿, 然后判断下一个
			sb.append(it.next());
			if (! it.hasNext()){
				return sb.toString();
			}
//            sb.append(SEPARATOR_DEFAULT_HAVEBLANK);
            sb.append(SEPARATOR_DEFAULT);
		}
    }
    
    /**
     * 集合转成数组 (使用的是集合自带的方法)
     * 
     * @param collection
     * @param array
     */
    public static <T> void collection2Array(final Collection<?> collection, T[] array) {
    	//todo 此处可能用反射可以解决外部创建array的问题
    	collection.toArray(array);
    }
    
    //不推荐, 这种方法转换后可能还需要进行强转
//    public static Object[] collection2Array(final Collection<?> collection) {
//    	return collection.toArray();
//    }
    
    /**
     * 字符串 转为数组, 字符串格式是"x1,x2"
     * <pre>
	 * str为"x1,x2"	 	 返回true
	 * str为"x1,x2,"	 	返回fasle
	 * str为"x1"  		 返回true
	 * </pre>
	 * 
     * @param str
     * @return
     */
    public static String[] str2Array(final String str) {
    	return str2Array(str, SEPARATOR_DEFAULT);
    }
    
    /**
     * 字符串 转为数组
     * 
     * @param str
     * @param separator
     * @return
     */
	public static String[] str2Array(final String str, final String separator) {
		if (!ValidateUtil.matchRegex(separator, str)) {
			throw new IllegalArgumentException("字符串格式是x1" + separator + "x2");
		}

		if (ValidateUtil.isEmpty(str))
			return null;

		String[] strArr = str.split(separator);
		return strArr;
	}
    
	/**
	 * 字符串 转成固定长度的集合, str格式是是"x1,x2"
	 * 
	 * @param str
	 * @return
	 */
    public static List<String> str2ListOfFixed(final String str) {
//    	String[] strArr = str2Array(str);
//    	//返回对象是一个Arrays内部类，并没有实现集合的修改方法。Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
//    	return Arrays.asList(strArr);
    	return str2ListOfFixed(str, SEPARATOR_DEFAULT);
    }
    
    /**
     * 字符串 转成固定长度的集合
     * 
     * @param str
     * @return
     */
    public static List<String> str2ListOfFixed(final String str, String separator) {
    	String[] strArr = str2Array(str, separator);
//    	return Arrays.asList(strArr);
    	return array2ListOfFixed(strArr);
    }
    
    /**
     * 字符串 转成可变长度的集合, str格式是是"x1,x2"
     * 
     * @param str
     * @return
     */
    public static List<String> str2ListOfVar(final String str) {
    	return str2ListOfVar(str, SEPARATOR_DEFAULT);
    }
    
    /**
     * 字符串 转成可变长度的集合
     * @param str
     * @return
     */
    public static List<String> str2ListOfVar(final String str, String separator) {
    	String[] strArr = str2Array(str, separator);
    	List<String> list = array2ListOfVar(strArr);
//    	int size = Math.min(strArr.length * 2, 10);
//    	List<String> list = new ArrayList<>(size);
//    	for (String value : strArr) {
//    		list.add(value);
//		}
    	return list;
    }
    
    /** 
     * 这个只是提供一种思路
     * 
     * @param str
     * @return
     */
    @Deprecated
    public static List<String> str2ListOfVar2(final String str) {
    	List<String> fixedList = str2ListOfFixed(str);
    	int size = Math.min(fixedList.size() * 2, 10);
    	List<String> list = new ArrayList<>(size);
    	//这个的实质是对数组进行copy
    	list.addAll(fixedList);
    	
    	return list;
    }

}
