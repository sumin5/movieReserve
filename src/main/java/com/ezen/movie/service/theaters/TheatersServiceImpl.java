package com.ezen.movie.service.theaters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.customerService.CustomerMapper;
import com.ezen.movie.mapper.theaters.TheatersMapper;

@Service
public class TheatersServiceImpl implements TheatersService {
	@Autowired
	private TheatersMapper theatersMapper;

	@Override
	public List<TheatersDTO> menuList() {
		
		return theatersMapper.selectMenu();
	}

}
