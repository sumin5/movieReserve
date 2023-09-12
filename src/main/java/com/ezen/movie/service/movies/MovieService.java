package com.ezen.movie.service.movies;

import java.util.List;

public interface MovieService {
	
	List<MoviesDTO> menuList();
	
	List<MoviesDTO> movieList();

	MoviesDTO getOne(MoviesDTO dto);
}
