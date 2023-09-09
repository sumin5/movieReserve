package com.ezen.movie.mapper.file;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.file.FileDTO;

@Mapper
public interface FileMapper {
	
	public FileDTO getOne(FileDTO vo);

}
