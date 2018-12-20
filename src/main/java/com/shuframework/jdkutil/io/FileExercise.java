package com.shuframework.jdkutil.io;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

import com.shuframework.jdkutil.lang.StringUtil;

/**
 * io流练习
 * 
 * @author shu
 *
 */
public class FileExercise {
	
	/** 前缀 */
	public final static String TYPE_PREFIX = StringUtil.TYPE_PREFIX;
	/** 后缀 */
	public final static String TYPE_SUFFIX = StringUtil.TYPE_SUFFIX;
//	public final static String TYPE_PREFIX = "prefix";
//	public final static String TYPE_SUFFIX = "suffix";
	
	/**
	 * 某个文件夹下的文件都加上前缀"[shu]"
	 */
	@Test
	public void rename_add2() {
		String rootPath = "D:\\autotemp\\test1";
		File file = new File(rootPath);
		String addName = "[shu]";
		renameByAdd(file, addName, TYPE_PREFIX);
	}
	
	/**
	 * 某个文件夹下的文件都加上后缀"[shu]"
	 */
	@Test
	public void rename_add3() {
		String rootPath = "D:\\autotemp\\test1";
		File file = new File(rootPath);
		String addName = "[shu]";
		renameByAdd(file, addName, TYPE_SUFFIX);
	}
	
	public void renameByAdd(File file, String addName, String type) {
		String rootPath = file.getPath();
		File[] listFiles = file.listFiles();
		for (File oldFile : listFiles) {
			String oldFileName = oldFile.getName();
			String newFileName = StringUtil.renameByAdd(oldFileName, addName, type);
			oldFile.renameTo(new File(rootPath, newFileName));
		}
	}
	
	public void renameByRemove(File file, String removeName, String type) {
		String rootPath = file.getPath();
		File[] listFiles = file.listFiles();
		for (File oldFile : listFiles) {
			String oldFileName = oldFile.getName();
			String newFileName = StringUtil.renameByRemove(oldFileName, removeName, type);
			oldFile.renameTo(new File(rootPath, newFileName));
		}
	}
	
	/**
	 * 某个文件夹下的文件都去掉前缀"[shu]"
	 */
	@Test
	public void rename_remove2() {
		String rootPath = "D:\\autotemp\\test1";
		File file = new File(rootPath);
		String removeName = "[shu]";
		renameByRemove(file, removeName, TYPE_PREFIX);
	}
	
	/**
	 * 某个文件夹下的文件都去掉后缀"[shu]"
	 */
	@Test
	public void rename_remove3() {
		String rootPath = "D:\\autotemp\\test1";
		File file = new File(rootPath);
		String removeName = "[shu]";
		renameByRemove(file, removeName, TYPE_SUFFIX);
	}
	

	/**
	 * 查找文件。
	 * @param baseDirName		待查找的目录
	 * @param targetFileName	目标文件名，支持通配符形式
	 * @param count				期望结果数目，如果畏0，则表示查找全部。
	 * @return		满足查询条件的文件名列表
	 */
	public static List<File> findFiles(String baseDirName, String targetFileName, int count) {
		/**
		 * 算法简述：
		 * 从某个给定的需查找的文件夹出发，搜索该文件夹的所有子文件夹及文件，
		 * 若为文件，则进行匹配，匹配成功则加入结果集，若为子文件夹，则进队列。
		 * 队列不空，重复上述操作，队列为空，程序结束，返回结果。
		 */
		List<File> fileList = new ArrayList<>();
		//判断目录是否存在
		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || !baseDir.isDirectory()){
			System.out.println("文件查找失败：" + baseDirName + "不是一个目录！");
			return fileList;
		}
		String tempName = null;
		//创建一个队列，Queue在第四章有定义
		Deque<File> queue = new ArrayDeque<>();//实例化队列 
		queue.add(baseDir);//入队 
		File tempFile = null;
		while (!queue.isEmpty()) {
			//从队列中取目录
			tempFile = queue.pop();
			if (tempFile.exists() && tempFile.isDirectory()) {
				File[] files = tempFile.listFiles();
				for (int i = 0; i < files.length; i++) {
					//如果是目录则放进队列
					if (files[i].isDirectory()) { 
						queue.add(files[i]);
					} else {
						//如果是文件则根据文件名与目标文件名进行匹配 
						tempName =  files[i].getName(); 
						if (wildcardMatch(targetFileName, tempName)) {
							//匹配成功，将文件名添加到结果集
							fileList.add(files[i].getAbsoluteFile()); 
							//如果已经达到指定的数目，则退出循环
							if ((count != 0) && (fileList.size() >= count)) {
								return fileList;
							}
						}
					}
				}
			} 
		}
		
		return fileList;
	}
	
	public static List<File> findFiles2(File baseDir, String targetFileName, int count, List<File> fileList) {
		/**
		 * 算法简述：
		 * 从某个给定的需查找的文件夹出发，搜索该文件夹的所有子文件夹及文件，
		 * 若为文件，则进行匹配，匹配成功则加入结果集，若为子文件夹，则递归。
		 */
//		List<File> fileList = new ArrayList<>();
		//判断目录是否存在
//		File baseDir = new File(baseDirName);
		if (!baseDir.exists()){
			System.out.println("文件查找失败：" + baseDir.getPath() + "不存在");
			return fileList;
		}
		
		if(baseDir.isFile()){
			String tempName = baseDir.getName();
			if (wildcardMatch(targetFileName, tempName)) {
				//匹配成功，将文件名添加到结果集
				fileList.add(baseDir.getAbsoluteFile()); 
				//如果已经达到指定的数目，则退出循环
				if ((count != 0) && (fileList.size() >= count)) {
					return fileList;
				}
			}
		}else {
			File[] files = baseDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				findFiles2(files[i], targetFileName, count, fileList);
			}
		}
		
		return fileList;
	}
	
	/**
	 * 通配符匹配
	 * @param pattern	通配符模式
	 * @param str	待匹配的字符串
	 * @return	匹配成功则返回true，否则返回false
	 */
	private static boolean wildcardMatch(String pattern, String str) {
		int patternLength = pattern.length();
		int strLength = str.length();
		int strIndex = 0;
		char ch;
		for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
			ch = pattern.charAt(patternIndex);
			if (ch == '*') {
				//通配符星号*表示可以匹配任意多个字符
				while (strIndex < strLength) {
					if (wildcardMatch(pattern.substring(patternIndex + 1),
							str.substring(strIndex))) {
						return true;
					}
					strIndex++;
				}
			} else if (ch == '?') {
				//通配符问号?表示匹配任意一个字符
				strIndex++;
				if (strIndex > strLength) {
					//表示str中已经没有字符匹配?了。
					return false;
				}
			} else {
				if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
					return false;
				}
				strIndex++;
			}
		}
		return (strIndex == strLength);
	}
	
	@Test
	public void findFiles_test() {
		String path = "D:\\autotemp\\a";
		String targetFileName = "*.txt";
		int count = 0;
		List<File> fileList = new ArrayList<>();
		fileList = findFiles(path, targetFileName, count);
		System.out.println(fileList);
	}
	
	@Test
	public void findFiles_test2() {
		String path = "D:\\autotemp\\a";
		File baseDir = new File(path);
		String targetFileName = "*.txt";
		int count = 0;
		List<File> fileList = new ArrayList<>();
//		fileList = findFiles2(baseDir, targetFileName, count, fileList);
		findFiles2(baseDir, targetFileName, count, fileList);
		System.out.println(fileList);
	}

}
