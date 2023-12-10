package com.ezen.movie.mapper.purchase;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.purchase.PurchaseDetailDTO;
import com.ezen.movie.service.purchase.PurchaseInfoDTO;
import com.ezen.movie.service.theaters.TheatersDTO;

@Mapper
public interface PurchaseMapper {

	/**
	 * 구매내역 insert (상위 테이블)
	 * @param purchaseInfoDTO
	 */
	public void infoInsert(PurchaseInfoDTO purchaseInfoDTO);
	
	/**
	 * 구매내역 insert (하위 테이블)
	 * @param purchaseDetailDTO
	 */
	public void detailInsert(PurchaseDetailDTO purchaseDetailDTO);
	

	
}
