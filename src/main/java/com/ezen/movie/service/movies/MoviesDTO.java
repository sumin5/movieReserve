package com.ezen.movie.service.movies;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;


@Alias("moviesDTO")
public class MoviesDTO extends CommDTO{
	
	private String movieNameHngl;
	private String movieNameEng;
	private String openingDt;
	private String movieRate;
	private String genre;
	private String movieCountry;
	private String runningTime;
	private String movieDistributor;
	private String movieInfo;
	private int movieIdx;
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
	
}
