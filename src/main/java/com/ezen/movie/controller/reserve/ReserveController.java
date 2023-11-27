package com.ezen.movie.controller.reserve;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.AjaxResVO;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.mapper.file.FileMapper;
import com.ezen.movie.service.file.FileDTO;
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.reserve.ReserveDTO;
import com.ezen.movie.service.reserve.ReserveService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/reserve")
public class ReserveController extends AbstractController{
	
	/*DI*/
	@Autowired
	private MovieService movieService;
	@Autowired
	private ReserveService reserveService;
	@Autowired
	private FileMapper fileMapper;
	
	/*상수*/
	final static String TABLEGB = "MOVIES";
	
	@GetMapping("/selectPage")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/reserve/selectPage");
		List<MoviesDTO> movieList = movieService.movieList();
		for(int i=0 ; i<movieList.size() ; i ++) {
			
		}
		
		if(!isNull(movieList)) {
			mav.addObject("initIdx",movieList.get(0).getMovieIdx());
		}
		
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
			System.out.println("new Gson().toJson(seatList) = " + new Gson().toJson(seatList));
			mav.addObject("seatList",seatList);

		} catch (ValueException e) {
			mav = new ModelAndView("/reserve/selectPage");
		}

		return mav;
	}
	
	@GetMapping("/selectSeat")
	public ModelAndView selectSeat() {
		
		ModelAndView mav = new ModelAndView("/reserve/selectSeat");
		List<MoviesDTO> movieList = movieService.movieList();
		for(int i=0 ; i<movieList.size() ; i ++) {
			
		}

		/*
		Type listType = new TypeToken<List<CouponContentVO>>() {
		}.getType();
		List<CouponContentVO> subList = new Gson().fromJson(contlist, listType);
		 */

		if(!isNull(movieList)) {
			mav.addObject("initIdx",movieList.get(0).getMovieIdx());
		}
		
		mav.addObject("movieList", movieList);
		return mav;
		
	}

	@ResponseBody
	@PostMapping("/reserve")
	public AjaxResVO<?> reserve(ReserveDTO dto,@RequestParam("seatList") String seatList) throws ValueException{

		AjaxResVO<?> data = new AjaxResVO<>();

		try {


			if(isNull(seatList) && (dto.getScreenIdx() < 0)){
				throw new ValueException("잘못된 접근입니다");
			}

			Type listType = new TypeToken<List<String >>() {
			}.getType();
			List<String> seatList1 = new Gson().fromJson(seatList, listType);

			//data = new AjaxResVO<>(AJAXPASS, "",timetable);

		} catch (ValueException e) {
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		}

		return data;

	}

}