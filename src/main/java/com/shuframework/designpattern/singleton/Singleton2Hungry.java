package com.shuframework.designpattern.singleton;

/**
 * “饿汉式”单例模式: 不管你用的用不上，一开始就建立这个单例对象：比如：有个单例对象
 * @author shu
 *
 */
public class Singleton2Hungry {

	//构造私有
	private Singleton2Hungry(){}
	
	private static Singleton2Hungry instance = new Singleton2Hungry();
	
	/**
	 * 获得实例。
	 * 由于只有一份所以不用担心同步问题
	 * public static synchronized MySingleton getInstance(){} 没必要加 synchronized
	 */
	public static Singleton2Hungry getInstance(){
		return instance;
	}
	
}
