package reservation.dto;

import java.util.Date;

public class Payment {

	private String payNo;
	private Date payDate;
	private int payMoney;
	private int resNo;
	private int ownerNo;
	private int hosNo;
	
	public Payment() {}

	public Payment(String payNo, Date payDate, int payMoney, int resNo, int ownerNo, int hosNo) {
		super();
		this.payNo = payNo;
		this.payDate = payDate;
		this.payMoney = payMoney;
		this.resNo = resNo;
		this.ownerNo = ownerNo;
		this.hosNo = hosNo;
	}

	@Override
	public String toString() {
		return "Payment [payNo=" + payNo + ", payDate=" + payDate + ", payMoney=" + payMoney + ", resNo=" + resNo
				+ ", ownerNo=" + ownerNo + ", hosNo=" + hosNo + "]";
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	public int getHosNo() {
		return hosNo;
	}

	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}	
	
}
