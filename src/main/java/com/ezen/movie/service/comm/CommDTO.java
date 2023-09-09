package com.ezen.movie.service.comm;

import java.util.HashMap;

public class CommDTO {
	
	private String createDt;	// 생성일
	private String changeDt;	// 변경일
	private String endDt;		// 종료일
	private String wildCard;	// 와일드카드
	private HashMap<String, Object> child;	// 자식요소
	private boolean flag;		// 여부
	
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
	public String getWildCard() {
		return wildCard;
	}
	public void setWildCard(String wildCard) {
		this.wildCard = wildCard;
	}
	public HashMap<String, Object> getChild() {
		return child;
	}
	public void setChild(HashMap<String, Object> child) {
		this.child = child;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
