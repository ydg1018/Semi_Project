package depInfo.dto;

public class DepInfo {

	private int dep_code;
	private String dep_item;
	private String dep_detail;
	
	public DepInfo() {
	}
	
	public DepInfo(int dep_code, String dep_item, String dep_detail) {
		super();
		this.dep_code = dep_code;
		this.dep_item = dep_item;
		this.dep_detail = dep_detail;
	}

	@Override
	public String toString() {
		return "DepInfo [dep_code=" + dep_code + ", dep_item=" + dep_item + ", dep_detail=" + dep_detail + "]";
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
	
}