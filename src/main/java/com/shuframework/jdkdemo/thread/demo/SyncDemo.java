package com.shuframework.jdkdemo.thread.demo;

/**
 * 单个变量 同步问题
 * Created by shu on 2018/9/14.
 */
public class SyncDemo {

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {

            ThreadDemo td = new ThreadDemo();
            new Thread(td).start();

            while(true) {
//                synchronized (td) {
                    if (td.isFlag()) {
                        System.out.println("########");
                        break;
                    }
//                }
            }
//        }
    }
}


class ThreadDemo implements Runnable {
    private volatile boolean flag = false;

    @Override
    public void run() {
        //模拟有处理内容
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag="+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}