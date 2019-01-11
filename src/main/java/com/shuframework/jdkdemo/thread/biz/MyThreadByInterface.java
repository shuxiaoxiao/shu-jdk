package com.shuframework.jdkdemo.thread.biz;

/**
 * @author shuheng
 */
public class MyThreadByInterface implements Runnable {

//    String name;

//    public MyThreadByInterface(String name){
//
//    }

	@Override
	public void run() {
        System.out.println("currentThread:"+Thread.currentThread().getName());
//        System.out.println("this:"+this.getName());//拿不到
		System.out.println("interface: hello world ");
	}

}
