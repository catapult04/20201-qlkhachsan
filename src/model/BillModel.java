package model;

import java.sql.Timestamp;

public class BillModel {
	private String bookId;
	private int roomCost;
	private int serviceCost;
	private Timestamp dateBill;
	
	
	public BillModel(String bookId, int roomCost, int serviceCost, Timestamp dateBill) {
		super();
		this.bookId = bookId;
		this.roomCost = roomCost;
		this.serviceCost = serviceCost;
		this.dateBill = dateBill;
	}
	public String getBookId() {
		return bookId;
	}
	public int getRoomCost() {
		return roomCost;
	}
	public int getServiceCost() {
		return serviceCost;
	}
	public Timestamp getDateBill() {
		return dateBill;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}
	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}
	public void setDateBill(Timestamp dateBill) {
		this.dateBill = dateBill;
	}
	
	
}
