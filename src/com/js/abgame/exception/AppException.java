package com.js.abgame.exception;
/**
 * 自定义系统异常类
 * @author Abeni
 *
 */
public class AppException extends Exception {
	//
	private int code;//编码
	private String msg;//信息
	/**
	 * 有参构造函数
	 * @param code
	 * @param msg
	 */
	public AppException(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
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
