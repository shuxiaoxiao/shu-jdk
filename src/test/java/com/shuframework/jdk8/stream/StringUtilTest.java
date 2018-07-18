package com.shuframework.jdk8.stream;

import org.junit.Test;

import java.util.List;

/**
 * Created by shu on 2018/7/10.
 */
public class StringUtilTest {

    @Test
    public void split2IntList_test(){
        String str = "1,3,7,4,5";
        List<Integer> list = StringUtil.split2IntList(str);
        list.forEach(n -> System.out.print(n + "  "));
    }

    @Test
    public void split2IntList_test2(){
        String str = ",";
        List<Integer> list = StringUtil.split2IntList(str);
        list.forEach(n -> System.out.print(n + "  "));
    }

    @Test
    public void split2LongList_test(){
        String str = "1,3,7,4,5";
        List<Long> list = StringUtil.split2LongList(str);
        list.forEach(n -> System.out.print(n + "  "));
    }
}
