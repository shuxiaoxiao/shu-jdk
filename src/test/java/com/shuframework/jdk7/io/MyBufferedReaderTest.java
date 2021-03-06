package com.shuframework.jdk7.io;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class MyBufferedReaderTest {

	@Test
	public void test() throws IOException {
		String filePath = "D:\\autotemp\\books.xml";
		MyBufferedReader mbr = new MyBufferedReader(new FileReader(filePath));

		String line = null;
		while ((line = mbr.readLine()) != null) {
			System.out.println(line);
		}

		mbr.close();
	}

}
