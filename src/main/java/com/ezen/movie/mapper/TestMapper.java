package com.ezen.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.MenuDTO;

@Mapper
public interface TestMapper {
	
	List<MenuDTO> selectMenu();
	
}
