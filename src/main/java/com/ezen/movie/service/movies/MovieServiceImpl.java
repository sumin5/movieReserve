package com.ezen.movie.service.movies;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.movie.mapper.file.FileMapper;
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
	@Autowired
	private FileMapper fileMapper;

	// 영화 리스트 가져오기
	@Override
	public List<MoviesDTO> movieList() {
		return moviesMapper.selectMovie();
	}

	// 영화 상세보기
	@Override
	public MoviesDTO getOne(MoviesDTO dto) {

		return moviesMapper.selectOneMovie(dto);
	}

	// 영화 자동 삭제
	 //@Scheduled(cron = "0 0 0 1 * ?")
	//매월 1일 자정에 작동
	@Override
	public void AutoDelete() {
		FileDTO dto = new FileDTO();
		dto.setTableGb("movies");

		moviesMapper.AutoDelete(dto);
	}

	// 영화 썸네일 등록
	@Override
	public void movieThumbNailInsert(FileDTO dto, MultipartFile file) throws Exception {
		System.err.println(dto);
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";

		String fileName = file.getOriginalFilename();

		File saveFile = new File(path, fileName);

		if (saveFile.exists()) {
			UUID uuid = UUID.randomUUID();
			fileName = uuid + "_" + file.getOriginalFilename();
			saveFile = new File(path, fileName);
		}

		file.transferTo(saveFile);

		if (dto.getPathGb()) {
			dto.setFileTopName(fileName);
			dto.setFileTopPath("/files/" + fileName);
		} else {
			dto.setFileName(fileName);
			dto.setFilePath("/files/" + fileName);
		}
		
		int tableIdx = moviesMapper.selectMaxMovieIdx();
		dto.setTableIdx(tableIdx +1);
		
		moviesMapper.movieThumbNailInsert(dto);
	}

	//영화 스틸컷
	public void movieStillCutInsert(FileDTO dto, MultipartFile[] files) throws Exception {

		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";

		System.err.println(files.length);
		
		// 썸네일의 이미지 파일들을 배열로 받아와서 for문으로 랜덤 파일이름을 하나씩 생성
		int tableIdx = moviesMapper.selectMaxMovieIdx();
		
		for (MultipartFile file : files) {
				
			FileDTO fDto = new FileDTO();
			
			//객체를 새로 생성 후 원래 저장되어있는 dto의 pathGb의 값을 넣어줌 (썸네일인지 스틸컷인지 구분해서 값을 넣기 위해)
			fDto.setPathGb(dto.getPathGb());
			String fileName = file.getOriginalFilename();
			
			File saveFile = new File(path, fileName);

			if (saveFile.exists()) {
				UUID uuid = UUID.randomUUID();
				fileName = uuid + "_" + file.getOriginalFilename();
				saveFile = new File(path, fileName);
			}

			file.transferTo(saveFile);

			if (fDto.getPathGb()) {
				fDto.setFileTopName(fileName);
				fDto.setFileTopPath("/files/" + fileName);
			} else {
				
				//dto.setFileTopPath("");
				System.err.println("여기");
				fDto.setFileName(fileName);
				fDto.setFilePath("/files/" + fileName);
			}
			
			fDto.setTableIdx(tableIdx);
			
			// 메서드를 for문 안에서  파일 개수만큼 호출
			moviesMapper.movieStillCutInsert(fDto);
		}
		
	}

	// 영화 정보 등록
	public void movieInsert(MoviesDTO mDto) {
		moviesMapper.movieInsert(mDto);
	}
	
	
	public int selectMaxMovieIdx() {
		System.out.println("asdfadfa"+moviesMapper.selectMaxMovieIdx() );
		return moviesMapper.selectMaxMovieIdx();
	}

}
