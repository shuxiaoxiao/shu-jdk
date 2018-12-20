package com.shuframework.jdkutil.codec;

import com.shuframework.jdkutil.constant.CharsetConstant;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * jdk8 的Base64 工具类. 原理: BASE64加密后产生的字节位数是8的倍数，如果不够位数以=符号填充
 *  需要注意BASE64用的是底层的 sun.misc.BASE64Decoder; sun.misc.BASE64Encoder; 如果不能导包就重新编辑下jdk
 *  jdk8+可以用java.util.Base64来进行
 *
 * @author shuheng
 */
public class Base64Util {

    static final String CHARSET_UTF8 = CharsetConstant.CHARSET_UTF8;

    /**
     * BASE64加密
     *
     * @param key
     * @return
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
     */
    public static byte[] decodeBASE64toByte(String key) {
        return Base64.getDecoder().decode(key);
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
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

        String decode = "aGVsbG8gd29ybGQ=";
        String s = Base64Util.decodeBASE64(decode);
//        byte[] bytes = Base64Util.decodeBASE64toByte(decode);
        System.out.println(s);
    }
}
