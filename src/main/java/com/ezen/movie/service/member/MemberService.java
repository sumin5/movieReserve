package com.ezen.movie.service.member;

public interface MemberService {
	
	// 아이디 중복체크 여부
	public boolean getDoubleChk(MemberDTO dto);

	// 일반 회원가입
	public void join(MemberDTO dto);

}
