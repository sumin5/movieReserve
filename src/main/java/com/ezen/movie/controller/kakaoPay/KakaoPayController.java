package com.ezen.movie.controller.kakaoPay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.service.kakao.KakaoApproveResponse;
import com.ezen.movie.service.kakao.KakaoPayResponse;
import com.ezen.movie.service.kakao.KakaoPayService;
import com.ezen.movie.service.kakao.KakaoReadyResponse;

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

        return kakaoPayService.kakaoPayReady(kakao);
    }
    
    /**
     * 결제 성공
     */
    @GetMapping("/success")
    public ResponseEntity afterPayRequest(@RequestParam("pg_token") String pgToken) throws ValueException{

        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);

        return new ResponseEntity<>(kakaoApprove, HttpStatus.OK);
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