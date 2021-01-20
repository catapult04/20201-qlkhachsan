package smallcontroller;

import javafx.collections.FXCollections;
import javafx.stage.Stage;
import model.BookModel;
import service.BookModelService;
import service.CustomerModelService;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import application.MainQLKS;
import controller.BookManageController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import util.MyUtil;

public class AddBookFormController implements Initializable{
	@FXML private TextField ma;
	@FXML private ComboBox<String> cmnd;
	@FXML private TextField songuoi;
	@FXML private TextField tiencoc;
	@FXML private TextField dsphong;
	@FXML private Label label;
	
	@FXML private TableView table;
	@FXML private TableColumn c1, c2, c3;
	
	@FXML private DatePicker datebook;
	@FXML private DatePicker datestart;
	@FXML private DatePicker dateend;
	
	@FXML private TextField timestart;
	@FXML private TextField timeend;
	
	@FXML private ComboBox<String> thuetheo;
	
	@FXML private JFXButton add, cancel;
	@FXML private JFXButton search, reset;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> ist = FXCollections.observableArrayList("Giờ", "Ngày", "Tháng");
		thuetheo.setItems(ist);
		
		CustomerModelService cusser = new CustomerModelService();
		cmnd.setItems(cusser.getAllCmnd());
		cmnd.setOnAction(event -> {
			label.setText(cusser.getNameByCmnd(cmnd.getValue()));
		});
		
		datebook.setValue(MainQLKS.today);
		
		buildTable();
	}
	
	public void buildTable() {
		
	}
	
	public void onSearch() {
		
	}
	
	public void onReset() {
		
	}
	
	public void onAdd() {
		try {
			int pos = timestart.getText().indexOf(":");
			int hour = Integer.parseInt(timestart.getText().substring(0, pos));
			int minute = Integer.parseInt(timestart.getText().substring(pos+1));
			Timestamp dtstart = Timestamp.valueOf(LocalDateTime.of(datestart.getValue(), LocalTime.of(hour, minute)));
			
			Timestamp dtend;
			try {
				pos = timeend.getText().indexOf(":");
				hour = Integer.parseInt(timeend.getText().substring(0, pos));
				minute = Integer.parseInt(timeend.getText().substring(pos+1));
				dtend = Timestamp.valueOf((LocalDateTime.of(dateend.getValue(), LocalTime.of(hour, minute))));
			} catch(Exception e) {
				dtend = null;
			}
			
			BookModel model = new BookModel(ma.getText(), cmnd.getValue(), Integer.parseInt(songuoi.getText()), dsphong.getText(), 
					Integer.parseInt(tiencoc.getText()), 
					Date.valueOf(datebook.getValue()), 
					dtstart, 
					dtend, thuetheo.getValue(), 0, 0, null);
			
			BookModelService service = new BookModelService();
			if(service.addNew(model)==true) {
				BookManageController.data.add(model);
				MyUtil.success("Thêm đơn đặt thành công");
				
			} else {
				MyUtil.fail("Có lỗi xảy ra, kiểm tra lại");
			}
		} catch(Exception e) {
			e.printStackTrace();
			MyUtil.fail("Có lỗi xảy ra, kiểm tra lại");
		}
	}
	
	public void onCancel() {
		Stage s = (Stage)cancel.getScene().getWindow();
		s.close();
	}
}
