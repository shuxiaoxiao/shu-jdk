package com.shuframework.jdkdemo.collection;

import java.util.TreeSet;

import org.junit.Test;

/**
 * TreeSet：能够对元素按照某种规则进行排序。
 * 排序有两种方式
 * A:自然排序
 * B:比较器排序   如果是对象一般是这个, 需要重写compareTo
 * 
 * TreeSet集合的特点：排序和唯一
 * 	存储顺序和取出顺序不一致, 但是其实在add 时会做排序, 所以存储顺序有取出顺序其实一样
 * 
 * 通过观察TreeSet的add()方法，我们知道最终要看TreeMap的put()方法。
 */
public class TreeSetDemo {

	TreeSet<String> treeSet = null;
	
	@Test
	public void add() {
		//自然排序
		treeSet = new TreeSet<String>();
		treeSet.add("aa");
		treeSet.add("b");
		treeSet.add("ab");
		treeSet.add("bc");
		treeSet.add("ba");
		System.out.println(treeSet);
	}
	
}
