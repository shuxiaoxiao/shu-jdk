package com.shuframework.jdkdemo.thread;

import com.shuframework.jdkdemo.thread.biz.MyThreadByExtend;
import com.shuframework.jdkdemo.thread.biz.MyThreadByInterface;
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
public class InitThreadDemo {

	/**
	 * 1)继承Thread类   2)实现Runnable接口
	 */
	@Test
	public void init_Thread_1() {
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
	public void start1() {
		 //创建线程对象
		MyThreadByExtend my = new MyThreadByExtend();
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
	public void start_MyThread1() {
		MyThreadByExtend my = new MyThreadByExtend();
		Thread td = new Thread(my);
//		Thread td = new Thread(my, "1");
		td.start();
	}

	@Test
	public void start_MyThread2() {
		MyThreadByInterface my = new MyThreadByInterface();
		Thread td = new Thread(my);
//		Thread td = new Thread(my, "1");
		td.start();
	}


/////////////////////////////////////////////
	MyThread my1 = null;
	MyThread my2 = null;
	MyThread my3 = null;

	@Before
	public void init_MyThread_ToMarks() {
		my1 = new MyThread("1刘备");
		my2 = new MyThread("2关羽");
		my3 = new MyThread("3张飞");

		//设置线程名, 默认是Thread-0
//		my1.setName("1刘备");
//		my2.setName("2关羽");
//		my3.setName("3张飞");
	}

	@Test
	public void priority() {
		//线程优先级高仅仅表示线程获取的 CPU时间片的几率高，但是要在次数比较多，或者多次运行的时候才能看到比较好的效果。
		//默认是5范围是1-10。
//		my2.setPriority(10); //一般不更改该值

		my1.start();
		my2.start();

//		Thread td1 = new Thread(my1);
//		Thread td2 = new Thread(my2);
//		my1.start();
//		my2.start();
	}

	//休眠线程
	@Test
	public void init_MyThread_Sleep() throws InterruptedException {
		my1.start();
		//睡眠1s 后 my2 才启动
		Thread.sleep(1000);
		my2.start();
	}

	//加入线程
	//public final void join():等待该线程终止。
	@Test
	public void init_MyThread_Join() throws InterruptedException {
		my1.start();

		//my1 结束后 my2、my3 才能开始执行
		my1.join();
		my2.start();
		my3.start();
	}

	//礼让线程
	//public static void yield():暂停当前正在执行的线程对象，并执行其他线程。
	//让多个线程的执行更和谐，但是不能靠它保证一人一次。
	@Test
	public void init_MyThread_Yield() throws InterruptedException {
		my1.start();
		//需要放在具体执行的方法内, 但是效果其实不明显
//		Thread.yield();
		my2.start();
	}

	//后台线程（守护线程）
	//public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。
	@Test
	public void init_MyThread_Daemon() {
		// 设置收获线程, 需要在start()前调用,
		my1.setDaemon(true);

		my1.start();
		my2.start();

		Thread.currentThread().setName("主公刘备");
		for (int x = 0; x < 5; x++) {
			System.out.println(Thread.currentThread().getName() + ":" + x);
		}
	}

}

