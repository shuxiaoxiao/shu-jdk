package com.shuframework.jdkutil.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.shuframework.jdkutil.lang.NumberSystemConvert;

/**
 * jdk自带的加密算法。 实际项目可以org.apache.commons.codec.digest.*
 * md5、sha加密底层是java.security.MessageDigest;
 * 对外调用的加密方法常用的是 xxHex
 *
 * @author shuheng
 */
public class DigestUtil {
    //md5、sha、hmac算法详情 http://snowolf.iteye.com/blog/379860

    /**
     * md5加密
     *
     * @param data
     * @return
     */
    public static String md5(byte[] data) {
        byte[] messageDigest = initByKey(data, DigestKeyEnum.MD5);
        return new String(messageDigest);
    }

    /**
     * md5加密
     *
     * @param data
     * @return
     */
    public static String md5(String data) {
        return md5(data.getBytes());
    }

    /**
     * sha1加密
     *
     * @param data
     * @return
     */
    public static String sha1(byte[] data) {
        byte[] messageDigest = initByKey(data, DigestKeyEnum.SHA1);
        return new String(messageDigest);
    }

    /**
     * sha1加密
     *
     * @param data
     * @return
     */
    public static String sha1(String data) {
        return sha1(data.getBytes());
    }

    /**
     * sha256加密
     *
     * @param data
     * @return
     */
    public static String sha256(byte[] data) {
        byte[] messageDigest = initByKey(data, DigestKeyEnum.SHA256);
        return new String(messageDigest);
    }

    /**
     * sha256加密
     *
     * @param data
     * @return
     */
    public static String sha256(String data) {
        return sha256(data.getBytes());
    }


    /**
     * md5加密且转成十六进制, 这是现在常用的md5加密
     *
     * @param data
     * @return
     */
    public static String md5Hex(byte[] data) {
        byte[] messageDigest = initByKey(data, DigestKeyEnum.MD5);
        return NumberSystemConvert.bytesToHexString(messageDigest);
    }

    /**
     * md5加密且转成十六进制, 这是现在常用的md5加密
     *
     * @param data
     * @return
     */
    public static String md5Hex(String data) {
        return md5Hex(data.getBytes());
    }

    /**
     * sha1加密且转成十六进制, 这是现在常用的sha1加密
     *
     * @param data
     * @return
     */
    public static String sha1Hex(byte[] data) {
        byte[] messageDigest = initByKey(data, DigestKeyEnum.SHA1);
        return NumberSystemConvert.bytesToHexString(messageDigest);
    }

    /**
     * sha1加密且转成十六进制, 这是现在常用的sha1加密
     *
     * @param data
     * @return
     */
    public static String sha1Hex(String data) {
        return sha1Hex(data.getBytes());
    }

    /**
     * sha256加密且转成十六进制, 这是现在常用的sha256加密
     *
     * @param data
     * @return
     */
    public static String sha256Hex(byte[] data) {
        byte[] messageDigest = initByKey(data, DigestKeyEnum.SHA256);
        return NumberSystemConvert.bytesToHexString(messageDigest);
    }

    /**
     * sha256加密且转成十六进制, 这是现在常用的sha256加密
     *
     * @param data
     * @return
     */
    public static String sha256Hex(String data) {
        return sha256Hex(data.getBytes());
    }


    /**
     * 根据不同的key获得密文
     *
     * @param data
     * @param keyEnum
     * @return
     */
    private static byte[] initByKey(byte[] data, DigestKeyEnum keyEnum) {
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = null;
        try {
            mdInst = MessageDigest.getInstance(keyEnum.getKey());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 使用指定的字节更新摘要
        mdInst.update(data);
        // 获得密文
        byte[] md = mdInst.digest();
        return md;
    }

//	//该方法移到了NumberSystemConvert.bytesToHexString(messageDigest);
//    private static String bytesToHexString(byte[] b) {
//        int length = b.length;
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            String hex = Integer.toHexString(b[i] & 0xFF);
//            if (hex.length() == 1) {
//                sb.append(0);//char 0 与 int 0结果一样
//            }
//            sb.append(hex);
//        }
//        return sb.toString();
//    }

}
