package com.ezen.movie.config;

import java.io.UnsupportedEncodingException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface EmailService {
	
	
	public MimeMessage createMessage(String to)throws MessagingException, UnsupportedEncodingException;
	
	public String createKey();
	
	public String sendSimpleMessage(String to)throws Exception;
	
	// DB에 인증번호 등록
	public void sendMail(String to);
}
