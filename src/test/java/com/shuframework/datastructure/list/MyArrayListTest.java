package com.shuframework.datastructure.list;

import com.shuframework.jdkutil.lang.StringUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

	MyArrayList<String> strList = null;
	Object[] strArr = null;

	@Before
	public void init() {
		strList = new MyArrayList<>(3);
		strList.add("a1");
		strList.add("a2");
		strList.add("a3");
		System.out.println(StringUtil.append("size:", strList.size(), ", length:", strList.length()));
//		System.out.println("size：" + strList.size() + ", length：" + strList.length());
		System.out.println("初始化:" + strList.toString());
	}

	@After
	public void end() {
		System.out.println("size：" + strList.size() + ", length：" + strList.length());
		System.out.println("操作后:" + strList.toString());
	}

	@Test
	public void add_test() {
		strList.add("b1");
//		int index = 1;
//		strList.add(index, "b1");
		System.out.println("add:"+ strList);
	}
	
	@Test
	public void remove_test() {
		int index = 0;
		strList.remove(index);
		strList.remove(index);
		strList.remove(index);
		System.out.println("removeKey:"+ strList);
	}
	
//	@Test
//	public void test2() {
//		int index = 2;
//		int srcPos = index + 1;
//		System.arraycopy(strArr, srcPos, strArr, index, (strArr.length - srcPos) );
//		System.out.println("s2:"+Arrays.toString(strArr));
//	}

}
