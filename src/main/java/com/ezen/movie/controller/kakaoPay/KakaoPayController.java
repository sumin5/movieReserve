package com.ezen.movie.controller.kakaoPay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.HttpUtil;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.service.kakao.KakaoApproveResponse;
import com.ezen.movie.service.kakao.KakaoPayResponse;
import com.ezen.movie.service.kakao.KakaoPayService;
import com.ezen.movie.service.kakao.KakaoReadyResponse;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/pay")
public class KakaoPayController extends AbstractController{
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	  /**
     * 결제요청
     */
    @PostMapping("/ready")
    public KakaoReadyResponse readyToKakaoPay(KakaoPayResponse kakao) {
    	
    	Map<String,String> map = new HashMap<>();
        return kakaoPayService.kakaoPayReady(map);
    }
    
    /**
     * 결제 성공
     */
    @GetMapping("/success")
    public ModelAndView afterPayRequest(@RequestParam("pg_token") String pgToken) throws ValueException{

    	HttpServletRequest request = HttpUtil.getRequest();
    	HttpSession session = request.getSession();
    
        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);
        System.err.println("여기");
        return new ModelAndView("/main/main");
    }

    /**
     * 결제 진행 중 취소
     */
    @GetMapping("/cancel")
    public void cancel() throws ValueException{

        throw new ValueException("취소");
    }

    /**
     * 결제 실패
     * @throws ValueException 
     */
    @GetMapping("/fail")
    public void fail() throws ValueException {

        throw new ValueException("실패");
    }

}