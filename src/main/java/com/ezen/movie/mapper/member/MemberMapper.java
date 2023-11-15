package com.ezen.movie.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.member.MailDTO;
import com.ezen.movie.service.member.MemberDTO;

@Mapper
public interface MemberMapper {

	/**
	 * 아이디 중복체크
	 * @param dto
	 * @return
	 */
	public int getDoubleChk(MemberDTO dto);
	
	/**
	 * 메일 인증 저장
	 * 
	 */
	public void sendMail(MailDTO dto);

	/**
	 * 메일 인증 확인
	 * @param dto
	 * @return
	 */
	public int authCheck(MailDTO dto);

	/**
	 * 일반회원가입
	 * @param dto
	 */
	public void join(MemberDTO dto);
	
}
