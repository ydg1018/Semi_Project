package reservation.dto;

import java.util.Date;

public class Reservation {

	private int resNo;
	private Date resDate;
	private String resDetail;
	private int userNo;
	private int petNo;
	private int hosNo;
	
	public Reservation() {}

	public Reservation(int resNo, Date resDate, String resDetail, int userNo, int petNo, int hosNo) {
		super();
		this.resNo = resNo;
		this.resDate = resDate;
		this.resDetail = resDetail;
		this.userNo = userNo;
		this.petNo = petNo;
		this.hosNo = hosNo;
	}

	@Override
	public String toString() {
		return "ReservationDto [resNo=" + resNo + ", resDate=" + resDate + ", resDetail=" + resDetail + ", userNo="
				+ userNo + ", petNo=" + petNo + ", hosNo=" + hosNo + "]";
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public String getResDetail() {
		return resDetail;
	}

	public void setResDetail(String resDetail) {
		this.resDetail = resDetail;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getPetNo() {
		return petNo;
	}

	public void setPetNo(int petNo) {
		this.petNo = petNo;
	}

	public int getHosNo() {
		return hosNo;
	}

	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}
	
}
