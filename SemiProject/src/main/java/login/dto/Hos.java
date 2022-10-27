package login.dto;

public class Hos {

	private int hosNo;
	private String hosId;
	private String hosPw;
	private int hosLic;
	private String hosName;
	private int hosCode;
	
	public Hos() {}

	public Hos(int hosNo, String hosId, String hosPw, int hosLic, String hosName, int hosCode) {
		super();
		this.hosNo = hosNo;
		this.hosId = hosId;
		this.hosPw = hosPw;
		this.hosLic = hosLic;
		this.hosName = hosName;
		this.hosCode = hosCode;
	}

	@Override
	public String toString() {
		return "Hos [hosNo=" + hosNo + ", hosId=" + hosId + ", hosPw=" + hosPw + ", hosLic=" + hosLic + ", hosName="
				+ hosName + ", hosCode=" + hosCode + "]";
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

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public int getHosCode() {
		return hosCode;
	}

	public void setHosCode(int hosCode) {
		this.hosCode = hosCode;
	}
}