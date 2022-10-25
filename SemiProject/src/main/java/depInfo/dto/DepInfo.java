package depInfo.dto;

public class DepInfo {

	private int dep_code;
	private String dep_item;
	private String dep_detail;
	private int det_code;
	private String det_item;
	private String det_detail;
	private int trt_code;
	private String trt_item;
	
	public DepInfo() {
	}

	public DepInfo(int dep_code, String dep_item, String dep_detail, int det_code, String det_item, String det_detail,
			int trt_code, String trt_item) {
		super();
		this.dep_code = dep_code;
		this.dep_item = dep_item;
		this.dep_detail = dep_detail;
		this.det_code = det_code;
		this.det_item = det_item;
		this.det_detail = det_detail;
		this.trt_code = trt_code;
		this.trt_item = trt_item;
	}

	@Override
	public String toString() {
		return "DepInfo [dep_code=" + dep_code + ", dep_item=" + dep_item + ", dep_detail=" + dep_detail + ", det_code="
				+ det_code + ", det_item=" + det_item + ", det_detail=" + det_detail + ", trt_code=" + trt_code
				+ ", trt_item=" + trt_item + "]";
	}

	public int getDep_code() {
		return dep_code;
	}

	public void setDep_code(int dep_code) {
		this.dep_code = dep_code;
	}

	public String getDep_item() {
		return dep_item;
	}

	public void setDep_item(String dep_item) {
		this.dep_item = dep_item;
	}

	public String getDep_detail() {
		return dep_detail;
	}

	public void setDep_detail(String dep_detail) {
		this.dep_detail = dep_detail;
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

	public int getTrt_code() {
		return trt_code;
	}

	public void setTrt_code(int trt_code) {
		this.trt_code = trt_code;
	}

	public String getTrt_item() {
		return trt_item;
	}

	public void setTrt_item(String trt_item) {
		this.trt_item = trt_item;
	}
	
}