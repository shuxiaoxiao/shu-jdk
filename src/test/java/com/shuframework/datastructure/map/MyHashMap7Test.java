package com.shuframework.datastructure.map;

import com.shuframework.datastructure.list.MyArrayList;
import com.shuframework.jdk7.lang.StringUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyHashMap7Test {

	MyHashMap7<String, String> myHashMap7 = null;

	@Before
	public void init() {
		myHashMap7 = new MyHashMap7<>();
		myHashMap7.put("a1", "1");
		myHashMap7.put("a2", "2");
		myHashMap7.put("a3", "3");
		System.out.println(StringUtil.append("size:", myHashMap7.size(), ", length:", myHashMap7.length()));
//		System.out.println("size：" + myHashMap7.size() + ", length：" + myHashMap7.length());
		System.out.println("初始化:" + myHashMap7.toString());
	}

	@After
	public void end() {
		System.out.println("size：" + myHashMap7.size() + ", length：" + myHashMap7.length());
		System.out.println("操作后:" + myHashMap7.toString());
	}

	@Test
	public void put_test() {
		myHashMap7.put("b1", "11");
		myHashMap7.put("b2", "12");
		myHashMap7.put("b3", "13");

		myHashMap7.put("c1", "111");
		myHashMap7.put("c2", "112");
		myHashMap7.put("c3", "113");
//		int index = 1;
//		myHashMap7.add(index, "b1");
		System.out.println("resizeCount：" + myHashMap7.getResizeCount());
		System.out.println("put:"+ myHashMap7);

		String v1 = myHashMap7.get("a1");
		System.out.println("get:"+ v1);
		String v2 = myHashMap7.get("b1");
		System.out.println("get:"+ v2);
	}

	@Test
	public void get_test() {
		String v1 = myHashMap7.get("a1");
		System.out.println("get:"+ v1);
		String v2 = myHashMap7.get("b1");
		System.out.println("get:"+ v2);
	}

//	@Test
//	public void remove_test() {
//		int index = 0;
//		myHashMap7.remove(index);
//		myHashMap7.remove(index);
//		myHashMap7.remove(index);
//		System.out.println("remove:"+ myHashMap7);
//	}
	

}
