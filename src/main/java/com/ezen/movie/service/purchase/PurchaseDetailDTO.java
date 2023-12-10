package com.ezen.movie.service.purchase;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

@Alias("purchaseDetailDTO")
public class PurchaseDetailDTO extends CommDTO{
	
	private int purchaseDetailIdx;	// 구매내역Idx
	private int productIdx;			// 상품내역Idx
	private String purchaseInfoIdx; // 상품정보내역Idx
	
	private List<Integer> productList; // 상품내역Idx 리스트
	
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
	public List<Integer> getProductList() {
		return productList;
	}
	public void setProductList(List<Integer> productList) {
		this.productList = productList;
	}	
	
	
}
