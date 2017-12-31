package com.shuframework.designpattern.singleton;

/**
 * “懒汉式”单例模式: 真正用到的时候才去建这个单例对象
 * @author shu
 *
 */
public class Singleton2Lazy {

	//构造私有
	private Singleton2Lazy(){}
	
	private static Singleton2Lazy instance = null;
	
	/**
	 * 获得实例
	 * 由于是需要时创建，存在并发问题（线程不安全），所以需要进行同步处理
	 * @return
	 */
	public static synchronized Singleton2Lazy getInstance(){
		if(instance == null){
			instance = new Singleton2Lazy();
		}
		
		return instance;
	}
	
//	public static Singleton2Lazy getInstance4Safe(){
//		//先检查实例是否存在，如果不存在才进入下面的同步块
//		if(instance == null){
//			//同步块，线程安全的创建实例
//			synchronized(Singleton2Lazy.class){
//				//再次检查实例是否存在，如果不存在才真的创建实例
//				if(instance == null){
//					instance = new Singleton2Lazy();
//				}
//			}
//		}
//		return instance;
//	}
	
}
