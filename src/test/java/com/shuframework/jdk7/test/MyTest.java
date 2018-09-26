package com.shuframework.jdk7.test;

import com.shuframework.jdk7.json.MyJSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

	@Test
	public void test5() {
		String[] arr1 = {"1","2","","",""};
		String[] arr2 = {"11","12","","",""};
		String[] arr3 = {"21","22","","",""};

		List<String[]> list = new ArrayList<>();
		list.add(arr1);
		list.add(arr2);
		list.add(arr3);
		System.out.println(MyJSON.collection2json(list));


		for (int i = 0; i < list.size(); i++) {
			String[] newArr = new String[2];
			System.arraycopy(list.get(i),0,newArr,0, 2);
			list.set(i, newArr);
		}
		System.out.println(MyJSON.collection2json(list));
//		List<String[]> newList = new ArrayList<>();
//		for(String[] strArr : list){
//			String[] newArr = new String[2];
//			System.arraycopy(strArr,0,newArr,0, 2);
//			newList.add(newArr);
//		}
//		System.out.println(MyJSON.collection2json(newList));
	}

	@Test
	public void test3() {
		List<Long> idList = new ArrayList<>();
		idList.add(1L);
		idList.add(180L);
		idList.add(380L);
		idList.add(1380L);
		System.out.println(idList);

		idList.remove(1380L);
		System.out.println(idList);
	}

	@Test
	public void test() {
		StringBuffer sb1 = new StringBuffer("1");
		StringBuffer sb2 = new StringBuffer("2");
		test2(sb1, sb2);
		System.out.println(sb1);
		System.out.println(sb2);
	}

	@Test
	public void test2() {
		String str = "";
		System.out.println(str.isEmpty());
		System.out.println(str == "");
	}

	
	void test2(StringBuffer sb1, StringBuffer sb2){
		sb2 = sb1;
		sb1 = new StringBuffer("11");
	}
}
