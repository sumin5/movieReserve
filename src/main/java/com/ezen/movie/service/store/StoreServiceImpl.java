package com.ezen.movie.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.customerService.CustomerMapper;
import com.ezen.movie.mapper.store.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public List<StoreDTO> popdrinkList() {
		return storeMapper.selectPopAndDrink();
	}

}
