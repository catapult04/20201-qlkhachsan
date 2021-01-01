package model;

public class RoomModel {
	private String name;
	private String typeRoom;
	private String status;
	
	public RoomModel(String name, String typeRoom, String status) {
		super();
		this.name = name;
		this.typeRoom = typeRoom;
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public String getTypeRoom() {
		return typeRoom;
	}


	public String getStatus() {
		return status;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
}
