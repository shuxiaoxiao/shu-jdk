package com.shuframework.jdk7;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import com.shuframework.jdk7.exception.UtilException;


/**
 * 参数校验
 * 1.大部分类型 判断是否为null或为空
 * 2.正则校验
 * 	推荐使用 hibernate-validator
 * 	自我实现：http://blog.csdn.net/wiker_yong/article/details/17040485
 * 
 * <pre>
 * ? 	0, 1
 * * 	0, n
 * + 	1, n
 * \d  	数字：[0-9]
 * \w 	单词字符：[a-zA-Z_0-9]
 * \\ 表示转义 
 * <pre>
 * 
 * @author shu
 *
 */
public class ValidateUtil {
	
	private ValidateUtil(){}
		
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
	 * 判断集合是否为null或空,是返回 true
	 * 
	 * @param collection
	 */
	public static boolean isEmpty(Collection<?> collection){
		return collection == null || collection.size() == 0;
//		//isEmpty的底层就是判断的size
//		return collection == null || collection.isEmpty();
	}
	/**
	 * 判断集合是否不为null或非空，是返回 true
	 * 
	 * @param collection
	 */
	public static boolean isNotEmpty(Collection<?> collection){
		return !isEmpty(collection);
	}
	
//	/**
//	 * 判断list是否为null或空,是返回 true
//	 * 
//	 * @param list
//	 */
//	public static boolean isEmpty(List<?> list){
//		return list == null || list.size() == 0;
//	}
//	/**
//	 * 判断list是否不为null或非空串（去空格了），是返回 true
//	 * 
//	 * @param list
//	 */
//	public static boolean isNotEmpty(List<?> list){
//		return !isEmpty(list);
//	}
	
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
	
//	//与上面差不多，因为Object是所有类的父类
//	/**
//	 * 判断数组对象 是否为null或空,是返回 true
//	 * 
//	 * @param array
//	 */
//	public static boolean isEmpty(Object[] array){
//		return array == null || array.length == 0;
//	}
//	/**
//	 * 判断数组对象 是否不为null或非空，是返回 true
//	 * 
//	 * @param array
//	 */
//	public static boolean isNotEmpty(Object[] array){
//		return !isEmpty(array);
//	}
	
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
	 * 判断数字类型对象 是否为null或0,是返回 true
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
	 * 判断数字类型对象 是否不为null或非0,是返回 true
	 * 包含Integer、Long
	 *
	 * @param num
	 */
	public static boolean isNotEmpty(Number num) {
		return !isEmpty(num);
	}
	
//	/**
//	 * 判断Integer对象 是否为null或0,是返回 true
//	 *
//	 * @param intNum
//	 */
//	public static boolean isEmpty(Integer intNum) {
//		return (intNum == null || intNum == 0);
//	}
//	/**
//	 * 判断Integer对象 是否不为null或非0,是返回 true
//	 *
//	 * @param intNum
//	 */
//	public static boolean isNotEmpty(Integer intNum) {
//		return !isEmpty(intNum);
//	}
//
//	/**
//	 * 判断Long对象 是否为null或0,是返回 true
//	 *
//	 * @param longNum
//	 */
//	public static boolean isEmpty(Long longNum) {
//		return (longNum == null || longNum == 0);
//	}
//	/**
//	 * 判断Long对象 是否不为null或非0,是返回 true
//	 *
//	 * @param longNum
//	 */
//	public static boolean isNotEmpty(Long longNum) {
//		return !isEmpty(longNum);
//	}
	
	
	/**
	 * 检查字符串长度，true表示未通过（不满足），false表示通过
	 * 如果required = true 则会判断不为空， 长度是否满足
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
	
	
/////////====== 类似表单校验 ======
	
	public enum NumberTypeEnnm {
		POSITIVE("正数", ""), //([+]?) +可以省略
		NEGATIVE("负数", "-"),
		ALL("正数或负数", "([+-]?)"),
		
//		INTEGER("整数"),
//		FLOAT("小数"),
//		NUMBER("数字")
		;
		
		private String msg;
		private String prefix;

		NumberTypeEnnm(String msg, String prefix) {
//			this.code = code;
			this.msg = msg;
			this.prefix = prefix;
		}
		
		public String getMsg() {
			return msg;
		}
		public String getPrefix() {
			return prefix;
		}
		
	}
	
	/** 整数 */
	private static final String V_INTEGER = "-?[1-9]\\d*";

