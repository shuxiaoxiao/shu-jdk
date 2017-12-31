package com.shuframework.jdk7.lang;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArrayUtilTest {

	Object[] objArr = null;
	String[] strArr = null;
	Integer[] intArr = null;
	
	@Before
	public void init() {
		objArr = new Object[]{2, 4, "str", 3, 6};
		strArr = new String[]{"2", "4", "8", "3", "6"};
		intArr = new Integer[]{2, 4, 8, 3, 6};
		
	}
	
	@Test
	public void test() {
		String objArrStr1 = Arrays.toString(objArr);
		System.out.println(objArrStr1);	//[2, 4, str, 3, 6]
		System.out.println("--------------");
		String objArrStr = ArrayUtil.toString(objArr);
		String intArrStr = ArrayUtil.toString(intArr);
		System.out.println(objArrStr);	//[2,4,str,3,6]
		System.out.println(intArrStr);	//[2,4,8,3,6]
	}
	
	@Test
	public void test2() {
		String[] newStrArr = ArrayUtil.copyArr(strArr, 8);
		Integer[] newIntArr = ArrayUtil.copyArr(intArr, 8);
		Object[] newObjArr = ArrayUtil.copyArr(objArr, 8);
		System.out.println(ArrayUtil.toString(newStrArr));
		System.out.println(ArrayUtil.toString(newIntArr));
		System.out.println(ArrayUtil.toString(newObjArr));
		System.out.println("--------------");
		Integer[] newIntArr2 = Arrays.copyOf(intArr, 3);
		Integer[] newIntArr3 = Arrays.copyOf(intArr, 8);
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(newIntArr2));
		System.out.println(Arrays.toString(newIntArr3));
	}

}
