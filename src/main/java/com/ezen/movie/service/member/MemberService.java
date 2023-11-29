package com.ezen.movie.service.member;

import java.util.Map;

public interface MemberService {
	
	// 아이디 중복체크 여부
	public boolean getDoubleChk(MemberDTO dto);

	// 일반 회원가입
	public void join(MemberDTO dto);

	// 로그인
    public MemberDTO login(MemberDTO dto);

	// 카카오 접근 토큰가져오기
    public String getKakaoAccessToken(String code);
	// 유저 정보 가져오기
	public MemberDTO getOne(MemberDTO memberDTO);
	// 카카오에서 유저 정보 가져오기
	public Map<String, Object> getKakaoUserInfo(String accessToken);

	// 카카오로 회원가입
	public void kakaoJoin(MemberDTO memberDTO);
}
