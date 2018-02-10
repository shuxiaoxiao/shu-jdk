package com.shuframework.jdk7.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MapUtilTest {

	Map<String, Object> strMap = null;
	Map<Integer, Object> intMap = null;
	
	@Before
	public void init() {
		strMap = new HashMap<>();
		strMap.put("key1", "val1");
		strMap.put("key3", null);
		strMap.put("key2", "val2");
		strMap.put("key5", "");
		
		intMap = new HashMap<>();
		intMap.put(1, "val1");
		intMap.put(3, "val2");
		intMap.put(2, null);
		intMap.put(5, "");
	}
	
	@Test
	public void test() {
		String strMinKey = MapUtil.getMinKey(strMap);
		System.out.println(strMinKey);
		
		Integer intMinKey = MapUtil.getMinKey(intMap);
		System.out.println(intMinKey);
	}

}
