package login.dto;

public class Owner {

	private int ownerNo;
	private String ownerId;
	private String ownerPw;
	private String ownerName;
	private String ownerEmail;
	private int ownerCall;
	private String ownerNick;
	
	public Owner() {}
	
	public Owner(int ownerNo, String ownerId, String ownerPw, String ownerName, String ownerEmail, int ownerCall,
			String ownerNick) {
		super();
		this.ownerNo = ownerNo;
		this.ownerId = ownerId;
		this.ownerPw = ownerPw;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.ownerCall = ownerCall;
		this.ownerNick = ownerNick;
	}

	@Override
	public String toString() {
		return "Owner [ownerNo=" + ownerNo + ", ownerId=" + ownerId + ", ownerPw=" + ownerPw + ", ownerName="
				+ ownerName + ", ownerEmail=" + ownerEmail + ", ownerCall=" + ownerCall + ", ownerNick=" + ownerNick
				+ "]";
	}

	public int getOwnerNo() {
		return ownerNo;
	}

	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerPw() {
		return ownerPw;
	}

	public void setOwnerPw(String ownerPw) {
		this.ownerPw = ownerPw;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public int getOwnerCall() {
		return ownerCall;
	}

	public void setOwnerCall(int ownerCall) {
		this.ownerCall = ownerCall;
	}

	public String getOwnerNick() {
		return ownerNick;
	}

	public void setOwnerNick(String ownerNick) {
		this.ownerNick = ownerNick;
	}
}