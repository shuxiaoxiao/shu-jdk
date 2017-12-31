package com.shuframework.datastructure.list;

import java.util.Arrays;

/**
 * 
 * @author shu
 *
 */
public class MyArrayList<E> {
	
	/**数据的默认长度为10*/
	private final static int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	
	/**表示数组的实际长度*/
	private int size;
	/** 扩容次数 */
	int resizeCount;
	
	private Object[] elementData;

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		}else{
			this.elementData = new Object[initialCapacity];
		}
	}
	
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**返回数组长度*/
	public int size() {
		return size;
	}
	
	/**返回数组扩容次数*/
	public int resizeCount() {
		return resizeCount;
	}
	
//	public String toString() {
//		return StringUtil.join(elementData, ",");
//	}
	/**遍历数组，返回格式[x1,x2]*/
	public String toString() {
//		return "MyArrayList [" + Arrays.toString(elementData) + "]";
		return "MyArrayList：" + Arrays.toString(elementData);
	}
	
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

	/**
	 * 添加数据
	 * 	1、检查数组长度是否需要扩容, 是则扩容并复制之前的元素值, 不是则往下
	 * 	2、添加元素, 并size加1
	 * 
	 * @Title: add
	 * @param @param e 值
	 */
	public boolean add(E e) {
		ensureCapacity(size + 1); 
		elementData[size++] = e;
		return true;
	}
	
	/**
	 * 添加数据到指定索引位置
	 * @Title: add
	 * @param @param index 索引位置
	 * @param @param e	值
	 */
	public boolean add(int index, E e) {
		rangeCheck(index);
		ensureCapacity(size + 1);
		arrayCopy(index, elementData, "down");

		elementData[index] = e;
		return true;
	}

	/**
	 * 修改数据
	 * @Title: set
	 * @param @param index	索引位置
	 * @param @param element	值
	 * @param @return    设定文件
	 * @return E    返回类型
	 */
	@SuppressWarnings("unchecked")
	public E set(int index, E e) {
		rangeCheck(index);

		E oldValue = (E) elementData[index];
		elementData[index] = e;
		return oldValue;
	}
	
	/**
	 * 删除元素，返回该索引删除前对应的值
	 * @Title: remove
	 * @param @param index	索引位置
	 * @return E    返回类型
	 */
	//TODO 有问题
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		rangeCheck(index);
		// 在删除前，将值保留
		E oldValue = (E) elementData[index];
		arrayCopy(index, elementData, "up");
		return oldValue;
		// return (E) elementData[index];//直接这样返回存在的问题是，返回的是删除后数组对应的值
	}
	
	/**
	 * 根据索引查询元素
	 * @Title: get
	 * @param @param index 索引位置
	 * @return E    返回类型
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		rangeCheck(index);
		return (E) elementData[index];
	}
	
	/**
	 * 查到元素的索引, 没有返回-1
	 * @param o
	 * @return
	 */
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}
    
    /**
     * 元素是否包含
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
    
    /**
     * 清空
     */
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }
	
	//TODO 二分法查找
	public int binarySearch(E e) {
		return 0;
	}
	
	/**
	 * 检查数组长度是否超过默认值，
	 * 如果超过则改变其长度，原数据保持不变
	 * 新长度是(oldCapacity * 3) / 2 + 1
	 * @Title: ensureCapacity
	 * @param @param minCapacity    有效数据的长度
	 */
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			resizeCount++;//记录扩容次数
			int newCapacity = (oldCapacity * 3) / 2 + 1; //与下面的扩容效果相同
//			int newCapacity = oldCapacity + (oldCapacity / 2) + 1;
			if (newCapacity < minCapacity){
				newCapacity = minCapacity;
			}
			// 复制数组，并扩大其长度
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
	
	/**
	 * 检查index 是否合法
	 * @Title: RangeCheck
	 * @param @param index    设定文件
	 * @return void    返回类型
	 */
	private void rangeCheck(int index) {
		// 不用判断index<0,因为索引从0开始的
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	/**
	 * 调整数组数据及长度(有bug)
	 * @Title: arrayCopy
	 * @param @param index	索引
	 * @param @param arr	数组对象
	 * @param @param state    up表示数组往前移动,down表示数组往后移动
	 * @return void    返回类型
	 */
	public void arrayCopy(int index, Object[] arr, String state) {
		//length表示需要复制数组的长度
//		System.arraycopy(Object src,  int  srcPos,
//                Object dest, int destPos,
//                int length);
		if ("up".equals(state)) {
			// 前移, 最后一位前移时下标是size-2
			for (int i = index; i < size; i++) {
				if(i == size - 1){
//					arr[i] = null;
					size--;
				}else{
					arr[i] = arr[i + 1];
				}
			}
			
		} else if ("down".equals(state)) {
			// 后移
			for (int i = size; i > index; i--) {
				arr[i] = arr[i - 1];
			}
			size++;
		}
	}
	
}
