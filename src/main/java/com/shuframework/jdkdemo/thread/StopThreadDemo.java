package com.shuframework.jdkdemo.thread;

import com.shuframework.jdkdemo.thread.biz.MyThread2Stop;
import org.junit.Before;
import org.junit.Test;

/**
 *	中止线程的几种方法
 *		stop不推荐用了，且有原子操作隐患，用interrupt或者自定义一个
 *
 */
public class StopThreadDemo {

	MyThread2Stop thread2Stop = null;

	@Before
	public void init() {
		thread2Stop = new MyThread2Stop();
		Thread td = new Thread(thread2Stop);
		td.start();
		for (int i = 0; i < 5; i++) {
			new Thread(thread2Stop).start();
		}
	}


	@Test
	public void stop_1() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//不会特别及时的像 break那样直接停止，在run里面进行了状态判断就能解决
		thread2Stop.interrupt();
	}

	@Test
	public void stop_2() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//这种效果比较好
		thread2Stop.mystop();
	}



}
