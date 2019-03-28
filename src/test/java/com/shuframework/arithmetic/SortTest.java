package com.shuframework.arithmetic;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by shu on 2018/9/13.
 */
public class SortTest {

    @Test
    public void test2(){
        int[] intArr1 = {3,1,2,6,4,5};
        BubbleSort.sort(intArr1);
//        System.out.println("结果:"+ Arrays.toString(intArr));
        System.out.println("=============");
        int[] intArr2 = {3,1,2,6,4,5};
        BubbleSort.sortHasFlag(intArr2);
    }

    @Test
    public void test1(){
        int[] intArr1 = {3,2,1,6,4,5,7,8};
        BubbleSort.sort(intArr1);
//        System.out.println("结果:"+ Arrays.toString(intArr));
        System.out.println("=============");

        int[] intArr2 = {3,2,1,6,4,5,7,8};
        BubbleSort.sortHasFlag(intArr2);
        System.out.println("=============");

        int[] intArr3 = {3,2,1,6,4,5,7,8};
        BubbleSort.sortClassic(intArr3);
    }

    @Test
    public void test20(){
        int[] intArr = {3,2,5,4,6,7,8,9};
        BubbleSort.sort(intArr);
        System.out.println("结果:"+ Arrays.toString(intArr));
    }

}
