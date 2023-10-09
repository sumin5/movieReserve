package com.ezen.movie.service.movies;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.cast.CastDTO;
import com.ezen.movie.service.comm.CommDTO;
import com.ezen.movie.service.file.FileDTO;
import com.ezen.movie.service.person.PersonDTO;


@Alias("moviesDTO")
public class MoviesDTO extends CommDTO{
	
	private String movieNameHngl;	//영화명 한글
	private String movieNameEng;	//영화명 영어
	private String openingDt;		//개봉일
	private String movieRate;		//영화등급
	private String genre;			//장르
	private String movieCountry;	//국가
	private String runningTime;		//러닝타임
	private String movieDistributor;	//배급
	private String movieInfo;			//영화소개
	private int movieIdx;			// 영화IDx
	private int timetableIdx; 		// 시간표IDX
	private CastDTO castDTO;
	private PersonDTO personOne;
	private List<PersonDTO> personDTO;
	private List<FileDTO> fileDTO;
	private FileDTO fileDTO2;
	
	public String getMovieNameHngl() {
		return movieNameHngl;
	}
	public void setMovieNameHngl(String movieNameHngl) {
		this.movieNameHngl = movieNameHngl;
	}
	public String getMovieNameEng() {
		return movieNameEng;
	}
	public void setMovieNameEng(String movieNameEng) {
		this.movieNameEng = movieNameEng;
	}
	public String getOpeningDt() {
		return openingDt;
	}
	public void setOpeningDt(String openingDt) {
		this.openingDt = openingDt;
	}
	public String getMovieRate() {
		return movieRate;
	}
	public void setMovieRate(String movieRate) {
		this.movieRate = movieRate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMovieCountry() {
		return movieCountry;
	}
	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public String getMovieDistributor() {
		return movieDistributor;
	}
	public void setMovieDistributor(String movieDistributor) {
		this.movieDistributor = movieDistributor;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public int getMovieIdx() {
		return movieIdx;
	}
	public void setMovieIdx(int movieIdx) {
		this.movieIdx = movieIdx;
	}
	public CastDTO getCastDTO() {
		return castDTO;
	}
	public void setCastDTO(CastDTO castDTO) {
		this.castDTO = castDTO;
	}
	public PersonDTO getPersonOne() {
		return personOne;
	}
	public void setPersonOne(PersonDTO personOne) {
		this.personOne = personOne;
	}
	public List<PersonDTO> getPersonDTO() {
		return personDTO;
	}
	public void setPersonDTO(List<PersonDTO> personDTO) {
		this.personDTO = personDTO;
	}
	public List<FileDTO> getFileDTO() {
		return fileDTO;
	}
	public void setFileDTO(List<FileDTO> fileDTO) {
		this.fileDTO = fileDTO;
	}
	public FileDTO getFileDTO2() {
		return fileDTO2;
	}
	public void setFileDTO2(FileDTO fileDTO2) {
		this.fileDTO2 = fileDTO2;
	}
	public int getTimetableIdx() {
		return timetableIdx;
	}
	public void setTimetableIdx(int timetableIdx) {
		this.timetableIdx = timetableIdx;
	}
	
	
}
