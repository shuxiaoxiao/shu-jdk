package com.shuframework.jdk7.lang;

import org.junit.Test;

/**
 * 字符串的特点:字符串一旦被赋值，就不能改变。这里指的是字符串的内容不能改变，而不是引用不能改变。
 * @author shu
 *
 */
public class StringDemo {
	
	String str = "helloworld";

	/**
	 * 字符串的构造
	 */
//	@Test
	public void init() {
		//创建了2个对象：字符串常量缓冲区的对象，堆对象
		String s1 = new String("hello");
		//创建了1个对象：字符串常量缓冲区的对象
		String s2 = "hello";

		System.out.println(s1 == s2);//false
	}
	
	/**
	 * 字符串的构造
	 * 字符串如果是变量相加，先开空间，在拼接。
	 * 字符串如果是常量相加，是先加，然后在常量池找，如果有就直接返回，否则，就创建。
	 */
//	@Test
	public void init2() {
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";
		
		//字符串如果是变量相加，先开空间，在拼接
		System.out.println(s3 == s1 + s2);//false
		//字符串如果是常量相加，是先加，然后在常量池找，如果有就直接返回，否则，就创建。
		System.out.println(s3 == "hello" + "world");//应该是true
		// 通过反编译看源码，我们知道这里已经做好了处理。
		// System.out.println(s3 == "helloworld");
	}
	
	/**
	 * boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
	 * boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
	 */
//	@Test
	public void equals() {
		String s1 = "helloworld";
		String s2 = "helloworld";
		String s3 = "HelloWorld";
		
		//比较字符串的内容是否相同,区分大小写
		System.out.println("equals:" + s1.equals(s2));//true
		System.out.println("equals:" + s1.equals(s3));//false
		System.out.println("-----------------------");

		//比较字符串的内容是否相同,忽略大小写
		System.out.println("equals:" + s1.equalsIgnoreCase(s2));//true
		System.out.println("equals:" + s1.equalsIgnoreCase(s3));//true
	}
	
	/**
	 * 判断大字符串中是否包含小字符串
	 */
//	@Test
	public void contains() {
//		String s1 = "helloworld";
		//判断大字符串中是否包含小字符串
		System.out.println("contains:" + str.contains("hello"));//true
		System.out.println("contains:" + str.contains("hw"));//false
	}
	
	/**
	 * boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
	 * boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾
	 */
//	@Test
	public void startOrEndsWith() {
//		String s1 = "helloworld";
		//判断字符串是否以某个指定的字符串开头
		System.out.println("startsWith:" + str.startsWith("h"));//true
		System.out.println("startsWith:" + str.startsWith("hello"));//true
		System.out.println("startsWith:" + str.startsWith("world"));//false
		System.out.println("-----------------------");

		//判断字符串是否以某个指定的字符串结尾
		System.out.println("endsWith:" + str.endsWith("d"));//true
		System.out.println("endsWith:" + str.endsWith("hello"));//false
		System.out.println("endsWith:" + str.endsWith("world"));//true
	}
	
	/**
	 * boolean isEmpty():判断字符串是否为空。不兼容null和空格
	 */
//	@Test
	public void isEmpty() {
		String s1 = " ";
		String s2 = "";
//		String s3 = null;
		System.out.println("isEmpty:" + s1.isEmpty());//false
		System.out.println("isEmpty:" + s2.isEmpty());//true
		//对象都不存在，所以不能调用方法，空指针异常
//		System.out.println("isEmpty:" + s3.isEmpty());//NullPointerException
	}
	
	/**
	 * int length():获取字符串的长度
	 */
//	@Test
	public void length() {
		//helloworld
		System.out.println("length:" + str.length());//10
	}
	
	/**
	 * char charAt(int index):获取指定索引位置的字符,index从0开始
	 */
//	@Test
	public void charAt() {
		//helloworld
		System.out.println("charAt:" + str.charAt(7));//r
	}
	
	/**
	 * int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引,index从0开始
	 * int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引,index从0开始
	 * int indexOf(int ch, int fromIndex):返回指定字符在此字符串中从指定位置(fromIndex)后第一次出现处的索引
	 * int indexOf(String str, int fromIndex):返回指定字符在此字符串中从指定位置(fromIndex)后第一次出现处的索引
	 */
//	@Test
	public void indexOf() {
		//helloworld
		System.out.println("indexOf:" + str.indexOf('h'));//0
		System.out.println("indexOf:" + str.indexOf('l'));//2
		System.out.println("indexOf:" + str.indexOf("owo"));//4
		System.out.println("----------------------");
		
		System.out.println("indexOf:" + str.indexOf('l', 5));//8
		System.out.println("indexOf:" + str.indexOf("owo", 5));//-1
	}
	
