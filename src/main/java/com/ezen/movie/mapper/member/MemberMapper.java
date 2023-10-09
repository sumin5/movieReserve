package com.ezen.movie.mapper.member;

import org.apache.ibatis.annotations.Mapper;

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
	 * 메일 인증
	 * 
	 */
	public void sendMail(String to);
	
}
