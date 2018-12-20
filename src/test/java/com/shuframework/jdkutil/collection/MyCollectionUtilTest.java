package com.shuframework.jdkutil.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MyCollectionUtilTest {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		// 添加元素
		list.add(30);
		list.add(20);
		list.add(50);
		list.add(10);
		list.add(40);
		list.add(30);
		list.add(20);
		
		List<Integer> distinctList = MyCollectionUtil.distinct(list);
		System.out.println(distinctList);
	}
	
	@Test
	public void compareList_test1() {
		List<String> oldList = null;
		List<String> newList = null;
		oldList = new ArrayList<>();
		oldList.add("1");
		oldList.add("2");
		oldList.add("3");
		
		newList = new ArrayList<>();
		newList.add("1");
		newList.add("2");
		newList.add("4");
		newList.add("5");
		
//		Map<String, List<String>> returnMap = MyCollectionUtil.compareList(oldList, newList);
		Map<String, List<String>> returnMap = MyCollectionUtil.compareList2(oldList, newList);
		System.out.println(returnMap);
	}
	
	@Test
	public void compareList_test2() {
		List<Long> oldList = null;
		List<Long> newList = null;
		oldList = new ArrayList<>();
		oldList.add(1L);
		oldList.add(2L);
		oldList.add(3L);
		
		newList = new ArrayList<>();
		newList.add(1L);
		newList.add(2L);
		newList.add(4L);
		newList.add(5L);
		
//		Map<String, List<Long>> returnMap = MyCollectionUtil.compareList(oldList, newList);
		Map<String, List<Long>> returnMap = MyCollectionUtil.compareList2(oldList, newList);
		System.out.println(returnMap);
	}

}
