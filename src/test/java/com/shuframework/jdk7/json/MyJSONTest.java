package com.shuframework.jdk7.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MyJSONTest {

	@Test
	public void collection2json_test3() {
		List<Map<?, ?>> list = new ArrayList<>();
		Map<Object, Object> map = new HashMap<>();
		map.put("key1", "val1");
		map.put("key2", 2);
		map.put("key3", null);
		map.put("key5", true);
		map.put(5, "val5");
		list.add(map);
		
		//{"key1":"val1","key2":2,"key5":true,5:"val5"}
		System.out.println(MyJSON.collection2json(list));
	}
	
	@Test
	public void collection2json_test2() {
		List<Object> list = new ArrayList<>();
		list.add("key1");
		list.add(null);
		list.add(2);
		//["key1","",2]
		System.out.println(MyJSON.collection2json(list));
	}
	
	@Test
	public void collection2json_set_test1() {
		Set<String> set = new HashSet<>();
		set.add("key1");
		set.add("key2");
		set.add("key3");
		//["key1","key2","key3"]
		System.out.println(MyJSON.collection2json(set));
	}
	
	@Test
	public void collection2json_list_test3() {
		List<Map<?, ?>> list = new ArrayList<>();
		Map<Object, Object> map = new HashMap<>();
		map.put("key1", "val1");
		map.put("key2", 2);
		map.put("key3", null);
		map.put("key5", true);
		map.put(5, "val5");
		list.add(map);
		
		//{"key1":"val1","key2":2,"key5":true,5:"val5"}
		System.out.println(MyJSON.collection2json(list));
	}
	
	@Test
	public void collection2json_list_test2() {
		List<Object> list = new ArrayList<>();
		list.add("key1");
		list.add(null);
		list.add(2);
		//["key1","",2]
		System.out.println(MyJSON.collection2json(list));
	}
	
	@Test
	public void collection2json_list_test1() {
		List<String> list = new ArrayList<>();
		list.add("key1");
		list.add("key2");
		list.add("key3");
		//["key1","key2","key3"]
		System.out.println(MyJSON.collection2json(list));
	}
	
	@Test
	public void map2json_test2() {
		Map<String, Object> map = new HashMap<>();
		map.put("key1", "val1");
		map.put("key2", 2);
		map.put("key3", null);
		map.put("key5", "");
		map.put("key6", true);
		//未排除null的情况  {"key1":"val1","key2":"val2","key5":"","key3":""}
		//{"key1":"val1","key2":"val2","key5":""}
		System.out.println(MyJSON.map2json(map));
	}
	
	@Test
	public void test1() {
		String str = "name";
		System.out.println(MyJSON.string2json(str));
	}
	
}
