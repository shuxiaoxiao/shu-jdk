package com.shuframework.jdkutil.enums;

/**
 * id生成器的业务类型
 * 
 * @author shu
 *
 */
public enum IdGeneratorTypeEnum {

	ORDER("10", "订单"),
	FILE("20", "文件"),
	PAY("30", "支付交易单")
	;
	
	private String code;
	private String msg;

	IdGeneratorTypeEnum(String code, String msg) {
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
