package com.shuframework.jdk8.stream;

import com.shuframework.jdkutil.ValidateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shu on 2018/7/10.
 */
public class StringUtil {

    /**默认分隔符:逗号*/
    public static final String REGEX_DEFAULT = ",";

    /**
     * 字符串分隔为list,如果str是空返回null,list为空返回空对象
     * @param str
     * @param regex
     * @return
     */
    public static List<String> split2StrList(String str, String regex){
        if (ValidateUtil.isEmpty(str)){
            return null;
        }
        String[] strArr = str.split(regex);
        //数组是空对象,那么转为list也是空对象
        return Arrays.asList(strArr);
    }

    /**
     * 字符串分隔为list,如果str是空返回null,list为空返回空对象
     * @param str
     * @return
     */
    public static List<String> split2StrList(String str){
        return split2StrList(str, REGEX_DEFAULT);
    }

    /**
     * 字符串分隔为list,如果str是空返回null,list为空返回空对象
     * @param str
     * @return
     */
    public static List<Integer> split2IntList(String str, String regex){
        List<String> strList = split2StrList(str, regex);
        if (ValidateUtil.isEmpty(strList)){
            return null;
        }
        return strList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    /**
     * 字符串分隔为list,如果str是空返回null,list为空返回空对象
     * @param str
     * @return
     */
    public static List<Integer> split2IntList(String str){
        return split2IntList(str, REGEX_DEFAULT);
    }

    /**
     * 字符串分隔为list,如果str是空返回null,list为空返回空对象
     * @param str
     * @return
     */
    public static List<Long> split2LongList(String str, String regex){
        List<String> strList = split2StrList(str, regex);
        if (ValidateUtil.isEmpty(strList)){
            return null;
        }
        return strList.stream().map(s -> Long.parseLong(s)).collect(Collectors.toList());
    }

    /**
     * 字符串分隔为list,如果str是空返回null,list为空返回空对象
     * @param str
     * @return
     */
    public static List<Long> split2LongList(String str){
        return split2LongList(str, REGEX_DEFAULT);
    }

}
