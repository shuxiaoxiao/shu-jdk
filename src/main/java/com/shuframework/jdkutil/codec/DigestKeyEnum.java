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
    MAC_SHA512("HmacSHA512", "MAC_SHA512加密");

    private String key;
    private String desc;

    DigestKeyEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

}
