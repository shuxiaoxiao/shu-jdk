package com.shuframework.jdk8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 数组的循环操作
 * Created by shu on 2018/6/28.
 */
public class ArrForeachDemo {

    @Test
    public void arr_for(){
        int[] intArr = {1,2,3};
        for (int n : intArr){
            System.out.println(n);
        }
    }

    @Test
    public void arr_for2(){
        int[] intArr = {1,2,3};
        //[I@5aaa6d82
        Arrays.asList(intArr).stream().forEach(n ->  System.out.println(n));
        Integer[] integerArr = {1,2,3};
        //1 2 3
        Arrays.asList(integerArr).stream().forEach(n ->  System.out.println(n));
    }

    @Test
    public void arr_for22(){
        String[] strArr = {"1","2","3"};
        //1 2 3
        Arrays.asList(strArr).stream().forEach(n ->  System.out.println(n));
        //1 2 3
        Stream.of(strArr).forEach(n ->  System.out.println(n));
    }

    /**
     * 将int[] intArr = {1,2,3};
     * 转成String[] strArr = {"1","2","3"};
     */
    @Test
    public void arr_for3(){
        int[] intArr = {1,2,3};
        String[] strArr = Arrays.stream(intArr).boxed().map(n -> String.valueOf(n)).toArray(String[]::new);
        intArr[1] = 4;
        //1 2  3
        Stream.of(strArr).forEach(s ->  System.out.println(s));
    }
    @Test
    public void arr_for32(){
        Integer[] intArr2 = {1,2,3};
        String[] strArr2 = Stream.of(intArr2).map(n -> String.valueOf(n)).toArray(String[]::new);
        intArr2[1] = 4;
        //1 4 3
        Stream.of(intArr2).forEach(s ->  System.out.println(s));
        //1 2 3
        Stream.of(strArr2).forEach(s ->  System.out.println(s));
    }

}
