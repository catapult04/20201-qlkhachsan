package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Date;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;

import controller.BookManageController;
import controller.CustomerManageController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import service.BookModelService;
import javafx.scene.control.Alert.AlertType;
import util.MyUtil;

public class BookModel extends Model{
	private String id;
	private String customerCmnd;
	private int peopleAmount;
	private String listRoom;
	private int deposit;
	private Date dateBook;
	private Timestamp dateStart;
	private Timestamp dateEnd;
	private String byHourDayMonth;
	
	private int roomCost;
	private int serviceCost;
	private Timestamp dateBill;
	
	private JFXButton checkinBtn;
	
	public BookModel(String id, String customerCmnd, int peopleAmount, String listRoom, int deposit, Date dateBook,
			Timestamp dateStart, Timestamp dateEnd, String byHourDayMonth, int roomCost, int serviceCost,
			Timestamp dateBill) {
		super();
		this.id = id;
		this.customerCmnd = customerCmnd;
		this.peopleAmount = peopleAmount;
		this.listRoom = listRoom;
		this.deposit = deposit;
		this.dateBook = dateBook;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.byHourDayMonth = byHourDayMonth;
		this.roomCost = roomCost;
		this.serviceCost = serviceCost;
		this.dateBill = dateBill;
		oldId = id;
		
		BookModelService service = new BookModelService();
		
		checkinBtn = new JFXButton();
		checkinBtn.setStyle("-fx-background-color: #ffb700");
		checkinBtn.setText(" NOW! ");
		checkinBtn.autosize();
		
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
			a.setHeaderText("Xóa đơn đặt?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	String idd = this.getId();
	        	BookManageController.data.remove(this);
	        	service.delete(idd);
	        	MyUtil.success("Xóa thành công");
	        } 
		});
		
		this.getCheckinBtn().setOnAction(event -> {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Checkin bây giờ?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	LocalTime timeNow = LocalTime.now();
	        	Timestamp dtStart = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.of(timeNow.getHour(), timeNow.getMinute())));
	        	this.setDateStart(dtStart);
	        	service.checkIn(this.getId(), dtStart);
	        	BookManageController.nowObj.onResetBtn();
	        	MyUtil.success("Checkin thành công");
	        }
		});
	}
	public void setField(int pos, String value) {
		switch(pos) {
			case 1: setId(value); break;
			case 2: setCustomerCmnd(value); break;
			case 3: setPeopleAmount(Integer.parseInt(value)); break;
			case 4: setListRoom(value); break;
			case 5: setDeposit(Integer.parseInt(value)); break;
			case 6: setDateBook(Date.valueOf(value)); break;
			case 7: setDateStart(Timestamp.valueOf(value)); break;
			case 8: setDateEnd(Timestamp.valueOf(value)); break;
			case 9: setByHourDayMonth(value); break;
			
		}
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
	public int getPeopleAmount() {
		return peopleAmount;
	}
	public void setPeopleAmount(int peopleAmount) {
		this.peopleAmount = peopleAmount;
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
	public JFXButton getCheckinBtn() {
		return checkinBtn;
	}
	public void setCheckinBtn(JFXButton checkinBtn) {
		this.checkinBtn = checkinBtn;
	}
}
