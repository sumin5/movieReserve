package com.ezen.movie.service.cast;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;

@Alias("castDTO")
public class CastDTO extends CommDTO {

	private int movieIdx;
	private int persionIdx;
	private String role;
	private String cast_gb;
	public int getMovieIdx() {
		return movieIdx;
	}
	public void setMovieIdx(int movieIdx) {
		this.movieIdx = movieIdx;
	}
	public int getPersionIdx() {
		return persionIdx;
	}
	public void setPersionIdx(int persionIdx) {
		this.persionIdx = persionIdx;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCast_gb() {
		return cast_gb;
	}
	public void setCast_gb(String cast_gb) {
		this.cast_gb = cast_gb;
	}
	
	
}
