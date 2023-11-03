package com.ezen.movie.service.movies;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.movie.mapper.movies.MoviesMapper;
import com.ezen.movie.service.file.FileDTO;

@Service
public class MovieServiceImpl implements MovieService {
	
	private final SqlSessionFactory SessionFactory;
	
	public MovieServiceImpl(SqlSessionFactory SessionFactory) {
		this.SessionFactory = SessionFactory;
	}
	
	@Autowired
	private MoviesMapper moviesMapper;

	//영화 리스트 가져오기
	@Override
	public List<MoviesDTO> movieList() {
		return moviesMapper.selectMovie();
	}
	
	//영화 상세보기
	@Override
	public MoviesDTO getOne(MoviesDTO dto) {
		
		return moviesMapper.selectOneMovie(dto);
	}
	
	//영화 자동 삭제
	//@Scheduled(cron = "0 0 0 1 * ?") 
	//매월 1일 자정에 작동
	@Override
	public void AutoDelete() {
		FileDTO dto  = new FileDTO();
		dto.setTableGb("movies");
		
		moviesMapper.AutoDelete(dto);
	}
	
	@Override
	public void movieInsert(FileDTO dto,MultipartFile file) throws Exception {
		
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";

		String fileName = file.getOriginalFilename();
		
		File saveFile = new File(path , fileName);
		
		if(saveFile.exists()) {
			UUID uuid = UUID.randomUUID();
			fileName = uuid + "_" + file.getOriginalFilename();
			saveFile = new File(path,fileName);
		}
	
		file.transferTo(saveFile);
	
		if(dto.getPathGb()) {
			dto.setFileTopName(fileName);
			dto.setFileTopPath("/files/" + fileName);
		} else {
			dto.setFileName(fileName);
			dto.setFilePath("/files/" + fileName);
		}
		
		moviesMapper.movieInsert(dto);
	}
}
