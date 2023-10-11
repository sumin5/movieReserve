package com.ezen.movie.service.movies;

import java.util.List;
import java.util.Map;

public interface MovieService {
	
	//영화 리스트 가져오기
	List<MoviesDTO> movieList();

	//영화 상세보기
	MoviesDTO getOne(MoviesDTO dto);

	//영화 자동 삭제
	void AutoDelete();
	

}
