package com.shuframework.jdk7.collection;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * TreeSet：能够对元素按照某种规则进行排序。
 * 排序有两种方式
 * A:自然排序
 * B:比较器排序
 * 
 * TreeSet集合的特点：排序和唯一
 * 
 * 通过观察TreeSet的add()方法，我们知道最终要看TreeMap的put()方法。
 */
public class TreeSetDemo {

	TreeSet<String> treeSet = null;
	
	//
	@Before
	public void add() {
		//自然排序
		treeSet = new TreeSet<String>();
		treeSet.add("aa");
		treeSet.add("b");
		treeSet.add("ab");
		treeSet.add("bc");
		treeSet.add("ba");
		
	}
	
	
	@Test
	public void show() {
//		set的遍历有2种
		Iterator<String> it = treeSet.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("-----------");
		for (String str : treeSet) {
			System.out.println(str);
		}
	}
	
	@Test
	public void test() {
		
	}
}
