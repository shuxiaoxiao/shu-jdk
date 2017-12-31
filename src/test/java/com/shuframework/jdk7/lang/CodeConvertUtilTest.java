package com.shuframework.jdk7.lang;

import org.junit.Test;

public class CodeConvertUtilTest {

	@Test
	public void test() {
		String url = "http://www.google.com/search?hl=zh-CN&newwindow=1&q=%E4%B8%AD%E5%9B%BD%E5%A4%A7%E7%99%BE%E7%A7%91%E5%9C%A8%E7%BA%BF%E5%85%A8%E6%96%87%E6%A3%80%E7%B4%A2&btnG=%E6%90%9C%E7%B4%A2";
		boolean b1 = CodeConvertUtil.isIso(url);
		boolean b2 = CodeConvertUtil.isUTF8(url);
		System.out.println(b1);//true
		System.out.println(b2);//true
		
		//http://www.google.com/search?hl=zh-cn&newwindow=1&q=中国大百科在线全文检索&btng=搜索
		String url2 = CodeConvertUtil.decodeUtf8URL(url);
		System.out.println(url2);
	}
	
	@Test
	public void test2() {
		String url = "http://www.google.com/search?hl=zh-cn&newwindow=1&q=中国大百科在线全文检索&btng=搜索";
		boolean b1 = CodeConvertUtil.isIso(url);
		boolean b2 = CodeConvertUtil.isUTF8(url);
		System.out.println(b1);//false
		System.out.println(b2);//true
		
		//http://www.google.com/search?hl=zh-cn&newwindow=1&q=%E4%B8%AD%E5%9B%BD%E5%A4%A7%E7%99%BE%E7%A7%91%E5%9C%A8%E7%BA%BF%E5%85%A8%E6%96%87%E6%A3%80%E7%B4%A2&btng=%E6%90%9C%E7%B4%A2
		String url2 = CodeConvertUtil.encodeUtf8URL(url);
		System.out.println(url2);
	}

}
