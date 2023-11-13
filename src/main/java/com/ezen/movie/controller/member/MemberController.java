package com.ezen.movie.controller.member;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.AjaxResVO;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.config.EmailService;
import com.ezen.movie.service.member.MailDTO;
import com.ezen.movie.service.member.MemberDTO;
import com.ezen.movie.service.member.MemberService;
import com.ezen.movie.service.store.StoreService;

@Controller
@RequestMapping("/member")
public class MemberController extends AbstractController{
	

	@Autowired
	private EmailService emailService;	//이메일서비스
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/loginForm")
	public ModelAndView loginForm() {
		
		ModelAndView mav = new ModelAndView("/member/login");
		return mav;
		
	}
	
	@GetMapping("/joinForm")
	public ModelAndView joinForm() {
		
		ModelAndView mav = new ModelAndView("/member/join");
		return mav;
		
	}
	
	/**
	 * 아이디 중복 체크
	 * @param dto
	 * @return
	 * @throws ValueException
	 */
	@ResponseBody
	@PostMapping("/doubleChk")
	public AjaxResVO<?> doubleChk(MemberDTO dto) throws ValueException{
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(isNull(dto.getMemberId())) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}
			
			boolean flag = memberService.getDoubleChk(dto);
			String msg = "";
			
			if(flag) {
				throw new ValueException("이미 있는 계정입니다.");
			}
			msg = "없는 계정입니다.";
			
			data = new AjaxResVO<>(AJAXPASS, msg);
			
		} catch (ValueException e) {
			e.getMessage();
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		} 
		
		return data;
		
	}

	//인증 메일 발송
	@PostMapping("/mailAuthSend")
	@ResponseBody
    public AjaxResVO<?> mailConfirm(@RequestParam String email) throws Exception {
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(isNull(email)) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}

	        String code = emailService.sendSimpleMessage(email);
	        
	        MailDTO dto = new MailDTO();
	        dto.setAuthNum(code);
			emailService.sendMail(dto);
			
			data = new AjaxResVO<>(AJAXPASS,"메일을 확인해주세요.",dto.getAuthId());
			
		} catch (ValueException e) {
			e.getMessage();
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		} 
		
		return data;
		
    }
	
	//인증 메일 확인
	@PostMapping("/mailAuthCheck")
	@ResponseBody
    public AjaxResVO<?> mailAuthCheck(MailDTO dto) throws Exception {
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(dto == null) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}

			boolean flag = emailService.authCheck(dto);
			String msg = "인증에 실패하였습니다.";
			
			if(flag) {
				msg = "인증이 완료되었습니다.";
			}
			data = new AjaxResVO<>(AJAXPASS,msg);
			
		} catch (ValueException e) {
			e.getMessage();
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		} 
		
		return data;
		
    }
	
	@PostMapping("/join")
	@ResponseBody
    public AjaxResVO<?> join(MemberDTO dto) throws Exception {
		
		
	
		/*
		 * String asd = "yemawoo"; int a = asd.indexOf("ye"); System.err.println(a);
		 * asd=asd.substring(a+1); System.err.println("asd ? " + asd);
		 */
		
		String [] babbling = {"aya", "yee", "u", "maa", "yemawoowoaya"};
		int answer = 0;
		String[] ok = {"aya","ye","woo","ma"};
		int bigInt = 0; 
		for(String str : babbling) { //5번 루프
			
			for(int i=0; i<ok.length; i++) {
				System.err.println((i+1)+ "번쨰");
				System.err.println("포문 str ? " + str);
				System.err.println("포문 answser? " + ok[i]);
				if( str.contains(ok[i]) ) {
					/*
					 * int idx = str.indexOf(answers[i]);
					 * 
					 * 
					 * System.err.println("idx ? " +idx);
					 */
					str = str.replace(ok[i], "/");
					
					
					System.err.println("str ?" + str);
					
				}
				
			}
		
			int aCount = str.length() - str.replace("/", "").length();
			if(str=="/") {
				answer+= 1;
			}
			
		}
		answer = bigInt;
		System.err.println(answer);
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(dto == null) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}

			//memberService.join(dto);
			
			data = new AjaxResVO<>(AJAXPASS,"회원가입에 성공하였습니다.");
			
		} catch (ValueException e) {
			e.getMessage();
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		} 
		
		return data;
		
    }

}