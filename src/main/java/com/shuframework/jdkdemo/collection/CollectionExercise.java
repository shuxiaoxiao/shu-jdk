package com.shuframework.jdkdemo.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.shuframework.jdkutil.random.RandomUtil;
import com.shuframework.testmodel.BookInfo2;

/**
 * 集合的练习
 * @author shu
 *	1: 产生10个1-20之间的随机数，要求随机数不能重复 [数据去重]
 *	2: 比对2个string集合，列出新增，修改，删除的部分
 *	3: 获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
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

	/**
	 * list比较 【推荐】
	 */
	@Test
	public void compare_list() {
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
		System.out.println("saveList：" + saveList);		//[4, 5]
		System.out.println("updateList：" + updateList);	//[1, 2]
		System.out.println("deleteList：" + deleteList);	//[3]
	}
	
	/**
	 * list比较(第二种方法)【了解】
	 */
	@Test
	public void compare_list2() {
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
		
		//浅度copy 底层是set方法, 如果是添加对象则修改其属性还是会变的
////		List<String> tempList = new ArrayList<>(oldList.size());//这个只是设置length 不是size
//		List<String> tempList = new ArrayList<>(Arrays.asList(new String[oldList.size()]));
//		Collections.copy(tempList, oldList);
		//浅度copy 底层是add方法
		List<String> tempList = new ArrayList<>();
		tempList.addAll(oldList);
		
		/*
		 * 老的集合如果包含, 说明是原有的, 则表示修改部分
		 * 如果不包含, 说明是新增的
		 * 老的集合还剩下的就是需要删除的
		 */
		oldList.retainAll(newList);//取交集
		newList.removeAll(oldList);
		tempList.removeAll(oldList);
		System.out.println("saveList：" + newList);
		System.out.println("updateList：" + oldList);
		System.out.println("deleteList：" + tempList);
		
		//帮助理解版
//		oldList.retainAll(newList);//取交集
//		List<String> updateList = oldList;
//		
//		newList.removeAll(oldList);
//		List<String> saveList = newList;
//		System.out.println("oldList：" + oldList);
//		System.out.println("newList：" + newList);
//		System.out.println("tempList：" + tempList);
//		
//		tempList.removeAll(oldList);
//		List<String> deleteList = tempList;
//		
//		System.out.println("=========");
//		System.out.println("saveList：" + saveList);
//		System.out.println("updateList：" + updateList);
//		System.out.println("deleteList：" + deleteList);
	}
	
	
	/**
	 * list比较(第二种方法)【了解】
	 */
	@Test
	public void compare_list_obj2() {
		//BookInfo对象没有重写equals()和hashCode()
//		BookInfo book1 = new BookInfo(1, "a1");
		BookInfo2 b1 = new BookInfo2(1, "a1");
		BookInfo2 b2 = new BookInfo2(2, "a2");
		BookInfo2 b3 = new BookInfo2(3, "a3");
		BookInfo2 b11 = new BookInfo2(11, "b1");
		BookInfo2 b12 = new BookInfo2(12, "b2");
//		BookInfo2 b13 = new BookInfo2(13L, "b3");
		
		List<BookInfo2> oldList = null;
		List<BookInfo2> newList = null;
		oldList = new ArrayList<>();
		oldList.add(b1);
		oldList.add(b2);
		oldList.add(b3);
		
		newList = new ArrayList<>();
		newList.add(b1);
		newList.add(b2);
		newList.add(b11);
		newList.add(b12);
		
		//浅度copy 底层是set方法, 如果是添加对象则修改其属性还是会变的
////		List<String> tempList = new ArrayList<>(oldList.size());//这个只是设置length 不是size
//		List<BookInfo2> tempList = new ArrayList<>(Arrays.asList(new BookInfo2[oldList.size()]));
//		Collections.copy(tempList, oldList);
//		oldList.get(2).setName("c1");//改变集合元素的值对tempList有影响
		//浅度copy 底层是add方法
		List<BookInfo2> tempList = new ArrayList<>();
		tempList.addAll(oldList);
//		oldList.set(2, b13);//这个改变对tempList没影响
//		tempList.set(2, b13);//这个改变对oldList没影响
		oldList.get(2).setName("c1");//改变集合元素的值对tempList有影响
//		b3.setName("c1");//改变集合元素的值对tempList有影响
		
		/*
		 * 老的集合如果包含, 说明是原有的, 则表示修改部分
		 * 如果不包含, 说明是新增的
		 * 老的集合还剩下的就是需要删除的
		 */
		oldList.retainAll(newList);
		newList.removeAll(oldList);
		tempList.removeAll(oldList);
		
		System.out.println("saveList：" + newList);
		System.out.println("updateList：" + oldList);
		System.out.println("deleteList：" + tempList);
	}
	
	/**
	 * 获取字符串中每一个字母出现的次数要求结果:a(5)b(4)c(3)d(2)e(1)
	 */
	//利用str.toCharArray() 获得char数组, 然后遍历char
	@Test
	public void str_each() {
		String str = "edcbadcbacbabaa";	//a(5)b(4)c(3)d(2)e(1)
//		String str = "aababcabcdabcde";	//a(5)b(4)c(3)d(2)e(1)
		char[] charArray = str.toCharArray();
		//用HashMap 接收可能存在遍历时顺序的问题, 推荐用TreeMap
		Map<Character, Integer> map = new TreeMap<>();
//		Map<Character, Integer> map = new HashMap<>();
		for (char c : charArray) {
			Integer counts = map.get(c);
			if (counts == null) {
				map.put(c, 1);
			}else{
				map.put(c, ++counts);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for(Entry<Character, Integer> entry : entrySet){
			sb.append(entry.getKey());
			sb.append('(');
			sb.append(entry.getValue());
			sb.append(')');
		}
		System.out.println(sb.toString());
	}
	
	//利用str.charAt(i); 获得char (了解)
	@Test
	public void str_each_2() {
		String str = "aababcabcdabcde";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, max = str.length(); i < max; i++) {
			char c = str.charAt(i);
			Integer counts = map.get(c);
			if (counts == null) {
				map.put(c, 1);
			}else{
				map.put(c, ++counts);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for(Entry<Character, Integer> entry : entrySet){
			sb.append(entry.getKey());
			sb.append('(');
			sb.append(entry.getValue());
			sb.append(')');
		}
		System.out.println(sb.toString());
	}
	
	
}
