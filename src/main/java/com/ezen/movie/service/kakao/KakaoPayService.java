package com.ezen.movie.service.kakao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ezen.movie.comm.HttpUtil;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class KakaoPayService {
	
	static final String cid = "TC0ONETIME"; // 가맹점 테스트 코드
	
	@Value("${kakao.adminKey}")
	private String admin_Key; 
	
	private KakaoReadyResponse kakaoReady;
	
    public KakaoReadyResponse kakaoPayReady(Map<String,String> map) {
    	
    	HttpServletRequest request = HttpUtil.getRequest();
    	
    	String path = HttpUtil.getRequest().getScheme()+"://"+HttpUtil.getRequest().getServerName()+":"+HttpUtil.getRequest().getServerPort();
    	
    	// 카카오페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        
        HttpSession session = request.getSession();
        parameters.add("cid", cid);
        session.setAttribute("cid", cid);
		/*
		 * parameters.add("partner_order_id", kakaoPay.getPartner_order_id());
		 * parameters.add("partner_user_id", kakaoPay.getPartner_user_id());
		 * parameters.add("item_name", kakaoPay.getItem_name()); // todo
		 * parameters.add("quantity", kakaoPay.getQuantity());
		 * parameters.add("total_amount",kakaoPay.getAmount().getTotal());
		 * parameters.add("tax_free_amount", kakaoPay.getAmount().getTax_free());
		 */
        parameters.add("partner_order_id", map.get("partner_order_id"));
        session.setAttribute("partner_order_id", map.get("partner_order_id"));
        parameters.add("partner_user_id", map.get("partner_user_id"));
        session.setAttribute("partner_user_id", map.get("partner_user_id"));
        parameters.add("item_name", map.get("item_name"));
        parameters.add("quantity", map.get("quantity"));
        parameters.add("total_amount", map.get("total_amount"));
        parameters.add("tax_free_amount", map.get("tax_free_amount"));
        parameters.add("approval_url", path + "/pay/success"); // 성공 시 redirect url
        parameters.add("cancel_url", path + "/pay/cancle"); // 취소 시 redirect url
        parameters.add("fail_url", path + "/pay/fail"); // 실패 시 redirect url
        
        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        System.err.println(requestEntity);
        System.err.println("이것 ? " + new Gson().toJson(requestEntity));
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();
        
        kakaoReady = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/ready",
                requestEntity,
                KakaoReadyResponse.class);
        System.err.println(kakaoReady);
        return kakaoReady;
        
    	
    }
    
    /**
     * 결제 완료 승인
     */
    public KakaoApproveResponse approveResponse(String pgToken) {
    
    	HttpServletRequest request = HttpUtil.getRequest();
    	// 세션값 추출
    	HttpSession session = request.getSession();
    	
        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("partner_order_id", (String)session.getAttribute("partner_order_id"));
        parameters.add("partner_user_id", (String)session.getAttribute("partner_user_id"));
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();
        
        KakaoApproveResponse approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                requestEntity,
                KakaoApproveResponse.class);
                
        return approveResponse;
    }
    
    /**
     * 카카오 요구 헤더값
     */
    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_Key;

        httpHeaders.set("Authorization", auth);
        httpHeaders.set("Accept", "application/json");
        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }

}
