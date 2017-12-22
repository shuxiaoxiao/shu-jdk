package com.shuframework.datastructure.map;

import java.util.Map;
import java.util.Set;

/**
 * 自己实现的HashMap, 底层只是拉链表, 没加红黑树
 * 
 * @author shu
 *
 */
public class MyHashMap7<K, V> {

	/** 默认size */
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 2^4=16
	/** 最大size */
	static final int MAXIMUM_CAPACITY = 1 << 30;// 2^30
	/** 加载因子, 用来判断是否需要扩容 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/** MyHashMap具体的值 */
	MyMapNode<K, V>[] table;

	Set<Map.Entry<K, V>> entrySet;

	/** MyHashMap具体的大小 */
	int size;
	/** 修改次数 */
	int resizeCount;
	/** 扩容次数 */
	int modCount;
	/** 扩容后的长度 */
	int threshold;
	/** 具体的加载因子, 未赋值就给默认值 */
	float loadFactor;

	/**
	 * Constructs an empty <tt>HashMap</tt> with the specified initial capacity
	 * and load factor.
	 *
	 * @param initialCapacity
	 *            the initial capacity
	 * @param loadFactor
	 *            the load factor
	 * @throws IllegalArgumentException
	 *             if the initial capacity is negative or the load factor is
	 *             nonpositive
	 */
	public MyHashMap7(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		if (loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
		this.loadFactor = loadFactor;
		this.threshold = tableSizeFor(initialCapacity);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the specified initial capacity
	 * and the default load factor (0.75).
	 *
	 * @param initialCapacity
	 *            the initial capacity.
	 * @throws IllegalArgumentException
	 *             if the initial capacity is negative.
	 */
	public MyHashMap7(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
	 * (16) and the default load factor (0.75).
	 */
	public MyHashMap7() {
		this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
	}

	/**
	 * Returns a power of two size for the given target capacity.
	 */
	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	/**
	 * 获得key的hash值
	 * 
	 * @param key
	 * @return
	 */
	static final int hash(Object key) {
		int h = key.hashCode();
		return (key == null) ? 0 : h ^ (h >>> 16);
//		 //方式二(了解)这种产生的值，重复率会很高
//		 int m = DEFAULT_INITIAL_CAPACITY;
//		 int rh = h % m;
//		 return (rh >= 0) ? rh : -rh;
	}

	/**
	 * 获得实际的大小
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 判断是否为空对象
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 根据key 获得value
	 * 
	 * @param key
	 * @return
	 */
	public V get(Object key) {
		MyMapNode<K, V> e = getNode(hash(key), key);
		return e == null ? null : e.value;
	}

	/**
	 * 是否包含key
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		return getNode(hash(key), key) != null;
	}

	/**
	 * 
	 * @param hash
	 * @param key
	 * @return
	 */
	final MyMapNode<K, V> getNode(int hash, Object key) {
		MyMapNode<K, V>[] tab = table;
		MyMapNode<K, V> first, e;
		int n;
		K k;
		if (tab != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
			if (first.hash == hash && // always check first node
					((k = first.key) == key || (key != null && key.equals(k))))
				return first;
			if ((e = first.next) != null) {
				// 此处的红黑树暂时不加
				// if (first instanceof TreeNode)
				// return ((TreeNode<K,V>)first).getTreeNode(hash, key);
				do {
					// 进行hash碰撞，然后比较key值(不建议循环)
					if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
						return e;
				} while ((e = e.next) != null);
			}
		}
		return null;
	}

	/**
	 * 插入, 此时会检查是否需要扩容
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {

		return null;
		// return putValOf7(hash(key), key, value, false, true);
		// return putValOf8(hash(key), key, value, false, true);
	}

	/**
	 * 扩展
	 * 
	 * @return
	 */
	final MyMapNode<K, V>[] resize() {
		resizeCount++; // 记录扩容次数
		MyMapNode<K, V>[] oldTab = table;
		int oldCap = (oldTab == null) ? 0 : oldTab.length;
		int oldThr = threshold;
		int newCap, newThr = 0;
		if (oldCap > 0) {
			if (oldCap >= MAXIMUM_CAPACITY) {
				threshold = Integer.MAX_VALUE;
				return oldTab;
			} else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
				// 新的长度限制 = 老的 * 2
				newThr = oldThr << 1; // double threshold
			}
		} else if (oldThr > 0) // initial capacity was placed in threshold
			newCap = oldThr;
		else { // 都没赋值给上默认值
			newCap = DEFAULT_INITIAL_CAPACITY;
			newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
		}

		if (newThr == 0) {
			float ft = (float) newCap * loadFactor;
			newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
		}
		threshold = newThr;

		// @SuppressWarnings({"rawtypes","unchecked"})
		MyMapNode<K, V>[] newTab = new MyMapNode[newCap];
		// 原来的oldTab， 赋值给newTab

		table = newTab;
		if (oldTab != null) {
			for (int j = 0; j < oldCap; ++j) {
				MyMapNode<K, V> e = oldTab[j];
				if (e != null) {
					oldTab[j] = null;
					if (e.next == null)
						newTab[e.hash & (newCap - 1)] = e;
					else { // preserve order
						MyMapNode<K, V> loHead = null, loTail = null;
						MyMapNode<K, V> hiHead = null, hiTail = null;
						MyMapNode<K, V> next;
						do {
							next = e.next;
							if ((e.hash & oldCap) == 0) {
								if (loTail == null)
									loHead = e;
								else
									loTail.next = e;
								loTail = e;
							} else {
								if (hiTail == null)
									hiHead = e;
								else
									hiTail.next = e;
								hiTail = e;
							}
						} while ((e = next) != null);
						if (loTail != null) {
							loTail.next = null;
							newTab[j] = loHead;
						}
						if (hiTail != null) {
							hiTail.next = null;
							newTab[j + oldCap] = hiHead;
						}
					}
				}
			}
		}
		return newTab;
	}

	// public MyMapNode<K, V>[] getTable() {
	// return table;
	// }

	// public Set<Map.Entry<K,V>> entrySet() {
	// Set<Map.Entry<K,V>> es = entrySet;
	// return es == null ? (entrySet = new EntrySet()) : es;
	// }

	public int getResizeCount() {
		return resizeCount;
	}

	public int getModCount() {
		return modCount;
	}

	public int getThreshold() {
		return threshold;
	}

	public float getLoadFactor() {
		return loadFactor;
	}

}
