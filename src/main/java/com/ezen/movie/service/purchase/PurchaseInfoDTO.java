package com.ezen.movie.service.purchase;

import java.util.List;

import com.ezen.movie.service.comm.CommDTO;

public class PurchaseInfoDTO extends CommDTO{
	
	private int purchaseInfoIdx;	// 구매정보내역인덱스
	private String memberId;		// 회원IDX
	private int totalPrice;			// 총합가격
	
	private List<PurchaseDetailDTO> detailList ;	// 상세리스트

	public int getPurchaseInfoIdx() {
		return purchaseInfoIdx;
	}

	public void setPurchaseInfoIdx(int purchaseInfoIdx) {
		this.purchaseInfoIdx = purchaseInfoIdx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
