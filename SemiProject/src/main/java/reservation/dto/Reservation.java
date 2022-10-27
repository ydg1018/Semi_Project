package reservation.dto;

import java.util.Date;

public class Reservation {

	private int resNo;
	private String resDate;
	private String resDetail;
	private int ownerNo;
	private int petNo;
	private int hosCode;
	
	public Reservation() {}

	public Reservation(int resNo, String resDate, String resDetail, int ownerNo, int petNo, int hosCode) {
		super();
		this.resNo = resNo;
		this.resDate = resDate;
		this.resDetail = resDetail;
		this.ownerNo = ownerNo;
		this.petNo = petNo;
		this.hosCode = hosCode;
	}

	@Override
	public String toString() {
		return "Reservation [resNo=" + resNo + ", resDate=" + resDate + ", resDetail=" + resDetail + ", ownerNo="
				+ ownerNo + ", petNo=" + petNo + ", hosCode=" + hosCode + "]";
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	public String getResDetail() {
		return resDetail;
	}

	public void setResDetail(String resDetail) {
		this.resDetail = resDetail;
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	public int getPetNo() {
		return petNo;
	}

	public void setPetNo(int petNo) {
		this.petNo = petNo;
	}

	public int getHosCode() {
		return hosCode;
	}

	public void setHosCode(int hosCode) {
		this.hosCode = hosCode;
	}
	
}
