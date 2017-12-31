package com.shuframework.datastructure.list;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

	MyArrayList<String> strList = null;
	Object[] strArr = null;

	@Before
	public void add() {
		strList = new MyArrayList<>(3);
		System.out.println("init前："+strList.resizeCount);
		strList.add("a1");
		strList.add("a2");
		strList.add("a3");
		strList.add("a4");
		strList.add("a5");
//		strList.add("a6");
//		strList.add("a7");
		System.out.println("init后："+strList.resizeCount);
		
		strArr = strList.toArray();
		System.out.println("s1:"+ Arrays.toString(strArr));
	}

	@Test
	public void test() {
		int index = 2;
//		strList.remove(index);
		strList.add(index, "b1");
		System.out.println("s2:"+ strList);
//		strList.arrayCopy(index, strArr, "up");
//		System.out.println("s2:"+ Arrays.toString(strArr));
	}
	
	@Test
	public void test2() {
		int index = 2;
		int srcPos = index + 1;
		System.arraycopy(strArr, srcPos, strArr, index, (strArr.length - srcPos) );
		System.out.println("s2:"+Arrays.toString(strArr));
	}

}
