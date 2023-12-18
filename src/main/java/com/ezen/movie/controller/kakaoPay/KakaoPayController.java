package com.ezen.movie.controller.kakaoPay;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.service.kakao.KakaoApproveResponse;
import com.ezen.movie.service.kakao.KakaoPayResponse;
import com.ezen.movie.service.kakao.KakaoPayService;
import com.ezen.movie.service.kakao.KakaoReadyResponse;
import com.ezen.movie.service.purchase.PurchaseDetailDTO;
import com.ezen.movie.service.purchase.PurchaseInfoDTO;
import com.ezen.movie.service.purchase.PurchaseService;
import com.ezen.movie.service.reserve.ReserveDTO;
import com.ezen.movie.service.reserve.ReserveService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
@RequestMapping("/pay")
public class KakaoPayController extends AbstractController{
	
	@Autowired
	private KakaoPayService kakaoPayService;
	@Autowired
	private ReserveService reserveService;
	@Autowired
	private PurchaseService purchaseService;
	
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
    @SuppressWarnings("unchecked")
	@GetMapping("/success")
    public ModelAndView afterPayRequest(@RequestParam("pg_token") String pgToken) throws ValueException{
    	
        KakaoApproveResponse kakaoApprove = kakaoPayService.approveResponse(pgToken);
        TransactionStatus status = getTransactionStatus();
        try {
        	Type type = new TypeToken<Map<String,Object>>(){}.getType();
            
            Map<String,Object> itemCodeMap = new HashMap<>();
            itemCodeMap = new Gson().fromJson(kakaoApprove.getItem_code(),type);
            
            // 예약확정처리
            if(itemCodeMap.get("seatList") != null && itemCodeMap.get("screenIdx") != null && itemCodeMap.get("timetableIdx") != null) {
            	ReserveDTO reserveDTO = new ReserveDTO();
            	reserveDTO.setScreenIdx((int)Double.parseDouble(String.valueOf(itemCodeMap.get("screenIdx")))); 
            	reserveDTO.setTimetableIdx((int)Double.parseDouble(String.valueOf(itemCodeMap.get("timetableIdx"))));
            	reserveDTO.setSeatList((List<String>) itemCodeMap.get("seatList"));
            	List<ReserveDTO> rList = reserveService.getList(reserveDTO);
            	if(!isNull(rList)) {
            		
            		List<Integer> SeatReserveList = new ArrayList<>();
            		for(ReserveDTO dto : rList) {
            			SeatReserveList.add(dto.getSeatReserveIdx());
            		}
            		
            		reserveService.reserveUpdate(SeatReserveList);
            	}
            }
            
            // 구매내역 테이블에 넣기
            if(kakaoApprove.getPartner_order_id() != null && itemCodeMap.get("productList") != null 
            		&& kakaoApprove.getPartner_user_id() != null && !(kakaoApprove.getAmount().getTotal() < 0) 
            		&& kakaoApprove.getTid() != null) 
            {
            	PurchaseInfoDTO purchaseInfoDTO = new PurchaseInfoDTO();
                purchaseInfoDTO.setPurchaseInfoIdx(kakaoApprove.getPartner_order_id());
                purchaseInfoDTO.setTotalPrice(kakaoApprove.getAmount().getTotal());
                purchaseInfoDTO.setMemberId(kakaoApprove.getPartner_user_id());
                purchaseInfoDTO.setTid(kakaoApprove.getTid());

                purchaseService.infoInsert(purchaseInfoDTO);
                //구매내역 디테일 테이블 넣기
                PurchaseDetailDTO purchaseDetailDTO = new PurchaseDetailDTO();
    			purchaseDetailDTO.setProductList((List<Integer>)itemCodeMap.get("productList"));
    			purchaseDetailDTO.setPurchaseInfoIdx(purchaseInfoDTO.getPurchaseInfoIdx());
    			
    			purchaseService.detailInsert(purchaseDetailDTO);
    			tManager.commit(status);
            }
            
        } catch (Exception e) {
        	tManager.rollback(status);
        	// 환불처리 진행
        	e.printStackTrace();
		}
        
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