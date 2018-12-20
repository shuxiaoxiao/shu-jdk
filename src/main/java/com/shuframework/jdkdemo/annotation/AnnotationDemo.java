package com.shuframework.jdkdemo.annotation;

import org.junit.Test;

/**
 * 注解示例
 * 
 * @author shu
 *
 */
@MyAnno
public class AnnotationDemo {

//    @Test
//    public void test(){
//        Reflections Reflections = new Reflections("com.shuframework.jdkutil");
//        Set<Class<?>> typesAnnotatedWithSet = Reflections.getTypesAnnotatedWith(MyAnno.class);
//        for(Class clazz : typesAnnotatedWithSet){
//            MyAnno myAnno = (MyAnno) clazz.getAnnotation(MyAnno.class);
//            System.out.println(clazz.getName() + " - " + clazz.getCanonicalName());
//        }
//    }

    @Test
    public void test2(){
        String str = Long.MAX_VALUE + "";
        System.out.println(str.length());
    }

}
