package com.shuframework.jdkdemo.proxy.logaop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 连接点
 *
 * @author shuheng
 */
public class AopJoinPoint {
    //参数
    private Object[] params;
    //反射
    private Method method;
    //目标对象
    private Object target;

    //构造方法
    public AopJoinPoint(Object target, Method method, Object[] params) {
        this.target = target;
        this.method = method;
        this.params = params;
    }

    /**
     * 通过反射调用原来的方法
     *
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }

    @Override
    public String toString() {
        return "AopJoinPoint{" +
                "params=" + Arrays.toString(params) +
                ", method=" + method +
                ", target=" + target +
                '}';
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

}
