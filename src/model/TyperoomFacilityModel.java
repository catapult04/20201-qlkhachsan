package model;

public class TyperoomFacilityModel {
	private String typeroomId;
	private String facId;
	private int quantity;
	
	public TyperoomFacilityModel(String name, String id, int quantity) {
		super();
		this.typeroomId = name;
		this.facId = id;
		this.quantity = quantity;
	}

	public String getName() {
		return typeroomId;
	}

	public String getId() {
		return facId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.typeroomId = name;
	}

	public void setId(String id) {
		this.facId = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
