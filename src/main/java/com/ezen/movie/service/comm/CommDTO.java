package com.ezen.movie.service.comm;

import java.util.Map;

public class CommDTO {
	
	private String createDt;	// 생성일
	private String changeDt;	// 변경일
	private String endDt;		// 종료일
	private String wildCard;	// 와일드카드
	private Map<String, Object> child;	//자식
	private boolean flag;		// 여부
	private Object obChild;		// 자식
	private int total;			// 총합
	
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
	
	public Map<String, Object> getChild() {
		return child;
	}
	public void setChild(Map<String, Object> child) {
		this.child = child;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Object getObChild() {
		return obChild;
	}
	public void setObChild(Object obChild) {
		this.obChild = obChild;
	}
	public Object getObChild2() {
		return obChild;
	}
	public void setObChild2(Object obChild2) {
		this.obChild = obChild2;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
