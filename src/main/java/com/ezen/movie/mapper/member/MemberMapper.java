package com.ezen.movie.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.member.MailDTO;
import com.ezen.movie.service.member.MemberDTO;

@Mapper
public interface MemberMapper {

	/**
	 * @DESC: 아이디 중복체크
	 * @param dto
	 * @return
	 */
	public int getDoubleChk(MemberDTO dto);
	
	/**
	 * @DESC: 메일 인증 저장
	 * 
	 */
	public void sendMail(MailDTO dto);

	/**
	 * @DESC: 메일 인증 확인
	 * @param dto
	 * @return
	 */
	public int authCheck(MailDTO dto);

	/**
	 * @DESC: 일반회원가입
	 * @param dto
	 */
	public void join(MemberDTO dto);

	/**
	 * @DESC: 로그인
	 */
    public MemberDTO login(MemberDTO dto);

	/**
	 * @DESC : 계정 정보가져오기
	 * @param memberId
	 * @return
	 */
    public MemberDTO getOne(MemberDTO memberDTO);

	/**
	 * @DESC : 카카오로 회원가입하기
	 * @param memberDTO
	 */
	public void kakaoJoin(MemberDTO memberDTO);
}
