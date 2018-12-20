package com.shuframework.jdkutil.enums;

/**
 * 分隔符类型的枚举
 * 
 * @author shu
 *
 */
public enum SeparatorTypeEnum {

	COMMA(",", "逗号"),
	POINT(".", "点"),
	UNDERLINE("_", "下划线"),
	BLANK(" ", "空格");

	//	private Integer code;
	private String value;
	private String desc;//description

	SeparatorTypeEnum(String value, String desc) {
//		this.code = code;
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}

}
