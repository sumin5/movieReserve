package com.ezen.movie.service.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ezen.movie.service.file.FileDTO;

public interface MovieService {
	
	//영화 리스트 가져오기
	List<MoviesDTO> movieList();

	//영화 상세보기
	MoviesDTO getOne(MoviesDTO dto);

	//영화 자동 삭제
	void AutoDelete();

	//영화 등록
	void movieThumbNailInsert(FileDTO dto,MultipartFile file) throws Exception;

	void movieInsert(MoviesDTO mDto);

	void movieStillCutInsert(FileDTO dto, MultipartFile[] files) throws Exception;
	
	int selectMaxMovieIdx() throws Exception;
	

}
