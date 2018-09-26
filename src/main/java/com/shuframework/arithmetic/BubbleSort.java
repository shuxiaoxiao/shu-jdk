package com.shuframework.arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by shu on 2018/9/13.
 */
public class BubbleSort {

    public static void sort(int[] intArr){
        //max为 数组长度-1
        for (int i = 0, max = intArr.length - 1; i < max; i++) {
//            System.out.println("第"+(i+1)+"趟");
            //假设每一趟开始都是有序
            boolean flag = true;
            for (int j = 0; j < max - i; j++) {
                if (intArr[j] > intArr[j+1]){
                    //2数互换
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                    flag = false;
                }
//                System.out.println("结果:"+ Arrays.toString(intArr));
            }
            if (flag){
                break;
            }
        }

    }

}
