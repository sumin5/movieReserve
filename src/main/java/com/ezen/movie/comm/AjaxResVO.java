package com.ezen.movie.comm;


public class AjaxResVO {
	
	private int gb;		// 구분
	private String msg;		// 메세지
	private Object data;	// 데이터
	
	public AjaxResVO(int gb, String msg) {
		super();
		this.gb = gb;
		this.msg = msg;
	}
	
	
	public AjaxResVO(int gb, String msg, Object data) {
		super();
		this.gb = gb;
		this.msg = msg;
		this.data = data;
	}

	public int getGb() {
		return gb;
	}
	public void setGb(int gb) {
		this.gb = gb;
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
	
	
	
	
	
	
}
