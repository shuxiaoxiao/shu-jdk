package com.shuframework.jdk7.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.shuframework.jdk7.lang.NumberSystemConvert;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * jdk自带的加密算法。 实际项目可以org.apache.commons.codec.digest.*
 * md5、sha加密底层是java.security.MessageDigest;
 * <p>
 * 	BASE加密后产生的字节位数是8的倍数，如果不够位数以=符号填充。 
 * </p>
 * 
 * 
 * @author shu
 *
 */
public class JdkDigestUtil {
	//base64、md5、sha、hmac算法详情 http://snowolf.iteye.com/blog/379860
	
///////需要注意BASE64 用的是底层的	sun.misc.BASE64Decoder;  sun.misc.BASE64Encoder;如果不能导包就重新编辑下jdk
    /** 
     * BASE64解密 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decodeBASE64(String key) throws Exception {  
        return (new BASE64Decoder()).decodeBuffer(key);  
    }
  
    /** 
     * BASE64加密 
     *  
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static String encodeBASE64(byte[] key) throws Exception {  
        return (new BASE64Encoder()).encodeBuffer(key);  
    } 
	
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
	
///////////下面的加密方法才是常用的, 上面的加密只是转成了字节数组	
	/**
	 * md5加密且转成十六进制, 这是现在常用的md5加密
	 * @param data
	 * @return
	 */
	public static String md5Hex(byte[] data) {
		byte[] messageDigest = initByKey(data, DigestKeyEnum.MD5);
		return NumberSystemConvert.bytesToHexString(messageDigest);
	}
	
	/**
	 * md5加密且转成十六进制, 这是现在常用的md5加密
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
	
//	//改方法移到了NumberSystemConvert.bytesToHexString(messageDigest);
//	public static String bytesToHexString(byte[] b) {
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < b.length; i++) {
//			String hex = Integer.toHexString(b[i] & 0xFF);
//			if (hex.length() == 1) {
//				sb.append(0);//char 0 与 int 0结果一样
//			}
//			sb.append(hex);
//		}
//		return sb.toString();
//	}
	
}
