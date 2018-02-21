package com.shuframework.jdk7.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;

import com.shuframework.testmodel.BookInfo;
import com.shuframework.testmodel.SubBookInfo;

/**
 * 反射示例
 * @author shu
 *
 */
public class ReflectDemo {

	@Test
	public void getField() throws ReflectiveOperationException, SecurityException {
		//java.lang.NoSuchFieldException: name , 访问不了private的属性
//		Field field = BookInfo.class.getField("name");
		
		Field field2 = BookInfo.class.getDeclaredField("name");
		System.out.println(field2);
		//java.lang.NoSuchFieldException: title 没有该属性
		Field field3 = BookInfo.class.getDeclaredField("title");
		System.out.println(field3);
	}
	
	@Test
	public void getField_test2() throws ReflectiveOperationException, SecurityException {
//		Field field2 = SubBookInfo.class.getDeclaredField("name");//这个是父类有
		Field field2 = getDeclaredField(SubBookInfo.class, "name");
		System.out.println(field2);
		Field field3 = SubBookInfo.class.getDeclaredField("title");
		System.out.println(field3);
	}
	
	@SuppressWarnings("rawtypes")
	protected Field getDeclaredField(final Class clazz, final String fieldName) {
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
				continue;
			}
		}
		return null;
	}
	
	@Test
	public void getConstructors() throws ReflectiveOperationException, SecurityException {
		// public Constructor[] getConstructors():所有公共构造方法
		Constructor<?>[] list1 = BookInfo.class.getConstructors();
		System.out.println(list1);
		//public Constructor[] getDeclaredConstructors():所有构造方法
		Constructor<?>[] list2 = BookInfo.class.getDeclaredConstructors();
		System.out.println(list2);
	}
	
	@Test
	public void getProperty() throws ReflectiveOperationException, SecurityException {
		Field field = BookInfo.class.getDeclaredField("name");
		System.out.println(field);
	}
	
}
