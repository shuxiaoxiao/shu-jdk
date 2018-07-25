package com.shuframework.jdk8.lambda;

import com.shuframework.testmodel.BookInfo;
import com.shuframework.testmodel.BookInfo2;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by shu on 2018/6/28.
 */
public class CollectForeachDemo {

//    List<Integer> intList = null;
    List<Integer> intList;
    List<BookInfo> bookList;

    @Before
    public void init(){
        intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);


        BookInfo b1 = new BookInfo(1, "a1");
        BookInfo b2 = new BookInfo(2, "a2");
        BookInfo b3 = new BookInfo(3, "a3");
        bookList = new ArrayList<>();
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
    }

    @Test
    public void list_for(){
        for (int n : intList){
            System.out.println(n);
        }
    }

    @Test
    public void list_for2(){
        intList.stream().forEach(n ->  System.out.println(n));
//        intList.stream().forEach(System.out::println);
    }


    @Test
    public void list_filter(){
        intList.stream().filter(n -> n%2==0).forEach(n ->  System.out.println(n));
//        intList.stream().forEach(System.out::println);
    }
    @Test
    public void list_filter2(){
        //等同效果
//        bookList.stream().filter(bookInfo -> bookInfo.getId()%2==0).forEach(bookInfo ->  System.out.println(bookInfo));
        List<BookInfo> newBookInfoList = bookList.stream().filter((BookInfo bookInfo) -> bookInfo.getId() % 2 == 0)
                .collect(Collectors.toList());//转成集合
//        System.out.println(newBookInfoList);
        newBookInfoList.forEach(bookInfo ->  System.out.println(bookInfo));
    }

    //累加，累乘等
    @Test
    public void list_reduce_add(){
        Optional<Integer> addSum = intList.stream().reduce((num1, num2) -> num1 + num2);
        //2种都是输出 Optional[15]
        System.out.println(addSum);
        System.out.println(addSum.toString());
        //get()获得Optional对象的值
        System.out.println(addSum.get());//15
    }
    @Test
    public void list_reduce_add2(){
        //identity表示初始值
        Integer addSum = intList.stream().reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(addSum);
    }

    @Test
    public void list_reduce_mul(){
        Integer mulSum = intList.stream().reduce(0, (num1, num2) -> num1 * num2);
        System.out.println(mulSum);//0

        Integer mulSum2 = intList.stream().reduce(1, (num1, num2) -> num1 * num2);
        System.out.println(mulSum2);//120
    }


    @Test
    public void list_tomap(){
        Map<Integer, BookInfo> bookInfoMap = bookList.stream().collect(Collectors.toMap(BookInfo::getId, Function.identity()));
//        Map<Integer, BookInfo> bookInfoMap = bookList.stream().collect(Collectors.toMap(b -> b.getId(), Function.identity()));
        System.out.println(bookInfoMap);
    }
    @Test
    public void list_tomap2(){
        Map<Integer, List<BookInfo>> bookInfoMap = bookList.stream().collect(Collectors.groupingBy(BookInfo::getId));
//        Map<Integer, BookInfo> bookInfoMap = bookList.stream().collect(Collectors.toMap(b -> b.getId(), Function.identity()));
        System.out.println(bookInfoMap);
    }

    @Test
    public void intList_tomap(){
//        Map<Integer, Integer> integerMap = intList.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
//        System.out.println(integerMap);
//        Map<String, Integer> integerMap = intList.stream().collect(Collectors.toMap("key", Function.identity()));
//        System.out.println(integerMap);
    }


}
