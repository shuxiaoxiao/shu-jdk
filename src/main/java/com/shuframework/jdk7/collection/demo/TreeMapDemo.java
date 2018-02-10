package com.shuframework.jdk7.collection.demo;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * TreeMap:是基于红黑树的Map接口的实现。
 * 特点：
 * 		对key排序, key唯一
 * 
 */
public class TreeMapDemo {

	@Test
	public void test() {
		Map<String, String> treeMap = new TreeMap<>();

		// 创建并添加元素
		treeMap.put("test3", "hello");
		treeMap.put("test1", "world");
		treeMap.put("test2", "java");
		treeMap.put("test6", "javaee");
		treeMap.put("test5", "android");
		
		foreachMap(treeMap);
//		test1--world
//		test2--java
//		test3--hello
//		test5--android
//		test6--javaee
	}
	
	public void foreachMap(Map<String, String> map) {
		Set<Entry<String, String>> set = map.entrySet();
		for (Entry<String, String> me : set) {
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key + "--" + value);
		}
	}
}
