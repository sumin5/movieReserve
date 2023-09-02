package com.ezen.movie.mapper.movies;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.movies.MoviesDTO;

@Mapper
public interface MoviesMapper {
	
	List<MoviesDTO> selectMenu();

	List<MoviesDTO> selectMovie();
	
}
