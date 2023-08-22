package com.ezen.movie.mapper.theaters;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.theaters.TheatersDTO;

@Mapper
public interface TheatersMapper {
	
	List<TheatersDTO> selectMenu();
	
}