	/**
	 * String substring(int start):从指定位置开始截取字符串,默认到末尾。包含start这个索引
	 * String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。包括start索引但是不包end索引
	 */
	@Test
	public void substring() {
		//helloworld
		System.out.println("substring:" + str.substring(5));//world
		System.out.println("substring:" + str.substring(0));//helloworld
		System.out.println("----------------------");
		
		System.out.println("substring:" + str.substring(3, 8));//lowor
		System.out.println("substring:" + str.substring(0, str.length()));//helloworld
	}
	
	/**
	 * byte[] getBytes():把字符串转换为字节数组
	 */
	@Test
	public void getBytes() {
		//helloworld
		byte[] bys = str.getBytes();
		for (int x = 0, max = bys.length; x < max; x++) {
			System.out.println(bys[x]);
		}
	}
	
	/**
	 * char[] toCharArray():把字符串转换为字符数组
	 */
	@Test
	public void toCharArray() {
		//helloworld
		char[] chs = str.toCharArray();
		for (int x = 0, max = chs.length; x < max; x++) {
			System.out.println(chs[x]);
		}
	}
	
	/**
	 * 将obj 转为str, 该方法有很多重载
	 * static String valueOf(char[] chs):把字符数组转成字符串
	 */
	@Test
	public void valueOf() {
		String s1 = String.valueOf(1);
		System.out.println(s1);
		String s2 = String.valueOf(1.0);
		System.out.println(s2);
		
		char[] chs = {'a', 'b'};
		String s3 = String.valueOf(chs);
		System.out.println(s3);
	}
	
	/**
	 * String toLowerCase():把字符串转成小写
	 * String toUpperCase():把字符串转成大写
	 */
	@Test
	public void toLowerOrUpperCase() {
		System.out.println("toLowerCase:" + str.toLowerCase());
		System.out.println("toUpperCase:" + str.toUpperCase());
	}
	
	/**
	 * String concat(String str):把字符串拼接,实质是重新创建了一个新str,底层代码是new String()
	 */
	@Test
	public void concat() {
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2;
		String s4 = s1.concat(s2);
		System.out.println("s4:" + s4);
		System.out.println(s3 == s4); //false
	}
	
	/**
	 * 替换功能, 一般是去空格或特殊字符
	 */
	@Test
	public void replace() {
		//helloworld
		String s2 = str.replace('l', 'k');
		String s3 = str.replace("owo", "ak47");
		System.out.println("s2:" + s2);
		System.out.println("s3:" + s3);
		System.out.println("---------------");
		
		String ss1 = "  a b c ";
		String ss2 = ss1.replace(" ", "");//替换所有空格
		System.out.println("ss2:" + ss2);//abc
	}
	
	/**
	 * 去除字符串左右两边空格, 这样的缺陷是中间的空格无法去掉
	 */
	@Test
	public void trim() {
		String s1 = "  a b c ";
		String s2 = s1.trim();
		System.out.println("s2:" + s2);//a b c
	}
	
	/**
	 * 按字典顺序比较两个字符串 <br>
	 * 等于0 表示前者等于后者
	 * 大于0 表示前者大于后者
	 * 小于0 表示前者小于后者
	 */
	@Test
	public void compareTo() {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = "abc";
		System.out.println(s1.compareTo(s2));// 0
		System.out.println(s1.compareTo(s3));// 7
	}
	
	@Test
	public void compareTo_2() {
//		String hmTime = "10:00";
		String hmTime = "11:30";
		if (hmTime.compareTo("11:00") >= 0 && hmTime.compareTo("13:00") <= 0){
            System.out.println(true);
        }else{
        	System.out.println(false);
        }
		//"10:00" 输出 false
		//"11:30" 输出 true
	}
	
	/**
	 * 查看源码后得知：比较对象变成了字符数组(char[]), 然后比较字符，不同就返回(return c1 - c2), 都相同就返回(return len1 - len2)
	 */
	@Test
	public void compareTo_3() {
		String s1 = "hello";
		String s2 = "hel";
		System.out.println(s1.compareTo(s2));// 2
	}
	
}
