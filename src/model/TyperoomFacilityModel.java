package model;

public class TyperoomFacilityModel {
	private String typeroomId;
	private String facId;
	private int amount;
	
	public TyperoomFacilityModel(String name, String id, int amount) {
		super();
		this.typeroomId = name;
		this.facId = id;
		this.amount = amount;
	}

	public String getName() {
		return typeroomId;
	}

	public String getId() {
		return facId;
	}

	public int getAmount() {
		return amount;
	}

	public void setName(String name) {
		this.typeroomId = name;
	}

	public void setId(String id) {
		this.facId = id;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
