package com.shuframework.jdkdemo.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * LinkedListDemo 与ArrayListDemo里面的非特有方法使用是一样
 * 
 * LinkedList的特有功能：
 * 注意是LinkedList strLinkedList = new LinkedList<>(); 这样子类对象特有方法才能调用
 * 		A:添加功能
 * 			public void addFirst(Object e)
 * 			public void addLast(Object e)
 * 		B:获取功能
 * 			public Object getFirst()
 * 			public Obejct getLast()
 * 		C:删除功能
 * 			public Object removeFirst()
 * 			public Object removeLast()
 * 
 */
public class LinkedListDemo {

	List<String> strList = null;
	LinkedList<String> strLinkedList = null;
	
	@Before
	public void add() {
		strList = new LinkedList<>();
		strList.add("aa");
		strList.add("bb");
		
		/*
		 * 特有方法,
		 * 注意是LinkedList strLinkedList = new LinkedList<>();
		 * List strList = new LinkedList<>(); 这样的对象方法都是左边的
		 */
		strLinkedList = new LinkedList<>();
		strLinkedList.addFirst("aa");
		strLinkedList.addFirst("bb");
		
	}
	
	@Test
	public void show() {
//		list的遍历有3种
		Iterator<String> it = strList.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

		System.out.println("-----------");
		for (int x = 0; x < strList.size(); x++) {
			String s = strList.get(x);
			System.out.println(s);
		}
		
		System.out.println("-----------");
		for (String str : strList) {
			System.out.println(str);
		}
	}
}
