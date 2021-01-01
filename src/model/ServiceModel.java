package model;

public class ServiceModel {
	private String id;
	private String name;
	private String unit;
	private int price;
	private String description;
	
	public ServiceModel(String id, String name, String unit, int price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
