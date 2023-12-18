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

	/**
	 * 예약좌석 업데이트 하기전 예약되어있는지 확인
	 * @param reserveDTO
	 * @return
	 */
	public List<ReserveDTO> getList(ReserveDTO reserveDTO);

	/**
	 * 예약좌석확정
	 * @param seatReserveList
	 */
	public void reserveUpdate(List<Integer> seatReserveList);
}
