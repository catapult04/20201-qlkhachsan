package model;

import java.sql.Date;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;

import controller.CustomerManageController;
import controller.TypeRoomManageController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import service.CustomerModelService;
import service.TypeRoomModelService;
import util.MyUtil;

public class TypeRoomModel extends Model{
	private String id;
	private int maxPeople;
	private String description;
	
	private int hourWeekdayPriceS;
	private int hourWeekendPriceS;
	private int dayWeekdayPriceS;
	private int dayWeekendPriceS;
	private int monthPriceS;
	
	private int hourWeekdayPriceW;
	private int hourWeekendPriceW;
	private int dayWeekdayPriceW;
	private int dayWeekendPriceW;
	private int monthPriceW;
	
	private int amount;
	private JFXButton save2Btn;
	
	public TypeRoomModel(String id, int maxPeople, String description, int hourWeekdayPriceS,
			int hourWeekendPriceS, int dayWeekdayPriceS, int dayWeekendPriceS, int monthPriceS, int hourWeekdayPriceW,
			int hourWeekendPriceW, int dayWeekdayPriceW, int dayWeekendPriceW, int monthPriceW, int amount) {
		super();
		this.id = id;
		this.maxPeople = maxPeople;
		this.description = description;
		this.amount = amount;
		this.hourWeekdayPriceS = hourWeekdayPriceS;
		this.hourWeekendPriceS = hourWeekendPriceS;
		this.dayWeekdayPriceS = dayWeekdayPriceS;
		this.dayWeekendPriceS = dayWeekendPriceS;
		this.monthPriceS = monthPriceS;
		this.hourWeekdayPriceW = hourWeekdayPriceW;
		this.hourWeekendPriceW = hourWeekendPriceW;
		this.dayWeekdayPriceW = dayWeekdayPriceW;
		this.dayWeekendPriceW = dayWeekendPriceW;
		this.monthPriceW = monthPriceW;
		oldId = id;
		
		TypeRoomModelService service = new TypeRoomModelService();
		
		FontAwesomeIcon save2Icon = new FontAwesomeIcon(); 
		save2Icon.setSize("1.2em");
		save2Icon.setGlyphName("CHECK");
		save2Icon.setFill(Color.FORESTGREEN);
		save2Btn = new JFXButton();
		save2Btn.setStyle("-fx-background-color: #87CEEB");
		save2Btn.setGraphic(save2Icon);
		save2Btn.autosize();
		this.save2Btn.setOnAction(event -> {
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
			a.setHeaderText("Xóa Loại Phòng?");
			Optional<ButtonType> option = a.showAndWait();
	        if (option.get() == ButtonType.OK) {
	        	String idd = this.getId();
	        	TypeRoomManageController.data.remove(this);
	        	service.delete(idd);
	        	MyUtil.success("Xóa thành công");
	        } 
		});
	}
	public void setField(int pos, String value) {
		switch(pos) {
			case 0: setId(value); break;
			case 1: setMaxPeople(Integer.parseInt(value));break;
			case 2: setDescription(value);break;
			
			case 3: setHourWeekdayPriceS(Integer.parseInt(value));break;
			case 4: setHourWeekendPriceS(Integer.parseInt(value));break;
			case 5: setDayWeekdayPriceS(Integer.parseInt(value));break;
			case 6: setDayWeekendPriceS(Integer.parseInt(value));break;
			case 7: setMonthPriceS(Integer.parseInt(value));break;
			
			case 8: setHourWeekdayPriceW(Integer.parseInt(value));break;
			case 9: setHourWeekendPriceW(Integer.parseInt(value));break;
			case 10: setDayWeekdayPriceW(Integer.parseInt(value));break;
			case 11: setDayWeekendPriceW(Integer.parseInt(value));break;
			case 12: setMonthPriceW(Integer.parseInt(value));break;
		}
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getHourWeekdayPriceS() {
		return hourWeekdayPriceS;
	}
	public void setHourWeekdayPriceS(int hourWeekdayPriceS) {
		this.hourWeekdayPriceS = hourWeekdayPriceS;
	}
	public int getHourWeekendPriceS() {
		return hourWeekendPriceS;
	}
	public void setHourWeekendPriceS(int hourWeekendPriceS) {
		this.hourWeekendPriceS = hourWeekendPriceS;
	}
	public int getDayWeekdayPriceS() {
		return dayWeekdayPriceS;
	}
	public void setDayWeekdayPriceS(int dayWeekdayPriceS) {
		this.dayWeekdayPriceS = dayWeekdayPriceS;
	}
	public int getDayWeekendPriceS() {
		return dayWeekendPriceS;
	}
	public void setDayWeekendPriceS(int dayWeekendPriceS) {
		this.dayWeekendPriceS = dayWeekendPriceS;
	}
	public int getMonthPriceS() {
		return monthPriceS;
	}
	public void setMonthPriceS(int monthPriceS) {
		this.monthPriceS = monthPriceS;
	}
	public int getHourWeekdayPriceW() {
		return hourWeekdayPriceW;
	}
	public void setHourWeekdayPriceW(int hourWeekdayPriceW) {
		this.hourWeekdayPriceW = hourWeekdayPriceW;
	}
	public int getHourWeekendPriceW() {
		return hourWeekendPriceW;
	}
	public void setHourWeekendPriceW(int hourWeekendPriceW) {
		this.hourWeekendPriceW = hourWeekendPriceW;
	}
	public int getDayWeekdayPriceW() {
		return dayWeekdayPriceW;
	}
	public void setDayWeekdayPriceW(int dayWeekdayPriceW) {
		this.dayWeekdayPriceW = dayWeekdayPriceW;
	}
	public int getDayWeekendPriceW() {
		return dayWeekendPriceW;
	}
	public void setDayWeekendPriceW(int dayWeekendPriceW) {
		this.dayWeekendPriceW = dayWeekendPriceW;
	}
	public int getMonthPriceW() {
		return monthPriceW;
	}
	public void setMonthPriceW(int monthPriceW) {
		this.monthPriceW = monthPriceW;
	}
	public JFXButton getSave2Btn() {
		return save2Btn;
	}
	public void setSave2Btn(JFXButton save2Btn) {
		this.save2Btn = save2Btn;
	}
	
}
