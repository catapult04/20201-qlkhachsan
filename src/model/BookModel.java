package model;

import java.sql.Timestamp;
import java.util.Date;

public class BookModel {
	private String id;
	private String customerCmnd;
	private int peopleQuantity;
	private String listRoom;
	private int deposit;
	private Date dateBook;
	private Timestamp dateStart;
	private Timestamp dateEnd;
	private String byHourDayMonth;
	
	private int roomCost;
	private int serviceCost;
	private Timestamp dateBill;
	public BookModel(String id, String customerCmnd, int peopleQuantity, String listRoom, int deposit, Date dateBook,
			Timestamp dateStart, Timestamp dateEnd, String byHourDayMonth, int roomCost, int serviceCost,
			Timestamp dateBill) {
		super();
		this.id = id;
		this.customerCmnd = customerCmnd;
		this.peopleQuantity = peopleQuantity;
		this.listRoom = listRoom;
		this.deposit = deposit;
		this.dateBook = dateBook;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.byHourDayMonth = byHourDayMonth;
		this.roomCost = roomCost;
		this.serviceCost = serviceCost;
		this.dateBill = dateBill;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerCmnd() {
		return customerCmnd;
	}
	public void setCustomerCmnd(String customerCmnd) {
		this.customerCmnd = customerCmnd;
	}
	public int getPeopleQuantity() {
		return peopleQuantity;
	}
	public void setPeopleQuantity(int peopleQuantity) {
		this.peopleQuantity = peopleQuantity;
	}
	public String getListRoom() {
		return listRoom;
	}
	public void setListRoom(String listRoom) {
		this.listRoom = listRoom;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Date getDateBook() {
		return dateBook;
	}
	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}
	public Timestamp getDateStart() {
		return dateStart;
	}
	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}
	public Timestamp getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}
	public String getByHourDayMonth() {
		return byHourDayMonth;
	}
	public void setByHourDayMonth(String byHourDayMonth) {
		this.byHourDayMonth = byHourDayMonth;
	}
	public int getRoomCost() {
		return roomCost;
	}
	public void setRoomCost(int roomCost) {
		this.roomCost = roomCost;
	}
	public int getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}
	public Timestamp getDateBill() {
		return dateBill;
	}
	public void setDateBill(Timestamp dateBill) {
		this.dateBill = dateBill;
	}
}
