package com.shuframework.jdkdemo.proxy.logaop.test;

/**
 * @author shuheng
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void say(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new RuntimeException("param is null");
        }
        System.out.println("hello: " + name);
    }
}
