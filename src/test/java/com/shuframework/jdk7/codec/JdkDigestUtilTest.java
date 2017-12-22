package com.shuframework.jdk7.codec;

import org.junit.Test;

public class JdkDigestUtilTest {

	@Test
	public void md5_test() {
		String md5Str = JdkDigestUtil.md5Hex("test");
		//098f6bcd4621d373cade4e832627b4f6
		System.out.println(md5Str);
	}
	
	@Test
	public void sha1_test() {
		String sha1Str = JdkDigestUtil.sha1Hex("test");
		//a94a8fe5ccb19ba61c4c0873d391e987982fbbd3
		System.out.println(sha1Str);
	}
	
	@Test
	public void sha256_test() {
		String sha1Str = JdkDigestUtil.sha256Hex("test");
		//9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
		System.out.println(sha1Str);
	}

}