	/** 正整数 */
	private static final String V_Z_INDEX = "[1-9]\\d*";

	/** 负整数 */
	private static final String V_NEGATIVE_INTEGER = "-[1-9]\\d*";

	/** 数字 */
	private static final String V_NUMBER = "([+-]?)\\d*\\.?\\d+";

	/** 正数 */
	private static final String V_POSITIVE_NUMBER = "[1-9]\\d*|0";

	/** 负数 */
	private static final String V_NEGATINE_NUMBER = "-[1-9]\\d*|0";

	/** 浮点数模型: 加前后缀来限制条件 */
	private static final String V_FLOAT_TEMPLATE = "\\d+\\.\\d";
//	private static final String V_FLOAT = "([+-]?)\\d*\\.\\d+";
//	/** 验证两位数 */
//	private static final String V_TWO＿POINT = "[0-9]+(.[0-9]{2})?";

	/** 邮件 */
	private static final String V_EMAIL = "\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+";

	/** 颜色 */
	private static final String V_COLOR = "[a-fA-F0-9]{6}";

	/** url */
	private static final String V_URL = "http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?";

	/** 仅中文 */
	private static final String V_CHINESE = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+";

	/** 仅ACSII字符 */
	private static final String V_ASCII = "[\\x00-\\xFF]+";

	/** 邮编 */
	private static final String V_ZIPCODE = "\\d{6}";

	/** 手机 */
	private static final String V_MOBILE_PHONE = "(1)[0-9]{10}";

	/** ip地址 */
	private static final String V_IP4 = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

//	/** 非空 */
//	private static final String V_NOTEMPTY = "\\S+";

	/** 图片 */
	private static final String V_PICTURE = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)";

	/** 压缩文件 */
	private static final String V_RAR = "(.*)\\.(rar|zip|7zip|tgz)";

	/** 日期: yyyy-MM-dd */
	private static final String V_DATE = "((19|20)\\d{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])";
	/** 时间: HH:mm:ss */
    private static final String V_TIME = "([0-1][0-9]|2[0-4]):([0-5][0-9]|60):([0-5][0-9]|60)";
    //2种都可以
