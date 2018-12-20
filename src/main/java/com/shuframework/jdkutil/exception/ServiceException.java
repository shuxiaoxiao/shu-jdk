package com.shuframework.jdkutil.exception;

/**
 * 服务（业务）的异常
 *
 * @author shuheng
 *
 */
public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = -1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	
	/**
	 * 原方法是 同步方法，性能低
	 * 	public synchronized Throwable fillInStackTrace()
	 * 
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
	
}
