package com.shuframework.jdkutil.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
	
	@Test
	public void test2() {
		String str = (String) intMap.get(2);
		System.out.println(str);
	}

	@Test
	public void removeKey_test1() {
		intMap.remove(2);
		System.out.println(intMap);
	}
	@Test
	public void removeKey_test2() {
		MapUtil.removeKey(strMap, "key1");
		System.out.println(strMap);
	}

	@Test
	public void removeVal_test0() {
		boolean flag = strMap.remove(strMap, "key1");
		System.out.println(flag);
		System.out.println(strMap);
	}
	@Test
	public void removeVal_test1() {
		boolean flag = MapUtil.removeVal(strMap, "key1");
		System.out.println(flag);
		System.out.println(strMap);
	}
	@Test
	public void removeVal_test2() {
		boolean flag = MapUtil.removeVal(strMap, "val1");
		System.out.println(flag);
		System.out.println(strMap);
	}


	

}
