package com.shuframework.jdk8.stream;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by shu on 2018/7/26.
 */
public class OptionalDemo {

    @Test
    public void test1(){
        //空对象 不是null
        Optional emptyOptional = Optional.empty();
        boolean emptyPresent = emptyOptional.isPresent();
        System.out.println(emptyPresent);

//        //java.lang.NullPointerException
//        Optional nullOptional = Optional.of(null);
        //null被处理为空对象
        Optional nullOptional = Optional.ofNullable(null);
        boolean nullPresent = nullOptional.isPresent();
        System.out.println(nullPresent);
    }

}
