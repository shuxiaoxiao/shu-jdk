package com.shuframework.jdk7.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.shuframework.jdk7.io.FileUtil;

/**
 * 对象反射
 * @author shu
 *
 */
@SuppressWarnings("rawtypes")
public class MyBeanUtil {

	/**
	 * 实例化对象
	 * @param clazz
	 * @return
	 * @throws ReflectiveOperationException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<?> clazz) {
		try {
			T obj = (T) clazz.newInstance();
			return obj;
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
//	public static <T> T newInstance(Class<?> clazz) throws ReflectiveOperationException {
//		T obj = (T) clazz.newInstance();
//		return obj;
//	}
	
	/**
	 * 实例化对象
	 * 
	 * @param clazzStr	类名
	 * @return 对象
	 */
	public static <T> T newInstance(String clazzStr) {
		try {
			Class<?> clazz = Class.forName(clazzStr);
			return newInstance(clazz);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获得内省PropertyDescriptor对象
	 * 
	 * @param bean
	 * @param propertyName
	 * @return
	 */
	protected static PropertyDescriptor getPropertyDescriptor(final Class clazz, String propertyName) {
		try {
			PropertyDescriptor pd = new PropertyDescriptor(propertyName, clazz);
			return pd;
		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param clazz
	 * @return
	 */
	protected static PropertyDescriptor[] getPropertyDescriptorList(final Class clazz) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] pdList = beanInfo.getPropertyDescriptors();
			return pdList;
		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取Bean的属性
	 * 
	 * @param bean
	 * @param propertyName	属性名
	 * @return 属性值
	 */
	public static Object getProperty(Object bean, String propertyName){
		PropertyDescriptor pd = getPropertyDescriptor(bean.getClass(), propertyName);
		Method readMethod = pd.getReadMethod();
		if (!readMethod.isAccessible()) {
			readMethod.setAccessible(true);
		}
		try {
			return readMethod.invoke(bean);
		} catch (Exception e) {
			throw new RuntimeException("Could not read property '" + propertyName + "' to bean", e);
		}
	}
	
	/**
	 * 获取Bean的属性（建议不用这个）
	 * 
	 * @param clazz
	 * @param propertyName 	属性名
	 * @return
	 */
	public static Object getProperty(final Class clazz, String propertyName){
//		PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);
//		Method readMethod = pd.getReadMethod();
//		if (!readMethod.isAccessible()) {
//			readMethod.setAccessible(true);
//		}
//		try {
//			return readMethod.invoke(clazz.newInstance());
//		} catch (Exception e) {
//			throw new RuntimeException("Could not read property '" + propertyName + "' to bean", e);
//		}
		try {
			return getProperty(clazz.newInstance(), propertyName);
		} catch (Exception e) {
			throw new RuntimeException("Could not read property '" + propertyName + "' to bean", e);
		}
	}
	
	/**
	 * 获取Bean的属性(过时的方法)
	 * 
	 * @param bean
	 * @param propertyName	属性名
	 * @return 属性值
	 */
	@Deprecated
	public static Object getPropertyByField(Object bean, String propertyName){
		Field field = getDeclaredField(bean.getClass(), propertyName);
		if (field == null){
			throw new IllegalArgumentException("Could not find field [" + propertyName + "] on target [" + bean + "]");
		}
		try {
			return field.get(bean);
		} catch (Exception e) {
			throw new RuntimeException("Could not read property '" + propertyName + "' to bean", e);
		}
	}
	
	/**
	 * 设置Bean属性
	 * 
	 * @param bean
	 * @param propertyName	属性名
	 * @param value		属性值
	 */
	public static void setProperty(Object bean, String propertyName, Object value) {
		PropertyDescriptor pd = getPropertyDescriptor(bean.getClass(), propertyName);
		Method writeMethod = pd.getWriteMethod();
		if (!writeMethod.isAccessible()) {
			writeMethod.setAccessible(true);
		}
		try {
			writeMethod.invoke(bean, value);
		} catch (Exception e) {
			throw new RuntimeException("Could not set property '" + propertyName + "' to bean", e);
		}
	}
	
	/**
	 * 设置Bean属性（建议不用这个）
	 * 
	 * @param bean
	 * @param propertyName	属性名
	 * @param value		属性值
	 */
	public static void setProperty(final Class clazz, String propertyName, Object value) {
//		PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);
//		Method writeMethod = pd.getWriteMethod();
//		if (!writeMethod.isAccessible()) {
//			writeMethod.setAccessible(true);
//		}
//		try {
//			writeMethod.invoke(clazz.newInstance(), value);
//		} catch (Exception e) {
//			throw new RuntimeException("Could not set property '" + propertyName + "' to bean", e);
//		}
		try {
			setProperty(clazz.newInstance(), propertyName, value);
		} catch (Exception e) {
			throw new RuntimeException("Could not set property '" + propertyName + "' to bean", e);
		}
	}
	
	/**
	 * 设置Bean属性
	 * 
	 * @param bean
	 * @param propertyName	属性名
	 * @param value		属性值
	 */
	@Deprecated
	public static void setPropertyByField(Object bean, String propertyName, Object value) {
		Field field = getDeclaredField(bean.getClass(), propertyName);
		if (field == null){
			throw new IllegalArgumentException("Could not find field [" + propertyName + "] on target [" + bean + "]");
		}
		try {
			field.set(bean, value);
		} catch (Exception e) {
			throw new RuntimeException("Could not set property '" + propertyName + "' to bean", e);
		}
	}
	
	/**
	 * 获得申明的字段, 如果有继承关系, 子类拿不到会去父类获取
	 * 
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	public static Field getDeclaredField(final Class clazz, final String fieldName) {
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Field field = superClass.getDeclaredField(fieldName);
				if(!field.isAccessible()){
					field.setAccessible(true);
				}
				return field;
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
				continue;
			}
		}
		return null;
	}
	
	/**
	 * 拷贝对象
	 * 
	 * @param src	源对象
	 * @param dist	需要赋值的对象
	 */
	public static void copy(Object src, Object dist) {
		//TODO copy
		
	}
	
	/**
	 * 深度复制
	 * @param src
	 * @param dist
	 */
	public static void deepCopy(Object src, Object dist) {
		try {
			dist = FileUtil.deepCopy(src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 对象转为map
	 * 
	 * @param bean
	 * @return
	 */
	public static Map<String, Object> beanToMap(Object bean) {
		Map<String, Object> map = new HashMap<>();
		PropertyDescriptor[] pdList = getPropertyDescriptorList(bean.getClass());
		try {
			for (PropertyDescriptor property : pdList) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method readMethod = property.getReadMethod();
					Object value = readMethod.invoke(bean);
//					if (!readMethod.isAccessible()) {
//						readMethod.setAccessible(true);
//					}
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return map;
	}
	
	/**
	 * map转为bean
	 * 
	 * @param map
	 * @param bean
	 */
	public static void mapToBean(Map<String, Object> map, Object bean) {
		PropertyDescriptor[] pdList = getPropertyDescriptorList(bean.getClass());
		try {
			for (PropertyDescriptor property : pdList) {
				String key = property.getName();
				Object value = map.get(key);
				// 跳过空值或者不存在的key
				if (value == null) {
					continue;
				}
				Method writeMethod = property.getWriteMethod();
//				if (!writeMethod.isAccessible()) {
//					writeMethod.setAccessible(true);
//				}
				//类型转换未处理
				writeMethod.invoke(bean, value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
