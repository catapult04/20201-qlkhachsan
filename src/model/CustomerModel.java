package model;

import java.sql.Date;
import java.util.Optional;
import controller.CustomerManageController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.ConnectionService;
import service.CustomerModelService;
import util.MyUtil;
import javafx.scene.control.Alert.AlertType;

public class CustomerModel extends Model{
	private String cmnd;
	private String name;
	private String sex;
	private Date birth;
	private String phone;
	private String address;
	private String nationality;
	
	public CustomerModel(String cmnd, String name, String sex, Date date, String phone, String address, String nationality) {
		super();
		this.cmnd = cmnd;
		this.name = name;
		this.sex = sex;
		this.birth = date;
		this.phone = phone;
		this.address = address;
		this.nationality = nationality;
		oldId = cmnd;
		
		CustomerModelService service = new CustomerModelService();
		
		this.getSaveBtn().setOnAction(event -> {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Lưu các thay đổi?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	if(service.update(this, this.oldId)==true) {
	        		this.oldId = this.getCmnd();
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
	        	String id = this.getCmnd();
	        	CustomerManageController.data.remove(this);
	        	service.delete(id);
	        	MyUtil.success("Xóa thành công");
	        } 
		});
	}
	public void setField(int pos, String value) {
		switch(pos) {
			case 0: setCmnd(value); break;
			case 1: setName(value); break;
			case 2: setSex(value); break;
			case 3: setBirth(Date.valueOf(value)); break;
			case 4: setPhone(value); break;
			case 5: setAddress(value); break;
			case 6: setNationality(value); break;
		}
	}
	

	public String getCmnd() {
		return cmnd;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return birth;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.birth = date;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
