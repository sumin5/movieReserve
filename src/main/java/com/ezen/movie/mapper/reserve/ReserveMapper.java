package com.ezen.movie.mapper.reserve;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.reserve.ReserveDTO;

@Mapper
public interface ReserveMapper {
	
	List<ReserveDTO> selectMenu();
	
}
