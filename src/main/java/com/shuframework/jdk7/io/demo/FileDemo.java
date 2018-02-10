package com.shuframework.jdk7.io.demo;

import java.io.File;

import org.junit.Test;

/*
 * 我们要想实现IO的操作，就必须知道硬盘上文件的表现形式。
 * 而Java就提供了一个类File供我们使用。
 * 
 * File:文件和目录(文件夹)路径名的抽象表示形式
 * 构造方法：
 * 		File(String pathname)：根据一个路径得到File对象
 * 		File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * 		File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 */
public class FileDemo {
	
	/**
	 * 创建文件
	 * 以下三种方式其实效果一样, 常用第一种
	 */
	public void create() {
		String filePath = "D:\\autotemp";
		String fileName = "user2import.xls";
		// File(String pathname)：根据一个路径得到File对象
		// 把e:\\demo\\a.txt封装成一个File对象
		File file = new File("D:\\autotemp\\user2import.xls");

		// File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		File file2 = new File(filePath, fileName);

		// File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
		File file3 = new File(filePath);
		File file4 = new File(file3, fileName);
	}
	
	@Test
	public void test1() {
		File file = new File("D:\\autotemp\\user2import.xls");
		File[] listFiles = file.listFiles();
		System.out.println(listFiles.length);
	}
	
//	public static void main(String[] args) {
//		File file = new File("D:\\autotemp\\user2import.xls");
//		File[] listFiles = file.listFiles();
//		System.out.println(listFiles.length);
//	}
}
