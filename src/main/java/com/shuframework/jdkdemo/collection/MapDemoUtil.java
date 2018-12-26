package com.shuframework.jdkdemo.collection;

import com.shuframework.jdkutil.SystemUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * map的常用操作，map与bean的转换见MyBeanUtil
 *
 * @author shu
 */
public class MapDemoUtil {
	
	/**
	 * 获取map key的最小值<br>
	 * 
	 * @param map
	 */
	public static <K> K getMinKey(Map<K, ?> map) {
		List<K> list = sortKey(map);
		return list.get(0);
	}
//	@SuppressWarnings("unchecked")
//	public static <K> K getMinKey(Map<K, ?> map) {
//		Set<K> keySet = map.keySet();
//		List list = new ArrayList<>(keySet);
//		Collections.sort(list);
//		return list.get(0);
//	}
//	public static String getMinKey(Map map) {
//		Set keySet = map.keySet();
//		Object[] obj = keySet.toArray();
//		Arrays.sort(obj);
//		return obj[0].toString();
//	}

	/**
	 * 获取map key的最大值<br>
	 * Collections.sort(list),不能对进行排序set(通过循环将key放入list，然后排序)
	 * 
	 * @param map
	 */
	public static <K> K getMaxKey(Map<K, ?> map) {
		List<K> list = sortKey(map);
		int maxIndex = list.size() - 1;
		return list.get(maxIndex);
	}
//	@SuppressWarnings("unchecked")
//	public static <K> K getMaxKey(Map<K, ?> map) {
//		Set<K> keySet = map.keySet();
//		List list = new ArrayList<>(keySet);
//		Collections.sort(list);
//		int maxIndex = list.size() - 1;
//		return (K) list.get(maxIndex);
//	}
//	public static String getMaxKey(Map map) {
//		Set set = map.keySet();
//		Object[] obj = set.toArray();
//		Arrays.sort(obj);
//		return obj[obj.length-1].toString();
//	}
	
	/**
	 * 获取map value的最小值<br>
	 * 利用Arrays.sort排序(推荐)
	 * Collections.sort(list),不能对进行排序set(通过循环将key放入list，然后排序)
	 * @param map
	 */
	public static <V> V getMinValue(Map<?, V> map) {
		List<V> list = sortValue(map);
		return list.get(0);
	}
//	@SuppressWarnings("unchecked")
//	public static <V> V getMinValue(Map<?, V> map) {
//		Collection valcoll = map.values();
//		List list = new ArrayList<>(valcoll);
//		Collections.sort(list);
//		return (V) list.get(0);
//	}
//	public static Object getMinValue(Map map) {
//		Collection valcoll = map.values();
//		Object[] obj = valcoll.toArray();
//		Arrays.sort(obj);
//		
//		return obj[0];
//	}
	
	/**
	 * 获取map value的最大值<br>
	 * 利用Arrays.sort排序(推荐)
	 * Collections.sort(list),不能对进行排序set(通过循环将key放入list，然后排序)
	 * @param map
	 */
	public static <V> V getMaxValue(Map<?, V> map) {
		List<V> list = sortValue(map);
		int maxIndex = list.size() - 1;
		return list.get(maxIndex);
	}
//	@SuppressWarnings("unchecked")
//	public static <V> V getMaxValue(Map<?, V> map) {
//		Collection valcoll = map.values();
//		List list = new ArrayList<>(valcoll);
//		Collections.sort(list);
//		int maxIndex = list.size() - 1;
//		return (V) list.get(maxIndex);
//	}
//	public static Object getMaxValue(Map map) {
//		Collection valcoll = map.values();
//		Object[] obj = valcoll.toArray();
//		Arrays.sort(obj);
//		
//		return obj[obj.length-1];
//	}
	
//	/**
//	 * 获取map value的最大值<br>
//	 * 利用Arrays.sort排序(推荐)
//	 * Collections.sort(list),不能对进行排序set(通过循环将key放入list，然后排序)
//	 * @param map
//	 */
//	public static Number getMaxValue2Number(Map map) {
//		Object obj = getMaxValue(map);
//		if (obj != null) {
//            if (obj instanceof Number) {
//                return (Number) obj;
//            }
//		}
//		return null;
//	}
	
	/**
	 * 对key 进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static <K> List<K> sortKey(Map<K, ?> map) {
		List<K> list = sort2List(map.keySet());
		return list;
	}
	
	/**
	 * 对value 进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static <V> List<V> sortValue(Map<?, V> map) {
		List<V> list = sort2List(map.values());
		return list;
	}
	
	/**
	 * Collections.sort(list), 不能对进行排序set
	 * 
	 * @param coll
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> List<T> sort2List(Collection<T> coll) {
		List list = new ArrayList<>(coll);
		Collections.sort(list);
		return list;
	}
	
	
	/**
	 * 通过key 删除某项(map的本身remove与其功能一样)
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static boolean removeKey(Map<String, ?> map, String key) {
		boolean isSuccess = false;
		//map迭代删除
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String mapKey = it.next();
			if (key.equals(mapKey)) {
				//用迭代器去删除
				it.remove();
				isSuccess = true;
			}
		}
//		//错误方式
//		Set<String> keySet = map.keySet();
//		for (String key : keySet) {
//			//java.util.ConcurrentModificationException  at java.util.HashMap$HashIterator
//			if (key.equals("k5")) {
//				map.removeKey(key);
//			}
//		}
		return isSuccess;
	}
	
	/**
	 * 通过val 删除某项
	 * 
	 * @param map
	 * @param val
	 * @return
	 */
	public static boolean removeVal(Map<?, Object> map, Object val) {
		boolean isSuccess = false;
		//map迭代删除 用迭代自身的，用map的remove会出现 并发修改的问题
		Iterator<Object> it = map.values().iterator();
		while(it.hasNext()){
			Object mapVal = it.next();
			if (val.equals(mapVal)) {
				//用迭代器去删除，其原理是 modCount的值修改问题
				it.remove();
				isSuccess = true;
			}
		}
		return isSuccess;
	}
	
	/**
	 * 通过value 获得key, 
	 * 如果未找到对应值, 返回""  
	 * 如果有多个key返回, 用逗号隔开。格式是key1,key2
	 * 
	 * @param map
	 * @param value
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static String getKey(Map map, String value) {
		String returnKey = "";
		//方便理解的map循环
		Set set = map.keySet();
		for(Object key : set) {
			String mapValue = map.get(key).toString();
			if (mapValue.equals(value)) {
				returnKey = returnKey + "," + key;
			}
		}
		//截取多余的逗号，排查没有找到的情况
		if(SystemUtil.isNotEmpty(returnKey)){
			returnKey = returnKey.substring(1);
		}
		
		return returnKey;
	}
	
	//方式1：键找值(这种其实循环了2遍)
	@Deprecated
	public static void show1(Map<?, ?> map) {
		// 键 对象
		Set<?> set = map.keySet();
		for (Object key : set) {
			String value = map.get(key).toString();
			System.out.println(key + "--" + value);
		}
	}
	
	//方式2：键值对对象找键和值
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void show2(Map map) {
		// 键值对 对象
		Set<Entry> set2 = map.entrySet();
		for (Entry me : set2) {
			String key = me.getKey().toString();
			String value = me.getValue().toString();
			System.out.println(key + "--" + value);
		}
	}
	
}