//    private static final String V_TIME = "(0[0-9]|1[0-9]|2[0-4])\\:([0-5][0-9]|60)\\:([0-5][0-9]|60)";

	/** QQ号码 */
	private static final String V_QQ_NUMBER = "[1-9]*[1-9][0-9]*";

	/** 电话号码的函数(包括验证国内区号,国际区号,分机号) */
	private static final String V_TEL_PHONE = "(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?";

	/** 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串 */
	private static final String V_USERNAME = "\\w+";

	/** 字母 */
	private static final String V_LETTER = "[A-Za-z]+";

	/** 大写字母 */
	private static final String V_LETTER_U = "[A-Z]+";

	/** 小写字母 */
	private static final String V_LETTER_I = "[a-z]+";

	/** 身份证 */
	private static final String V_IDCARD = "(\\d{15}|\\d{18}|\\d{17}(\\d|X|x))";

	/** 验证密码(数字和英文同时存在) */
	private static final String V_PASSWORD_REG = "[A-Za-z]+[0-9]";

	/** 验证密码长度(6-18位) */
	private static final String V_PASSWORD_LENGTH = "\\d{6,18}";

	/** 验证一个月的31天 */
	private static final String V_31DAYS = "((0?[1-9])|((1|2)[0-9])|30|31)";
    
    /** 
     * 验证是不是整数 
     * @param value 要验证的字符串 要验证的字符串 
     * @return  如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isInteger(String value) {
		return match(V_INTEGER, value);
	}
  
    /** 
     * 验证是不是正整数 
     * @param value 要验证的字符串 
     * @return  如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Z_index(String value) {
		return match(V_Z_INDEX, value);
	}
  
    /** 
     * 验证是不是负整数 
     * @param value 要验证的字符串 
     * @return  如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Negative_integer(String value) {
		return match(V_NEGATIVE_INTEGER, value);
	}
  
    /** 
     * 验证是不是数字 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isNumber(String value) {
		return match(V_NUMBER, value);
	}
  
    /** 
     * 验证是不是正数 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isPositiveNumber(String value) {
		return match(V_POSITIVE_NUMBER, value);
	}
  
    /** 
     * 验证是不是负数 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isNegatineNumber(String value) {
		return match(V_NEGATINE_NUMBER, value);
	}
  
    /** 
     * 验证一个月的31天 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Is31Days(String value) {
		return match(V_31DAYS, value);
	}
  
    /** 
     * 验证是不是ASCII 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isASCII(String value) {
		return match(V_ASCII, value);
	}
  
    /** 
     * 验证是不是中文 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isChinese(String value) {
		return match(V_CHINESE, value);
	}
  
    /** 
     * 验证是不是颜色 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isColor(String value) {
		return match(V_COLOR, value);
	}
  
    /** 
     * 验证是不是日期 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isDate(String value) {
		return match(V_DATE, value);
	}
  
	/**
     * 验证是不是日期yyyy-MM-dd HH:mm:ss
     * 如果是符合格式的字符串,返回true,否则为false
     * @param str 要验证的字符串
     * @return
     */
    public static boolean isDateTime(String str) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(V_DATE);
    	sb.append(" ");
    	sb.append(V_TIME);
