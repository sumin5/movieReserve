package com.ezen.movie.controller.reserve;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ezen.movie.comm.MemberUtil;
import com.ezen.movie.service.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.AjaxResVO;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.service.file.FileDTO;
import com.ezen.movie.service.kakao.KakaoPayService;
import com.ezen.movie.service.kakao.KakaoReadyResponse;
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.product.ProductDTO;
import com.ezen.movie.service.product.ProductService;
import com.ezen.movie.service.purchase.PurchaseDetailDTO;
import com.ezen.movie.service.purchase.PurchaseInfoDTO;
import com.ezen.movie.service.purchase.PurchaseService;
import com.ezen.movie.service.reserve.ReserveDTO;
import com.ezen.movie.service.reserve.ReserveService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/reserve")
public class ReserveController extends AbstractController{
	
	/*DI*/
	@Autowired
	private MovieService movieService;
	@Autowired
	private ReserveService reserveService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private KakaoPayService kakaoPayService;
	
	/*상수*/
	final static String TABLEGB = "MOVIES";
	
	@GetMapping("/selectPage")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/reserve/selectPage");
		List<MoviesDTO> movieList = movieService.movieList();
		
		ProductDTO productDto = new ProductDTO();
		productDto.setProductGb("T");
		List<ProductDTO> pList = productService.getList(productDto);
		
		if(!isNull(movieList)) {
			mav.addObject("initIdx",movieList.get(0).getMovieIdx());
		}
		
