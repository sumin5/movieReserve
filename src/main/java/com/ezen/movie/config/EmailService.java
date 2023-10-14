package com.ezen.movie.config;

import java.io.UnsupportedEncodingException;

import com.ezen.movie.service.member.MailDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface EmailService {
	
	
	public MimeMessage createMessage(String to)throws MessagingException, UnsupportedEncodingException;
	
	public String createKey();
	
	public String sendSimpleMessage(String to)throws Exception;
	
	/**
	 * DB에 인증 저장
	 * @param dto
	 */
	public void sendMail(MailDTO dto);

	/**
	 * 이메일 인증확인
	 * @param dto
	 * @return 
	 */
	public boolean authCheck(MailDTO dto);
}
