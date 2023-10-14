package com.ezen.movie.service.member;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

@Alias("mailDTO")
public class MailDTO extends CommDTO{
	
	private int authId;			// 메일_idx
	private String createDt;	// 생성일
	private String changeDt;	// 변경일
	private String endDt;		// 종료일
	private String authNum;		// 인증번호
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getChangeDt() {
		return changeDt;
	}
	public void setChangeDt(String changeDt) {
		this.changeDt = changeDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getAuthNum() {
		return authNum;
	}
	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}
	

	
}
