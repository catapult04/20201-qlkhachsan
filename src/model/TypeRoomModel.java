package model;

public class TypeRoomModel {
	private String id;
	private int maxPeople;
	private String description;
	
	public TypeRoomModel(String id, int maxPeople, String description) {
		super();
		this.id = id;
		this.maxPeople = maxPeople;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public int getMaxPeople() {
		return maxPeople;
	}

	public String getDescription() {
		return description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
