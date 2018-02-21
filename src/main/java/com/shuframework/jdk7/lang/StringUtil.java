package com.shuframework.jdk7.lang;

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
	 * 添加addName的前缀或后缀
	 * 
	 * @param oldFileName
	 * @param removeName
	 * @param type  TYPE_PREFIX(前缀)、TYPE_SUFFIX(后缀)
	 * @return
	 */
	public static String renameByRemove(String oldFileName, String removeName, String type) {
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
     * <p>Joins the elements of the provided array into a single String
     * containing the provided list of elements.</p>
     *
     * <p>No delimiter is added before or after the list.
     * Null objects or empty strings within the array are represented by
     * empty strings.</p>
     *
     * <pre>
     * StringUtil.join(null, *)               = null
     * StringUtil.join([], *)                 = ""
     * StringUtil.join([null], *)             = ""
     * StringUtil.join(["a", "b", "c"], ';')  = "a;b;c"
     * StringUtil.join(["a", "b", "c"], null) = "abc"
     * StringUtil.join([null, "", "a"], ';')  = ";;a"
     * </pre>
     *
     * @param array  the array of values to join together, may be null
     * @param separator  the separator character to use
     * @return the joined String, {@code null} if null array input
     */
    public static String join(final Object[] array, final String separator) {
        if (array == null) {
            return null;
        }
        return join(array, separator, 0, array.length);
    }
	
    /**
     * <p>
     * Joins the elements of the provided array into a single String containing the provided list of elements.
     * </p>
     *
     * @param array 		数组
     * @param separator 	分隔符
     * @param startIndex 	the first index to start joining from
     * @param endIndex 		the index to stop joining from 
     * @return the joined String, {@code null} if null array input
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
        	//这个判断, 巧妙的实现了去头去尾
            if (i > startIndex) {
                buf.append(separator);	//得到的格式：1,2,3
//                buf.append(',').append(' '); //得到的格式：1, 2, 3 
            }
            Object obj = array[i];
            if (obj != null) {
            	buf.append(obj);
			}
            
        }
        return buf.toString();
    }
    
}
