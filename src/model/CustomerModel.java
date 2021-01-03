package model;

import java.util.Date;

public class CustomerModel {
	private String cmnd;
	private String name;
	private Date birth;
	private String phone;
	private String address;
	private String nationality;
	
	public CustomerModel(String cmnd, String name, Date date, String phone, String address, String nationality) {
		super();
		this.cmnd = cmnd;
		this.name = name;
		this.birth = date;
		this.phone = phone;
		this.address = address;
		this.nationality = nationality;
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
	
	
}
