package com.ezen.movie.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.test.MenuDTO;

@Mapper
public interface TestMapper {
	
	List<MenuDTO> selectMenu();
	
}
