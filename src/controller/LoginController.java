package controller;

import javafx.scene.Scene;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ConnectionService;

public class LoginController implements Initializable {
	   @FXML private Button closeBtn;
	   @FXML private TextField userTextField;
	   @FXML private PasswordField passTextField;
	   @FXML private JFXButton loginBtn;
	   @FXML private Label forgotPassLabel;
	   @FXML private Label errorLabel1;
	   @FXML private Label errorLabel2;
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {	      
	   }
	   
	   public void onClose(ActionEvent event) {
		   System.exit(0);
	   }
	   
	   public void onLogin(ActionEvent event) {
		   errorLabel1.setText(null);
		   errorLabel2.setText(null);
		   try {
			    String SQL = "SELECT maTT,password FROM user_minhhn WHERE username=" + "'" + userTextField.getText() + "'";
			    ResultSet rs = ConnectionService.conn.createStatement().executeQuery(SQL);
			    try {
			    	rs.next();
			    	if(rs.getString(2).equals(passTextField.getText())) {				        
				        //crete info of thuthu
				        MainQLTV.maTT = rs.getString(1);
				        MainQLTV.username = userTextField.getText();
				        String SQL2 = "SELECT Ten_20183955 FROM thuthu_minhhn WHERE MaTT_20183955=" + "'" + MainQLTV.maTT + "'";
					    ResultSet rs2 = ConnectionService.conn.createStatement().executeQuery(SQL2);
					    rs2.next();
					    MainQLTV.tenTT = rs2.getString(1);
					    
					  //create UI
			    		Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainScene.fxml")));
				        Stage stage = (Stage) forgotPassLabel.getScene().getWindow();
				        stage.setScene(mainScene);
				        stage.centerOnScreen();
			    	} else {
			    		errorLabel2.setText("Sai mật khẩu!");
			    	}
			    	ConnectionService.conn.close();
			    } catch(Exception e) {
			    	e.printStackTrace();
			    	errorLabel1.setText("Sai tên đăng nhập!");
			    }		        
		    }catch (Exception io){
		        io.printStackTrace();
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