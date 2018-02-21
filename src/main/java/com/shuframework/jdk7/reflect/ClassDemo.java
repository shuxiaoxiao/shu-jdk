package com.shuframework.jdk7.reflect;

import org.junit.Test;

/**
 * 反射示例
 * @author shu
 *
 */
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

}
