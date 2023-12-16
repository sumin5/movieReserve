package com.ezen.movie.mapper.product;

import java.util.List;

import com.ezen.movie.service.product.ProductDTO;


public interface ProductMapper {

	public List<ProductDTO> getList(ProductDTO dto);

	public ProductDTO getOne(Integer integer);

}
