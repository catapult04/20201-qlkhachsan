package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.MainQLKS;
import component.RoomComponent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RoomManageController implements Initializable {
	/***********************
	 * HEADER FOR ALL SCENE
	 ***********************/
	@FXML private JFXButton accBtn;
	@FXML private Label signoutLb;
	public void onAccBtn() {
		//MainQLKS.stage.setScene();
	}
	public void onSignoutLb() {
		try {
   			Scene scene = new Scene(FXMLLoader.load(getClass() .getResource("/view/LoginScene.fxml")));
	   		MainQLKS.stage.setScene(scene);
	   		MainQLKS.stage.centerOnScreen();
   		} catch(Exception e) {
   			e.printStackTrace();
   		}
	}
	
	
	/***********************
	 * FOR EACH SCENE:
	 ***********************/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildScrollPane();
	}
	
	@FXML private ScrollPane scrollPane;
	public void buildScrollPane() {
		VBox parent =  new VBox(); 
		parent.setSpacing(6);
		for(int i=1; i<6; i++) {
			HBox layer =  new HBox();
			layer.setSpacing(5);
			for(int j=1; j<=7; j++) {
				RoomComponent com = new RoomComponent("101", "N2", "abc");
				layer.getChildren().add(com);
			}
			parent.getChildren().add(layer);
		}
		scrollPane.setContent(parent);
	}
}
