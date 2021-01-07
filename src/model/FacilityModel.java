package model;

import java.util.Optional;

import controller.FacilityManageController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import service.FacilityModelService;
import util.MyUtil;

public class FacilityModel extends Model {
	private String id;
	private String name;
	private String unit;
	private int price;
	private String description;
	
	public FacilityModel(String id, String name, String unit, int price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.description = description;
		oldId = id;
		
		FacilityModelService service = new FacilityModelService();
		
		this.getSaveBtn().setOnAction(event -> {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Lưu các thay đổi?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	if(service.update(this, this.oldId)==true) {
	        		this.oldId = this.getId();
	        		MyUtil.success("Cập nhật thành công");
	        	} else {
	        		MyUtil.fail("Có lỗi xảy ra");
	        	}		
	        } 
		});
		
		this.getDelBtn().setOnAction(event -> {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Xóa khách hàng?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	String ID = this.getId();
	        	FacilityManageController.data.remove(this);
	        	service.delete(id);
	        	MyUtil.success("Xóa thành công");
	        } 
		});
	}
	public void setField(int pos, String value) {
		try {
			switch(pos) {
				case 0: setId(value); break;
				case 1: setName(value); break;
				case 2: setUnit(value); break;
				case 3: setPrice(Integer.parseInt(value)); break;
				case 4: setDescription(value); break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
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
