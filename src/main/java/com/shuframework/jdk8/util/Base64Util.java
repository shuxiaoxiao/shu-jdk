package com.shuframework.jdk8.util;

import com.shuframework.jdk7.codec.JdkDigestUtil;
import com.shuframework.jdk7.constant.CharsetConstant;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * jdk8 的Base64 工具类
 * @author Created by shuheng
 * @Description:
 * @date 2018-12-05 10:26
 */
public class Base64Util {

    static final String CHARSET_UTF8 = CharsetConstant.CHARSET_UTF8;

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encodeBASE64(String key) {
//        String asB64 = Base64.getEncoder().encodeToString(key.getBytes(CHARSET_UTF8));
        try {
            return Base64.getEncoder().encodeToString(key.getBytes(CHARSET_UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decodeBASE64toByte(String key) {
        return Base64.getDecoder().decode(key);
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String decodeBASE64(String key) {
        byte[] bytes = Base64.getDecoder().decode(key);
//        String str = new String(bytes);
        //不加编码 也能转换成功，但是最好还是加上编码
        String str = null;
        try {
            str = new String(bytes, CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        String encode1 = Base64Util.encodeBASE64("hello world");
        System.out.println(encode1);

//        String encode2 = JdkDigestUtil.encodeBASE64("hello world".getBytes());
//        System.out.println(encode2);

        String decode = "aGVsbG8gd29ybGQ=";
        String s = Base64Util.decodeBASE64(decode);
//        byte[] bytes = Base64Util.decodeBASE64toByte(decode);
        System.out.println(s);
    }
}
