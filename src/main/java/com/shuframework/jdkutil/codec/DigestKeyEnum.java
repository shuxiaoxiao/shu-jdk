package com.shuframework.jdkutil.codec;

/**
 * 加密的key
 *
 * @author shuheng
 */
public enum DigestKeyEnum {

    MD5("MD5", "md5加密"),
    SHA1("SHA-1", "sha1加密"),
    SHA256("SHA-256", "sha256加密"),
    SHA512("SHA-512", "sha256加密"),
    MAC_MD5("HmacMD5", "MAC_MD5加密"),
    MAC_SHA1("HmacSHA1", "MAC_SHA1加密"),
    MAC_SHA256("HmacSHA256", "MAC_SHA256加密"),
    MAC_SHA384("HmacSHA384", "MAC_SHA384加密"),
    MAC_SHA512("HmacSHA512", "MAC_SHA512加密"),

    DES("DES", "DES对称加密"),
    AES("AES", "AES对称加密"),

    RSA("RSA", "RSA非对称加密"),
    ;
/*
 * DES                  key size must be equal to 56
 * DESede(TripleDES)    key size must be equal to 112 or 168
 * AES                  key size must be equal to 128, 192 or 256,but 192 and 256 bits may not be available
 * Blowfish             key size must be multiple of 8, and can only range from 32 to 448 (inclusive)
 * RC2                  key size must be between 40 and 1024 bits
 * RC4(ARCFOUR)         key size must be between 40 and 1024 bits
 */

    private String key;
//    private Integer keySize;
    private String desc;

    DigestKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }
//    DigestKeyEnum(String key, String desc, Integer keySize) {
//        this.key = key;
//        this.desc = desc;
//        this.keySize = keySize;
//    }

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

}
