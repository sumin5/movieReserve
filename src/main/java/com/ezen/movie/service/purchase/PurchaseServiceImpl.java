package com.ezen.movie.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.purchase.PurchaseMapper;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	PurchaseMapper purchaseMapper;
	
	/**
	 * 구매내역 insert (상위 테이블)
	 */
	@Override
	public void infoInsert(PurchaseInfoDTO purchaseInfoDTO) {
		
		purchaseMapper.infoInsert(purchaseInfoDTO);
		
		
	}

	/**
	 * 구매내역 insert(하위 테이블)
	 */
	@Override
	public void detailInsert(PurchaseDetailDTO purchaseDetailDTO) {
		
		purchaseMapper.detailInsert(purchaseDetailDTO);
		
	}

}
