package com.shuframework.datastructure.list;

import java.util.Arrays;
import java.util.List;

/**
 * 可变长的集合
 * 	与固定长集合(MyFixedArrayList)的区别在于add时需要判断长度, 超过了需要复制内容且扩容, 其他都是一样
 * 
 * 如果想要用foreach循环则需要implements Iterable<E>的public Iterator<E> iterator()
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
	private int resizeCount;
	
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
	
//	/**返回数组长度*/
//	public int length() {
//		return elementData.length;
//	}
	
	/**返回数组长度*/
	public int size() {
		return size;
	}
	
	/**返回数组扩容次数*/
	public int resizeCount() {
		return resizeCount;
	}
	
	/**遍历数组，返回格式[x1,x2]*/
	public String toString() {
		//初始化的数组
//		return Arrays.toString(elementData);
//		//真正的
		int max = size - 1;
        if (max == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(elementData[i]));
            if (i == max)
                return b.append(']').toString();
            b.append(", ");
        }
	}
	
	/** 转成数组 */
	@Deprecated
	public Object[] getArray() {
        return Arrays.copyOf(elementData, size);
    }
	//java.lang.ClassCastException
//    public E[] getArray() {
//    	return (E[]) Arrays.copyOf(elementData, size);
//    }
    
    /** 
     * 转成数组(推荐)
     * 使用例子：	
     * 	MyArrayList<String> strList = null;
     * 	String[] arr2 = new String[strList.size()];
     * 	fixedArrayList.toArray(arr2);
     * 
     * @param destArr
     */
    public void toArray(E[] destArr) {
//    	Object[] destArr = new Object[size];
//    	System.arraycopy(elementData, 0, destArr, 0, size);
//    	return destArr;
    	System.arraycopy(elementData, 0, destArr, 0, size);
    }
    
    /**
     * 返回的list长度是固定的
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<E> getList() {
    	//elementData是初始化的数组，里面可能存在null
    	return (List<E>) Arrays.asList(elementData);
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
//		rangeCheck(size);
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
		// index前面部分不动，[index+1, size] 的部分后移
		int copyLength = (elementData.length - 1) - index;
		if (copyLength > 0) {
			System.arraycopy(elementData, index, elementData, index + 1, copyLength);
		}

		elementData[index] = e;
		size++; // 长度累加
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
		// index后面部分不动，[index, size] 的部分前移
		int copyLength = (elementData.length - 1) - index;
		if (copyLength > 0) {
			//注意与add有区别
			System.arraycopy(elementData, index + 1, elementData, index, copyLength);
		}
		elementData[size - 1] = null;// 真正的最后一位设置为null
		size--;// 长度累减
		return oldValue;
	}
	
	public E remove() {
		return remove(size - 1);
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
	
	
	/**
	 * 检查数组长度是否超过默认值，
	 * 如果超过则改变其长度，原数据保持不变, 新长度是(oldCapacity * 3) / 2 + 1
	 * 
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
			//这种会数组越界
//			System.arraycopy(elementData, 0, elementData, 0, newCapacity);
		}
	}
	
	/**
	 * 检查index 是否合法
	 * @Title: RangeCheck
	 * @param @param index    设定文件
	 * @return void    返回类型
	 */
	private void rangeCheck(int index) {
		//固定数组这里的size用length, 可变长数组用size也可行
//		int length = elementData.length;
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

}
