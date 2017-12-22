package com.shuframework.jdk7.enums;

/**
 * 异常编码枚举
 * 100-199 用于指定客户端应相应的某些动作。
 * 200-299 用于表示请求成功。
 * 300-399 用于已经移动的文件并且常被包含在定位头信息中指定新的地址信息。
 * 400-499 用于指出客户端的错误。
 * 500-599 用于支持服务器错误。
 * 
 * @author shu
 *
 */
public enum ExceptionCodeEnum {

	/**
	 * 4xx 现在有的编码是400-417,421-426,449,451
	 * 为了不冲突，现在的编码从46x 到49x，并扩展到5位。
	 * 
	 */
	PARAMETER_ERROR(46101, "参数错误"), 
	NOTEXIST_ERROR(46401, "不存在的信息错误"),
	unknown_error(56101, "未知错误");
	

	private int code;
	private String msg;

	ExceptionCodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	// private ExceptionCodeEnum(int code, String msg) {
	// this.code = code;
	// this.msg = msg;
	// }

	/**
	 * 通过code 获得枚举对象
	 * 
	 * @param code
	 * @return
	 */
	public ExceptionCodeEnum getEnumByCode(int code) {
		for (ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()) {
			if (exceptionCodeEnum.getCode() == code) {
				return exceptionCodeEnum;
			}
		}
		throw new IllegalArgumentException("No element matches " + code);
	}

	/**
	 * 通过code 获得msg
	 * 
	 * @param code
	 * @return
	 */
	public String getMsgByCode(int code) {
		for (ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()) {
			if (exceptionCodeEnum.getCode() == code) {
				return exceptionCodeEnum.getMsg();
			}
		}
		throw new IllegalArgumentException("No element matches " + code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
