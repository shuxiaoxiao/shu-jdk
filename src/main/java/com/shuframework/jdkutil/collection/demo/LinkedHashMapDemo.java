package com.shuframework.jdkutil.collection.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 特点：
 * 		有序(存储顺序和取出顺序不一致), key唯一
 * LinkedHashMap:是Map接口的哈希表和链接列表实现，具有可预知的迭代顺序。
 * 由哈希表保证键的唯一性
 * 由链表保证键盘的有序(存储和取出的顺序一致)
 * 
 */
public class LinkedHashMapDemo {
	public static void main(String[] args) {
		// 创建集合对象
		Map<String, String> linkedMap = new LinkedHashMap<>();
		Map<String, String> hashMap = new HashMap<>();

		// 创建并添加元素
		linkedMap.put("test3", "hello");
		linkedMap.put("test1", "world");
		linkedMap.put("test2", "java");
		linkedMap.put("test6", "javaee");
		linkedMap.put("test5", "android");
		
		hashMap.put("test3", "hello");
		hashMap.put("test1", "world");
		hashMap.put("test2", "java");
		hashMap.put("test6", "javaee");
		hashMap.put("test5", "android");

		// 遍历
//		Set<String> set = hm.keySet();
//		for (String key : set) {
//			String value = hm.get(key);
//			System.out.println(key + "---" + value);
//		}
		foreachMap(linkedMap);
		System.out.println("---------------");
		foreachMap(hashMap);
//		test3--hello
//		test1--world
//		test2--java
//		test6--javaee
//		test5--android
//		---------------
//		test5--android
//		test2--java
//		test3--hello
//		test6--javaee
//		test1--world
	}

	private static void foreachMap(Map<String, String> linkedMap) {
		Set<Entry<String, String>> set = linkedMap.entrySet();
		for (Entry<String, String> me : set) {
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key + "--" + value);
		}
	}
}
