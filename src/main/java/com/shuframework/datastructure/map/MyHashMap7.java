package com.shuframework.datastructure.map;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 自己实现的HashMap, 底层只是数组里面放拉链表, 没加红黑树
 * 主要是hash碰撞 和扩容的实现
 * jdk8 多了红黑树，同一index的链表元素有8个以上时会变成红黑树
 *
 * @author shu
 *
 */
public class MyHashMap7<K, V> {

	/**
	 * 实现思路：
	 * 构造方法只是初始化值，没初始化链表 put()时才创建，其他如果获取table时需要判断下
	 */
	/**
	 * put方法的实现思路
	 * 	计算index（根据key的hashCode进行计算）, 如果index相同，key不同则node的next上追加，key相同则覆盖
	 */

	/** 默认size */
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 2^4=16
	/** 最大size */
	static final int MAX_CAPACITY = 1 << 30;// 2^30
	/** 加载因子, 用来判断是否需要扩容 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	/** MyHashMap具体的值 */
	MyMapNode<K, V>[] table;

	Set<Map.Entry<K, V>> entrySet;

	/** MyHashMap具体的大小 */
	int size;
	/** 扩容次数 */
	int resizeCount;
	/** 修改次数 */
	int modCount;
	/** 扩容后的长度 */
	int threshold;
	/** 数组长度 */
	int tableLength;
	/** 具体的加载因子, 未赋值就给默认值 */
	float loadFactor;

