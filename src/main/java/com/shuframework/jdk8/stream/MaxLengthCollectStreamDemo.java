package com.shuframework.jdk8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 集合的流操作
 * Created by shu on 2018/7/23.
 */
public class MaxLengthCollectStreamDemo {

    Stream<String> nameStream = null;

    @Before
    public void init(){
//        nameStream = Stream.of("John Lennon", "Paul McCartney",
//                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
        nameStream = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");
    }


    @Test
    public void count_test(){
        //Function.identity() 表示自身类型，一般是用方法引用指定一个属性
//        Map<String, Long> map = nameStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //str -> str 这样也能指定
        Map<String, Long> map = nameStream.collect(Collectors.groupingBy(str -> str, Collectors.counting()));
        System.out.println(map);
    }


    @Test
    public void maxLength_test(){
        //建议用这个
//        Optional<String> max = nameStream.max(Comparator.comparing(str -> str.length()));
//        System.out.println(max.get());
        //不能max，min同时用 java.lang.IllegalStateException: stream has already been operated upon or closed
        Optional<String> min = nameStream.min(Comparator.comparing(str -> str.length()));
        System.out.println(min.get());
    }

    @Test
    public void maxLength_test2(){
        Optional<String> max = nameStream.collect(Collectors.maxBy(Comparator.comparing(str -> str.length())));
        System.out.println(max.get());
    }


}
