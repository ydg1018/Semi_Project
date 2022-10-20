package login.dto;

public class Hospital {

	private int hosNo;
	private String hosId;
	private String hosPw;
	private int hosLic;
	private int hosCode;
	
	public Hospital() {}

	public Hospital(int hosNo, String hosId, String hosPw, int hosLic, int hosCode) {
		super();
		this.hosNo = hosNo;
		this.hosId = hosId;
		this.hosPw = hosPw;
		this.hosLic = hosLic;
		this.hosCode = hosCode;
	}

	@Override
	public String toString() {
		return "Hospital [hosNo=" + hosNo + ", hosId=" + hosId + ", hosPw=" + hosPw + ", hosLic=" + hosLic
				+ ", hosCode=" + hosCode + "]";
	}

	public int getHosNo() {
		return hosNo;
	}

	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}

	public String getHosId() {
		return hosId;
	}

	public void setHosId(String hosId) {
		this.hosId = hosId;
	}

	public String getHosPw() {
		return hosPw;
	}

	public void setHosPw(String hosPw) {
		this.hosPw = hosPw;
	}

	public int getHosLic() {
		return hosLic;
	}

	public void setHosLic(int hosLic) {
		this.hosLic = hosLic;
	}

	public int getHosCode() {
		return hosCode;
	}

	public void setHosCode(int hosCode) {
		this.hosCode = hosCode;
	}
}