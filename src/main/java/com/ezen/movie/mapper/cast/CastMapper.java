package com.ezen.movie.mapper.cast;

import java.util.List;

import com.ezen.movie.service.cast.CastDTO;

public interface CastMapper {

	public CastDTO getOne(CastDTO cast);
	
	public List<CastDTO> getList();
}
