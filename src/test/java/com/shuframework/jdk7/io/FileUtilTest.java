package com.shuframework.jdk7.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.shuframework.test.model.BookTemp;


public class FileUtilTest {

	@Test
	public void test() {
		File file = new File("D:\\autotemp\\a2");
		boolean flag = FileUtil.deleteFile(file);
		System.out.println(flag);
	}
	
	@Test
	public void deepCopy_test1() throws ClassNotFoundException, IOException {
		BookTemp b1 = new BookTemp(1, "a1");
		BookTemp b2 = b1;
		//未实现Serializable的异常：java.io.NotSerializableException: com.shuframework.test.model.BookTemp
		BookTemp b3 = (BookTemp) FileUtil.deepCopy(b1);
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
		BookTemp b1 = new BookTemp(1, "a1");
		BookTemp b2 = new BookTemp(2, "a2");
		
		List<BookTemp> oldList = null;
		oldList = new ArrayList<>();
		oldList.add(b1);
		oldList.add(b2);
		
		@SuppressWarnings("unchecked")
		List<BookTemp> newList = (List<BookTemp>) FileUtil.deepCopy(oldList);
		//未实现Serializable的异常：java.io.NotSerializableException: com.shuframework.test.model.BookTemp
		System.out.println("===复制前===");
		System.out.println("oldList:" + oldList);//[BookTemp [id=1, name=a1], BookTemp [id=2, name=a2]]
		System.out.println("newList:" + newList);//[BookTemp [id=1, name=a1], BookTemp [id=2, name=a2]]
		
		//浅度复制
		List<BookTemp> tempList = new ArrayList<>();
		tempList.addAll(oldList);
		//浅度复制
		List<BookTemp> tempList2 = new ArrayList<>(Arrays.asList(new BookTemp[oldList.size()]));
		Collections.copy(tempList2, oldList);
		
		b1.setName("cc");
		
		System.out.println("===修改前===");
		System.out.println("oldList:" + oldList);//[BookTemp [id=1, name=cc], BookTemp [id=2, name=a2]]
		System.out.println("newList:" + newList);//[BookTemp [id=1, name=a1], BookTemp [id=2, name=a2]]
		System.out.println("tempList:" + tempList);//[BookTemp [id=1, name=cc], BookTemp [id=2, name=a2]]
		System.out.println("tempList2:" + tempList2);//[BookTemp [id=1, name=cc], BookTemp [id=2, name=a2]]
	}

}
