package smallcontroller;

import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import controller.FacilityManageController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.FacilityModel;
import model.ServiceModel;
import service.FacilityModelService;
import service.ServiceModelService;
import util.MyUtil;

public class AddFacilityFormController implements Initializable{
	@FXML private TextField in1;
	@FXML private TextField in2;
	@FXML private TextField in3;
	@FXML private TextField in4;
	@FXML private TextField in5;
	
	@FXML private JFXButton add;
	@FXML private JFXButton cancel;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		in1.requestFocus();
	}
	
	public void onAdd() {
		FacilityModel model = new FacilityModel(in1.getText(), in2.getText(), in3.getText(), Integer.parseInt(in4.getText()), in5.getText());
		FacilityModelService service = new FacilityModelService();
		if(service.addNew(model)==true) {
			FacilityManageController.data.add(model);
			MyUtil.success("Thêm CSVC thành công");
			in1.clear();
			in2.clear();
			in3.clear();
			in4.clear();
			in5.clear();
		} else {
			MyUtil.fail("Có lỗi xảy ra, kiểm tra lại");
		}
	}
	
	public void onCancel() {
		Stage s = (Stage)cancel.getScene().getWindow();
		s.close();
	}
}
