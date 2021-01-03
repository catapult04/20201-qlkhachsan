package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.MainQLKS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class Controller implements Initializable {
	/***********************
	 * HEADER
	 ***********************/
	@FXML public JFXButton accBtn;
	@FXML public Label signoutLb;
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
	 * TABS
	 ***********************/
	//cac tab duoc sap theo thu tu, tru tab 11 la quan ly nhan vien
	@FXML public JFXButton tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9, tab10, tab11; 
	public void onTab(ActionEvent event) {
		try {
			String url="";
			if(event.getSource().equals(tab1)) {
				url = "/" + MainQLKS.viewPkgName + "/RoomManage.fxml";
			} else if(event.getSource().equals(tab2)) {
				url = "/" + MainQLKS.viewPkgName + "/CustomerManage.fxml";
			} else if(event.getSource().equals(tab3)) {
				url = "/" + MainQLKS.viewPkgName + "/BookManage.fxml";
			} else if(event.getSource().equals(tab4)) {
				url = "/" + MainQLKS.viewPkgName + "/UseServiceManage.fxml";
			} else if(event.getSource().equals(tab5)) {
				url = "/" + MainQLKS.viewPkgName + "/CheckoutManage.fxml";
			} else if(event.getSource().equals(tab6)) {
				url = "/" + MainQLKS.viewPkgName + "/StatisticsManage.fxml";
			} else if(event.getSource().equals(tab7)) {
				url = "/" + MainQLKS.viewPkgName + "/ReportManage.fxml";
			} else if(event.getSource().equals(tab8)) {
				url = "/" + MainQLKS.viewPkgName + "/TypeRoomManage.fxml";
			} else if(event.getSource().equals(tab9)) {
				url = "/" + MainQLKS.viewPkgName + "/ServiceManage.fxml";
			} else if(event.getSource().equals(tab10)) {
				url = "/" + MainQLKS.viewPkgName + "/StaffManage.fxml";
			} else {
				url = "/" + MainQLKS.viewPkgName + "/InfoManage.fxml";
			}
			System.out.println(url);
			Scene scene = new Scene(FXMLLoader.load(getClass() .getResource(url)));
			MainQLKS.stage.setScene(scene);
			MainQLKS.stage.centerOnScreen();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
}
