package com.ezen.movie.mapper.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.file.FileDTO;

@Mapper
public interface FileMapper {
	
	public FileDTO getOne(FileDTO vo);

	public List<FileDTO> getList(FileDTO vo);
}
