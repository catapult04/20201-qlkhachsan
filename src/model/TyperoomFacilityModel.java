package model;

public class TyperoomFacilityModel {
	private String name;
	private String id;
	private int quantity;
	
	public TyperoomFacilityModel(String name, String id, int quantity) {
		super();
		this.name = name;
		this.id = id;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
