package com.ezen.movie.service.movies;

import java.util.List;
import java.util.Map;

public interface MovieService {
	
	List<MoviesDTO> menuList();

	/**
	 * @Desc: 현재 상영중인 영화 목록과, total 값을 가져온다
	 * */
	List<MoviesDTO> movieList();

	MoviesDTO getOne(MoviesDTO dto);
	

}
