package com.ezen.movie.service.person;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

@Alias ("personDTO")
public class PersonDTO extends CommDTO{

	private int persionIdx;
	private String personNameHngl;
	private String personNameEng;
	private String personCountry;
	private String gender;
	private String birthDt;
	private String height;
	private String debutDt;
	private String debutMovie;
	private int movieIdx;
	public int getPersionIdx() {
		return persionIdx;
	}
	public void setPersionIdx(int persionIdx) {
		this.persionIdx = persionIdx;
	}
	public String getPersonNameHngl() {
		return personNameHngl;
	}
	public void setPersonNameHngl(String personNameHngl) {
		this.personNameHngl = personNameHngl;
	}
	public String getPersonNameEng() {
		return personNameEng;
	}
	public void setPersonNameEng(String personNameEng) {
		this.personNameEng = personNameEng;
	}
	public String getPersonCountry() {
		return personCountry;
	}
	public void setPersonCountry(String personCountry) {
		this.personCountry = personCountry;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDt() {
		return birthDt;
	}
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDebutDt() {
		return debutDt;
	}
	public void setDebutDt(String debutDt) {
		this.debutDt = debutDt;
	}
	public String getDebutMovie() {
		return debutMovie;
	}
	public void setDebutMovie(String debutMovie) {
		this.debutMovie = debutMovie;
	}
	public int getMovieIdx() {
		return movieIdx;
	}
	public void setMovieIdx(int movieIdx) {
		this.movieIdx = movieIdx;
	}
	
}
