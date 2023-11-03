package com.ezen.movie.controller.movies;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.comm.AjaxResVO;
import com.ezen.movie.comm.ValueException;
import com.ezen.movie.mapper.cast.CastMapper;
import com.ezen.movie.mapper.file.FileMapper;
import com.ezen.movie.mapper.person.PersonMapper;
import com.ezen.movie.service.file.FileDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.person.PersonDTO;
import com.google.gson.Gson;

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
		
		FileDTO list = new FileDTO();
		FileDTO getOne = new FileDTO();
		
		PersonDTO onePerson = new PersonDTO();
		PersonDTO listPerson = new PersonDTO();
		
		onePerson.setWildCard("감독");
		onePerson.setMovieIdx(movieDetail.getMovieIdx());
		listPerson.setWildCard("주연");
		listPerson.setMovieIdx(movieDetail.getMovieIdx());
		
		getOne.setTableGb("movies");
		getOne.setTableIdx(movieDetail.getMovieIdx());
		list.setTableGb("movies");
		list.setTableIdx(movieDetail.getMovieIdx());
		
		List<FileDTO> file = fileMapper.getList(list);
		
		FileDTO getTop = fileMapper.getTop(getOne);
		List<PersonDTO> person = personMapper.getList(listPerson);
		PersonDTO ps = personMapper.getOne(onePerson);
		System.out.println("testss" + person);
		System.out.println("aaaa"+ps);
		//file.setTableIdx(movieDetail.getMovieIdx());
		//file.setTableGb("movies");
		movieDetail.setFileDTO2(getTop);
		movieDetail.setFileDTO(file);
		movieDetail.setPersonOne(ps);
		movieDetail.setObChild(ps);
		// 이렇게 참조하는 방법도 있음.
		movieDetail.setPersonDTO(person);
		mav.addObject("movieDetail", movieDetail);
		return mav;
	}

	@GetMapping("/movieRegister")
	public ModelAndView movieRegister() {
		ModelAndView mav = new ModelAndView("/movies/movieRegister");
		 
		return mav;
	}
	
	/*
	 * @PostMapping("/upload") public String movieInsert(MultipartFile file,FileDTO
	 * dto,Model model) throws Exception {
	 * 
	 * dto.setTableIdx(1); dto.setPathGb(true); movieService.movieInsert(dto,file);
	 * 
	 * model.addAttribute("message", "등록되었습니다.");
	 * model.addAttribute("movieList","/movieList"); return "message"; }
	 */
	
	@ResponseBody
	@PostMapping("/upload")
	public AjaxResVO<?> getTimetable(MultipartFile file, FileDTO dto) throws ValueException{
	
		AjaxResVO<?> data = new AjaxResVO<>();
		
		try {
			
			if(isNull(file.getOriginalFilename())) {
				throw new ValueException("정상적인 접근이 아닙니다.");
			}
			
			dto.setTableIdx(1);
			dto.setPathGb(true);
			movieService.movieInsert(dto,file);
			
			String msg = "등록되었습니다";
			
			data = new AjaxResVO<>(AJAXPASS, msg);
			
		} catch (ValueException e) {
			data = new AjaxResVO<>(AJAXFAIL, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			data = new AjaxResVO<>(AJAXFAIL, "오류로 인하여 실패하였습니다.");
		} 
		
		return data;
		
	}
	
	
	
}