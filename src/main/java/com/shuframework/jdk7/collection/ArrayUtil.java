package com.shuframework.jdk7.collection;

import java.lang.reflect.Array;

/**
 * 数组工具类, 可以直接使用java.util.Arrays;
 * @author shu
 *
 */
public class ArrayUtil {
    
    /**
     * 数组复制,如果长度比之前大，多的长度内容赋值为空
     * 
     * @param array
     * @param newLength
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T[] copyArr(T[] original, int newLength) {
    	return (T[]) copyArr(original, newLength, original.getClass());
    }
    
    /**
     * 数组复制,如果长度比之前大，多的长度内容赋值为空
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
//    	for (int i = 0; i < length; i++) {
//    		newArr[i] = original[i];
//		}
    	System.arraycopy(original, 0, newArr, 0, length);
    	return newArr;
    }
    
    /**
     * 向前strp步复制
     * 
     * @param array
     * @param index
     * @param step
     * @return
     */
	public static <T> void forwardCopy(T[] array, int index, int step) {
		int size = array.length;
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		int copyLength = (size - step) - index;
		System.arraycopy(array, index + step, array, index, copyLength);
	}
	
	/**
	 * 向前复制（删除）
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static <T> void forwardCopy(T[] array, int index) {
//		int size = array.length;
//		if (index >= size || index < 0) {
//			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//		}
//		int copyLength = (size - 1) - index;
//		System.arraycopy(array, index + 1, array, index, copyLength);
		
		forwardCopy(array, index, 1);
		//其原理是把后一个下标值给当前, 正序循环是前一个值就不会变了
//		for (int i = index; i < array.length - 1; i++) {
//			array[i] = array[i + 1];
//		}
	}
	
	/**
	 * 向后复制（新增）
	 * 
	 * @param array
	 * @param index
	 * @param step
	 * @return
	 */
	public static <T> void backwardsCopy(T[] array, int index, int step) {
		int size = array.length;
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		int copyLength = (size - step) - index;
		System.arraycopy(array, index, array, index + step, copyLength);
	}
	
	/**
	 * 向后复制（新增）
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static <T> void backwardsCopy(T[] array, int index) {
//		int size = array.length;
//		if (index >= size || index < 0) {
//			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//		}
//		int copyLength = (size - 1) - index;
//		System.arraycopy(array, index, array, index + 1, copyLength);
		
		backwardsCopy(array, index, 1);
		//原理 把前一个下标值给当前, 倒序循环是前一个值就不会变了
//		for(int i = array.length - 1; i > index; i--){
//			array[i] = array[i - 1];
//		}
	}
	
	
}
