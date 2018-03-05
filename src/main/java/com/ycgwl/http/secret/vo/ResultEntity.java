package com.ycgwl.http.secret.vo;

import java.io.Serializable;

/**
 * 
 * @Description: aili框架核心处理和基本支持
 * @author sys
 * @date 2015年3月11日 上午10:05:24
 * 
 */
public class ResultEntity implements Serializable {
	private static final long serialVersionUID = -5207285996548676020L;

	private boolean success = true;
	private String msg;
	private Object data;
	private String stackTrace;
	private String code = "0";

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ResultEntity [success=" + success + ", msg=" + msg + ", data=" + data + ", stackTrace=" + stackTrace
				+ ", errorCode=" + code + "]";
	}
}
