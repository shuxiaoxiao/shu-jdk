package com.shuframework.datastructure.list;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyFixedArrayListTest {

	MyFixedArrayList<String> fixedArrayList = null;
	
	@Before
	public void init() {
		fixedArrayList = new MyFixedArrayList<>(5);
		fixedArrayList.add("a1");
		fixedArrayList.add("a2");
		fixedArrayList.add("a3");
		System.out.println("初始化：" + fixedArrayList.toString());
	}
	
	@Test
	public void add_test() {
		fixedArrayList.add("a4");
//		fixedArrayList.add("a5");
//		fixedArrayList.add(3, "a5");
		fixedArrayList.add(4, "a5");
//		//担心越界最好判断
//		if(!fixedArrayList.isFull()){
//			fixedArrayList.add("a6");
//		}
		System.out.println("add：" + fixedArrayList.toString());
//		String oldValue = fixedArrayList.removeKey(3);
//		String oldValue = fixedArrayList.removeKey();
//		System.out.println("removeKey：" + oldValue);
//		System.out.println("removeKey：" + fixedArrayList.toString());
	}
	
	@Test
	public void set_test() {
		fixedArrayList.set(3, "b1");
		System.out.println("set：" + fixedArrayList.toString());
		fixedArrayList.add(3, "b2");
		System.out.println("set：" + fixedArrayList.toString());
	}
	
	@Test
	public void remove_test() {
		String oldValue1 = fixedArrayList.remove();
		System.out.println("removeKey：" + oldValue1);
		String oldValue2 = fixedArrayList.remove();
		System.out.println("removeKey：" + oldValue2);
		System.out.println("removeKey：" + fixedArrayList.toString());
	}
	
	@Test
	public void getList_test() {
		Object[] arr1 = fixedArrayList.getArray();
		System.out.println("getArray：" + Arrays.toString(arr1));
		
		String[] arr2 = new String[fixedArrayList.size()];
		fixedArrayList.toArray(arr2);
		System.out.println("getArray：" + Arrays.toString(arr2));
		
		List<String> list1 = fixedArrayList.getList();
		System.out.println("getList：" + list1);
		for(String str : list1){
			System.out.print(str + ", ");
		}
	}

}
