package com.shuframework.jdkutil.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import com.shuframework.jdkutil.constant.CharsetConstant;

/**
 * 判断文件，建议直接调用file.exists()
 * 读文件 read 
 * 写文件 write 
 * 复制文件 copy 
 * 文件操作 递归新增、递归删除（这里的递归是针对文件夹）
 * 
 * @author shuheng
 *
 */
public class FileUtil {
	
	private static final String DEFAULT_ENCODING = CharsetConstant.CHARSET_UTF8;
	
//	/**
//	 * 这个方法建议直接调用file.exists()
//	 * @param file
//	 * @return
//	 */
//	public static boolean isExist(File file){
//		return file.exists();
//	}
//	
//	/**
//	 * 判断文件是否存在
//	 * @param filePath
//	 * @return
//	 */
//	public static boolean isExist(String filePath){
//		
//		return new File(filePath).exists();
//	}

	
	/**
	 * 读操作 字节流（二进制流）, 默认是utf-8编码
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static String readByBinary(InputStream input) throws IOException {
		return readByBinary(input, DEFAULT_ENCODING);
	}
	
	/**
	 * 读操作 字节流（二进制流）
	 * 
	 * @param input
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readByBinary(InputStream input, String encoding)
			throws IOException {
//		// 创建字节输入流对象
//		FileInputStream fis = new FileInputStream(filePath);
		// 转换流
		InputStreamReader inread = new InputStreamReader(input, encoding);

		StringBuffer sb = new StringBuffer();
		char[] chs = new char[1024];
		int len = 0;
		while ((len = inread.read(chs)) != -1) {
			sb.append(new String(chs, 0, len));
		}
		// 释放资源
		input.close();
		inread.close();

		return sb.toString();
	}
	
	/**
	 * 读操作 字节流（二进制流）, 默认是utf-8编码
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String readByBinary(String filePath) throws IOException {
		return readByBinary(filePath, DEFAULT_ENCODING);
	}
	
	/**
	 * 读操作 字节流（二进制流）
	 * 
	 * @param filePath
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readByBinary(String filePath, String encoding)
			throws IOException {
		FileInputStream input = new FileInputStream(filePath);
		return readByBinary(input, encoding);
	}

	/**
	 * 读操作 字符流
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static String readByText(Reader reader) throws IOException {
		// 创建字符缓冲输入流对象
		BufferedReader bfReader = new BufferedReader(reader);
		
		StringBuffer sb = new StringBuffer();
		String s =null;//存放一行内容
		//BufferedReader的readLine方法
		while ((s = bfReader.readLine()) != null) {
			sb.append(s).append("\n");
		}
//		//BufferedReader的read方法
//		char[] chs = new char[1024];
//		int len = 0;
//		StringBuffer sb = new StringBuffer();
//		while ((len = br.read(chs)) != -1) {
//			sb.append(new String(chs, 0, len));
//		}
		// 释放资源
		bfReader.close();
		return sb.toString();
	}
	
	/**
	 * 读操作 字符流
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String readByText(String filePath) throws IOException {
		FileReader reader = new FileReader(filePath);
		return readByText(reader);
	}

	
	/**
	 * 写操作 字节流（二进制流）, 默认是utf-8编码
	 * 
	 * @param outStream 注意构建时 data是追加还是从头加
	 * @param data
	 * @throws IOException
	 */
	public static void writeByBinary(OutputStream outStream, String data) throws IOException {
		writeByBinary(outStream, data, DEFAULT_ENCODING);
	}
	
	/**
	 * 写操作 字节流（二进制流）
	 * 
	 * @param outStream 注意构建时 data是追加还是从头加
	 * @param data
	 * @param encoding
	 * @throws IOException
	 */
	public static void writeByBinary(OutputStream outStream, String data, String encoding) throws IOException {
//		FileOutputStream fos = new FileOutputStream(filePath);
		OutputStreamWriter outwrite = new OutputStreamWriter(outStream, encoding);
		// 写数据
		outwrite.write(data);
		// 刷新缓冲区
		outwrite.flush();
		// 释放资源
		outStream.close();
		outwrite.close();
	}
	
	/**
	 * 写操作 字节流（二进制流）, data是追加在文件内容后面, 默认是utf-8编码
	 * 
	 * @param filePath
	 * @param data
	 * @throws IOException
	 */
	public static void writeByBinary(String filePath, String data) throws IOException {
		writeByBinary(filePath, data, true, DEFAULT_ENCODING);
	}
	
	/**
	 * 写操作 字节流（二进制流）, 默认是utf-8编码
	 * 
	 * @param filePath
	 * @param data
	 * @param isAppend  data是追加还是从头加
	 * @throws IOException
	 */
	public static void writeByBinary(String filePath, String data, boolean isAppend) throws IOException {
		writeByBinary(filePath, data, isAppend, DEFAULT_ENCODING);
	}
	
