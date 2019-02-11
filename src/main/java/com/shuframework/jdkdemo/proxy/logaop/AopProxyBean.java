package com.shuframework.jdkdemo.proxy.logaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * aop的动态代理bean
 *
 * @author shuheng
 */
public class AopProxyBean implements InvocationHandler {

    private Object target;
    private AopInterceptor interceptor;

    public static Object getProxyBean(Object target, AopInterceptor interceptor) {
        AopProxyBean proxyBean = new AopProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        //生成代理对象
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        //异常标识
        boolean exceptionFlag = false;
        //target是真实对象
        AopJoinPoint joinPoint = new AopJoinPoint(target, method, args);

        interceptor.before();
        Object retuenObj = null;
        try {
            if (interceptor.useAround()){
                retuenObj = interceptor.around(joinPoint);
            }else{
                retuenObj = method.invoke(target, args);
            }
        }catch (Exception e){
            exceptionFlag = true;
        }
        interceptor.after();

        if (exceptionFlag){
            interceptor.afterThrowing();
        }else{
            interceptor.afterReturning();
        }

        return retuenObj;
    }
}
