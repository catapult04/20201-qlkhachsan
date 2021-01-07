package smallcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.RoomModel;
import service.RoomModelService;
import service.TypeRoomModelService;
import util.MyUtil;

public class FormThemPhongController implements Initializable{
	@FXML private TextField in1;
	@FXML private ComboBox<String> in2;
	@FXML private ComboBox<String> in3;
	
	@FXML private JFXButton add;
	@FXML private JFXButton cancel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildComboBox();
		in1.requestFocus();
	}
	
	public void buildComboBox() {
		TypeRoomModelService typeRoomService = new TypeRoomModelService();
		ObservableList<String> listType = typeRoomService.getTypes();
		in2.setItems(listType);
		
		ObservableList<String> listStatus = FXCollections.observableArrayList("Đã dọn", "Đang ở", "Chưa dọn", "Chờ đến", "Đang sửa");
		in3.setItems(listStatus);
		in3.setValue(listStatus.get(0));
	}
	
	public void onAdd() {
		RoomModel model = new RoomModel(in1.getText(), in2.getValue(), in3.getValue());
		RoomModelService service = new RoomModelService();
		if(service.addNew(model)==true) {
			MyUtil.success("Thêm phòng thành công");
		} else {
			MyUtil.fail("Trùng mã phòng");
		}
	}
	
	public void onCancel() {
		Stage s = (Stage)cancel.getScene().getWindow();
		s.close();
	}
}
