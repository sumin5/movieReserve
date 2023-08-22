package com.ezen.movie.service.reserve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.customerService.CustomerMapper;
import com.ezen.movie.mapper.reserve.ReserveMapper;

@Service
public class ReserveServiceImpl implements ReserveService {
	@Autowired
	private ReserveMapper reserveMapper;

	@Override
	public List<ReserveDTO> menuList() {
		
		return reserveMapper.selectMenu();
	}

}
