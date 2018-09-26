package com.shuframework.jdk7.thread;

import org.junit.Before;
import org.junit.Test;

/**
 *	进程：
 *		正在运行的程序，是系统进行资源分配和调用的独立单位。每一个进程都有它自己的内存空间和系统资源。
 *	线程：
 *		是进程中的单个顺序控制流，是一条执行路径。
 *		一个进程如果只有一条执行路径，则称为单线程程序。一个进程如果有多条执行路径，则称为多线程程序。
 * 
 * Java程序的运行原理：
 * 		由java命令启动JVM，JVM启动就相当于启动了一个进程。
 * 		接着有该进程创建了一个主线程去调用main方法。
 * 
 */
public class ThreadDemo {

	@Test
	public void init_Thread_1() {
		//这个里面都是空实现, 一般有如下2种方法
		//1)继承Thread类   2)实现Runnable接口
		Thread my = new Thread();
//		my.run();
		my.start();//空，Thread是内置对象，没有具体输出
	}
	
	/**
	 * 面试题：run()和start()的区别?
		run():仅仅是封装被线程执行的代码，直接调用是普通方法（相当于是单线程效果）
		start():首先启动了线程，然后再由jvm去调用该线程的run()方法。
	 */
	@Test
	public void start_MyThread() {
		 //创建线程对象
		 MyThread my = new MyThread();
		 // 启动线程
		 //线程:main
		 my.run();
		 my.run();//这个可以调用2次(因为是直接调用是普通方法)
		 
		 //线程:Thread-0
		 my.start();
		 // IllegalThreadStateException:非法的线程状态异常
		 // 因为这个相当于是my线程被调用了两次。而不是两个线程启动。
		 //my.start();
	}

	@Test
	public void start_MyThread2() {
		MyThread my = new MyThread();
		my.start();
		//
		//与上面的执行结果相同
//		Thread td = new Thread(my);
//		td.start();
	}

	/**
	 * 停止线程
	 * 不推荐用stop（已过时）
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void stop_MyThread() throws InterruptedException {
		MyThread my = new MyThread();
		my.start();
		//这里效果不明显， 在run里面也进行了睡眠处理
		Thread.sleep(1);
		//不会特别及时的像 break那样直接停止，在run里面进行了状态判断就能解决
		my.interrupt();
		System.out.println("end");
	}

}
