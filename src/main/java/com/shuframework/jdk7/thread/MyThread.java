package com.shuframework.jdk7.thread;

/**
 * 该类要重写run()方法,为什么呢?
 * 不是类中的所有代码都需要被线程执行的。
 * 而这个时候，为了区分哪些代码能够被线程执行，java提供了Thread类中的run()用来包含那些被线程执行的代码。
 * 
 * Thread.currentThread().getName()  //返回当前正在执行的线程对象
 * 
 * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
 * 当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。 
 * 
 */
public class MyThread extends Thread {

	public MyThread() {
	}
	
	public MyThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		// 自己写代码
		// System.out.println("hello world");
		// 一般来说，被线程执行的代码肯定是比较耗时的。所以我们用循环改进
		StringBuilder sb = null;
		int max = 10;
//		int max = 200;
		for (int x = 0; x < max; x++) {
			//底层的+ 拼接还是会被翻译为StringBuilder, 
			//一个+ 就会被创建一个, 所以像这样还是单独创建减少jvm的翻译
			sb = new StringBuilder();
			sb.append("线程:");
			sb.append(Thread.currentThread().getName());
			sb.append(", 结果：");
			sb.append(x);
			System.out.println(sb);
		}
	}

}
