package com.ezen.movie.controller.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.AjaxResVO;
import com.ezen.movie.comm.MemberUtil;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.config.EmailService;
import com.ezen.movie.service.member.MailDTO;
import com.ezen.movie.service.member.MemberDTO;
import com.ezen.movie.service.member.MemberService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController extends AbstractController{
	

	@Autowired
	private EmailService emailService;	//이메일서비스
	
	@Autowired
	private MemberService memberService;
	
	@Value("${kakao.jsAppKey}")
	private String jsAppKey; 
	
	@Value("${kakao.redirectUri}")
	private String redirectUri;
	
	@GetMapping("/loginForm")
	public ModelAndView loginForm() {

		ModelAndView mav = new ModelAndView("/member/login");

		if(MemberUtil.isLogin()){
			mav = new ModelAndView("redirect:/main");
		}
		
		mav.addObject("redirectUri",redirectUri);
		mav.addObject("jsAppKey",jsAppKey);
		
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
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(dto == null) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}

			memberService.join(dto);
			
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

	@PostMapping("/login")
	@ResponseBody
	public AjaxResVO<?> login(HttpServletRequest request, MemberDTO dto) throws Exception {

		AjaxResVO<?> data = new AjaxResVO<>();

		try {

			if(dto == null) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}

			MemberDTO member = memberService.login(dto);

			String msg = "";
			if(member == null) {
				msg = "로그인 실패";
				data = new AjaxResVO<>(AJAXFAIL,msg);

			}else{
				msg = "로그인 성공";
				HttpSession session = request.getSession();
				session.setAttribute("user",new Gson().toJson(member));
				data = new AjaxResVO<>(AJAXPASS,msg);

			}


		} catch (ValueException e) {
			e.getMessage();
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		}

		return data;

	}

	@GetMapping("/logOut")
	public ModelAndView logout( HttpServletRequest request ) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/main");
	}

	@ResponseBody
	@GetMapping("/login/kakao")
	public ModelAndView loginKakao(HttpServletRequest request,@RequestParam(required = false) String code){

		ModelAndView mav = null;
		HttpSession session = request.getSession();

		String accessToken = memberService.getKakaoAccessToken(code);

		if(accessToken != null && !"".equals(accessToken)){

			Map<String,Object> userInfo = memberService.getKakaoUserInfo(accessToken);
			MemberDTO memberPrm = new MemberDTO();
			String memberId = "KA-"+userInfo.get("id");
			memberPrm.setMemberId(memberId);
			// member 가져오기
			MemberDTO member = memberService.getOne(memberPrm);

			// 회원가입
			if(member == null) {

				MemberDTO memberDTO = new MemberDTO();

				memberDTO.setMemberId(memberId);
				memberDTO.setMemberName((String)userInfo.get("nickname"));
				memberDTO.setEmail((String)userInfo.get("email"));
				memberDTO.setMemberGender((String)userInfo.get("gender"));
				memberDTO.setKakaoIdGb("Y");

				memberService.kakaoJoin(memberDTO);

				session.setAttribute("user",new Gson().toJson(memberDTO));

			}else { // 로그인
				session.setAttribute("user",new Gson().toJson(member));
			}

			mav = new ModelAndView("redirect:/main");

		}

		return mav;

	}


}