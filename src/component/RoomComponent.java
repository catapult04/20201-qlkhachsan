package component;
import java.util.Date;

import com.jfoenix.controls.JFXButton;

import javafx.scene.paint.Color;
import model.RoomModel;

public class RoomComponent  extends JFXButton{
	public static String DANG_O = "#2C85C1";
	public static String CHUA_DON = "#808000";
	public static String DA_DON = "#228B22";
	public static String CHO_DEN = "#FF8C00";
	public static String KO_DEN = "#FF4500";
	public static String DANG_SUA = "#800080";
//	public static String dangBan = "-fx-background-color: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%)";
	
	RoomModel roomModel;
	String customerName;
	Date from;
	Date to;
	
	public RoomComponent(String name, String typeRoom, String status) {
		roomModel = new RoomModel(name, typeRoom, status);
		this.setStyle("-fx-background-color: " + DANG_SUA);
		this.setText(roomModel.getName() + " - " + roomModel.getTypeRoom()  + "\n");
		this.setTextFill(Color.WHITE);
		this.setPrefHeight(70);
		this.setPrefWidth(200);
	}
}
