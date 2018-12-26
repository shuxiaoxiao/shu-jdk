package com.shuframework.jdkdemo.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/**
 * LinkedHashSet:底层数据结构由哈希表和链表组成。
 * 哈希表保证元素的唯一性。
 * 链表保证元素有素。(存储和取出是一致)
 * 
 * @author shu
 *
 */
public class LinkedHashSetDemo {

	Set<String> strSet = null;
	LinkedHashSet<String> strLinkedSet = null;
	
	@Test
	public void add() {
		//Set集合的特点：无序(存储顺序和取出顺序不一致), 唯一
		strSet = new HashSet<String>();
		strSet.add("a1");
		strSet.add("a3");
		strSet.add("c2");
		strSet.add("a2");
		strSet.add("b5");
		System.out.println(strSet);
		
		//LinkedHashSet集合的特点：有序(存储顺序和取出顺序不一致), 唯一
		strLinkedSet = new LinkedHashSet<>();
		strLinkedSet.add("a1");
		strLinkedSet.add("a3");
		strLinkedSet.add("c2");
		strLinkedSet.add("a2");
		strLinkedSet.add("b5");
		System.out.println(strLinkedSet);
	}
	
	
}
