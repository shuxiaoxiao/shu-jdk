package com.shuframework.datastructure.stack;

import java.util.LinkedList;

/**
 * 通过LinkedList
 * 
 * @author shu
 *
 */
public class MyStackByLinkedList<T> {
	private LinkedList<T> link;

	public MyStackByLinkedList() {
		link = new LinkedList<>();
	}
	
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t) {
		link.addFirst(t);
	}

	/**
	 * 获得第一个
	 * @return
	 */
	public T peek() {
		 return link.getFirst();
	}
	
	/**
	 * 取出
	 * @return
	 */
	public T poll() {
		return link.removeFirst();
	}
	
	public int size() {
		return link.size();
	}

	/**
	 * 判断是否空
	 * @return
	 */
	public boolean isEmpty() {
		return link.isEmpty();
	}
	
	/**
	 * 判断是否空
	 * @return
	 */
	public boolean isNotEmpty() {
		return !isEmpty();
	}

	@Override
	public String toString() {
		return link.toString();
	}
	
}
