package com.ezen.movie.comm;

import java.util.List;

import org.springframework.util.CollectionUtils;

public class AbstractController {
	
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
	
}
