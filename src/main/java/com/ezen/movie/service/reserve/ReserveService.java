package com.ezen.movie.service.reserve;

import java.util.List;
import java.util.Map;

import com.ezen.movie.service.movies.MoviesDTO;

public interface ReserveService {

	/**
	 * @Desc: 영화 시간표를 가져온다 
	 */
	public List<Map<String, Object>> getTimetable(MoviesDTO dto);

	/**
	 * @Desc : 시트 불러오기
	 * @param dto
	 * @return
	 */
	public List<ReserveDTO> getSeatLoad(ReserveDTO dto);

	/**
	 * @Desc : 영화예약하기
	 * @param dto
	 */
	public void insert(ReserveDTO dto);
}
