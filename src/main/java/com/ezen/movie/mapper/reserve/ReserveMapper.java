package com.ezen.movie.mapper.reserve;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.reserve.ReserveDTO;

@Mapper
public interface ReserveMapper {

	List<ReserveDTO> selectMenu();
	
	
	/**
	 * @Desc: 영화 시간표를 가져온다 
	 */
	List<Map<String, Object>> getTimetable(MoviesDTO dto);
}
