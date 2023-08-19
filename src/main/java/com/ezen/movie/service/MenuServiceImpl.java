package com.ezen.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.TestMapper;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private TestMapper testMapper;

	@Override
	public List<MenuDTO> menuList() {
		
		return testMapper.selectMenu();
	}

}
