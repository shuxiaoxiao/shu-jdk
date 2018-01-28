package com.shuframework.jdk7.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ArrayListDemo {

	List<String> strList = null;
	List<String> strList2 = null;
	
	@Before
	public void add() {
		strList = new ArrayList<>(5);
		strList.add("aa");
		strList.add(2, "ab");//越界, size没到, 5表示的是初始长度
		strList.add("bb");
		
		strList2 = new ArrayList<>();
		strList2.add("aa");
		strList2.add("cc");
		strList2.add("ca");
		strList2.add("cb");
	}
	
	// boolean addAll(Collection c):添加一个集合的元素
	@Test
	public void addAll() {
		strList.addAll(strList2);
		System.out.println(strList);//[aa, ab, bb, cc, ca, cb]
	}
	
	//void clear():移除所有元素
	@Test
	public void clear() {
		System.out.println("移除前：" + strList);
		strList.clear();
		System.out.println("移除后：" + strList);//[]
	}
	
	// boolean remove(Object o):移除一个元素
	//底层是o.equals(elementData[index]) 注意如果移除对象时, 需要重写equals方法
	@Test
	public void remove() {
		System.out.println("移除前：" + strList);//[aa, ab, bb]
		strList.remove("aa");
		System.out.println("移除后：" + strList);//[ab, bb]
	}
	
	//boolean removeAll(Collection c):移除一个集合的元素
	@Test
	public void removeAll() {
		System.out.println("移除前：" + strList);//[aa, ab, bb]
		strList.removeAll(strList2);
		System.out.println("移除后：" + strList);//[ab, bb]
	}
	
	// boolean contains(Object o)：判断集合中是否包含指定的元素
	//底层是o.equals(elementData[index]) 注意如果移除对象时, 需要重写equals方法
	@Test
	public void contains() {
		System.out.println("移除前：" + strList);//[aa, ab, bb]
		boolean contains = strList.contains("aa");
		System.out.println(contains);//true
	}
	
	//boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素
	//只有包含所有的元素，才叫包含
	@Test
	public void containsAll() {
		System.out.println("移除前：" + strList);//[aa, ab, bb]
		boolean contains = strList.containsAll(strList2);
		System.out.println(contains);//false
	}
	
	@Test
	public void show() {
//		list的遍历有3种
		Iterator<String> it = strList.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}

		System.out.println("-----------");
		for (int x = 0; x < strList.size(); x++) {
			String s = strList.get(x);
			System.out.println(s);
		}
		
		System.out.println("-----------");
		for (String str : strList) {
			System.out.println(str);
		}
	}
	
	/**
	 * foreach不好判断, 只有2种比较好实现
	 * 原理是获取到元素先拼接, 然后判断是否是最后, 是则拼接"]", 不是则拼接", "
	 */
	@Test
	public void myToString() {
		Iterator<String> it = strList.iterator();
		if (it == null || !it.hasNext()) {
			System.out.println("[]");
		}else{
			StringBuilder sb1 = new StringBuilder();
			sb1.append('[');
			while (true) {
				//获取到元素, 判断是否是最后, 是则拼接"]", 不是则拼接", "
				sb1.append(it.next());
				if(!it.hasNext()){
					sb1.append(']');
					break;
				}
				sb1.append(", ");
			}
			System.out.println(sb1.toString());
		}
		
		System.out.println("-----------");
		int max = strList.size();
		if (max == 0) {
			System.out.println("[]");
		}else{
			StringBuilder sb2 = new StringBuilder();
			sb2.append('[');
			for (int x = 0; x < max; x++) {
				sb2.append(strList.get(x));
				if (x == max -1) {
					sb2.append(']');
					break;
				}
				sb2.append(", ");
			}
			System.out.println(sb2.toString());
		}
	}
	
	
}
