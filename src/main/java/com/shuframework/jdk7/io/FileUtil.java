package com.shuframework.jdk7.io;

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
import java.io.Writer;


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
	 * 读操作 字节流（二进制流）
	 * 
	 * @param input
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readToStringByBinary(InputStream input, String encoding)
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
	 * 读操作 字节流（二进制流）
	 * 
	 * @param filePath
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	public static String readToStringByBinary(String filePath, String encoding)
			throws IOException {
		FileInputStream input = new FileInputStream(filePath);
		return readToStringByBinary(input, encoding);
	}

	
	/**
	 * 读操作 字符流
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String readToStringByText(String filePath) throws IOException {
		// 创建字符缓冲输入流对象
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		
		StringBuffer sb = new StringBuffer();
		String s =null;//存放一行内容
		//BufferedReader的readLine方法
		while ((s = reader.readLine()) != null) {
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
		reader.close();
		return sb.toString();
	}

	
	/**
	 * 写操作 字节流（二进制流）
	 * 
	 * @param outStream
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
	 * 写操作 字节流（二进制流）
	 * 
	 * @param filePath
	 * @param data
	 * @param encoding
	 * @throws IOException
	 */
	public static void writeByBinary(String filePath, String data, String encoding) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		writeByBinary(fos, data, encoding);
	}
	
	/**
	 * 写操作 字符流
	 * 
	 * @param filePath
	 * @param data
	 * @throws IOException
	 */
	public static void writeByText(Writer writer, String data) throws IOException {
//		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		BufferedWriter bw = new BufferedWriter(writer);

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
	 * @throws IOException
	 */
	public static void writeByText(String filePath, String data) throws IOException {
		FileWriter writer = new FileWriter(filePath);
		writeByText(writer, data);
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
		File tarpath = new File(target, source.getName());
		if (source.isDirectory()) {
			tarpath.mkdir();
			File[] dir = source.listFiles();
			for (int i = 0; i < dir.length; i++) {
				copy(dir[i], tarpath);
			}
		} else {
			//用于读取文件的原始字节流
			InputStream input = new FileInputStream(source); 
			//用于写入文件的原始字节的流
			OutputStream output = new FileOutputStream(tarpath); 
			copy(input, output);
		}
	}
	
	/**
	 * 
	 * @param input
	 * @param output
	 * @throws IOException
	 */
	public static void copy(InputStream input, OutputStream output) throws IOException {
//		// 用于读取文件的原始字节流
//		InputStream input = new FileInputStream(source);
//		// 用于写入文件的原始字节的流
//		OutputStream output = new FileOutputStream(tarpath);
		byte[] buf = new byte[1024];// 存储读取数据的缓冲区大小
		int len = 0;
		while ((len = input.read(buf)) != -1) {
			output.write(buf, 0, len);
		}
		input.close();
		output.close();
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
	 * 递归删除文件或 删除单个文件
	 * 
	 * @param file
	 * @return
	 */
	public static boolean deleteFile(File file) {
		File[] files = file.listFiles();
		if (file.isDirectory() && files != null) {
			for (int i = 0, size = files.length; i < size; i++) {
				File subFile = files[i];
				if (subFile.isDirectory()){
					deleteFile(subFile);
				}else{
					subFile.delete();
				}
			}
		} else if (file.isFile() || (file.isDirectory() && files == null)) {
			file.delete();
		} else{
			return false;
		}
		return true;
	}
	
}
