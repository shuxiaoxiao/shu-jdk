package com.shuframework.jdk7.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.shuframework.jdk7.constant.CharsetConstant;
import com.shuframework.testmodel.BookInfo3;


public class FileUtilTest {

	@Test
	public void readByBinary_test() throws IOException {
		String filePath = "D:\\autotemp\\books.xml";
//		String encoding = CharsetConstant.CHARSET_GBK;// 乱码： 鏍稿績鎶�鏈�
		String encoding = CharsetConstant.CHARSET_UTF8;// 正常：核心技术
		String content = FileUtil.readByBinary(filePath, encoding);
		System.out.println(content);
	}
	
	@Test
	public void readByText_test() throws IOException {
		String filePath = "D:\\autotemp\\books.xml";
		String content = FileUtil.readByText(filePath);
		System.out.println(content);
	}
	
	@Test
	public void writeByBinary_test() throws IOException {
		String filePath = "D:\\autotemp\\books.xml";
		String encoding = CharsetConstant.CHARSET_GBK;// 乱码
//		String encoding = CharsetConstant.CHARSET_UTF8;// 正常
		FileUtil.writeByBinary(filePath, "\n测试数据：中国", true, encoding);
		String content = FileUtil.readByText(filePath);
		System.out.println(content);
	}
	
	@Test
	public void writeByText_test() throws IOException {
		String filePath = "D:\\autotemp\\books.xml";
		FileUtil.writeByText(filePath, "\n测试数据：中国");
		String content = FileUtil.readByText(filePath);
		System.out.println(content);
	}
	
	
	@Test
	public void deleteFile_test() {
		File file = new File("D:\\autotemp\\a2");
//		File file = new File("D:\\autotemp\\a5");
		boolean flag = FileUtil.deleteFile(file);
		System.out.println(flag);
	}
	
	@Test
	public void deleteFileByFolder_test() {
		File file = new File("D:\\autotemp\\a2");
//		File file = new File("D:\\autotemp\\a3\\a.txt");
		boolean flag = FileUtil.deleteFileByFolder(file);
		System.out.println(flag);
	}
	
	@Test
	public void deleteFolder_test() {
		File file = new File("D:\\autotemp\\a3");
//		File file = new File("D:\\autotemp\\a3\\a.txt");
		boolean flag = FileUtil.deleteFolder(file);
		System.out.println(flag);
	}
	
	@Test
	public void deepCopy_test1() throws ClassNotFoundException, IOException {
//		BookInfo b1 = new BookInfo(1, "a1");
//		BookInfo b2 = b1;
//		//未实现Serializable的异常：java.io.NotSerializableException: com.shuframework.test.model.BookTemp
//		BookInfo b3 = (BookInfo) FileUtil.deepCopy(b1);
		BookInfo3 b1 = new BookInfo3(1, "a1");
		BookInfo3 b2 = b1;
		//未实现Serializable的异常：java.io.NotSerializableException: com.shuframework.test.model.BookTemp
		BookInfo3 b3 = (BookInfo3) FileUtil.deepCopy(b1);
		System.out.println("===复制前===");
		System.out.println("b1:" + b1);//[id=1, name=a1]
		System.out.println("b2:" + b2);//[id=1, name=a1]
		System.out.println("b3:" + b3);//[id=1, name=a1]
		
		b1.setName("cc");
		System.out.println("===修改前===");
		System.out.println("b1:" + b1);//[id=1, name=cc]
		System.out.println("b2:" + b2);//[id=1, name=cc]
		System.out.println("b3:" + b3);//[id=1, name=a1]
	}
	
	
	@Test
	public void deepCopy_test2() throws ClassNotFoundException, IOException {
		BookInfo3 b1 = new BookInfo3(1, "a1");
		BookInfo3 b2 = new BookInfo3(2, "a2");
		
		List<BookInfo3> oldList = null;
		oldList = new ArrayList<>();
		oldList.add(b1);
		oldList.add(b2);
		
		@SuppressWarnings("unchecked")
		List<BookInfo3> newList = (List<BookInfo3>) FileUtil.deepCopy(oldList);
		//未实现Serializable的异常：java.io.NotSerializableException: com.shuframework.test.model.BookTemp
		System.out.println("===复制前===");
		System.out.println("oldList:" + oldList);//[BookTemp [id=1, name=a1], BookTemp [id=2, name=a2]]
		System.out.println("newList:" + newList);//[BookTemp [id=1, name=a1], BookTemp [id=2, name=a2]]
		
		//浅度复制
		List<BookInfo3> tempList = new ArrayList<>();
		tempList.addAll(oldList);
		//浅度复制
		List<BookInfo3> tempList2 = new ArrayList<>(Arrays.asList(new BookInfo3[oldList.size()]));
		Collections.copy(tempList2, oldList);
		
		b1.setName("cc");
		
		System.out.println("===修改前===");
		System.out.println("oldList:" + oldList);//[BookTemp [id=1, name=cc], BookTemp [id=2, name=a2]]
		System.out.println("newList:" + newList);//[BookTemp [id=1, name=a1], BookTemp [id=2, name=a2]]
		System.out.println("tempList:" + tempList);//[BookTemp [id=1, name=cc], BookTemp [id=2, name=a2]]
		System.out.println("tempList2:" + tempList2);//[BookTemp [id=1, name=cc], BookTemp [id=2, name=a2]]
	}

}
