package com.shuframework.jdkdemo;

import org.junit.Test;

/**
 * 练习题例子
 * @author shu
 * String的练习题
 *	1:字符串遍历
	2:统计字符串中大写，小写及数字字符的个数
	3:把字符串的首字母转成大写，其他小写
	4:把int数组拼接成一个指定格式的字符串 (循环处理即可)
	5:字符串反转
	6:统计大串中小串出现的次数
 */
public class ExerciseExample {
	
	/**
	 * 1:字符串遍历
	 */
	@Test
	public void getEachChar() {
		String str = "helloworld";
		for (int i = 0, max = str.length(); i < max; i++) {
			 char ch = str.charAt(i);
			 System.out.println(ch);
		}
	}
	
	
	/**
	 * 2:统计字符串中大写，小写及数字字符的个数
	 */
	@Test
	public void calcCounts() {
		String str = "Hello123World";
		// 定义三个统计变量
		int bigCount = 0;
		int smallCount = 0;
		int numberCount = 0;

		for (int i = 0, max = str.length(); i < max; i++) {
			char ch = str.charAt(i);
			// 判断该字符到底是属于那种类型的
//			if (ch >= 'a' && ch <= 'z') {
//				smallCount++;
//			} else if (ch >= 'A' && ch <= 'Z') {
//				bigCount++;
//			} else if (ch >= '0' && ch <= '9') {
//				numberCount++;
//			}
			//利用Character的方法进行判断
			if (Character.isLowerCase(ch)) {
				smallCount++;
			} else if (Character.isUpperCase(ch)) {
				bigCount++;
			} else if (Character.isDigit(ch)) {
				numberCount++;
			}
		}
		// 输出结果
		System.out.println("大写字母" + bigCount + "个");
		System.out.println("小写字母" + smallCount + "个");
		System.out.println("数字" + numberCount + "个");
	}
	
	
	/**
	 * 3:把字符串的首字母转成大写，其他小写
	 */
	@Test
	public void capitalize() {
		String str = "helloWorld";
//		String s1= (str.charAt(0) + "").toUpperCase();//一样的效果
		String s1= str.substring(0, 1).toUpperCase();
		String s2 = str.substring(1).toLowerCase();
		String s = s1 + s2;
		System.out.println(s);
	}
	
	@Test
	public void capitalize_2() {
		String str = "helloWorld";
		StringBuilder sb = new StringBuilder(str.length());
		sb.append(Character.toUpperCase(str.charAt(0)));
		sb.append(str.substring(1).toLowerCase());
		
		System.out.println(sb.toString());
	}
	
	/**
	 * 5:字符串反转
	 * 	(1)遍历字符串，然后倒序输出
	 * 	(2)StringBuilder的reverse方法
	 */
	@Test
	public void reverse() {
		String str = "abc";
		String result = "";

		// 把字符串转成字符数组
		char[] chs = str.toCharArray();
		// 倒着遍历字符串，得到每一个字符
		for (int x = chs.length - 1; x >= 0; x--) {
			// 用新字符串把每一个字符拼接起来
			result += chs[x];
		}
		
		System.out.println(result);//cba
	}
	
	@Test
	public void reverse_2() {
		String str = "abc";
//		String str = "aababcabcdabcde";
		StringBuilder sb = new StringBuilder(str);
		
		System.out.println(sb.reverse().toString());//cba
	}
	
	/**
	 * 6:统计大串中小串出现的次数
	 */
	@Test
	public void maxHasminCount() {
		// 定义大串
		String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
		// 定义小串
		String minString = "java";
		// 定义一个统计变量，初始化值是0
		int count = 0;
		int index;
		// 先查，赋值，判断
		while ((index = maxString.indexOf(minString)) != -1) {
			count++;
			maxString = maxString.substring(index + minString.length());
		}

		System.out.println("Java在大串中出现了：" + count + "次");
	}
	
	@Test
	public void maxHasminCount_2() {
		// 定义大串
		String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
		// 定义小串
		String minString = "java";
		// 定义一个统计变量，初始化值是0
		int count = 0;
		int index = 0;
//		while (true) {
//			index = maxString.indexOf(minString, index);
//			if(index == -1){
//				break;
//			}
//			index++;//第一次获得索引下标后，需要进行后移，不然永远定位在第一次的位置，导致死循环
//			count++;
//		}
		// 先查，赋值，判断
		while ((index = maxString.indexOf(minString, index)) != -1) {
			index++;//第一次获得索引下标后，需要进行后移，不然永远定位在第一次的位置，导致死循环
			count++;
		}
		
		System.out.println("Java在大串中出现了：" + count + "次");
	}
	
//	@Test
//	public void name() {
//		long starttime = System.currentTimeMillis();
//		maxHasminCount();
//		long endtime = System.currentTimeMillis();
//		System.out.println(endtime - starttime);
//		
//		long starttime2 = System.currentTimeMillis();
//		maxHasminCount_2();
//		long endtime2 = System.currentTimeMillis();
//		System.out.println(endtime2 - starttime2);
//	}

}
