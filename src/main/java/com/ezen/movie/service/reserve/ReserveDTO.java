package com.ezen.movie.service.reserve;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.ezen.movie.service.comm.CommDTO;


@Alias("reserveDTO")
public class ReserveDTO extends CommDTO {

	private int seatReserveIdx;    // 인덱스
	private int screenIdx;        // 스크린인덱스
	private String seatNumber;    // 좌석넘버
	private int timetableIdx;    // 시간표인덱스
	private String memberId;        // 예약자 아이디

	private boolean seatReserveChk;    // 좌석 유무
	private String seatRowTitle;    // 시트좌석타이틀
	private String seatRowNum;        // 시트좌석번호
	private List<String> seatList;		// 좌석시트담을곳
	private String paymentYn;			// 결제여부

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

	public int getTimetableIdx() {
		return timetableIdx;
	}

	public void setTimetableIdx(int timetableIdx) {
		this.timetableIdx = timetableIdx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public boolean isSeatReserveChk() {
		return seatReserveChk;
	}

	public void setSeatReserveChk(boolean seatReserveChk) {
		this.seatReserveChk = seatReserveChk;
	}

	public String getSeatRowTitle() {
		return seatRowTitle;
	}

	public void setSeatRowTitle(String seatRowTitle) {
		this.seatRowTitle = seatRowTitle;
	}

	public String getSeatRowNum() {
		return seatRowNum;
	}

	public void setSeatRowNum(String seatRowNum) {
		this.seatRowNum = seatRowNum;
	}

	public List<String> getSeatList() {
		return seatList;
	}

	public void setSeatList(List<String> seatList) {
		this.seatList = seatList;
	}

	public String getPaymentYn() {
		return paymentYn;
	}

	public void setPaymentYn(String paymentYn) {
		this.paymentYn = paymentYn;
	}
	
}
