package com.ezen.movie.mapper.file;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.movie.service.file.FileDTO;

@Mapper
public interface FileMapper {
	// 영화 리스트에 영화 대표이미지 가져오기
	public FileDTO getOne(FileDTO vo);
	//스틸 컷 가져오기
	public List<FileDTO> getList(FileDTO vo);
	//영화 상세보기의 영화 대표이미지 가져오기
	public FileDTO getTop(FileDTO vo);
	//메인 페이지에 영화 대표이미지리스트 가져오기
	public List<FileDTO> getListMain(FileDTO vo);

}
