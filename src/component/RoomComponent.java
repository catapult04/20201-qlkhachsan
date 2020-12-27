package component;
import java.util.Date;

import com.jfoenix.controls.JFXButton;

public class RoomComponent  extends JFXButton{
	public static String coSan = "-fx-background-color: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%)";
	public static String dangBan = "-fx-background-color: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%)";
	public static String dangSua = "-fx-background-color: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%)";
	public static String daDat = "-fx-background-color: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%)";
	String color;
	String roomName;
	String roomStatus;
	String customerName;
	Date from;
	Date to;
	
	public RoomComponent(String s2, String s3, String s4, String s1) {
		color = s1;
		roomName = s2;
		roomStatus = s3;
		customerName = s4;
		this.setStyle(coSan);
		this.setText(roomName + "\n" + roomStatus + "\n" + customerName + "\n");
		this.setPrefHeight(70);
		this.setPrefWidth(200);
	}
}
