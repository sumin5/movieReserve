package com.ezen.movie.service.product;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

/**
 * 상품
 * @author osn92
 *
 */
@Alias("productDTO")
public class ProductDTO extends CommDTO{
	
	private int productIdx;			//상품 인덱스
	private String productGb;		//상품 구분
	private String productName;		//상품 이름
	private String productPrice;	//상품 가격
	private String productInfo;		//상품 설명
	
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
