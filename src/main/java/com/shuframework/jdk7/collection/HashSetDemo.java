package com.shuframework.jdk7.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class HashSetDemo {

	Set<String> strSet = null;
	
	/**
	 * 	先看hashCode()值是否相同
	 * 		相同:继续走equals()方法
	 * 			返回true：	说明元素重复，就不添加
	 * 			返回false：说明元素不重复，就添加到集合
	 * 		不同：就直接把元素添加到集合
	 */
	@Before
	public void add() {
		strSet = new HashSet<String>();
		strSet.add("aa");
		strSet.add("bb");
		strSet.add("cc");
	}
	
	@Test
	public void show() {
//		set的遍历有2种
		Iterator<String> it = strSet.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("-----------");
		for (String str : strSet) {
			System.out.println(str);
		}
	}
	
	
	@Test
	public void test() {
		
	}
}
