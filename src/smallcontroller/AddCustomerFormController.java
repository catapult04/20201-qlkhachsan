package smallcontroller;

import javafx.stage.Stage;
import javafx.collections.FXCollections;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import controller.CustomerManageController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.CustomerModel;
import service.CustomerModelService;
import util.MyUtil;

public class AddCustomerFormController implements Initializable{
	@FXML private TextField in1;
	@FXML private TextField in2;
	@FXML private ComboBox<String> in3;
	@FXML private DatePicker in4;
	@FXML private TextField in5;
	@FXML private TextField in6;
	@FXML private TextField in7;
	
	@FXML private JFXButton add;
	@FXML private JFXButton cancel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildComboBox();
		in1.requestFocus();
	}
	
	public void buildComboBox() {
		ObservableList<String> listStatus = FXCollections.observableArrayList("Nam", "Nữ", "No3");
		in3.setItems(listStatus);
	}
	
	public void onAdd() {
		CustomerModel model = new CustomerModel(in1.getText(), in2.getText(), in3.getValue(), Date.valueOf(in4.getValue()), in5.getText(), in6.getText(), in7.getText());
		CustomerModelService service = new CustomerModelService();
		if(service.addNew(model)==true) {
			MyUtil.success("Thêm khách hàng thành công");
			CustomerManageController.data.add(model);
			in1.clear();
			in2.clear();
			in5.clear();
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
