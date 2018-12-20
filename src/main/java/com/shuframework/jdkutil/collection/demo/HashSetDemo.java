package com.shuframework.jdkutil.collection.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * Set集合的特点：无序(存储顺序和取出顺序不一致), 唯一
 * 对象需要重写equals和hashCode 方法 (自动生成即可)
 * 
 * @author shu
 *
 */
public class HashSetDemo {

	Set<String> strSet = null;
	
	/**
	 * 	先看hashCode()值是否相同
	 * 		相同:继续走equals()方法
	 * 			返回true：	说明元素重复，就不添加
	 * 			返回false：	说明元素不重复，就添加到集合
	 * 		不同：就直接把元素添加到集合
	 */
	@Before
	public void add() {
		strSet = new HashSet<String>();
		strSet.add("a1");
		strSet.add("a3");
		strSet.add("c2");
		strSet.add("a2");
		strSet.add("b5");
		System.out.println(strSet);
	}
	
	@Test
	public void show() {
//		set的遍历有2种, 少了get, 因为get是List的专属
		Iterator<String> it = strSet.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("-----------");
		for (String str : strSet) {
			System.out.println(str);
		}
	}
	
}
