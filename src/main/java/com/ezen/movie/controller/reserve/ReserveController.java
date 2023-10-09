package com.ezen.movie.controller.reserve;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.AjaxResVO;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.mapper.file.FileMapper;
import com.ezen.movie.service.file.FileDTO;
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;
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
	
}
