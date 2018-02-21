package com.shuframework.jdk7.io;

import org.junit.Test;

public class ZipUtilTest {

	@Test
	public void zip() throws Exception {
		// D:\autotemp\a
		String dir = "D:\\autotemp\\a";
		String zipPath = "D:\\autotemp";
		String zipFileName = "a.zip";
		
		ZipUtil.zip(dir, zipPath, zipFileName);
		//将刚创建的ZIP文件解压缩到D盘的temp目录下
		System.out.println();
	}
	
	@Test
	public void unzip() throws Exception {
		String zipFilePath = "D:\\autotemp\\a.zip";
//		String unzipFilePath = "D:\\autotemp\\a5";
		//D:\autotemp\a5\a\autotemp\a
//		ZipUtil.unzip(zipFilePath, unzipFilePath, true);
		//D:\autotemp\a5\autotemp\a
//		ZipUtil.unzip(zipFilePath, unzipFilePath, false);
		//以上指定会有问题此处是有问题的
		String unzipFilePath = "e:/";
		//E:\a\autotemp\a
//		ZipUtil.unzip(zipFilePath, unzipFilePath, true);
		//E:\autotemp\a
		ZipUtil.unzip(zipFilePath, unzipFilePath, false);
	}

}
