package com.shuframework.jdkutil.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import com.shuframework.jdkutil.ValidateUtil;

/**
 * zip工具类（压缩，解压）
 * 
 * @author shu
 *
 */
public class ZipUtil {

	/**
	 * 打包压缩下载文件
	 * 
	 * @param fileList	文件List
	 * @param outputStream	输出
	 * @param zipName	下载的zip文件名
	 * @throws IOException
	 */
	public static void downLoadZipFile(List<File> fileList, OutputStream outputStream, String zipName)
			throws IOException {
		ZipOutputStream out = new ZipOutputStream(outputStream);

		byte[] buffer = new byte[1024];
		for (File file : fileList) {
			FileInputStream fis = new FileInputStream(file);
			out.putNextEntry(new ZipEntry(file.getName()));
			int len;
			// 读入需要下载的文件的内容，打包到zip文件
			while ((len = fis.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			out.flush();
			out.closeEntry();
			fis.close();
		}
		out.close();
	}

//	/**
//	 * 打包压缩下载文件
//	 * 
//	 * @param fileList	文件List
//	 * @param response
//	 * @param zipName	下载的zip文件名
//	 * @throws IOException
//	 */
//	public static void downLoadZipFile(List<File> fileList, HttpServletResponse response, String zipName)
//			throws IOException {
//
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-Disposition", "attachment;filename=" + zipName);
//		OutputStream outputStream = response.getOutputStream();
//
//		downLoadZipFile(fileList, outputStream, zipName);
//	}

	/**
	 * 递归压缩文件夹
	 * 
	 * @param srcRootDir
	 *            压缩文件夹根目录的子路径
	 * @param file
	 *            当前递归压缩的文件或目录对象
	 * @param zos
	 *            压缩文件存储对象
	 * @throws IOException 
	 * @throws Exception
	 */
	private static void zip(String srcRootDir, File file, ZipOutputStream zos) throws IOException {
		// 如果是文件，则直接压缩该文件; 如果是目录，则压缩整个目录
		if (file.isFile()) {
			int count, bufferLen = 1024;
			byte data[] = new byte[bufferLen];

			// 获取文件相对于压缩文件夹根目录的子路径
			String subPath = file.getAbsolutePath();
			int index = subPath.indexOf(srcRootDir);
			if (index != -1) {
				subPath = subPath.substring(srcRootDir.length() + File.separator.length());
			}
			ZipEntry entry = new ZipEntry(subPath);
			zos.putNextEntry(entry);
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			while ((count = bis.read(data, 0, bufferLen)) != -1) {
				zos.write(data, 0, count);
			}
			bis.close();
			zos.closeEntry();
			
		}else {
			// 压缩目录中的文件或子目录
			File[] childFileList = file.listFiles();
			for (int n = 0; n < childFileList.length; n++) {
				childFileList[n].getAbsolutePath().indexOf(file.getAbsolutePath());
				zip(srcRootDir, childFileList[n], zos);
			}
		}
	}

	/**
	 * 对文件或文件目录进行压缩
	 * 
	 * @param srcPath
	 *            要压缩的源文件路径。如果压缩一个文件，则为该文件的全路径；如果压缩一个目录，则为该目录的顶层目录路径
	 * @param zipPath
	 *            压缩文件保存的路径。注意：zipPath不能是srcPath路径下的子文件夹
	 * @param zipFileName	压缩文件名
	 * @throws IOException 
	 */
	public static void zip(String srcPath, String zipPath, String zipFileName) throws IOException{
		CheckedOutputStream cos = null;
		ZipOutputStream zos = null;
		File srcFile = new File(srcPath);
		// 判断压缩文件保存的路径是否为源文件路径的子文件夹，如果是，则抛出异常（防止无限递归压缩的发生）
		if (srcFile.isDirectory() && zipPath.indexOf(srcPath) != -1) {
			throw new RuntimeException("zipPath must not be the child directory of srcPath.");
		}

		// 判断压缩文件保存的路径是否存在，如果不存在，则创建目录
		File zipDir = new File(zipPath);
		if (!zipDir.exists() || !zipDir.isDirectory()) {
			zipDir.mkdirs();
		}

		// 创建压缩文件保存的文件对象
		String zipFilePath = zipPath + File.separator + zipFileName;
		File zipFile = new File(zipFilePath);
		if (zipFile.exists()) {
			// 检测文件是否允许删除，如果不允许删除，将会抛出SecurityException
			SecurityManager securityManager = new SecurityManager();
			securityManager.checkDelete(zipFilePath);
			// 删除已存在的目标文件
			zipFile.delete();
		}

		cos = new CheckedOutputStream(new FileOutputStream(zipFile), new CRC32());
		zos = new ZipOutputStream(cos);

		// 如果只是压缩一个文件，则需要截取该文件的父目录
		String srcRootDir = srcPath;
		if (srcFile.isFile()) {
			int index = srcPath.lastIndexOf(File.separator);
			if (index != -1) {
				srcRootDir = srcPath.substring(0, index);
			}
		}
		// 调用递归压缩方法进行目录或文件压缩
		zip(srcRootDir, srcFile, zos);
		zos.flush();
		zos.close();
	}

	/**
	 * 解压缩zip包
	 * 
	 * @param zipFilePath		zip文件的全路径
	 * @param unzipFilePath		解压后的文件保存的路径
	 * @param includeZipFileName
	 *            解压后的文件保存的路径是否包含压缩文件的文件名。true-包含；false-不包含
	 * @throws IOException 
	 * @throws ZipException 
	 */
	public static void unzip(String zipFilePath, String unzipFilePath, boolean includeZipFileName)
			throws ZipException, IOException {
		File zipFile = new File(zipFilePath);
		if (!zipFile.exists()) {
			throw new RuntimeException(zipFilePath + "不存在");
		}
		// 如果解压后的文件保存路径包含压缩文件的文件名，则追加该文件名到解压路径
		if (includeZipFileName) {
			String fileName = zipFile.getName();
			if (ValidateUtil.isNotEmpty(fileName)) {
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
			}
			unzipFilePath = unzipFilePath + File.separator + fileName;
		}
		// 创建解压缩文件保存的路径
		File unzipFileDir = new File(unzipFilePath);
		if (!unzipFileDir.exists() || !unzipFileDir.isDirectory()) {
			unzipFileDir.mkdirs();
		}

		// 开始解压
		ZipEntry entry = null;
		String entryFilePath = null, entryDirPath = "";
		File entryFile = null, entryDir = null;
		int index = 0, count = 0, bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ZipFile zip = new ZipFile(zipFile);
		// Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries();
		Enumeration<? extends ZipEntry> entries = zip.entries();

		// 循环对压缩包里的每一个文件进行解压
		while (entries.hasMoreElements()) {
			entry = entries.nextElement();
			//TODO 此处是有问题的, 使用时只能通过指定unzipFilePath为盘符来解决这个目录层级的问题
			String entryName = entry.getName();
//			System.out.println(entryName);
			// 构建压缩包中一个文件解压后保存的文件全路径
			entryFilePath = unzipFilePath + File.separator + entryName;
			// 构建解压后保存的文件夹路径
			index = entryFilePath.lastIndexOf(File.separator);
			if (index != -1) {
				entryDirPath = entryFilePath.substring(0, index);
			}
			entryDir = new File(entryDirPath);
			// 如果文件夹路径不存在，则创建文件夹
			if (!entryDir.exists() || !entryDir.isDirectory()) {
				entryDir.mkdirs();
			}

			// 创建解压文件
			entryFile = new File(entryFilePath);
			//如果存在多级别的文件夹这样删除有问题
//			if (entryFile.exists()) {
//				// 检测文件是否允许删除，如果不允许删除，将会抛出SecurityException
//				SecurityManager securityManager = new SecurityManager();
//				securityManager.checkDelete(entryFilePath);
//				// 删除已存在的目标文件
//				entryFile.delete();
//			}

			// 写入文件
			bos = new BufferedOutputStream(new FileOutputStream(entryFile));
			bis = new BufferedInputStream(zip.getInputStream(entry));
			while ((count = bis.read(buffer, 0, bufferSize)) != -1) {
				bos.write(buffer, 0, count);
			}
			bos.flush();
			bos.close();
		}
		// 操作完成后关闭
		zip.close();
	}
}
