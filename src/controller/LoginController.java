package controller;

import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.*;

import application.MainQLKS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import service.UserModelService;

public class LoginController implements Initializable { 
	   @FXML private TextField userTextField;
	   @FXML private PasswordField passTextField;
	   @FXML private JFXButton loginBtn;
	   @FXML private Label forgotPassLabel;
	   @FXML private Label errorLabel1;
	   @FXML private Label errorLabel2;
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	   }
	   
	   public void onLoginBtn() {
		   errorLabel1.setText(null);
		   errorLabel2.setText(null);
		   UserModelService userSer = new UserModelService();
		   String name = userTextField.getText();
		   String pass = passTextField.getText();
		   String rs = userSer.checkPassword(name, pass);
		   switch(rs) {
		   	case "password": {
		   		errorLabel2.setText("Sai mật khẩu"); break;
		   	}
		   	case "username": {
		   		errorLabel1.setText("Sai tên đăng nhập"); break;
		   	}
		   	default: {
		   		MainQLKS.username = name;
		   		switch(rs) {
		   			case "Quản lý":{
		   				MainQLKS.viewPkgName = "view_ql";break;
		   			}
		   			case "Lễ tân": {
		   				MainQLKS.viewPkgName = "view_lt";break;
		   			}
		   			case "Thu ngân": {
		   				MainQLKS.viewPkgName = "view_tn";break;
		   			} 
		   			case "Kế toán": {
		   				MainQLKS.viewPkgName = "view_kt";break;
		   			}
		   		}
		   		try {
		   			Scene scene = new Scene(FXMLLoader.load(getClass() .getResource("/" + MainQLKS.viewPkgName + "/RoomManage.fxml")));
			   		MainQLKS.stage.setScene(scene);
			   		MainQLKS.stage.centerOnScreen();
		   		} catch(Exception e) {
		   			e.printStackTrace();
		   		}
		   	}
		   }
	   }
	   
	   public void onForgotPass() {
		   forgotPassLabel.setTextFill(Color.GREEN);
		   Alert alert = new Alert(Alert.AlertType.INFORMATION);
		   alert.setTitle("Quên mật khẩu");
		   alert.setContentText("Đã gửi mật khẩu về số điện thoại/ email đăng ký!");
		   alert.setOnCloseRequest((event) -> {forgotPassLabel.setTextFill(Color.valueOf("#9e1482"));});
		   alert.showAndWait();
	   }
}