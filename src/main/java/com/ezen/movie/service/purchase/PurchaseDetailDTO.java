package com.ezen.movie.service.purchase;

import com.ezen.movie.service.comm.CommDTO;

public class PurchaseDetailDTO extends CommDTO{
	
	private int purchaseDetailIdx;	// 구매내역Idx
	private int productIdx;			// 상품내역Idx
	private String purchaseInfoIdx; // 상품정보내역Idx
	
	public int getPurchaseDetailIdx() {
		return purchaseDetailIdx;
	}
	public void setPurchaseDetailIdx(int purchaseDetailIdx) {
		this.purchaseDetailIdx = purchaseDetailIdx;
	}
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getPurchaseInfoIdx() {
		return purchaseInfoIdx;
	}
	public void setPurchaseInfoIdx(String purchaseInfoIdx) {
		this.purchaseInfoIdx = purchaseInfoIdx;
	}	
	
	
}
