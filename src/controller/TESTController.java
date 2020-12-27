package controller;

import java.net.URL;
import java.util.ResourceBundle;

import component.RoomComponent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TESTController implements Initializable {
	@FXML private ScrollPane scrollPane;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildIconsBox();		
	}
	
	public void buildIconsBox() {
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);
		VBox parent =  new VBox(); 
		parent.setSpacing(6);
		for(int i=1; i<6; i++) {
			HBox layer =  new HBox();
			layer.setSpacing(5);
			for(int j=1; j<=7; j++) {
				RoomComponent com = new RoomComponent("00FF00", String.valueOf(i) + "0" + String.valueOf(j), "Có sẵn", "Ngô Bá Khá");
				layer.getChildren().add(com);
			}
			parent.getChildren().add(layer);
		}
		scrollPane.setContent(parent);
	}
}
