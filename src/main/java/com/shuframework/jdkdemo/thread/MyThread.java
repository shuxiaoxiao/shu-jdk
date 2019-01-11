package com.shuframework.jdkdemo.thread;

/**
 * 该类要重写run()方法,为什么呢?
 * 不是类中的所有代码都需要被线程执行的。
 * 而这个时候，为了区分哪些代码能够被线程执行，java提供了Thread类中的run()用来包含那些被线程执行的代码。
 * 
 * Thread.currentThread().getName()  //返回当前正在执行的线程对象 与this对象有区别
 *
 * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
 * 当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。 
 * 
 */
public class MyThread extends Thread {
	//第一种方法是 MyThread implements Runnable
	//第二种方法是 MyThread extends Thread


	public MyThread() {
//		currentThread:main
//		this:Thread-0
//		currentThread:Thread-0
//		this:Thread-0
		//run里面的 currentThread有点区别
//		System.out.println("currentThread:"+Thread.currentThread().getName());
//		System.out.println("this:"+this.getName());
	}
	
	public MyThread(String name){
		super(name);
//		System.out.println("currentThread:"+Thread.currentThread().getName());
//		System.out.println("this:"+this.getName());
	}
	
	@Override
	public void run() {
//		System.out.println("currentThread:"+Thread.currentThread().getName());
//		System.out.println("this:"+this.getName());

		// 自己写代码
//		 System.out.println("hello world");
//		int max = 10;
		int max = 200000;
		for (int x = 0; x < max; x++) {
			if(isInterrupted()){
				System.out.println(x+"结束线程");
				break;
			}
			System.out.println(x);
//			//boolean isInterrupted()
//			System.out.println("isInterrupted:"+x+this.isInterrupted());
//			//static boolean interrupted()
//			System.out.println("interrupted:"+x+interrupted());

			//这里进行了sleep会影响 外部执行interrupt的状态结果
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				System.out.println("进入catch");
//			}
		}

	}

}
