package com.shuframework.jdk7.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArrayListDemo {

	List<String> strList = null;
	
	@Before
	public void add() {
		strList = new ArrayList<>();
		strList.add("aa");
		
	}
	
	
	@Test
	public void test() {
		int oldCapacity = 5;
		int newCapacity = (oldCapacity * 3) / 2 + 1;
		int newCapacity2 = oldCapacity + (oldCapacity / 2) + 1;
		System.out.println(newCapacity);
		System.out.println(newCapacity2);
	}
}
