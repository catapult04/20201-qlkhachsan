package model;

import java.sql.Date;
import java.util.Optional;
import controller.UserManageController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.UserModelService;
import javafx.scene.control.Alert.AlertType;
import util.MyUtil;

public class UserModel  extends Model{
	public static String QUAN_LY="Quản lý", KE_TOAN="Kế toán", LE_TAN="Lễ tân", THU_NGAN="Thu ngân";
	
	private String username; 
	private String password; 
	private String name;
	private String sex;   	 
	private Date birth;		 
	private String phone;	 
	private String address;	 
	private String type;	 
	
	public UserModel(String username, String password, String name, String sex, Date birth, String phone, String address, String type) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
		this.type = type;
		oldId = username;
		
		UserModelService service = new UserModelService();
		this.getSaveBtn().setOnAction(event -> {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Lưu các thay đổi?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	if(service.update(this, this.oldId)==true) {
	        		this.oldId = this.getUsername();
	        		MyUtil.success("Cập nhật thành công");
	        	} else {
	        		MyUtil.fail("Có lỗi xảy ra");
	        	}		
	        } 
		});
		
		this.getDelBtn().setOnAction(event -> {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Xóa nhân viên?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	String id = this.getUsername();
	        	UserManageController.data.remove(this);
	        	service.delete(id);
	        	MyUtil.success("Xóa thành công");
	        } 
		});
	}
	public void setField(int pos, String value) {
		switch(pos) {
			case 0: setUsername(value); break;
			case 1: setName(value); break;
			case 2: setSex(value); break;
			case 3: setBirth(Date.valueOf(value)); break;
			case 4: setPhone(value); break;
			case 5: setAddress(value); break;
			case 6: setType(value); break;
		}
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
