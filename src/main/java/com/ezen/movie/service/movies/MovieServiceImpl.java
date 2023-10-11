package com.ezen.movie.service.movies;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.movies.MoviesMapper;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final SqlSessionFactory SessionFactory;
	
	public MovieServiceImpl(SqlSessionFactory SessionFactory) {
		this.SessionFactory = SessionFactory;
	}
	
	@Autowired
	private MoviesMapper moviesMapper;

	@Override
	public List<MoviesDTO> menuList() {
		
		return moviesMapper.selectMenu();
	}	
	
	//영화 리스트 가져오기
	@Override
	public List<MoviesDTO> movieList() {
		return moviesMapper.selectMovie();
	}
	
	//영화 상세보기
	@Override
	public MoviesDTO getOne(MoviesDTO dto) {
		
		return moviesMapper.selectOneMovie(dto);
	}
	
}
