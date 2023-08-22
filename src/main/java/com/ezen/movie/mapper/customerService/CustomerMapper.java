package com.ezen.movie.mapper.customerService;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.customerService.CustomerDTO;

@Mapper
public interface CustomerMapper {
	
	List<CustomerDTO> selectMenu();
	
}
