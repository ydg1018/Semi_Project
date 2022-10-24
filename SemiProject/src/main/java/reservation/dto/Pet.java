package reservation.dto;

public class Pet {

	private int petNo;
	private String petName;
	private int petAge;
	private String petSex;
	private String petType;
	
	public Pet() {}

	public Pet(int petNo, String petName, int petAge, String petSex, String petType) {
		super();
		this.petNo = petNo;
		this.petName = petName;
		this.petAge = petAge;
		this.petSex = petSex;
		this.petType = petType;
	}

	@Override
	public String toString() {
		return "Pet [petNo=" + petNo + ", petName=" + petName + ", petAge=" + petAge + ", petSex=" + petSex
				+ ", petType=" + petType + "]";
	}

	public int getPetNo() {
		return petNo;
	}

	public void setPetNo(int petNo) {
		this.petNo = petNo;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}
	
}
