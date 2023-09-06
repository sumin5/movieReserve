package com.ezen.movie.service.store;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

import lombok.Getter;
import lombok.Setter;

@Alias("storeDTO")
public class StoreDTO extends CommDTO{
	
	private int productIdx;
	private String productGb;
	private String productName;
	private String productPrice;
	private String productInfo;
	
	public int getProductIdx() {
		return productIdx;
	}
	public void setProductIdx(int productIdx) {
		this.productIdx = productIdx;
	}
	public String getProductGb() {
		return productGb;
	}
	public void setProductGb(String productGb) {
		this.productGb = productGb;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	
}