	/**
	 * 写操作 字节流（二进制流）
	 * 
	 * @param filePath
	 * @param data
	 * @param isAppend  data是追加还是从头加
	 * @param encoding  编码
	 * @throws IOException
	 */
	public static void writeByBinary(String filePath, String data, boolean isAppend, String encoding) throws IOException {
		//true 表示append, 即data 追加在文件内容后面
		FileOutputStream fos = new FileOutputStream(filePath, isAppend);
		writeByBinary(fos, data, encoding);
	}
	
	/**
	 * 写操作 字符流
	 * 
	 * @param writer 注意构建时 data是追加还是从头加
	 * @param data
	 * @throws IOException
	 */
	public static void writeByText(Writer writer, String data) throws IOException {
		BufferedWriter bw = new BufferedWriter(writer);
//		//根据系统来决定换行符
//		bw.newLine();
		// 写数据
		bw.write(data);
		// 刷新缓冲区
		bw.flush();
		// 释放资源
		bw.close();
	}
	
	/**
	 * 写操作 字符流
	 * 
	 * @param filePath
	 * @param data
	 * @param isAppend  data是追加还是从头加
	 * @throws IOException
	 */
	public static void writeByText(String filePath, String data, boolean isAppend) throws IOException {
		FileWriter writer = new FileWriter(filePath, isAppend);
		writeByText(writer, data);
	}
	
