package com.shuframework.jdk7.collection;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.shuframework.jdk7.collection.ArrayUtil;

public class ArrayUtilTest {

	Object[] objArr = null;
	String[] strArr = null;
	Integer[] intArr = null;
	
	@Before
	public void init() {
		objArr = new Object[]{2, 4, "str", 3, 6};
		strArr = new String[]{"2", "4", "8", "3", "6"};
		intArr = new Integer[]{2, 4, 8, 3, 6, 0, 0, 9};
		
	}
	
	@Test
	public void toString_test() {
		String objArrStr = ArrayUtil.toString(objArr);
		String intArrStr = ArrayUtil.toString(intArr);
		System.out.println(objArrStr);	//[2,4,str,3,6]
		System.out.println(intArrStr);	//[2,4,8,3,6]
	}
	
	@Test
	public void copy_test() {
		//[2, 4, 8, 3, 6, 0, 0, 0]
		System.out.println("copy前：" + Arrays.toString(intArr));	
		int index = 1;
		int length = (intArr.length - 1) - index;
//		System.arraycopy(intArr, index, intArr, index+1, length);
//		//[2, 4, 4, 8, 3, 6, 0, 0]
//		System.out.println("copy后（后移）：" + Arrays.toString(intArr));
		System.arraycopy(intArr, index+1, intArr, index, length);
		//[2, 8, 3, 6, 0, 0, 0, 0]
		System.out.println("copy后（前移）：" + Arrays.toString(intArr));	
	}
	
	@Test
	public void copy_test2() {
		//[2, 4, 8, 3, 6, 0, 0, 0]
		System.out.println("copy前：" + Arrays.toString(intArr));	
		intArr = Arrays.copyOf(intArr, 20);
//		System.arraycopy(intArr, 0, intArr, 0, 20);
		System.out.println("copy后（前移）：" + Arrays.toString(intArr));	
	}
	
	@Test
	public void forwardCopy_test2() {
		//[2, 4, 8, 3, 6, 0, 0, 0]
		System.out.println("copy前：" + Arrays.toString(intArr));	
		int index = 1;
//		ArrayUtil.forwardCopy(intArr, index, 2);
//		//[2, 8, 3, 6, 0, 0, 0, 0]
//		System.out.println("copy后（前移）：" + Arrays.toString(intArr));
//		int len = intArr.length;
//		for(int i = index; i< intArr.length - 1; i++){
//			intArr[i] = intArr[i+1];
//		}
//		//[2, 4, 3, 6, 0, 0, 0, 0]
		System.out.println("copy后（前移）：" + Arrays.toString(intArr));	
	}
	
	@Test
	public void backwardsCopy_test2() {
		//[2, 4, 8, 3, 6, 0, 0, 0]
		System.out.println("copy前：" + Arrays.toString(intArr));	
		int index = 1;
//		ArrayUtil.backwardsCopy(intArr, index);
//		//[2, 4, 4, 8, 3, 6, 0, 0]
//		System.out.println("copy后（后移）：" + Arrays.toString(intArr));
		for(int i = intArr.length - 1; i > index; i--){
			intArr[i] = intArr[i - 1];
		}
//		//[2, 4, 4, 8, 3, 6, 0, 0]
		System.out.println("copy后（后移）：" + Arrays.toString(intArr));
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
