package depInfo.dto;

public class DetInfo {
	
	private int dep_code;
	private int det_code;
	private String det_item;
	private String det_detail;
	
	public DetInfo() {
	}

	public DetInfo(int dep_code, int det_code, String det_item, String det_detail) {
		super();
		this.dep_code = dep_code;
		this.det_code = det_code;
		this.det_item = det_item;
		this.det_detail = det_detail;
	}

	@Override
	public String toString() {
		return "DetInfo [dep_code=" + dep_code + ", det_code=" + det_code + ", det_item=" + det_item + ", det_detail="
				+ det_detail + "]";
	}

	public int getDep_code() {
		return dep_code;
	}

	public void setDep_code(int dep_code) {
		this.dep_code = dep_code;
	}

	public int getDet_code() {
		return det_code;
	}

	public void setDet_code(int det_code) {
		this.det_code = det_code;
	}

	public String getDet_item() {
		return det_item;
	}

	public void setDet_item(String det_item) {
		this.det_item = det_item;
	}

	public String getDet_detail() {
		return det_detail;
	}

	public void setDet_detail(String det_detail) {
		this.det_detail = det_detail;
	}
	
}