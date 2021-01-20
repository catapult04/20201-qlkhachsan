package smallcontroller;

import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import controller.ServiceManageController;
import controller.TypeRoomManageController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.ServiceModel;
import model.TypeRoomModel;
import service.TypeRoomModelService;
import util.MyUtil;

public class AddTypeRoomFormController implements Initializable{
	@FXML private TextField in1;
	@FXML private TextField in2;
	@FXML private TextField in3;
	
	@FXML private JFXButton add;
	@FXML private JFXButton cancel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		in1.requestFocus();
	}
	
	public void onAdd() {
		TypeRoomModel model = new TypeRoomModel(in1.getText(), Integer.parseInt(in2.getText()), in3.getText(), 0,0,0,0,0, 0,0,0,0,0, 0);
		TypeRoomModelService service = new TypeRoomModelService();
		if(service.addNew(model)==true) {
			TypeRoomManageController.data.add(model);
			MyUtil.success("Thêm thành công. Hãy sửa giá trong bảng báo giá!");
			in1.clear();
			in2.clear();
			in3.clear();
		} else {
			MyUtil.fail("Có lỗi xảy ra, kiểm tra lại");
		}
	}
	
	public void onCancel() {
		Stage s = (Stage)cancel.getScene().getWindow();
		s.close();
	}
}
