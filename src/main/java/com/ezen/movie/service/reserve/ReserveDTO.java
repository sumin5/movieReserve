package com.ezen.movie.service.reserve;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;


@Alias("reserveDTO")
public class ReserveDTO extends CommDTO {
	
	public int seatReserveIdx;	// 인덱스
	public int screenIdx;		// 스크린인덱스
	public String seatNumber;	// 좌석넘버
	public int timeTableIdx;	// 시간표인덱스
	public String memberId;		// 예약자 아이디
	
	public int getSeatReserveIdx() {
		return seatReserveIdx;
	}
	public void setSeatReserveIdx(int seatReserveIdx) {
		this.seatReserveIdx = seatReserveIdx;
	}
	public int getScreenIdx() {
		return screenIdx;
	}
	public void setScreenIdx(int screenIdx) {
		this.screenIdx = screenIdx;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getTimeTableIdx() {
		return timeTableIdx;
	}
	public void setTimeTableIdx(int timeTableIdx) {
		this.timeTableIdx = timeTableIdx;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
