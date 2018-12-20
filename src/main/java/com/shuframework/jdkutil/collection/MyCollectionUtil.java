package com.shuframework.jdkutil.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类 拓展
 * @author shu
 *
 */
public class MyCollectionUtil {

	/**
	 * List去重
	 * 底层实现是用的set集合的特性
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<T> distinct(List<T> list){
		List<T> returnList = new ArrayList<>(new LinkedHashSet<>(list));
		return returnList;
	}
	
	
	/**
	 * <p>
	 * 老的集合如果包含, 说明是原有的, 则表示修改部分
	 * 如果不包含, 说明是新增的
	 * 老的集合还剩下的就是需要删除的
	 * 返回的key : saveList, updateList, deleteList
	 * <p>
	 * T类的equals方法需要进行重写
	 * 
	 * @param oldList
	 * @param newList
	 * @return
	 */
	public static <T> Map<String, List<T>> compareList(List<T> oldList, List<T> newList){
		List<T> saveList = new ArrayList<>();
		List<T> updateList = new ArrayList<>();
		//需要注意如果对象集合, contains、remove都依赖equals方法那么需要进行重写
		for(T val : newList){
			if(oldList.contains(val)){
				updateList.add(val);
				oldList.remove(val);
			}else{
				saveList.add(val);
			}
		}
		List<T> deleteList = oldList;
		
		Map<String, List<T>> returnMap = new HashMap<>();
		returnMap.put("saveList", saveList);
		returnMap.put("updateList", updateList);
		returnMap.put("deleteList", deleteList);
		return returnMap;
	}
	//第二种实现（了解）
	public static <T> Map<String, List<T>> compareList2(List<T> oldList, List<T> newList){
		List<T> tempList = new ArrayList<>();
		tempList.addAll(oldList);
		oldList.retainAll(newList);//取交集， 改变了oldList，newList没变
		newList.removeAll(oldList);
		tempList.removeAll(oldList);
		
		Map<String, List<T>> returnMap = new HashMap<>();
		returnMap.put("saveList", newList);
		returnMap.put("updateList", oldList);
		returnMap.put("deleteList", tempList);
		return returnMap;
	}
	
	
}
