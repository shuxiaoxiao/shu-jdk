package com.shuframework.datastructure.map;

import java.util.Map;
import java.util.Objects;

/**
 * Java map数据类型的底层哈希表, 其实可以当做subclass写在HashMap里面<br>
 * 哈希表的原理其实是数组 + 链表(拉链法可以理解为"链表的数组")
 * 
 * @author shu
 *
 * @param <K>
 * @param <V>
 */
public class MyMapNode<K, V> implements Map.Entry<K, V> {
	
	final int hash;
	final K key;
	V value;
	MyMapNode<K, V> next;

	MyMapNode(int hash, K key, V value, MyMapNode<K, V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public final K getKey() {
		return key;
	}

	public final V getValue() {
		return value;
	}

	public MyMapNode<K, V> getNext() {
		return next;
	}

	public void setNext(MyMapNode<K, V> next) {
		this.next = next;
	}

	public final String toString() {
		return key + "=" + value + "next:" + next;
	}

	public final int hashCode() {
		return Objects.hashCode(key) ^ Objects.hashCode(value);
	}

	public final V setValue(V newValue) {
		V oldValue = value;
		value = newValue;
		return oldValue;
	}

	public final boolean equals(Object o) {
		if (o == this)
			return true;
		if (o instanceof Map.Entry) {
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue()))
				return true;
		}
		return false;
	}
}