package com.shuframework.jdkutil.codec;

import com.shuframework.jdkutil.constant.CharsetConstant;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * DES对称加密
 * 1.还原密钥
 * 2.初始化,设置为加密(解密)模式
 * 3.执行操作
 *
 * @author shuheng
 */
@Deprecated
public class DesUtil {

    public static final String ALGORITHM = DigestKeyEnum.DES.getKey();
    /**
     * DES key size must be equal to 56
     */
    public static final int KEY_SIZE = 56;


    /**
     * 加密
     *
     * @param data 需要加密的数据
     * @param key  initKey()生成的key经过base64加密了
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) {
        byte[] encryptBytes = null;
        try {
            //还原密钥
            Key k = toKey(Base64Util.decodeBASE64toByte(key));
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            //初始化,设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, k);
            //执行操作
            encryptBytes = cipher.doFinal(data);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return encryptBytes;
    }

    /**
     * 解密
     *
     * @param data 需要解密的数据
     * @param key  initKey()生成的key经过base64加密了
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) {
        byte[] decryptBytes = null;
        try {
            Key k = toKey(Base64Util.decodeBASE64toByte(key));
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, k);
            decryptBytes = cipher.doFinal(data);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return decryptBytes;
    }


    /**
     * 转换密钥<br>
     *
     * @param key
     * @return
     * @throws Exception
     */
    private static Key toKey(byte[] key) {
//        DESKeySpec dks = new DESKeySpec(key);
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
//        SecretKey secretKey = keyFactory.generateSecret(dks);

        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
        return secretKey;
    }

    /**
     * 生成密钥, 先生成密钥然后通过base64加密
     *
     * @return
     */
    public static String initKey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(KEY_SIZE);
        SecretKey secretKey = kg.generateKey();
        byte[] keyEncoded = secretKey.getEncoded();
//        //乱码
//        System.out.println("keyEncoded:" + new String(keyEncoded));
        return Base64Util.encodeBASE64(keyEncoded);
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
//        String key = DesUtil.initKey();
        // java.security.InvalidKeyException: Wrong key size 只能是8 bytes
        String key = Base64Util.encodeBASE64("com.shuy");
        System.out.println(key);
        String data = "hello world";

        byte[] encrypt = DesUtil.encrypt(data.getBytes(), key);

//        System.out.println(encrypt);
//        //乱码
//        System.out.println(new String(encrypt));

        byte[] decrypt = DesUtil.decrypt(encrypt, key);
        System.out.println(new String(decrypt));
    }

}
