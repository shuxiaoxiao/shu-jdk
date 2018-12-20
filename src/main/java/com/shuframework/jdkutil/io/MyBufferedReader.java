package com.shuframework.jdkutil.io;

import java.io.IOException;
import java.io.Reader;

/**
 * 扩展java.io.Reader 
 * @author shu
 *
 */
public class MyBufferedReader extends Reader {
	
	private Reader reader;
	
	public MyBufferedReader(Reader reader) {
		this.reader = reader;
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return this.reader.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		this.reader.close();
	}

	/**
	 * 读取一行
	 * 
	 * @throws IOException  
	 */
	public String readLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		//一个字节读取, 碰到换行就结束
		while ((ch = reader.read()) != -1) {
			if (ch == '\r') {
				continue;
			}

			if (ch == '\n') {
				return sb.toString();
			} else {
				sb.append((char) ch);
			}
		}

		// 为了防止数据丢失
		if (sb.length() > 0) {
			return sb.toString();
		}
		return null;
	}
	
}
