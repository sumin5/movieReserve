package com.ezen.movie.controller.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.movie.comm.AbstractController;
import com.ezen.movie.service.main.MainDTO;
import com.ezen.movie.service.main.MainService;
import com.ezen.movie.service.movies.MovieService;
import com.ezen.movie.service.movies.MoviesDTO;

@Controller
@RequestMapping("/movies")
public class MoviesController extends AbstractController{
	
	@Autowired
	private MainService menuService;
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movieList")
	public ModelAndView movieList() {
		ModelAndView mav = new ModelAndView("/movies/movieList");
			List<MoviesDTO> movieList = movieService.movieList();
			mav.addObject("movieList",movieList);
		return mav;
	}
	
	@GetMapping("/movieDetail")
	public ModelAndView movieDetail() {
		ModelAndView mav = new ModelAndView("/movies/movieDetail");
		return mav;
	}

}
