package model;

public class RoomModel {
	public static String DANG_O = "Đang ở", DA_DON = "Đã dọn", CHUA_DON="Chưa dọn", 
			CHO_DEN="Chờ đến", KO_DEN="Ko đến", DANG_SUA="Đang sửa";
	
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
