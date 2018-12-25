package com.shuframework.jdkutil;

import com.shuframework.jdkutil.lang.DateFormatUtil;
import com.shuframework.jdkutil.lang.StringUtil;
import com.shuframework.jdkutil.random.RandomUtil;


/**
 * 系统通用的判断<br>
 * 1.大部分类型 判断是否为null或为空
 * 2.手动生成的id，主要用于编码或主键
 * @author shu
 *
 */
public class SystemUtil {

	/**
	 * 获得36位长度的字符串, 里面包含字符 "-"
	 */
	public static String getUUId() {
		// java.util.UUID 是jdk 提供的类
		String str = java.util.UUID.randomUUID().toString();
		return str;
	}
	
	/**
	 * 获得32位长度的字符串, 实际是将getUUId() 中的字符 "-"去掉后的结果
	 */
	public static String getUUId32() {
		// java.util.UUID 是jdk 提供的类
		String str = java.util.UUID.randomUUID().toString();
		// String uuids = str.substring(0, 8) + str.substring(9, 13)
		// + str.substring(14, 18) + str.substring(19, 23)
		// + str.substring(24);
		// 方法二：与截取字符串的速度差不多
		String uuids = str.replace("-", "");
		return uuids;
	}
	
	/**
	 * 返回(12+length)位随机数, 组成格式：当前日期（yyMMddHHmmss）+ length位随机数
	 * 
	 * @param @param length 	随机位长度
	 */
	public static String getRandomId2(int length) {
		
		return DateFormatUtil.today2YyMMddHHmmss() + RandomUtil.randomByLength(length);
	}

	/**
	 * 返回(15+length)位随机数, 组成格式：当前日期（yyMMddHHmmssSSS）+ length位随机数
	 * 
	 * @param @param length 	随机位长度
	 */
	public static String getRandomId3(int length) {
		return DateFormatUtil.today2YyMMddHHmmssSSS() + RandomUtil.randomByLength(length);
	}

	/**
	 * 文件重命名（20位+后缀），组成格式：当前日期（yyMMddHHmmssSSS）+ 5位随机数
	 * null表示重命名失败，无后缀
	 * （由于依赖生成id 所以没放入StringUtil）
	 * 
	 * @param oldFileName
	 */
	public static String getNewFileName(String oldFileName) {
		String suffix = StringUtil.getSuffixHasPoint(oldFileName);
		if(suffix != null){
			return getRandomId3(5) + suffix;
		}else{
			return null;
		}
	}
	    
    //产生验证码，根据用户手机号保存到数据库，然后拿出数据与参数进行比较
    public static Integer verifyCode(){
    	//生成的随机数是线性可预测的
    	return RandomUtil.randomByLength(6);
    }

	/**
	 * 获得订单编码
	 * @return
	 */
	public static String getOrderCode(){
    	//TODO 获得订单编码
    	return "";
    }
	
	/**
	 * bool转成int
	 * @param bool
	 * @return
	 */
	public static Integer bool2Int(boolean bool) {
		return bool ? 1 : 0;
	}
	
	private static final String USER_HOME_KEY = "user.home";
	private static final String USER_DIR_KEY = "user.dir";
	private static final String JAVA_HOME_KEY = "java.home";
	private static final String JAVA__CLASS_PATH_KEY = "java.class.path";
	private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
	private static final String FILE_ENCODING_KEY = "file.encoding";
	private static final String FILE_SEPARATOR_KEY = "file.separator";

	public static final String USER_HOME = getSystemProperty(USER_HOME_KEY);
	public static final String USER_DIR = getSystemProperty(USER_DIR_KEY);
	public static final String JAVA_HOME = getSystemProperty(JAVA_HOME_KEY);
	public static final String JAVA_CLASS_PATH = getSystemProperty(JAVA__CLASS_PATH_KEY);
	public static final String JAVA_IO_TMPDIR = getSystemProperty(JAVA_IO_TMPDIR_KEY);
	public static final String FILE_ENCODING = getSystemProperty(FILE_ENCODING_KEY);
	public static final String FILE_SEPARATOR = getSystemProperty(FILE_SEPARATOR_KEY);

	private static String getSystemProperty(final String property) {
		try {
			return System.getProperty(property);
		} catch (final SecurityException ex) {
			System.err.println("Caught a SecurityException reading the system property '" + property
					+ "'; the SystemUtils property value will default to null.");
			return null;
		}
	}
}