	/**
	 * 写操作 字符流, data是追加在文件内容后面
	 * 
	 * @param filePath
	 * @param data
	 * @throws IOException
	 */
	public static void writeByText(String filePath, String data) throws IOException {
//		FileWriter writer = new FileWriter(filePath, true);
//		writeByText(writer, data);
		writeByText(filePath, data, true);
	}
	

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
			for (File newFile : dir) {
				copy(newFile, tarpath);
			}
//			for (int i = 0; i < dir.length; i++) {
//				copy(dir[i], tarpath);
//			}
		} else {
			//用于读取文件的原始字节流
			InputStream input = new FileInputStream(source); 
			//用于写入文件的原始字节的流
			OutputStream output = new FileOutputStream(tarpath); 
//			copy(input, output);
			copyHasCache(input, output);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void copy(InputStream input, OutputStream output) throws IOException {
		byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
		int len = 0;
		while ((len = input.read(buf)) != -1) {
			output.write(buf, 0, len);
		}
		input.close();
		output.close();
	}
	
	/**
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void copyHasCache(InputStream input, OutputStream output) throws IOException {
		BufferedInputStream bfInput = new BufferedInputStream(input);
		BufferedOutputStream bfOutput = new BufferedOutputStream(output);
		byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
		int len = 0;
		while ((len = bfInput.read(buf)) != -1) {
			bfOutput.write(buf, 0, len);
		}
		bfInput.close();
		bfOutput.close();
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
		reader.close();
		writer.close();
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
		bfReader.close();
		bfWriter.close();
	}
//	public static void copyHasCache(Reader reader, Writer writer) throws IOException {
//		BufferedReader bfReader = new BufferedReader(reader);
//		BufferedWriter bfWriter = new BufferedWriter(writer);
//		//注意这个是char 数组, InputStream是byte数组
//		char[] buf = new char[1024];// 存储读取数据的缓冲区大小
//		int len = 0;
//		while ((len = bfReader.read(buf)) != -1) {
//			bfWriter.write(buf, 0, len);
//			bfWriter.flush();
//		}
//		bfReader.close();
//		bfWriter.close();
//	}
	
	
	/**
	 * 对象深度复制
	 * 注意obj 必须实现Serializable接口 
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object deepCopy(Object obj) throws IOException, ClassNotFoundException {
		// 先序列化，写入到流里
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ObjectOutputStream objOutput = new ObjectOutputStream(output);
		objOutput.writeObject(obj);
		
		// 然后反序列化，从流里读取出来，即完成复制
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		ObjectInputStream objInput = new ObjectInputStream(input);
		
		return objInput.readObject();
	}
	

	/**
	 * 图片BASE64 编码
	 * 
	 * @param picPath
	 * @return
	 * @throws IOException 
	 */
	public static String getPicBASE64(String picPath) throws IOException {
		FileInputStream fis = new FileInputStream(picPath);
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		String content = new sun.misc.BASE64Encoder().encode(bytes); // 具体的编码方法
		fis.close();
		
		return content;
	}

	/**
	 * 图片BASE64 编码
	 * 
	 * @param base64str
	 * @param outPicPath
	 * @throws IOException 
	 */
	public static void getPicFromBASE64(String base64str, String outPicPath) throws IOException {
		byte[] result = new sun.misc.BASE64Decoder().decodeBuffer(base64str.trim());
		FileOutputStream fos = new FileOutputStream(outPicPath); // r,rw,rws,rwd
		fos.write(result);
		fos.close();
	}
	
	/**
	 * 删除单个文件
	 * 
	 * @param file
	 * @return
	 */
	public static boolean deleteFile(File file) {
		boolean flag = false;
		if(!file.exists()){
			System.out.println(file + "不存在");
			return flag;
		}
		
		if(file.isFile()){
			flag = file.delete();
		}else{
			System.out.println(file + "不是文件");
		}
		
		return flag;
	}
	
	/**
	 * 删除文件夹下的所有文件 (递归删除)
	 * <pre>
	 * 目录 d:\\filetest\\a
	 * 		b
	 * 			c
	 * 			b.txt
	 * 		a.txt
	 * 删除目录d:\\filetest\\a (文件夹) ,那么其下的所有文件都会删除, 文件夹（b、c）都未被删除
	 * </pre>
	 * @param file
	 * @return
	 */
	public static boolean deleteFileByFolder(File file) {
		boolean flag = false;
		if(!file.exists()){
			System.out.println(file + "不存在");
			return flag;
		}
		
		if(file.isDirectory()){
			File[] fileArray = file.listFiles();
			if(fileArray.length == 0){
				System.out.println(file + "这个文件夹是空的");
			}
			for (File subFile : fileArray) {
				// 判断该File对象是否是文件夹
				if (subFile.isDirectory()) {
					deleteFileByFolder(subFile);
				} else {
//					System.out.println(subFile);
					flag = subFile.delete();
				}
			}
		}else{
			System.out.println(file + "不是文件夹");
		}
		return flag;
	}
	
	/**
	 * 递归删除这个文件夹所有内容 (包括文件和文件夹)
	 * <pre>
	 * 目录 d:\\filetest\\a
	 * 		b
	 * 			c
	 * 			b.txt
	 * 		a.txt
	 * 删除目录d:\\filetest\\a (文件夹) ,那么其下的所有文件和文件夹（b、c）都会删除
	 * </pre>
	 * 
	 * @param file
	 * @return
	 */
	public static boolean deleteFolder(File file) {
		boolean flag = false;
		if(!file.exists()){
			System.out.println(file + "不存在");
			return flag;
		}
		
		if(file.isDirectory()){
			File[] fileArray = file.listFiles();
			if(fileArray.length == 0){
				System.out.println(file + "这个文件夹是空的");
			}
			for (File subFile : fileArray) {
				// 判断该File对象是否是文件夹
				if (subFile.isDirectory()) {
					//该文件的文件夹下如果没有内容就删除
					if(subFile.listFiles().length == 0){
//						System.out.println(subFile);
						flag = subFile.delete();
					}else{
						deleteFolder(subFile);
					}
				} else {
//					System.out.println(subFile);
					flag = subFile.delete();
					//该文件的文件夹下如果没有内容就删除
					File parentFile = subFile.getParentFile();
					if(parentFile.listFiles().length == 0){
//						System.out.println(parentFile);
						flag = parentFile.delete();
					}
				}
			}
		}else{
			System.out.println(file + "不是文件夹");
		}
		return flag;
	}
	
	/**
	 * 删除文件 或文件夹(包含其下的文件和文件夹)
	 * 
	 * @param file
	 * @return
	 */
	public static boolean deleteFileOrFolder(File file) {
		boolean flag = false;
		if(file.isFile()){
			flag = deleteFile(file);
		}
		if(file.isDirectory()){
			flag = deleteFolder(file);
		}
		return flag;
	}
	
	//文件和文件夹都能删除
//	public static boolean deleteFolder(File file) {
//		boolean flag = false;
//		if(!file.exists()){
//			return flag;
//		}
//		
//		if(file.isFile()){
//			System.out.println(file.toString());
//			flag = file.delete();
//		}else{
//			File[] fileArray = file.listFiles();
//			for (File subFile : fileArray) {
//				// 判断该File对象是否是文件夹
//				if (subFile.isDirectory()) {
//					//该文件的文件夹下如果没有内容就删除
//					if(subFile.listFiles().length == 0){
//						System.out.println(subFile);
//						flag = subFile.delete();
//					}else{
//						deleteFolder(subFile);
//					}
//				} else {
////					String filePath = subFile.getPath();
////					String parentFilePath = filePath.substring(0, filePath.lastIndexOf("\\"));
////					File parentFile = new File(parentFilePath);
//					System.out.println(subFile.toString());
//					flag = subFile.delete();
//					//该文件的文件夹下如果没有内容就删除
//					File parentFile = subFile.getParentFile();
//					if(parentFile.listFiles().length == 0){
//						System.out.println(parentFile.toString());
//						flag = parentFile.delete();
//					}
//				}
//			}
//		}
//		return flag;
//	}
	
}
