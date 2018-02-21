package com.shuframework.jdk7.io.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

import com.shuframework.testmodel.BookInfo3;

/**
 * 不同流的使用
 */
public class StreamDemo {

	/**
	 * 拷贝一个目录或者文件到指定路径下，即把源文件拷贝到目标文件路径下
	 * 
	 * @param source	源文件
	 * @param target	目标文件路径
	 * @return void
	 * @throws IOException 
	 */
	public static void copy(File source, File target) throws IOException {
		if(!target.exists()){
			target.mkdirs();
		}
		File tarpath = new File(target, source.getName());
		if (source.isDirectory()) {
			tarpath.mkdir();
			File[] dir = source.listFiles();
			for (int i = 0; i < dir.length; i++) {
				copy(dir[i], tarpath);
			}
		} else {
			//用于读取文件的原始字节流
			FileInputStream input = new FileInputStream(source); 
			//用于写入文件的原始字节的流
			FileOutputStream output = new FileOutputStream(tarpath); 
//			copy(input, output);
			copyHasCache(input, output);
		}
	}
	
	/**
	 * 基本字节流一次读写一个字节数组
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void copy(InputStream input, OutputStream output) throws IOException {
		// 存储读取数据的缓冲区大小
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = input.read(buf)) != -1) {
			output.write(buf, 0, len);
		}
		output.close();
		input.close();
	}
	
	/**
	 * 高效字节流一次读写一个字节数组 (推荐)
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void copyHasCache(InputStream input, OutputStream output) throws IOException {
		BufferedInputStream bfInput = new BufferedInputStream(input);
		BufferedOutputStream bfOutput = new BufferedOutputStream(output);
		// 存储读取数据的缓冲区大小
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = bfInput.read(buf)) != -1) {
			bfOutput.write(buf, 0, len);
		}
		bfOutput.close();
		bfInput.close();
	}
	
	/**
	 * 
	 * @param reader
	 * @param writer
	 * @throws IOException
	 */
	public static void copy(Reader reader, Writer writer) throws IOException {
		//注意这个是char 数组, InputStream是byte数组
		char[] buf = new char[1024];// 存储读取数据的缓冲区大小
		int len = 0;
		while ((len = reader.read(buf)) != -1) {
			writer.write(buf, 0, len);
			writer.flush();
		}
		writer.close();
		reader.close();
	}
	
	/**
	 * 
	 * @param reader
	 * @param writer
	 * @throws IOException
	 */
	public static void copyHasCache(Reader reader, Writer writer) throws IOException {
		BufferedReader bfReader = new BufferedReader(reader);
		BufferedWriter bfWriter = new BufferedWriter(writer);
		String line = null;
		// 读取一行数据
		while ((line = bfReader.readLine()) != null) {
			bfWriter.write(line);
			bfWriter.newLine();
			bfWriter.flush();
		}
		bfWriter.close();
		bfReader.close();
	}
	
	/**
	 * 
	 * @param reader
	 * @param writer
	 * @throws IOException
	 */
	public static void copyHasCache2(Reader reader, Writer writer) throws IOException {
		BufferedReader bfReader = new BufferedReader(reader);
		PrintWriter ptWriter = new PrintWriter(writer);
		String line = null;
		// 读取一行数据
		while ((line = bfReader.readLine()) != null) {
			ptWriter.println(line);
			ptWriter.flush();
			//相当于之前的这几句
//			bfWriter.write(line);
//			bfWriter.newLine();
//			bfWriter.flush();
		}
		ptWriter.close();
		bfReader.close();
	}
	
