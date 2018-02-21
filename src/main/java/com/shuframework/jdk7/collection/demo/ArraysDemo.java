package com.shuframework.jdk7.collection.demo;

import java.util.Arrays;

import org.junit.Test;

/**
 * Arrays的示例
 * @author shu
 *
 */
public class ArraysDemo {

	@Test
	public void toString_test() {
		int[] intArr = {1,2,3};
		Integer[] intArr2 = {1,2,3};
		
		Object obj1 = intArr;
//		Object[] objArr1 = intArr; //编译不通过, 这个对应的是Object
		Object[] objArr2 = intArr2;
		
		//注意底层匹配的方法不同
		//toString(int[] a)
		System.out.println(Arrays.toString(intArr));//[1, 2, 3]
		//toString(Object[] a)
		System.out.println(Arrays.toString(intArr2));//[1, 2, 3]
	}
	
	@Test
	public void asList() {
		int[] intArr = {1,2,3};
		Integer[] intArr2 = {1,2,3};
		System.out.println(intArr.getClass());
		System.out.println(intArr2.getClass());
		
		Object obj1 = intArr;
//		Object[] objArr1 = intArr; //编译不通过, 这个对应的是Object
		Object[] objArr2 = intArr2;
		
		System.out.println(Arrays.asList(intArr));//[[I@30946e09] ,被当成一个对象
		System.out.println(Arrays.asList(intArr2));//[1, 2, 3]
	}
	
}
