package com.bigdata.ssm.exceptions;

/**
 * @Title:CustomException
 * @Description:自定义的异常类
 * @author:Rainbow.huahang.com
 * @date:2016年10月6日 下午6:32:14
 */
public class CustomException extends Exception {
	/**
	 * uuid
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public CustomException() {
	}

	public CustomException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