	/**
	 * 复制 字节数组
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public byte[] copy(byte[] source) throws IOException {
		// 用于读取的原始字节流
		ByteArrayInputStream input = new ByteArrayInputStream(source);
		// 用于写入的原始字节的流
		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		copy(input, output);
		copyHasCache(input, output);
		return output.toByteArray();
	}
	
	/**
	 * 复制 字节数组
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public String copy(String source) throws IOException {
		// 用于读取的原始字节流
		StringReader reader = new StringReader(source);
		// 用于写入的原始字节的流
		StringWriter writer = new StringWriter();
//		copy(reader, writer);
		copyHasCache(reader, writer);
		return writer.toString();
	}
	
	
	/**
	 * 对象深度复制
	 * 注意obj 必须实现Serializable接口 
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object copy(Object obj) throws IOException, ClassNotFoundException {
		// 先序列化，写入到内存流里
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ObjectOutputStream objOutput = new ObjectOutputStream(output);
		objOutput.writeObject(obj);
		
		// 然后反序列化，从内存流里读取出来，即完成复制
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		ObjectInputStream objInput = new ObjectInputStream(input);
		
		return objInput.readObject();
	}
	
	
/////////////////////
	//这是2个
	@Test
	public void combineInput() throws IOException {
		InputStream in1 = new FileInputStream("D:\\autotemp\\books.xml");
		InputStream in2 = new FileInputStream("D:\\autotemp\\a.txt");
		//合并流
		SequenceInputStream input = new SequenceInputStream(in1, in2);
//		BufferedOutputStream bfOutput = new BufferedOutputStream(
//				new FileOutputStream("D:\\autotemp\\testCopy.doc"));
		FileOutputStream bfOutput = new FileOutputStream("D:\\autotemp\\testCopy.doc");

		copy(input, bfOutput);
	}
	//这是多个
	@Test
	public void combineInput2() throws IOException {
		InputStream in1 = new FileInputStream("D:\\autotemp\\books.xml");
		InputStream in2 = new FileInputStream("D:\\autotemp\\a.txt");
		InputStream in3 = new FileInputStream("D:\\autotemp\\a.txt");
		
		Vector<InputStream> list = new Vector<InputStream>();
		list.add(in1);
		list.add(in2);
		list.add(in3);
		//合并流
		SequenceInputStream input = new SequenceInputStream(list.elements());
//		BufferedOutputStream bfOutput = new BufferedOutputStream(
//				new FileOutputStream("D:\\autotemp\\testCopy.doc"));
		FileOutputStream bfOutput = new FileOutputStream("D:\\autotemp\\testCopy.txt");
		
		copy(input, bfOutput);
	}
	
	@Test
	public void copy_byte_test1() throws IOException {
		byte[] byteArr = {1, 2, 3, 'a', 'b', 'c', 'd', 'e', 'f'};
		byte[] newByteArr = copy(byteArr);
		byteArr[2] = 10; //对newByteArr 没影响
		System.out.println(Arrays.toString(newByteArr));//[1, 2, 3, 97, 98, 99, 100, 101, 102]
	}
	@Test
	public void copy_String_test1() throws IOException {
		String str = "hello 中国";
		String newStr = copy(str);
		System.out.println(newStr);//hello 中国
	}
	
	@Test
	public void copy_obj_test1() throws IOException, ClassNotFoundException {
		int[] intArr = {1, 2, 3, 'a', 'b', 'c', 'd', 'e', 'f'};
		int[] newByteArr = (int[]) copy(intArr);
		System.out.println(Arrays.toString(newByteArr));//[1, 2, 3, 97, 98, 99, 100, 101, 102]
	}
	
	@Test
	public void copy_obj_test2() throws IOException, ClassNotFoundException {
//		BookInfo book = new BookInfo(1, "test1");
//		//未实现Serializable的异常：java.io.NotSerializableException: com.shuframework.test.model.BookTemp
//		BookInfo newBook = (BookInfo) copy(book);
//		System.out.println(newBook);
		
		BookInfo3 book = new BookInfo3(1, "test1");
		BookInfo3 newBook = (BookInfo3) copy(book);
		book.setName("test2"); //不会影响newBook
		System.out.println(newBook);
	}
	
	//copy文件
	@Test
	public void copy_file_test1() throws IOException, ClassNotFoundException {
		File sourceFile = new File("D:\\autotemp\\a\\a2.txt");
		File targetFile = new File("D:\\demotemp22");
		copy(sourceFile, targetFile);
	}
	@Test
	public void copy_file_test2() throws IOException, ClassNotFoundException {
		//像这样转换了格式 虽然复制成功但是内容遭到了破坏
		InputStream input = new FileInputStream("D:\\autotemp\\1-15042Q5493c45.jpg");
		//由jpg 变为doc, 复制成功但是doc文件里面是乱码
		FileOutputStream output = new FileOutputStream("D:\\autotemp\\testCopy.doc");
		copy(input, output);
	}
	
	//copy文件夹
	@Test
	public void copy_folder_test2() throws IOException, ClassNotFoundException {
		File sourceFile = new File("D:\\autotemp\\a");
		File targetFile = new File("D:\\demotemp22");
		copy(sourceFile, targetFile);
	}
	
	
	@Test
	public void reader_test2() throws IOException{
		String filePath = "D:\\autotemp\\books.xml";
		LineNumberReader lnr = new LineNumberReader(new FileReader(filePath));
		lnr.setLineNumber(11);//这个只是设置行号, 不影响读取的位置
		String line = null;
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}

		lnr.close();
	}
	

}
