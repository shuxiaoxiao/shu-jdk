package com.shuframework.jdk7.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * map示例
 * @author shu
 *
 */
public class MapDemo {

	@Test
	public void test() {
		Map<String, Object> map = new HashMap<>();
		map.put("1", "测试1");
		map.put("2", "测试2");
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
	}
}
