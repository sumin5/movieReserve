package com.ezen.movie.service.reserve;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.customerService.CustomerMapper;
import com.ezen.movie.mapper.reserve.ReserveMapper;
import com.ezen.movie.service.movies.MoviesDTO;

@Service
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	private ReserveMapper reserveMapper;

	@Override
	public List<ReserveDTO> menuList() {
		return reserveMapper.selectMenu();
	}

	@Override
	public List<Map<String, Object>> getTimetable(MoviesDTO dto) {
//		List<Map<String, Object>> timetable = reserveMapper.getTimetable(dto);
		return reserveMapper.getTimetable(dto);
	}

	@Override
	public List<ReserveDTO> getSeatLoad(ReserveDTO dto) {
		return reserveMapper.getSeatLoad(dto);
	}

}
