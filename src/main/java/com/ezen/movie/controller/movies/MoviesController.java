package com.ezen.movie.controller.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.mapper.cast.CastMapper;
import com.ezen.movie.mapper.file.FileMapper;
import com.ezen.movie.mapper.person.PersonMapper;
import com.ezen.movie.service.cast.CastDTO;
import com.ezen.movie.service.file.FileDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.person.PersonDTO;

@Controller
@RequestMapping("/movies")
public class MoviesController extends AbstractController{
	
	@Autowired
	private MainService menuService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private FileMapper fileMapper;
	@Autowired
	private CastMapper castMapper;
	@Autowired
	private PersonMapper personMapper;
	
	
	
	//영화 리스트 
	@GetMapping("/movieList")
	public ModelAndView movieList() {
		ModelAndView mav = new ModelAndView("/movies/movieList");
			List<MoviesDTO> movieList = movieService.movieList();
				
			if(!isNull(movieList)){
				
//				for(int i=0; i<movieList.size(); i++) {
//					
//					FileDTO file = new FileDTO();
//					file.setTableIdx(movieList.get(i).getMovieIdx());
//					file.setTableGb("movies");
//					
//					file = fileMapper.getOne(file);
//					
//					
//					movieList.get(i).setObChild(file);
//				}
				
				for (MoviesDTO moviesDTO : movieList) {
					
					FileDTO file = new FileDTO();
					file.setTableIdx(moviesDTO.getMovieIdx());
					file.setTableGb("movies");
					
					file = fileMapper.getOne(file);
					
//					Map<String, Object> map = new HashMap<>();
//					map.put("file",file);
//					moviesDTO.setChild(map);
					
					moviesDTO.setObChild(file);
				}
			}
//			if(isNull(movieList)) {
//				
//				for(MoviesDTO movieDTO  : movieList) {
//					FileDTO fileList = new FileDTO();
//					fileList.setTableIdx(movieDTO.getMovieIdx());
//					mav.addObject("fileList", fileList);
//				}
//			}
			mav.addObject("movieList",movieList);
		return mav;
	}
	
	//영화 상세정보
	@GetMapping("/movieDetail")
	public ModelAndView movieDetail(MoviesDTO dto) {
		ModelAndView mav = new ModelAndView("/movies/movieDetail");
		
		MoviesDTO movieDetail = movieService.getOne(dto);
		
		FileDTO  vo = new FileDTO();
		vo.setTableGb("movies");
		vo.setTableIdx(movieDetail.getMovieIdx());
		
		System.out.println("asdf" + vo.getTableIdx());
		List<FileDTO> file = fileMapper.getList(vo);
		List<PersonDTO> person = personMapper.getList();
		PersonDTO ps = personMapper.getOne();
		System.out.println("asfdas" + ps);
		//file.setTableIdx(movieDetail.getMovieIdx());
		//file.setTableGb("movies");
		movieDetail.setFileDTO(file);
		movieDetail.setPersonOne(ps);
		movieDetail.setObChild(ps);
		// 이렇게 참조하는 방법도 있음.
		movieDetail.setPersonDTO(person);
		mav.addObject("movieDetail", movieDetail);
		return mav;
	}

	
}
