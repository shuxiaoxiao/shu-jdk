package com.shuframework.arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by shu on 2018/9/13.
 */
public class SortTest {

    @Test
    public void test1(){
//        int[] intArr = {3,2,6,4,5,9,8};
        int[] intArr = {3,2,9,6,4,5,8};
        BubbleSort.sort(intArr);
        System.out.println("结果:"+ Arrays.toString(intArr));
    }
}
