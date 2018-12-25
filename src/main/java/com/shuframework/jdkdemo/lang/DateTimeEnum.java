package com.shuframework.jdkdemo.lang;

public enum DateTimeEnum {
	
	YEAR("年"), MONTH("月"), DAY("表示天而已没其他意思"), DAY_OF_MONTH("该天是月份的第几天"), DAY_OF_YEAR("该天是一年的第几天"), DAY_OF_WEEK("该天是星期几"),
	WEEK_OF_YEAR("该年的第几周"),
	HOUR("时(12小时制)"), HOUR24("时(24小时制)"), MINUTE("分钟"), SECOND("秒"), MILLISECOND("毫秒");
	
	private String desc;

	private DateTimeEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
}
