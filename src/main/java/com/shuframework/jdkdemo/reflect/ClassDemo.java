package com.shuframework.jdkdemo.reflect;

import org.junit.Test;

/**
 * 反射示例
 * @author shu
 *
 */
@SuppressWarnings("rawtypes")
public class ClassDemo {
	
	@Test
	public void init_class() throws ReflectiveOperationException {
		String s1 = "a";
		Class cls1 = s1.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		//字节码只有一份
		System.out.println(cls1 == cls2);//true
		System.out.println(cls2 == cls3);//true
//		cls1.isXXX 类型判断
	}

	//getCanonicalName和getName这两个方法没有什么不同的， 但是对于array或内部类等就显示出来了。
	@Test
	public void get() {
		Class clazz = String.class;
		System.out.println(clazz.getName());//java.lang.String
		System.out.println(clazz.getCanonicalName());//java.lang.String

		Class clazz2 = String[].class;
		System.out.println(clazz2.getName());//[Ljava.lang.String;
		System.out.println(clazz2.getCanonicalName());//java.lang.String[]
	}

}
