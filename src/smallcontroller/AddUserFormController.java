package smallcontroller;

import javafx.stage.Stage;
import javafx.collections.FXCollections;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.UserModel;
import model.UserModel;
import service.UserModelService;
import util.MyUtil;

public class AddUserFormController implements Initializable{
	@FXML private TextField in1;
	@FXML private TextField in2;
	@FXML private TextField in3;
	@FXML private ComboBox<String> in4;
	@FXML private DatePicker in5;
	@FXML private TextField in6;
	@FXML private TextField in7;
	@FXML private ComboBox<String> in8;
	
	@FXML private JFXButton add;
	@FXML private JFXButton cancel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildComboBox();
		in1.requestFocus();
	}
	
	public void buildComboBox() {
		ObservableList<String> list = FXCollections.observableArrayList("Nam", "Nữ", "No3");
		in4.setItems(list);
		
		list = FXCollections.observableArrayList(UserModel.QUAN_LY, UserModel.LE_TAN, UserModel.THU_NGAN, UserModel.KE_TOAN);
		in8.setItems(list);
	}
	
	public void onAdd() {
		UserModel model = new UserModel(in1.getText(), in2.getText(), in3.getText(), in4.getValue(), Date.valueOf(in5.getValue()), in6.getText(), in7.getText(), in8.getValue());
		UserModelService service = new UserModelService();
		if(service.addNew(model)==true) {
			MyUtil.success("Thêm nhân viên thành công");
			in1.clear();
			in2.clear();
			in3.clear();
			in6.clear();
			in7.clear();
		} else {
			MyUtil.fail("Có lỗi xảy ra");
		}
	}
	
	public void onCancel() {
		Stage s = (Stage)cancel.getScene().getWindow();
		s.close();
	}
}
