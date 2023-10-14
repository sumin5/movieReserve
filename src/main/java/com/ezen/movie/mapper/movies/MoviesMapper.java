package com.ezen.movie.mapper.movies;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.movies.MoviesDTO;

@Mapper
public interface MoviesMapper {
	
	//영화 리스트 가져오기
	List<MoviesDTO> selectMovie();

	//영화 상세정보
	MoviesDTO selectOneMovie(MoviesDTO dto);

	//영화 자동 삭제
	void AutoDelete();
	
}