//        String regex = V_DATE + " " + V_TIME;
    	String regex = sb.toString();
        return match(regex, str);
    }
	
    /** 
     * 验证是不是邮箱地址 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isEmail(String value) {
		return match(V_EMAIL, value);
	}
  
    /** 
     * 验证是不是浮点数 
     * @param value 要验证的字符串 
     * @return  如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isFloat(String value) {
		return isFloat(value, NumberTypeEnnm.ALL, null);
	}
	/** 
	 * 验证是不是浮点数 
	 * @param value 要验证的字符串 
	 * @return  如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
	 */  
	public static boolean isFloat(String value, Integer scale) {
		return isFloat(value, NumberTypeEnnm.ALL, scale);
	}
    /** 
     * 验证是不是负浮点数 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */
	public static boolean isNegativeFloat(String value) {
		return isFloat(value, NumberTypeEnnm.NEGATIVE, null);
	}
    /** 
     * 验证正浮点数 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */
	public static boolean isPosttiveFloat(String value) {
		return isFloat(value, NumberTypeEnnm.POSITIVE, null);
	}
	
	/**
	 * 验证是不是浮点数, scale是精确到小数位
	 * @param value 要验证的字符串
	 * @param scale 小数位
	 * @return  如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isFloat(String value, NumberTypeEnnm numberTypeEnnm, Integer scale) {
		StringBuilder sb = new StringBuilder();
		sb.append(numberTypeEnnm.getPrefix());
		sb.append(V_FLOAT_TEMPLATE);
		if(scale == null){
			sb.append("+");
		}else if(scale < 1){
			throw new UtilException("scale参数不能小于1");
		}else{
			sb.append("{").append(scale).append("}");
		}
		//scale为空,最终的正则是([+-]?)\\d+\\.\\d+
		//scale有值,最终的正则是([+-]?)\\d+\\.\\d{scale}
		String regex = sb.toString();
		return match(regex, value);
	}
	
	
//    /** 
//     * 验证非正浮点数 
//     * @param value 要验证的字符串 
//     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
//     */  
//	public static boolean Un_negative_float(String value) {
//		return match(V_UN_NEGATIVE_FLOAT, value);
//	}
//  
//    /** 
//     * 验证非负浮点数 
//     * @param value 要验证的字符串 
//     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
//     */  
//	public static boolean Unpositive_float(String value) {
//		return match(V_UNPOSITIVE_FLOAT, value);
//	}
	
    /** 
     * 验证是不是正确的身份证号码 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */
	public static boolean isIDcard(String value) {
		return match(V_IDCARD, value);
	}
  
    /** 
     * 验证是不是正确的IP地址 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */
	public static boolean isIP4(String value) {
		return match(V_IP4, value);
	}
  
    /** 
     * 验证是不是字母 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */
	public static boolean isLetter(String value) {
		return match(V_LETTER, value);
	}
  
    /** 
     * 验证是不是小写字母 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */
	public static boolean isLowerLetter(String value) {
		return match(V_LETTER_I, value);
	}
  
  
    /** 
     * 验证是不是大写字母 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isUpperLetter(String value) {
		return match(V_LETTER_U, value);
	}
  
  
    /** 
     * 验证是不是手机号码 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean isMobilePhone(String value) {
		return match(V_MOBILE_PHONE, value);
	}
  
    /** 
     * 验证非空 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
//	public static boolean isNotEmpty(String value) {
//		return match(V_NOTEMPTY, value);
//	}
  
    /** 
     * 验证密码的长度(6~18位) 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean checkCodeLength(String value) {
		return match(V_PASSWORD_LENGTH, value);
	}
  
    /** 
     * 验证密码(数字和英文同时存在) 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean passwordReg(String value) {
		return match(V_PASSWORD_REG, value);
	}
  
    /** 
     * 验证图片 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean picture(String value) {
		return match(V_PICTURE, value);
	}
  
    /** 
     * 验证QQ号码 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean QQnumber(String value) {
		return match(V_QQ_NUMBER, value);
	}
  
    /** 
     * 验证压缩文件 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Rar(String value) {
		return match(V_RAR, value);
	}
  
    /** 
     * 验证电话 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Tel(String value) {
		return match(V_TEL_PHONE, value);
	}
  

  
    /** 
     * 验证URL 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Url(String value) {
		return match(V_URL, value);
	}
  
    /** 
     * 验证用户注册。匹配由数字、26个英文字母或者下划线组成的字符串 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean UserName(String value) {
		return match(V_USERNAME, value);
	}
  
    /** 
     * 验证邮编 
     * @param value 要验证的字符串 
     * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b> 
     */  
	public static boolean Zipcode(String value) {
		return match(V_ZIPCODE, value);
	}
	
	/**
	 * 匹配含key的方法，格式是/../key* 或 ../key*
	 * 如 user/get*; /user/get*的方法
	 * 
	 * @param key
	 * @param str
	 * @return
	 */
	public static boolean matchMethod(String key, String str) {
		String regex = "\\/?\\w+/" + key + "\\w*";
		return match(regex, str);
	}
	
	/**
	 * 匹配含regexKey分隔符的字符串
	 * 
	 * <pre>
	 * regexKey为"," str为"x1,x2"	 	 返回true
	 * regexKey为"," str为"x1,x2,"	 返回fasle
	 * regexKey为"," str为"x1"  		 返回true
	 * </pre>
	 * 
	 * @param regexKey
	 * @param str
	 * @return
	 */
	public static boolean matchRegex(String regexKey, String str) {
		StringBuilder sb = new StringBuilder();
		sb.append("\\w+(\\" + regexKey + "\\w+)*");
		//regexKey为空 \\w+
		//regexKey不为空 \\w+(\\" + regexKey + "\\w+)+
		String regex = sb.toString();
		return match(regex, str);
	}
  
    /**
     * @param regex 正则表达式字符串 
     * @param str 要匹配的字符串 
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false; 
     */  
	public static boolean match(String regex, String str) {
		//有推荐说不要在方法内这样使用Pattern
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(str);
//		return matcher.matches();
		//第2种 其底层是与第一种一样
		return Pattern.matches(regex, str);
//		//第3种String的方法, 其底层是Pattern.matches(regex, this);
//		return str.matches(regex);
	}
	
}
