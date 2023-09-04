package com.ezen.movie.comm;


public class AjaxResVO<T> {

	private String code;	// 코드명
	private String msg;		// 메세지
	private T data;			// 데이터
	
	public AjaxResVO(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public AjaxResVO(String code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