		mav.addObject("pList",pList);
		mav.addObject("movieList", movieList);
		return mav;
		
	}
	
	
	@ResponseBody
	@PostMapping("/getTimetable")
	public AjaxResVO<?> getTimetable(MoviesDTO dto) throws ValueException{
		
		/*테스트용 콘솔 찍어보기*/
		System.out.println("getTimetable 컨트롤러 들어옴");
		System.out.println(new Gson().toJson(dto));
		/********끝********/
		
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(isNull(dto.getWildCard())) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}
			
			FileDTO file = new FileDTO();
			file.setTableGb(TABLEGB);
			dto.setFileDTO2(file);
			
			/*영화시간표 정보 가져오기*/
			List<Map<String, Object>> timetable = reserveService.getTimetable(dto);
			
			/*테스트용 콘솔 찍어보기*/
			for(int i=0 ; i<timetable.size() ; i++) {
				System.out.println(timetable.get(i));
			}
			/********끝********/
			
			data = new AjaxResVO<>(AJAXPASS, "",timetable);
			
		} catch (ValueException e) {
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		} 
		
		return data;
		
	}
	
	/**
	 * @DESC : 좌석 불러오기
	 * @param dto
	 * @return
	 */
	@ResponseBody
	@PostMapping("/seatLoad")
	public ModelAndView seatLoad(ReserveDTO dto) {

		ModelAndView mav = new ModelAndView("/reserve/seatType/Aseat");

		try{
			if(dto.getScreenIdx() < 0 && dto.getTimetableIdx() < 0){
				throw new ValueException("잘못된 접근입니다.");
			}

			List<ReserveDTO> seatLists = reserveService.getSeatLoad(dto);

			List<List<ReserveDTO>> seatList = Lists.partition(seatLists, 12);
			
			mav.addObject("seatList",seatList);

		} catch (ValueException e) {
			mav = new ModelAndView("/reserve/selectPage");
		}

		return mav;
	}

	/**
	 * @DESC : 예약하기
	 * @param dto
	 * @param seatList
	 * @return
	 * @throws ValueException
	 */
	@ResponseBody
	@PostMapping("/insert2")
	public AjaxResVO<?> insert2(ReserveDTO dto,@RequestParam("seatArray") String seatArray,@RequestParam("productArray") String productArray,
			@RequestParam("price") int price) throws ValueException{

		TransactionStatus status = getTransactionStatus();
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			MemberDTO member = MemberUtil.getMember();

			dto.setMemberId(member.getMemberId());

			if(isNull(seatArray) && (dto.getScreenIdx() < 0)){
				throw new ValueException("잘못된 접근입니다");
			}

			Type listType = new TypeToken<List<String>>() {
			}.getType();
			Type intListType = new TypeToken<List<Integer>>() {
			}.getType();
			List<String> seatList = new Gson().fromJson(seatArray, listType);
			
			List<Integer> productList = new Gson().fromJson(productArray, intListType);
			
			dto.setSeatList(seatList);
			
			reserveService.insert(dto);
			
			// 구매내역 테이블 상위에 넣기
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDDHHmmss");
			
			String nowTime = simpleDateFormat.format(System.currentTimeMillis());
			
			String purchaceDetailIdx = dto.getMemberId() + nowTime;
			
			PurchaseInfoDTO purchaseInfoDTO = new PurchaseInfoDTO();
			purchaseInfoDTO.setPurchaseInfoIdx(purchaceDetailIdx);
			purchaseInfoDTO.setTotalPrice(price);
			purchaseInfoDTO.setMemberId(member.getMemberId());
			
			purchaseService.infoInsert(purchaseInfoDTO);
			// 구매내역 테이블 하위 넣기
			
			PurchaseDetailDTO purchaseDetailDTO = new PurchaseDetailDTO();
			purchaseDetailDTO.setProductList(productList);
			purchaseDetailDTO.setPurchaseInfoIdx(purchaseInfoDTO.getPurchaseInfoIdx());
			
			purchaseService.detailInsert(purchaseDetailDTO);
			
			tManager.commit(status);
			
			
			data = new AjaxResVO<>(AJAXPASS, "예약이 완료되었습니다");

		} catch (ValueException e) {
			tManager.rollback(status);
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			tManager.rollback(status);
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		}

		return data;

	}
	
	/**
	 * @DESC : 예약하기
	 * @param dto
	 * @param seatList
	 * @return
	 * @throws ValueException
	 */
	@ResponseBody
	@PostMapping("/insert")
	public KakaoReadyResponse insert(ReserveDTO dto,@RequestParam("seatArray") String seatArray,@RequestParam("productArray") String productArray,
			@RequestParam("price") int price) throws ValueException{

		TransactionStatus status = getTransactionStatus();
		KakaoReadyResponse data = new KakaoReadyResponse();
		
		try {
			MemberDTO member = MemberUtil.getMember();

			dto.setMemberId(member.getMemberId());

			if(isNull(seatArray) && (dto.getScreenIdx() < 0)){
				throw new ValueException("잘못된 접근입니다");
			}

			Type listType = new TypeToken<List<String>>() {
			}.getType();
			Type intListType = new TypeToken<List<Integer>>() {
			}.getType();
			List<String> seatList = new Gson().fromJson(seatArray, listType);
			// 보류 
			List<Integer> productList = new Gson().fromJson(productArray, intListType);
			
			dto.setSeatList(seatList);
			
			reserveService.insert(dto);
			
			// 구매내역 테이블 상위에 넣기
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDDHHmmss");
			
			String nowTime = simpleDateFormat.format(System.currentTimeMillis());
			
			String purchaceDetailIdx = dto.getMemberId() + nowTime;
			
			Map<String,Object> strJsonMap = new HashMap<>();
			Map<String,String> map = new HashMap<>();
			
			map.put("partner_order_id", purchaceDetailIdx);
			map.put("partner_user_id", dto.getMemberId());
			map.put("item_name", "영화티켓");
			strJsonMap.put("productList", productList);
			strJsonMap.put("screenIdx", dto.getScreenIdx());
			strJsonMap.put("timetableIdx", dto.getTimetableIdx());
			strJsonMap.put("seatList",seatList);
			
			String strJson = new Gson().toJson(strJsonMap);
			
			map.put("item_code",strJson);
			map.put("quantity", Integer.toString(productList.size()));
			map.put("total_amount", Integer.toString(price));
			map.put("tax_free_amount", Integer.toString((int) (price*0.9)));
			
			data = kakaoPayService.kakaoPayReady(map);
			data.setAjaxCode(AJAXPASS);
			tManager.commit(status);
			

		} catch (ValueException e) {
			tManager.rollback(status);
			data = new KakaoReadyResponse(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			tManager.rollback(status);
			e.printStackTrace();
			data = new KakaoReadyResponse(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		}

		return data;

	}

}