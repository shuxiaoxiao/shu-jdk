package com.shuframework.jdkutil.io.demo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.junit.Test;

/**
 * 我们要想实现IO的操作，就必须知道硬盘上文件的表现形式。
 * 而Java就提供了一个类File供我们使用。
 * 
 * File:文件和目录(文件夹)路径名的抽象表示形式
 * <pre>
 * 	构造方法：(第一种最常用)
 * 		File(String pathname)：根据一个路径得到File对象
 * 		File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * 		File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 * 
 *	创建功能：
 *		public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了, 如果文件夹不存在会报异常
 *		public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了， 如果文件夹不存在就不会创建， 返回false
 *		public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
 * 
 * 	删除功能:public boolean delete()
 * 
 * 	重命名功能:public boolean renameTo(File dest)
 * 		如果路径名相同，就是改名。
 * 		如果路径名不同，就是改名并剪切。
 * 
 * 	判断功能:
 * 		public boolean isDirectory():判断是否是目录
 * 		public boolean isFile():判断是否是文件
 * 		public boolean exists():判断是否存在
 * 		public boolean canRead():判断是否可读
 * 		public boolean canWrite():判断是否可写
 * 		public boolean isHidden():判断是否隐藏
 * 
 * 	获取功能：
 * 		public String getAbsolutePath()：获取绝对路径
 * 		public String getPath():获取相对路径
 * 		public String getName():获取名称
 * 		public File getParentFile():获取父文件
 * 		public long length():获取长度。字节数
 * 		public long lastModified():获取最后一次的修改时间，毫秒值
 * 	获取功能：
 * 		public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 * 		public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
 * 		//FilenameFilter 文件过滤器
 * 		public String[] list(FilenameFilter filter)
 * 		public File[] listFiles(FilenameFilter filter)
 * 
 * </pre>
 */
public class FileDemo {
	
	/**
	 * 构建文件
	 * 以下三种方式其实效果一样, 常用第一种
	 */
	public void init() {
		String filePath = "D:\\autotemp";
		String fileName = "user2import.xls";
		// File(String pathname)：根据一个路径得到File对象
		// 把e:\\demotemp\\a.txt封装成一个File对象
		File file = new File("D:\\autotemp\\user2import.xls");
		System.out.println(file);

		// File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		File file2 = new File(filePath, fileName);
		System.out.println(file2);

		// File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
		File file3 = new File(filePath);
		File file4 = new File(file3, fileName);
		System.out.println(file4);
	}
	
	/**
	 * 创建方法
	 * @throws IOException 
	 */
	@Test
	public void createNewFile() throws IOException {
		// 需求：我要在d盘目录下创建一个文件夹demotemp
//		File file = new File("d:\\demotemp");
//		System.out.println("mkdir:" + file.mkdir());
//
//		// 需求:我要在d盘目录demotemp下创建一个文件a.txt
//		//java.io.IOException: 系统找不到指定的路径。 因为d:\\demotemp 不存在。 先创建文件夹然后创建文件, 这种方式其实不推荐
		File file2 = new File("d:\\demotemp\\a.txt");
		System.out.println("createNewFile:" + file2.createNewFile());
		
		//默认在项目路径下
//		File file3 = new File("a.txt");
//		System.out.println("createNewFile:" + file3.createNewFile());
	}
	
	/**
	 * 创建文件夹
	 */
	@Test
	public void mkdir_or_mkdirs() {
		// 需求：我要在d盘目录下创建一个文件夹demotemp
//		File file = new File("d:\\demotemp");
//		System.out.println("mkdir:" + file.mkdir());

		// 需求:我要在d盘目录demotemp下创建aaa目录
//		File file2 = new File("d:\\demotemp2\\aaa");
//		// d:\\demotemp2 不存在返回 false, 如果存在就会创建并返回true
//		System.out.println("mkdir:" + file2.mkdir());

		// 创建文件夹, 如果上级的文件夹不存在 则会创建
//		File file5 = new File("d:\\demotemp2\\aaa");
//		System.out.println("mkdirs:" + file5.mkdirs());

		// 创建文件夹, 这种a.txt是个文件夹
		File file6 = new File("d:\\demotemp\\a.txt");
		System.out.println("mkdirs:" + file6.mkdirs());
	}
	
	/**
	 * 删除文件夹
	 */
	@Test
	public void delete() {
//		File file3 = new File("a.txt");
//		System.out.println("createNewFile:" + file3.createNewFile());
		//如果file 不存在 返回false
//		System.out.println("delete:" + file3.delete());
		File file = new File("d:\\demotemp\\a");
		System.out.println("delete:" + file.delete());
	}
	
	/**
	 * 删除文件夹
	 */
	@Test
	public void get() {
		File file = new File("d:\\demotemp\\a\\a.txt");
		System.out.println("getAbsolutePath:" + file.getAbsolutePath());
		System.out.println("getName:" + file.getName());
		System.out.println("getPath:" + file.getPath());
		System.out.println("getParentFile:" + file.getParentFile().toString());
	}
	
	/**
	 * 	重命名功能: 如果路径名相同，就是改名。如果路径名不同，就是改名并剪切。
	 */
	@Test
	public void renameTo() {
		String rootPath = "src/main/resources/";
		File file = new File(rootPath + "testfile/bookInfos.xml");
//		File newFile2 = new File(rootPath + "testfile/bookInfos.xml");
		File newFile2 = new File(rootPath + "testfile2/books.xml");
		//如果file 不存在 返回false
		System.out.println("renameTo:" + file.renameTo(newFile2));
	}
	
	//判断D盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
	@Test
	public void foreach() {
		// 封装e判断目录
//		File file = new File("d:\\");
		File file = new File("d:\\autotemp");
		// 获取该目录下所有文件或者文件夹的File数组
		File[] fileArray = file.listFiles();
		// 遍历该File数组，得到每一个File对象，然后判断
		for (File f : fileArray) {
			// 是否是文件并且以.jpg结尾
			if (f.isFile() && f.getName().endsWith(".jpg")) {
				System.out.println(f.getName());
			}
		}
	}
	
	//判断D盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
	@Test
	public void foreach2() {
		// 封装e判断目录
//		File file = new File("d:\\");
		File file = new File("d:\\autotemp");
		// 获取该目录下所有文件或者文件夹的File数组
		String[] fileArray = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir, name);
				//是否是文件并且以.jpg结尾
				return file.isFile() && name.endsWith(".jpg");
			}
		});
		// 遍历该File数组，得到每一个File对象，然后判断
		for (String str : fileArray) {
			System.out.println(str);
		}
	}

}
