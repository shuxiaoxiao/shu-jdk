package com.shuframework.jdkutil;

import com.shuframework.jdkutil.lang.DateUtil;
import com.shuframework.jdkutil.lang.StringUtil;
import com.shuframework.jdkutil.random.RandomUtil;

import java.util.Collection;
import java.util.Map;


/**
 * 系统通用的判断<br>
 * 1.大部分类型 判断是否为null或为空
 * 2.手动生成的id，主要用于编码或主键
 * @author shuheng
 *
 */
public class SystemUtil {

	private SystemUtil(){}

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
	public static String getRandomId(int length) {
		return DateUtil.today2Str() + RandomUtil.randomByLength(length);
	}

	/**
	 * 文件重命名（18位+后缀），组成格式：当前日期（yyMMddHHmmss）+ 6位随机数
	 * null表示重命名失败，无后缀
	 * （由于依赖生成id 所以没放入StringUtil）
	 * 
	 * @param oldFileName
	 */
	public static String getNewFileName(String oldFileName) {
		String suffix = StringUtil.getSuffixHasPoint(oldFileName);
		if(suffix != null){
			return getRandomId(6) + suffix;
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
	 * 判断str是否为null或空串（去空格了）,是返回 true
	 *
	 * @param str
	 */
	public static boolean isEmpty(String str){
		//当str = null时为true，后面的不执行了，所以str = null时不会执行trim()，所以就没问题
		return str == null || str.trim().length() == 0;
	}
	/**
	 * 判断str是否不为null或非空串（已去空格），是返回 true
	 *
	 * @param str
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}


	/**
	 * 判断str是否为null或空串（没有去空格）,是返回 true
	 *
	 * @param str
	 */
	public static boolean isEmptyUnTrim(String str){
		//当str = null时为true，后面的不执行了，所以str = null时不会执行length()，所以就没问题
		return str == null || str.length() == 0;
	}
	/**
	 * 判断str是否不为null或非空串（去空格了），是返回 true
	 *
	 * @param str
	 */
	public static boolean isNotEmptyUnTrim(String str){
		return !isEmptyUnTrim(str);
	}


	/**
	 * 判断集合是否为null或空,是返回 true.
	 * 包含List、Set
	 *
	 * @param collection
	 */
	public static boolean isEmpty(Collection<?> collection){
		return collection == null || collection.size() == 0;
//		//isEmpty的底层就是判断的size
//		return collection == null || collection.isEmpty();
	}
	/**
	 * 判断集合是否不为null或非空，是返回 true.
	 * 包含List、Set
	 *
	 * @param collection
	 */
	public static boolean isNotEmpty(Collection<?> collection){
		return !isEmpty(collection);
	}


	/**
	 * 判断数组对象 是否为null或空,是返回 true
	 *
	 * @param array
	 */
	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 判断数组对象 是否不为null或非空，是返回 true
	 *
	 * @param array
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return !isEmpty(array);
	}


	/**
	 * 判断map对象 是否为null或空,是返回 true
	 *
	 * @param map
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.size() == 0);
		//isEmpty的底层就是判断的size
//        return (map == null || map.isEmpty());
	}
	/**
	 * 判断map对象 是否不为null或非空,是返回 true
	 *
	 * @param map
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}


	/**
	 * 判断数字类型对象 是否为null或0,是返回 true.
	 * 包含Integer、Long
	 *
	 * @param num
	 */
	public static boolean isEmpty(Number num) {
//		return (num == null || num.equals(0));//Long时返回false
//		return (num == null || num.equals(0L));//Integer时返回false
//		return (num == null || num.toString().equals(0));//返回都是false
		return (num == null || num.toString().equals("0"));
	}
	/**
	 * 判断数字类型对象 是否不为null或非0,是返回 true.
	 * 包含Integer、Long
	 *
	 * @param num
	 */
	public static boolean isNotEmpty(Number num) {
		return !isEmpty(num);
	}

	/**
	 * 检查字符串长度,true表示未通过（不满足）,false表示通过
	 * 如果required=true 则会判断不为空,长度是否满足
	 *
	 * @param str
	 * @param required	是否必填
	 * @param limitLength 长度
	 * @return
	 */
	public static boolean checkStrLength(String str, boolean required, int limitLength){
		boolean flag = true;
		if(isNotEmpty(str)){
			if (str.length() <= limitLength){
				flag = false;
			}
		}else{
			if (!required){//非必填直接过
				flag = false;
			}
		}
		return flag;
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