	/**
	 *
	 * @param initialCapacity
	 * @param loadFactor
	 * @throws IllegalArgumentException
	 */
	public MyHashMap7(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
		}
		if (initialCapacity > MAX_CAPACITY) {
			initialCapacity = MAX_CAPACITY;
		}
		if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
			throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
		}
		this.loadFactor = loadFactor;
		this.threshold = tableSizeFor(initialCapacity);
	}

	public MyHashMap7(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * Constructs an empty <tt>HashMap</tt> with the default initial capacity
	 * (16) and the default load factor (0.75).
	 */
	public MyHashMap7() {
		this.loadFactor = DEFAULT_LOAD_FACTOR;
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
		return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
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
	 * Returns index for hash code h.
	 */
	static int indexFor(int h, int length) {
		//与算法的规律: a & b 结果不会超过2个数的最小值
		return h & (length-1);
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
	 * 获得实际的大小
	 *
	 * @return
	 */
	public int length() {
		return tableLength;
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
	 * 遍历数组，返回格式{k1:v1, k2:v2}
	 * 建议换成遍历entrySet
	 */
	@Override
	public String toString() {
//		//长度，因为循环的是table里面有null，用size的话循环entrySet（还未赋值）
		int max = tableLength - 1;
		if (max == -1) {
			return "{}";
		}

		StringBuilder b = new StringBuilder();
		b.append('{');
//		MyMapNode<K, V> node = null;
		for (int i = 0; ; i++) {
			MyMapNode<K, V> node = table[i];
			//保证整个有个结束
			if(node != null){
				b.append(String.valueOf(node.key));
				b.append(": ");
				b.append(String.valueOf(node.value));
				b.append(", ");
				//next上有数据时，可能存在哈希碰撞多次用while不是if
				while((node = node.next) != null){
					b.append(String.valueOf(node.key));
					b.append(": ");
					b.append(String.valueOf(node.value));
					b.append(", ");
				}
			}
			//最后一位也是null
			if(i == max){
				//这里有点问题, 多了", "
				b.delete(b.length()-2, b.length());
				return b.append('}').toString();
			}
		}
//		return b.toString();
	}

	/**
	 * 根据key 获得value
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		MyMapNode<K, V> e = getNode(hash(key), key);
		return e == null ? null : e.value;
	}

	/**
	 * 是否包含key
	 * 
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key) {
		return getNode(hash(key), key) != null;
	}

	/**
	 * 获得元素
	 * @param hash
	 * @param key
	 * @return
	 */
	final MyMapNode<K, V> getNode(int hash, K key) {
		MyMapNode<K, V>[] tab = table;
		if(tab == null){
			return null;
		}
		int length = table.length;
		MyMapNode<K, V> first;
		MyMapNode<K, V> e; //next的元素
		K k;
		if (length > 0 && (first = tab[indexFor(hash, length)]) != null) {
			//拿到第一个元素 比较hash值和key
			if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
				return first;
			}
			if ((e = first.next) != null) {
				do {
					// 进行hash碰撞，然后比较key值
					if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
						return e;
					}
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
		 return putValOf7(hash(key), key, value, false, true);
	}

	final V putValOf7(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
		if(table == null){
			table = resize();
		}

		int length = table.length;
		int i = indexFor(hash, length);

		for (MyMapNode<K,V> e = table[i]; e != null; e = e.next) {
			K k;
			//key相同则覆盖
			if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}

		modCount++;
		//添加node，里面有判断是否需要扩容
		addEntry(hash, key, value, i);
		return null;
	}

//	private MyMapNode<K,V> newNode(int hash, K key, V value, MyMapNode<K, V> next) {
//		return new MyMapNode<>(hash, key, value, next);
//	}

	void addEntry(int hash, K key, V value, int bucketIndex) {
		if ((size >= threshold) && (null != table[bucketIndex])) {
			resize();
			hash = (null != key) ? hash(key) : 0;
			bucketIndex = indexFor(hash, table.length);
		}

		createEntry(hash, key, value, bucketIndex);
	}

	void createEntry(int hash, K key, V value, int bucketIndex) {
		MyMapNode<K,V> e = table[bucketIndex];
		table[bucketIndex] = new MyMapNode<>(hash, key, value, e);
		size++;
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
			if (oldCap >= MAX_CAPACITY) {
				threshold = Integer.MAX_VALUE;
				return oldTab;
			} else if ((newCap = oldCap << 1) < MAX_CAPACITY
					&& oldCap >= DEFAULT_INITIAL_CAPACITY) {
				// 新的长度限制 = 老的 * 2
				newThr = oldThr << 1;
			}
		} else if (oldThr > 0) {
			newCap = oldThr;
		}else { // 都没赋值给上默认值
			newCap = DEFAULT_INITIAL_CAPACITY;
			newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
		}

		if (newThr == 0) {
			float ft = (float) newCap * loadFactor;
			newThr = (newCap < MAX_CAPACITY && ft < (float) MAX_CAPACITY ? (int) ft : Integer.MAX_VALUE);
		}
		threshold = newThr;
		tableLength = newCap;

		MyMapNode<K, V>[] newTab = new MyMapNode[newCap];
		table = newTab;
		// 原来的oldTab， 赋值给newTab
		if (oldTab != null) {
			int newCapacity = newTab.length;
			for (MyMapNode<K,V> e : oldTab) {
				while(null != e) {
					MyMapNode<K,V> next = e.next;
					int i = indexFor(e.hash, newCapacity);
					//修改e的完整信息
					e.next = newTab[i];
					//赋值给新的数组元素
					newTab[i] = e;
					e = next;
				}
			}
//			for (int j = 0; j < oldCap; ++j) {
//				MyMapNode<K, V> e = oldTab[j];
//				if (e != null) {
//					oldTab[j] = null;
//					if (e.next == null) {
//						newTab[e.hash & (newCap - 1)] = e;
//					}else {
//						MyMapNode<K, V> loHead = null, loTail = null;
//						MyMapNode<K, V> hiHead = null, hiTail = null;
//						MyMapNode<K, V> next;
//						do {
//							next = e.next;
//							if ((e.hash & oldCap) == 0) {
//								if (loTail == null) {
//									loHead = e;
//								}else{
//									loTail.next = e;
//								}
//								loTail = e;
//							} else {
//								if (hiTail == null) {
//									hiHead = e;
//								}else {
//									hiTail.next = e;
//								}
//								hiTail = e;
//							}
//						} while ((e = next) != null);
//						if (loTail != null) {
//							loTail.next = null;
//							newTab[j] = loHead;
//						}
//						if (hiTail != null) {
//							hiTail.next = null;
//							newTab[j + oldCap] = hiHead;
//						}
//					}
//				}
//			}
		}
		return newTab;
	}

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

	/**
	 * 扩容后的长度
	 * @return
	 */
	public int getThreshold() {
		return threshold;
	}

	public float getLoadFactor() {
		return loadFactor;
	}

}
