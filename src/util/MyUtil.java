package util;

import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MyUtil {
	public static void success() {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText("Thành công");
		a.showAndWait();
	}
	public static void success(String content) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText("Thành công");
		a.setContentText(content);
		a.showAndWait();
	}
	
	public static void fail() {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText("Thất bại");
		a.showAndWait();
	}
	
	public static void fail(String content) {
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText("Thất bại");
		a.setContentText(content);
		a.showAndWait();
	}
	
	public static void popUp(String fileName) {
		try {
			Stage s = new Stage();
	        Scene scene = new Scene(FXMLLoader.load(MyUtil.class.getResource("/view/" + fileName +".fxml")));
			s.setScene(scene);
			s.show();
			s.centerOnScreen();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
