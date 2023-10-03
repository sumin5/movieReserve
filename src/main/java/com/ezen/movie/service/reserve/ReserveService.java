package com.ezen.movie.service.reserve;

import java.util.List;
import java.util.Map;

import com.ezen.movie.service.movies.MoviesDTO;

public interface ReserveService {
	
	List<ReserveDTO> menuList();

	/**
	 * @Desc: 영화 시간표를 가져온다 
	 */
	List<Map<String, Object>> getTimetable(MoviesDTO dto);
}
