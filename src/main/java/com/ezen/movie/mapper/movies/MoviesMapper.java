package com.ezen.movie.mapper.movies;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.movies.MoviesDTO;

@Mapper
public interface MoviesMapper {
	

	/**
	 * @Desc: 현재 상영중인 영화 목록과, total 값을 가져온다
	 * */
	List<MoviesDTO> selectMovie();

	MoviesDTO selectOneMovie(MoviesDTO dto);
	
}