package com.shuframework.jdkdemo.proxy.logaop;

/**
 * @author shuheng
 */
public class MyLogInterceptor implements AopInterceptor {

    @Override
    public void before() {
        System.out.println("before...");
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public Object around(AopJoinPoint joinPoint) throws Exception {
        System.out.println("around before...");
        System.out.println("joinPoint: "+ joinPoint);
        Object obj = joinPoint.proceed();
        System.out.println("around after...");
        return obj;
    }

    @Override
    public void after() {
        System.out.println("after...");
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }
}
