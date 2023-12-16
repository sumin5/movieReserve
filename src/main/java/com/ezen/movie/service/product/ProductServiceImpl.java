package com.ezen.movie.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.movie.mapper.product.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<ProductDTO> getList(ProductDTO dto) {
		return productMapper.getList(dto);
	}

	@Override
	public ProductDTO getOne(Integer integer) {
		return productMapper.getOne(integer);
		
	}

}
