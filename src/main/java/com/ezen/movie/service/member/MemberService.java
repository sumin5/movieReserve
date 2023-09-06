package com.ezen.movie.service.member;

public interface MemberService {
	
	// 아이디 중복체크 여부
	public boolean getDoubleChk(MemberDTO dto);

}
