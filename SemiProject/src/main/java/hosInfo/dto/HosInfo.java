package hosInfo.dto;

public class HosInfo {
	
	private int hosCode;
	private String hosName;
	private String hosAdd;
	private int hosZip;
	private String hosCall;
	private String hosTime;
	private String hosTrans;
	private String hosPark;
	private int hosPrice;
	
	public HosInfo() {}

	public HosInfo(int hosCode, String hosName, String hosAdd, int hosZip, String hosCall, String hosTime,
			String hosTrans, String hosPark, int hosPrice) {
		super();
		this.hosCode = hosCode;
		this.hosName = hosName;
		this.hosAdd = hosAdd;
		this.hosZip = hosZip;
		this.hosCall = hosCall;
		this.hosTime = hosTime;
		this.hosTrans = hosTrans;
		this.hosPark = hosPark;
		this.hosPrice = hosPrice;
	}

	@Override
	public String toString() {
		return "HosInfo [hosCode=" + hosCode + ", hosName=" + hosName + ", hosAdd=" + hosAdd + ", hosZip=" + hosZip
				+ ", hosCall=" + hosCall + ", hosTime=" + hosTime + ", hosTrans=" + hosTrans + ", hosPark=" + hosPark
				+ ", hosPrice=" + hosPrice + "]";
	}

	public int getHosCode() {
		return hosCode;
	}

	public void setHosCode(int hosCode) {
		this.hosCode = hosCode;
	}

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public String getHosAdd() {
		return hosAdd;
	}

	public void setHosAdd(String hosAdd) {
		this.hosAdd = hosAdd;
	}

	public int getHosZip() {
		return hosZip;
	}

	public void setHosZip(int hosZip) {
		this.hosZip = hosZip;
	}

	public String getHosCall() {
		return hosCall;
	}

	public void setHosCall(String hosCall) {
		this.hosCall = hosCall;
	}

	public String getHosTime() {
		return hosTime;
	}

	public void setHosTime(String hosTime) {
		this.hosTime = hosTime;
	}

	public String getHosTrans() {
		return hosTrans;
	}

	public void setHosTrans(String hosTrans) {
		this.hosTrans = hosTrans;
	}

	public String getHosPark() {
		return hosPark;
	}

	public void setHosPark(String hosPark) {
		this.hosPark = hosPark;
	}

	public int getHosPrice() {
		return hosPrice;
	}

	public void setHosPrice(int hosPrice) {
		this.hosPrice = hosPrice;
	}	
	
}