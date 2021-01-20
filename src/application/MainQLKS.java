package application;

import javafx.application.Application;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import service.ConnectionService;
import javafx.scene.Scene;

/*
 * 1.Build path for project: 	add all jar files in javafx/lib to Modules path
 * 2.Set run configuration for main method: Arguments -> VM Arguments:	   --module-path "\\paste path to folder where save jar files" --add-modules javafx.controls,javafx.fxml
 * --module-path "D:\20201\Project1\20201-qlkhachsan\libs\javafx\lib" --add-modules javafx.controls,javafx.fxml
 * 
 * 3.In each fxml file, add:
 *   + fx:controller="application.Controller"  for Container
 *   + fx:id="..."  for elements that need controlled
 *   + onAction="#name-Of-Method-Defined-In-Controller"  for elements needing controlled
 * 4.fx:id of elements in fxml must be the same name as declaring in Controller 
 */

public class MainQLKS extends Application {
	public static Stage stage;
	public static String username;
	public static String viewPkgName;
	public static LocalDate today = LocalDate.now();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			ConnectionService.conn = ConnectionService.getConnection(); 
			// Đọc file fxml và vẽ giao diện.
	        Scene loginScene = new Scene(FXMLLoader.load(getClass() .getResource("/view/LoginScene.fxml")));
			stage = new Stage();
			stage.setTitle("Quản lý khách sạn");
			stage.setScene(loginScene);
			stage.show();
			stage.setOnCloseRequest(event -> {
				try {
					System.out.println("Ket thuc chuong trinh");
					ConnectionService.conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args); 
	}
}
