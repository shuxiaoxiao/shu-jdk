package com.shuframework.jdk7.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.shuframework.jdk7.random.RandomUtil;

/**
 * 集合的练习
 * @author shu
 *	1:产生10个1-20之间的随机数，要求随机数不能重复 [数据去重]
	2:比对2个string集合，列出新增，修改，删除的部分
 *
 */
public class CollectionExercise {

	/**
	 * 数据去重, list可以存放重复值, 所以在add前需要判断是否已经包含了该元素
	 */
	@Test
	public void distinct_data_list() {
		int count = 0;
		List<Integer> list = new ArrayList<>();
		
		while(count < 10){
			int num = RandomUtil.random(1, 20);
			if (!list.contains(num)) {
				list.add(num);
				count++;
			}
		}
		System.out.println(list);
	}
	
	/**
	 * 数据去重, set不能存放重复的元素可以直接add, 循环次数则根据set的size来判断
	 */
	@Test
	public void distinct_data_set() {
		Set<Integer> set = new HashSet<>();
		
//		int count = set.size();//这样会死循环, 需要在循环体内再赋值
//		while(count < 10){
		while(set.size() < 10){
			int num = RandomUtil.random(1, 20);
			set.add(num);
		}
		System.out.println(set);
	}

	
	@Test
	public void compile_list() {
		List<String> oldList = null;
		List<String> newList = null;
		oldList = new ArrayList<>();
		oldList.add("1");
		oldList.add("2");
		oldList.add("3");
		
		newList = new ArrayList<>();
		newList.add("1");
		newList.add("2");
		newList.add("4");
		newList.add("5");
		
		/*
		 * 老的集合如果包含, 说明是原有的, 则表示修改部分
		 * 如果不包含, 说明是新增的
		 * 老的集合还剩下的就是需要删除的
		 */
		List<String> saveList = new ArrayList<>();
		List<String> updateList = new ArrayList<>();
		//需要注意如果对象集合, contains、remove都依赖equals方法那么需要进行重写
		for(String str : newList){
			if(oldList.contains(str)){
				updateList.add(str);
				oldList.remove(str);
			}else{
				saveList.add(str);
			}
		}
		List<String> deleteList = oldList;
		System.out.println("saveList：" + saveList);
		System.out.println("updateList：" + updateList);
		System.out.println("deleteList：" + deleteList);
	}
	
	
}

