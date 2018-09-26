package com.shuframework.jdk7.thread.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程 售票
 * Created by shu on 2018/9/14.
 */
public class TestLock{
    public static void main(String[] args){
        Ticket ticket = new Ticket();

        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();

    }
}


class Ticket implements Runnable{

    private int tick = 10;
    //不能保证并发问题
//    private AtomicInteger tick = new AtomicInteger(10);

    @Override
    public void run(){
        //线程一直执行,直到停止,但是线程没有真的停止
        while(true){
            saleBySync();
        }
    }

    private synchronized void saleBySync() {
        if (tick > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "完成售票,余票为: " + --tick);
        }
    }

    private void saleByLock() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            Thread.sleep(200);

            if (tick > 0) {
                System.out.println(Thread.currentThread().getName() + "完成售票,余票为: " + --tick);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}