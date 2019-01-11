package com.shuframework.jdkdemo.thread.biz;

/**
 * @author shuheng
 */
public class MyThread2Stop extends Thread {

	private volatile boolean stopFlag = false;

	@Override
	public void run() {
		System.out.println("测试开始");
		//第一种：配合 interrupt() 方法
		while (this.isInterrupted()){
			System.out.println("第一种 stop");
		}

		//第二种：这种效果比较好
		while (stopFlag){
			System.out.println("第二种 stop");
		}
		System.out.println("测试结束");
	}

	public void mystop(){
		stopFlag = true;
	}

}
