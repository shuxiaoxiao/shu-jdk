package com.shuframework.jdkdemo.proxy.logaop;

/**
 * aop的拦截器: 将大量重复的流程通过约定的方式抽出来，然后给默认实现
 * @author shuheng
 */
public interface AopInterceptor {

    /** 事前方法 */
    void before();

    /** 是否启用around方法代理，默认是true */
    boolean useAround();

    /** 代理方法 */
    Object around(AopJoinPoint joinPoint) throws Exception;

    /** 事后方法 */
    void after();

    /** after() 没有发生异常 */
    void afterReturning();

    /** after() 发生异常 即事后异常方法 */
    void afterThrowing();

}
