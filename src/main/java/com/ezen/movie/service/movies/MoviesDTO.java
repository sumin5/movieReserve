package com.ezen.movie.service.movies;

import org.apache.ibatis.type.Alias;


@Alias("moviesDTO")
public class MoviesDTO {
	
	private String movieNameHngl;
	private String movieNameEng;
	private String openingDate;
	private String movieRate;
	private String genre;
	private String movieCountry;
	private String runningTime;
	private String movieDistributor;
	private String movieInfo;
	public MoviesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MoviesDTO(String movieNameHngl, String movieNameEng, String openingDate, String movieRate, String genre,
			String movieCountry, String runningTime, String movieDistributor, String movieInfo) {
		super();
		this.movieNameHngl = movieNameHngl;
		this.movieNameEng = movieNameEng;
		this.openingDate = openingDate;
		this.movieRate = movieRate;
		this.genre = genre;
		this.movieCountry = movieCountry;
		this.runningTime = runningTime;
		this.movieDistributor = movieDistributor;
		this.movieInfo = movieInfo;
	}
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
	public String getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
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
	
}
