package model;

import java.sql.Date;

public class UserModel {
	public static String QUAN_LY="Quản lý", KE_TOAN="Kế toán", LE_TAN="Lễ tân", THU_NGAN="Thu ngân";
	
	private String username;
	private String password;
	private String name;
	private String phone;
	private Date birth;
	private String address;
	private String type;
	
	public UserModel(String username, String password, String name, String phone, Date birth, String address,
			String type) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.address = address;
		this.type = type;
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
}
