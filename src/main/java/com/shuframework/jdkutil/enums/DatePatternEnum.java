package com.shuframework.jdkutil.enums;

/**
 * 进制的枚举
 * 
 * @author shu
 *
 */
public enum DatePatternEnum {

	YM("yyyy-MM", "年-月"),
	MD("MM-dd", "月-日"),
	YMD("yyyy-MM-dd", "年-月-日"),
	YMD_HMS("yyyy-MM-dd HH:mm:ss", "年-月-日 时:分:秒"),
	YMD_HMS_S("yyyy-MM-dd HH:mm:ss.SSS", "年-月-日 时:分:秒.毫秒"),
	YMD_("yyMMdd", "年月日(没有中间字符)"),
	YMD_HMS_("yyMMddHHmmss", "年月日时分秒(没有中间字符)"),
	YMD_HMS_S_("yyMMddHHmmssSSS", "年月日时分秒毫秒(没有中间字符)")
	;

	private String code;
	private String msg;

	DatePatternEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
