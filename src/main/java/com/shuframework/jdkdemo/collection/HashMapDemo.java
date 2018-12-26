package com.shuframework.jdkdemo.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * Map集合和Collection集合的区别?
 * 		Map集合存储元素是成对出现的，Map集合的键是唯一的，值是可重复的。可以把这个理解为：夫妻对
 * 		Collection集合存储元素是单独出现的，Collection的儿子Set是唯一的，List是可重复的。可以把这个理解为：光棍(11.11)
 * 注意：
 * 		Map集合的数据结构针对键有效，跟值无关	
 *		Collection集合的数据结构是针对元素有效
 * 
 * 特点：
 * 		无序(存储顺序和取出顺序不一致), key唯一
 * 
 * Map集合的功能概述：
 * 1:添加功能
 * 		V put(K key,V value):添加元素
 * 			如果键是第一次存储，就直接存储元素，返回null
 * 			如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
 * 2:删除功能
 * 		void clear():移除所有的键值对元素
 * 		V removeKey(Object key)：根据键删除键值对元素，并把值返回
 * 3:判断功能
 * 		boolean containsKey(Object key)：判断集合是否包含指定的键
 * 		boolean containsValue(Object value):判断集合是否包含指定的值
 * 		boolean isEmpty()：判断集合是否为空
 * 4:获取功能
 * 		Set<Map.Entry<K,V>> entrySet():返回的是键值对对象的集合 （推荐用这种方法遍历）
 * 		V get(Object key):根据键获取值
 * 		Set<K> keySet():获取集合中所有键的集合
 * 		Collection<V> values():获取集合中所有值的集合
 * 5：长度功能
 * 		int size()：返回集合中的键值对的对数
 * 
 */
public class HashMapDemo {

	@Test
	public void test() {
		// 创建集合对象
		Map<String, String> map = new HashMap<>();

		// 添加元素
		// V put(K key,V value):添加元素。这个其实还有另一个功能?先不告诉你，等会讲
		// System.out.println("put:" + map.put("文章", "马伊俐"));
		// System.out.println("put:" + map.put("文章", "姚笛"));
		map.put("test1", "测试1");
		map.put("test2", "测试2");

		// void clear():移除所有的键值对元素
		// map.clear();

		// V removeKey(Object key)：根据键删除键值对元素，并把值返回
		// System.out.println("removeKey:" + map.removeKey("test1"));
		// System.out.println("removeKey:" + map.removeKey("test2"));

		// boolean containsKey(Object key)：判断集合是否包含指定的键
		// System.out.println("containsKey:" + map.containsKey("test1"));
		// System.out.println("containsKey:" + map.containsKey("test2"));

		// boolean isEmpty()：判断集合是否为空
		// System.out.println("isEmpty:"+map.isEmpty());

		// int size()：返回集合中的键值对的对数
		System.out.println("size:" + map.size());

		// V get(Object key):根据键获取值
		System.out.println("get:" + map.get("test1"));
		System.out.println("get:" + map.get("test3")); // 返回null
		System.out.println("----------------------");

		// Set<K> keySet():获取集合中所有键的集合
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println(key);
		}
		System.out.println("----------------------");

		// Collection<V> values():获取集合中所有值的集合
		Collection<String> con = map.values();
		for (String value : con) {
			System.out.println(value);
		}
	}
	
	//方式1：键找值(这种其实循环了2遍)
	public void show1(Map<?, ?> map) {
		// 键 对象
		Set<?> set = map.keySet();
		for (Object key : set) {
			String value = map.get(key).toString();
			System.out.println(key + "--" + value);
		}
	}
	
	//方式2：键值对对象找键和值
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void show2(Map map) {
		// 键值对 对象
		Set<Entry> set2 = map.entrySet();
		for (Entry me : set2) {
			String key = me.getKey().toString();
			String value = me.getValue().toString();
			System.out.println(key + "--" + value);
		}
	}
}
