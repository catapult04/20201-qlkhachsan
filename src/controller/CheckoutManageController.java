package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.BookModel;
import util.MyUtil;

public class CheckoutManageController extends Controller {
	@FXML private ComboBox<String> comboBox;
	@FXML private Button checkoutBtn, resetBtn;
	
	@FXML private TableView table;
	@FXML private TableColumn<BookModel, String> c1,c2,c3,c4,c5,c6,c7,c8;
	
	public void buildTable() {
		
	}
	public void buildComboBox() {
		
	}
	
	public void onCheckoutBtn() {
		MyUtil.popUp("BillForm");
	}
	
	public void onResetBtn() {
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildComboBox();
		buildTable();
	}
		
}
