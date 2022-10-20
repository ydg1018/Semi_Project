package depInfo.dto;

public class TrtInfo {
	
	private int dep_code;
	private int det_code;
	private int trt_code;
	private String trt_item;
	
	public TrtInfo() {
	}

	public TrtInfo(int dep_code, int det_code, int trt_code, String trt_item) {
		super();
		this.dep_code = dep_code;
		this.det_code = det_code;
		this.trt_code = trt_code;
		this.trt_item = trt_item;
	}

	@Override
	public String toString() {
		return "TrtInfo [dep_code=" + dep_code + ", det_code=" + det_code + ", trt_code=" + trt_code + ", trt_item="
				+ trt_item + "]";
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