package com.ezen.movie.mapper.store;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.store.StoreDTO;

@Mapper
public interface StoreMapper {

	List<StoreDTO> selectPopAndDrink();
}
