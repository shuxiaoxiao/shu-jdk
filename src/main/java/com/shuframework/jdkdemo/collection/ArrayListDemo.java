package com.shuframework.jdkdemo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * List集合的特点：有序(存储顺序和取出顺序一致), 可重复。
 * 
 * List集合的特有功能：
 * 	A:添加功能
 * 		void add(int index,Object element):在指定位置添加元素
 * 	B:获取功能
 * 		Object get(int index):获取指定位置的元素
 * 	C:列表迭代器
 * 		ListIterator listIterator()：List集合特有的迭代器
 * 	D:删除功能
 * 		Object removeKey(int index)：根据索引删除元素,返回被删除的元素
 * 	E:修改功能
 * 		Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
 * 
 * @author shu
 *
 */
public class ArrayListDemo {

	List<String> strList = null;
	List<String> strList2 = null;
	
	@Before
	public void add() {
		strList = new ArrayList<>(5);
		strList.add("aa");
//		strList.add(2, "ab");//越界, size没到, 5表示的是初始长度
		strList.add("ab");
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
	
	// boolean removeKey(Object o):移除一个元素
	//底层是o.equals(elementData[index]) 注意如果移除对象时, 需要重写equals方法
	@Test
	public void remove() {
		System.out.println("移除前：" + strList);//[aa, ab, bb]
		strList.remove("aa");
		System.out.println("移除后：" + strList);//[ab, bb]
	}
	
	//boolean removeAll(Collection c):移除一个集合的元素 (与第一个集合有相同的就会被移除,第二集合不变。成功一个就返回true)
	@Test
	public void removeAll() {
		System.out.println("移除前strList：" + strList);//[aa, ab, bb]
		System.out.println("移除前strList2：" + strList2);//[aa, cc, ca, cb]
		boolean removeAll = strList.removeAll(strList2);
		System.out.println(removeAll);//true
		
		System.out.println("移除后strList：" + strList);//[ab, bb]
		System.out.println("移除后strList2：" + strList2);//[aa, cc, ca, cb]
	}
	
	// boolean contains(Object o)：判断集合中是否包含指定的元素
	//底层是o.equals(elementData[index]) 注意如果移除对象时, 需要重写equals方法
	@Test
	public void contains() {
		System.out.println(strList);//[aa, ab, bb]
		boolean contains = strList.contains("aa");
		System.out.println(contains);//true
	}
	
	//boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素 (只有包含所有的元素，才叫包含)
	//底层依赖contains方法, 所以是对象需要重写equals方法
	@Test
	public void containsAll() {
		System.out.println("strList：" + strList);//[aa, ab, bb]
		System.out.println("strList2：" + strList2);//[aa, cc, ca, cb]
		boolean contains = strList.containsAll(strList2);
		System.out.println(contains);//false
	}
	
	//boolean retainAll(Collection c):两个集合都有的元素
	//假设有两个集合A，B。A对B做交集，最终的结果保存在A中，B不变。
	//返回值表示的是A是否发生过改变。
	@Test
	public void retainAll() {
		System.out.println("strList：" + strList);//[aa, ab, bb]
		System.out.println("strList2：" + strList2);//[aa, cc, ca, cb]
		boolean retains = strList.retainAll(strList2);
		System.out.println(retains);//true
		
		System.out.println("移除后strList：" + strList);//[ab]
		System.out.println("移除后strList2：" + strList2);//[aa, cc, ca, cb]
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
			StringBuilder sb = new StringBuilder();
			sb.append('[');
			while (true) {
				//获取到元素, 判断是否是最后, 是则拼接"]", 不是则拼接", "
				sb.append(it.next());
				if(!it.hasNext()){
					sb.append(']');
					break;
				}
				sb.append(", ");
			}
			System.out.println(sb.toString());
		}
	}
	
	/** 集合有get() */
	@Test
	public void myToString2() {
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
