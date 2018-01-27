package com.shuframework.jdk7.collection;

import java.lang.reflect.Array;

import com.shuframework.jdk7.lang.StringUtil;

/**
 * 数组工具类, 可以直接使用java.util.Arrays;
 * @author shu
 *
 */
public class ArrayUtil {

	/**
	 * 默认的连接方式，格式是[x1,x2]
	 * @param array
	 * @return
	 */
    public static String toString(final Object[] array) {
    	String str = StringUtil.join(array, ",");
    	StringBuilder buf = new StringBuilder(str.length() + 2);
    	buf.append("[");
    	buf.append(str);
    	buf.append("]");
        return buf.toString();
    }
    
    public static String toString2(final Object[] array) {
    	int length = array.length;
    	StringBuilder buf = new StringBuilder(length + 2);
    	buf.append("[");
    	for (int i = 0; i < length; i++) {
    		//先追加元素, 然后判断是否是最后
    		buf.append(array[i]);
    		if(i == length -1){
    			buf.append("]");
    		}
    		buf.append(", ");
		}
    	return buf.toString();
    }
    
    /**
     * 数组复制,如果长度比之前大，赋值为空
     * @param array
     * @param newLength
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T[] copyArr(T[] original, int newLength) {
    	return (T[]) copyArr(original, newLength, original.getClass());
    }
    
    /**
     * 
     * @param original
     * @param newLength
     * @param newType
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] copyArr(T[] original, int newLength, Class<? extends T[]> newType) {
    	if(original == null) return null;
    	
		T[] newArr = ((Object)newType == (Object)Object[].class)
    	            ? (T[]) new Object[newLength]
    	            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
    	            
    	int length = Math.min(original.length, newLength);
    	for (int i = 0; i < length; i++) {
    		newArr[i] = original[i];
		}
    	
    	return newArr;
    }
}
