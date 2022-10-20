package reservation.dto;

import java.util.Date;

public class Reservation {

	private int resNo;
	private Date resDate;
	private String resDetail;
	private int ownerNo;
	private int petNo;
	private int hosNo;
	
	public Reservation() {}

	public Reservation(int resNo, Date resDate, String resDetail, int ownerNo, int petNo, int hosNo) {
		super();
		this.resNo = resNo;
		this.resDate = resDate;
		this.resDetail = resDetail;
		this.ownerNo = ownerNo;
		this.petNo = petNo;
		this.hosNo = hosNo;
	}

	@Override
	public String toString() {
		return "Reservation [resNo=" + resNo + ", resDate=" + resDate + ", resDetail=" + resDetail + ", ownerNo="
				+ ownerNo + ", petNo=" + petNo + ", hosNo=" + hosNo + "]";
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

	public int getHosNo() {
		return hosNo;
	}

	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}
	
	
	
}
