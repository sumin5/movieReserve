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
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.reserve.ReserveService;

@Controller
@RequestMapping("/reserve")
public class ReserveController extends AbstractController{
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReserveService reserveService;
	
	@GetMapping("/selectPage")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/reserve/selectPage");
		List<MoviesDTO> movieList = movieService.movieList();
		
		if(!isNull(movieList)) {
			mav.addObject("initIdx",movieList.get(0).getMovieIdx());
		}
		
		mav.addObject("movieList", movieList);
		return mav;
		
	}
	
	
	@ResponseBody
	@PostMapping("/getTimetable")
	public AjaxResVO<?> getTimetable(MoviesDTO dto) throws ValueException{
		
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(!(dto.getMovieIdx() > 0) || isNull(dto.getWildCard())) {
				throw new ValueException("잘못된 접근 경로입니다.");
			}
			
			
			List<Map<String, Object>> timetable = reserveService.getTimetable(dto);
			
			
			data = new AjaxResVO<>(AJAXPASS, "",timetable);
			
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
