package hosInfo.dto;

public class HosInfo {
	
	private int hos_code;
	private String hos_name;
	private String hos_add;
	private int hos_zip;
	private String hos_call;
	private String hos_time;
	private String hos_trans;
	private String hos_park;
	private int hos_price;
	private int hos_x;
	private int hos_y;
	
	public HosInfo() {}

	public HosInfo(int hos_code, String hos_name, String hos_add, int hos_zip, String hos_call, String hos_time,
			String hos_trans, String hos_park, int hos_price, int hos_x, int hos_y) {
		super();
		this.hos_code = hos_code;
		this.hos_name = hos_name;
		this.hos_add = hos_add;
		this.hos_zip = hos_zip;
		this.hos_call = hos_call;
		this.hos_time = hos_time;
		this.hos_trans = hos_trans;
		this.hos_park = hos_park;
		this.hos_price = hos_price;
		this.hos_x = hos_x;
		this.hos_y = hos_y;
	}

	@Override
	public String toString() {
		return "HosInfo [hos_code=" + hos_code + ", hos_name=" + hos_name + ", hos_add=" + hos_add + ", hos_zip="
				+ hos_zip + ", hos_call=" + hos_call + ", hos_time=" + hos_time + ", hos_trans=" + hos_trans
				+ ", hos_park=" + hos_park + ", hos_price=" + hos_price + ", hos_x=" + hos_x + ", hos_y=" + hos_y + "]";
	}

	public int getHos_code() {
		return hos_code;
	}

	public void setHos_code(int hos_code) {
		this.hos_code = hos_code;
	}

	public String getHos_name() {
		return hos_name;
	}

	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}

	public String getHos_add() {
		return hos_add;
	}

	public void setHos_add(String hos_add) {
		this.hos_add = hos_add;
	}

	public int getHos_zip() {
		return hos_zip;
	}

	public void setHos_zip(int hos_zip) {
		this.hos_zip = hos_zip;
	}

	public String getHos_call() {
		return hos_call;
	}

	public void setHos_call(String hos_call) {
		this.hos_call = hos_call;
	}

	public String getHos_time() {
		return hos_time;
	}

	public void setHos_time(String hos_time) {
		this.hos_time = hos_time;
	}

	public String getHos_trans() {
		return hos_trans;
	}

	public void setHos_trans(String hos_trans) {
		this.hos_trans = hos_trans;
	}

	public String getHos_park() {
		return hos_park;
	}

	public void setHos_park(String hos_park) {
		this.hos_park = hos_park;
	}

	public int getHos_price() {
		return hos_price;
	}

	public void setHos_price(int hos_price) {
		this.hos_price = hos_price;
	}

	public int getHos_x() {
		return hos_x;
	}

	public void setHos_x(int hos_x) {
		this.hos_x = hos_x;
	}

	public int getHos_y() {
		return hos_y;
	}

	public void setHos_y(int hos_y) {
		this.hos_y = hos_y;
	}

}