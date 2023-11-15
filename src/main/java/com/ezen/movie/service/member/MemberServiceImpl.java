package com.ezen.movie.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.member.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean getDoubleChk(MemberDTO dto) {
		return memberMapper.getDoubleChk(dto) > 0; 
	}

	@Override
	public void join(MemberDTO dto) {
		memberMapper.join(dto);
		
	}

}
