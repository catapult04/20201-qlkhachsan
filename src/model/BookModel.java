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
	
	public BookModel(String id, String customerCmnd, int peopleQuantity, String listRoom, int deposit, Date dateBook,
			Timestamp dateStart, Timestamp dateEnd, String byHourDayMonth) {
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
	}

	public String getId() {
		return id;
	}

	public String getCustomerCmnd() {
		return customerCmnd;
	}

	public int getPeopleQuantity() {
		return peopleQuantity;
	}

	public String getListRoom() {
		return listRoom;
	}

	public int getDeposit() {
		return deposit;
	}

	public Date getDateBook() {
		return dateBook;
	}

	public Timestamp getDateStart() {
		return dateStart;
	}

	public Timestamp getDateEnd() {
		return dateEnd;
	}

	public String getByHourDayMonth() {
		return byHourDayMonth;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCustomerCmnd(String customerCmnd) {
		this.customerCmnd = customerCmnd;
	}

	public void setPeopleQuantity(int peopleQuantity) {
		this.peopleQuantity = peopleQuantity;
	}

	public void setListRoom(String listRoom) {
		this.listRoom = listRoom;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}

	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}

	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setByHourDayMonth(String byHourDayMonth) {
		this.byHourDayMonth = byHourDayMonth;
	}
	
	
}
