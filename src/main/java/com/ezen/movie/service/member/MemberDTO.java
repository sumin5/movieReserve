package com.ezen.movie.service.member;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

@Alias("memberDTO")
public class MemberDTO extends CommDTO{
	
	private String memberId;	// 회원Idx
	private String password;	// 패스워드
	private String memberName;	// 회원이름
	private String memberPhone;	// 회원폰번호
	private String email;		// 회원메일
	private String marketingYn;	// 마케팅수신여부
	private String smsYn;		// sms수신여부
	private String emailYn;		// 이메일수신여부
	private String naverIdGb;	// 네이버메일구분
	private String memberGb;	// 구분
	private String authNum;		// 인증번호
	private String memberGender;// 성별
	
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMarketingYn() {
		return marketingYn;
	}
	public void setMarketingYn(String marketingYn) {
		this.marketingYn = marketingYn;
	}
	public String getSmsYn() {
		return smsYn;
	}
	public void setSmsYn(String smsYn) {
		this.smsYn = smsYn;
	}
	public String getEmailYn() {
		return emailYn;
	}
	public void setEmailYn(String emailYn) {
		this.emailYn = emailYn;
	}
	public String getNaverIdGb() {
		return naverIdGb;
	}
	public void setNaverIdGb(String naverIdGb) {
		this.naverIdGb = naverIdGb;
	}
	public String getMemberGb() {
		return memberGb;
	}
	public void setMemberGb(String memberGb) {
		this.memberGb = memberGb;
	}
	public String getAuthNum() {
		return authNum;
	}
	public void setAuthNum(String authNum) {
		this.authNum = authNum;
	}

	
}
