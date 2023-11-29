package com.ezen.movie.comm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.CollectionUtils;

public abstract class AbstractController {

	@Autowired
	protected PlatformTransactionManager tManager;

	public static final String AJAXPASS = "00"; // AJax 성공 코드
	public static final String AJAXFAIL = "01"; // AJax 실패 코드
	
	// string 널체크
	public boolean isNull(String str) {
		
		 return str == null || str.isBlank();
		 
	}
	
	
	// list 널 체크
	public boolean isNull(List<?> list) {
		
		return CollectionUtils.isEmpty(list);
		
	}

	/**
	 * 트랜잭션 status 객체
	 * @return
	 */
	protected TransactionStatus getTransactionStatus(){
		return tManager.getTransaction(new DefaultTransactionDefinition());
	}
}
