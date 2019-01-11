package com.shuframework.jdkdemo.thread.biz;

/**
 * @author shuheng
 */
public class MyThreadByExtend extends Thread {

    public MyThreadByExtend(){

    }
    public MyThreadByExtend(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("currentThread:"+Thread.currentThread().getName());
		System.out.println("this:"+this.getName());
        System.out.println("hello world");
    }

}
