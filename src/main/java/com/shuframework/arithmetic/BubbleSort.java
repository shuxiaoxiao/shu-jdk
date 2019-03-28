package com.shuframework.arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序 每趟将最大值放到最后
 * <p>
 * Created by shu on 2018/9/13.
 */
public class BubbleSort {

    //这个更高效 可以减少局部有序的比较次数
    //第一次排序后部分已经有序, 那么开始比较的位置就往前了
    public static void sort(int[] intArr) {
        //max为 数组长度-1
        int max = intArr.length - 1;
        //记录上次发生交换位置的index
        int secondCount = max;
        for (int i = 0; i < max; i++) {
            System.out.println("第" + (i + 1) + "趟");
            //假设每一趟开始都是有序
            boolean flag = true;
            int lastChangeIndex = 0;
            for (int j = 0; j < secondCount; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    //2数互换
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                    flag = false;
                    lastChangeIndex = j;
                }
                System.out.println("比较次数："+(j+1)+", 结果:"+ Arrays.toString(intArr));
            }
            if (flag) {
                break;
            }
            //循环完后 得到最后的发生交换时下标
            secondCount = lastChangeIndex;
        }
    }

    public static void sortHasFlag(int[] intArr) {
        //max为 数组长度-1
        int max = intArr.length - 1;
        for (int i = 0; i < max; i++) {
            System.out.println("第" + (i + 1) + "趟");
            //假设每一趟开始都是有序
            boolean flag = true;
            for (int j = 0; j < max - i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    //2数互换
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                    flag = false;
                }
                System.out.println("比较次数：" + (j + 1) + ", 结果:" + Arrays.toString(intArr));
            }
            if (flag) {
                break;
            }
        }
    }

    // 缺点是已经有序时，后面的次数还是会继续
    public static void sortClassic(int[] intArr) {
        //max为 数组长度-1
        int max = intArr.length - 1;
        for (int i = 0; i < max; i++) {
            System.out.println("第" + (i + 1) + "趟");
            for (int j = 0; j < max - i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    //2数互换
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
                System.out.println("比较次数：" + (j + 1) + ", 结果:" + Arrays.toString(intArr));
            }
        }
    }


}
