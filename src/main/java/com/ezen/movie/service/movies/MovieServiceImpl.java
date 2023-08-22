package com.ezen.movie.service.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.movies.MoviesMapper;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MoviesMapper moviesMapper;

	@Override
	public List<MoviesDTO> menuList() {
		
		return moviesMapper.selectMenu();
	}

}
