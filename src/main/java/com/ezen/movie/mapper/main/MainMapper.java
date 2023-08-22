package com.ezen.movie.mapper.main;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.main.MainDTO;

@Mapper
public interface MainMapper {
	
	List<MainDTO> selectMenu();
	
}
