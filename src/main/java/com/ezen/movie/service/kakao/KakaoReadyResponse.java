package com.ezen.movie.service.kakao;

public class KakaoReadyResponse {
	
	private String tid;					// 결제 고유 번호
	private String next_redirect_pc_url; // pc 웹일 경우 받는 결제 페이지
    private String created_at;
    private String ajaxCode;				//ajax 성공여부
    private String ajaxMsg;				//ajax 성공여부
    
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}
	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getAjaxCode() {
		return ajaxCode;
	}
	public void setAjaxCode(String ajaxCode) {
		this.ajaxCode = ajaxCode;
	}
	public String getAjaxMsg() {
		return ajaxMsg;
	}
	public void setAjaxMsg(String ajaxMsg) {
		this.ajaxMsg = ajaxMsg;
	}
	public KakaoReadyResponse() {
		super();
	}
	public KakaoReadyResponse(String ajaxCode, String ajaxMsg) {
		super();
		this.ajaxCode = ajaxCode;
		this.ajaxMsg = ajaxMsg;
	}
	
    
}
