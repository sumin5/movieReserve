package com.ezen.movie.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.customerService.CustomerMapper;
import com.ezen.movie.mapper.main.MainMapper;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	private MainMapper mainMapper;

	@Override
	public List<MainDTO> menuList() {
		
		return mainMapper.selectMenu();
	}

}
