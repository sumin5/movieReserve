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
	
    public KakaoReadyResponse kakaoPayReady(KakaoPayResponse kakaoPay) {
    	
    	
    	HttpServletRequest request = HttpUtil.getRequest();
    	
    	String path = HttpUtil.getRequest().getScheme()+"://"+HttpUtil.getRequest().getServerName()+":"+HttpUtil.getRequest().getServerPort();
    	
    	// 카카오페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
		/*
		 * parameters.add("partner_order_id", kakaoPay.getPartner_order_id());
		 * parameters.add("partner_user_id", kakaoPay.getPartner_user_id());
		 * parameters.add("item_name", kakaoPay.getItem_name()); // todo
		 * parameters.add("quantity", kakaoPay.getQuantity());
		 * parameters.add("total_amount",kakaoPay.getAmount().getTotal());
		 * parameters.add("tax_free_amount", kakaoPay.getAmount().getTax_free());
		 */
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("item_name", "상품명");
        parameters.add("quantity", "1");
        parameters.add("total_amount", "5000");
        parameters.add("vat_amount", "500");
        parameters.add("item_code", "{\r\n"
        		+ "  \"product\": \"Item123\",\r\n"
        		+ "  \"quantity\": 2,\r\n"
        		+ "  \"amount\": 30000\r\n"
        		+ "}");
        parameters.add("tax_free_amount", "500");
        parameters.add("approval_url", path + "/pay/success"); // 성공 시 redirect url
        parameters.add("cancel_url", path + "/pay/cancle"); // 취소 시 redirect url
        parameters.add("fail_url", path + "/pay/fail"); // 실패 시 redirect url
        HttpSession session = request.getSession();
        session.setAttribute("tumin", 123);
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
    
        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
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
