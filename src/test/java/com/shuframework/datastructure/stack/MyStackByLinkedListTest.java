package com.shuframework.datastructure.stack;

import org.junit.Before;
import org.junit.Test;

public class MyStackByLinkedListTest {

	MyStackByLinkedList<String> myStack = null;
	
	@Before
	public void init() {
		myStack = new MyStackByLinkedList<>();
		myStack.add("1");
		myStack.add("2");
		myStack.add("3");
		System.out.println(myStack);
		System.out.println("size:" + myStack.size());
	}
	
	@Test
	public void get_test() {
		String str1 = myStack.peek();
		System.out.println(str1);
	}
	
	@Test
	public void for_test1() {
		int size = myStack.size();
		for (int i = 0; i < size; i++) {
			String str1 = myStack.poll();
			System.out.println(str1);
		}
	}
	
	@Test
	public void for_test2() {
		while(myStack.isNotEmpty()){
			String str1 = myStack.poll();
			System.out.println(str1);
		}
		System.out.println("===新增===");
		myStack.add("b1");
		myStack.add("b2");
		myStack.add("b3");
		int size = myStack.size();
		for (int i = 0; i < size; i++) {
			String str1 = myStack.poll();
			System.out.println(str1);
		}
	}

}
