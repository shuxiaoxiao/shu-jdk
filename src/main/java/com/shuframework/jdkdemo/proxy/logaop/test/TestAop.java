package com.shuframework.jdkdemo.proxy.logaop.test;

import com.shuframework.jdkdemo.proxy.logaop.AopProxyBean;
import com.shuframework.jdkdemo.proxy.logaop.MyLogInterceptor;
import org.junit.Test;

/**
 * @author shuheng
 */
public class TestAop {

    @Test
    public void aop(){
        HelloService helloService = new HelloServiceImpl();
        HelloService proxyBean = (HelloService)AopProxyBean.getProxyBean(helloService, new MyLogInterceptor());
        proxyBean.say("java");
        System.out.println("-----null-----");
        proxyBean.say(null);
    }

}
