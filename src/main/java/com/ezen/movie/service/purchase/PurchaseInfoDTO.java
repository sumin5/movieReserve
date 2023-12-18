package com.ezen.movie.service.purchase;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

@Alias("purchaseInfoDTO")
public class PurchaseInfoDTO extends CommDTO{
	
	private String purchaseInfoIdx;	// 구매정보내역인덱스
	private String memberId;		// 회원IDX
	private String tid;				// 카카오결제고유번호
	private int totalPrice;			// 총합가격
	
	private List<PurchaseDetailDTO> detailList ;	// 상세리스트

	public String getPurchaseInfoIdx() {
		return purchaseInfoIdx;
	}

	public void setPurchaseInfoIdx(String purchaseInfoIdx) {
		this.purchaseInfoIdx = purchaseInfoIdx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<PurchaseDetailDTO> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<PurchaseDetailDTO> detailList) {
		this.detailList = detailList;
	}
	
}
