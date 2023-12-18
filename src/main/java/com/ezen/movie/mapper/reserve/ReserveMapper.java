package com.ezen.movie.mapper.reserve;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.movies.MoviesDTO;
import com.ezen.movie.service.reserve.ReserveDTO;

@Mapper
public interface ReserveMapper {

	/**
	 * @Desc: 영화 시간표를 가져온다 
	 */
	public List<Map<String, Object>> getTimetable(MoviesDTO dto);

	/**
	 * @Desc: 시트 불러오기
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
	 * 좌석 업데이트전 예약있는지 판단
	 * @param reserveDTO
	 * @return
	 */
	public List<ReserveDTO> getList(ReserveDTO reserveDTO);

	/**
	 * 예약좌석 확정
	 * @param rList
	 */
	public void reserveUpdate(List<Integer> seatReserveList);
}
