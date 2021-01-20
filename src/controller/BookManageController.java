package controller;

import javafx.collections.FXCollections;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.BookModel;
import service.BookModelService;
import util.MyUtil;

public class BookManageController extends Controller {
	public static BookManageController nowObj;
	private static BookModelService service = new BookModelService();
	public static ObservableList<BookModel> data = FXCollections.observableArrayList(service.getAll());
	@FXML private TableView table;
	@FXML private TableColumn<BookModel, String> c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
	
	@FXML private TextField search1, search2, search3;
	@FXML ComboBox<String> comboBox;
	@FXML DatePicker pick11, pick12;
	@FXML DatePicker pick21, pick22;
	@FXML DatePicker pick31, pick32;
	
	@FXML private Button searchBtn, resetBtn;
	@FXML private Button addBtn, add2Btn, xuatBtn;
	
	
	public void buildComboBox() {
		ObservableList<String> ist = FXCollections.observableArrayList("Giờ", "Ngày", "Tháng");
		comboBox.setItems(ist);
	}
	
	public void buildTable() {
		data = FXCollections.observableArrayList(service.getAll());
    	
		//col 1 to 9
    	c1.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getId()));
    	c2.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getCustomerCmnd()));
    	c3.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getPeopleAmount())));
    	c4.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getListRoom()));
    	c5.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDeposit())));
    	c6.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDateBook())));
    	c7.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDateStart())));
    	c8.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDateEnd())));
    	c9.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getByHourDayMonth()));
    	
    	c10.setCellValueFactory(new PropertyValueFactory<>("checkinBtn")); // col 0
    	c11.setCellValueFactory(new PropertyValueFactory<>("saveBtn")); // col 11
    	c12.setCellValueFactory(new PropertyValueFactory<>("delBtn")); // col 12
    	 
    	ObservableList<TableColumn<BookModel, String>> columns = table.getColumns();
    	for(int i=1; i<=9; i++) {
    		columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
    		columns.get(i).setOnEditCommit(
          			new EventHandler<CellEditEvent<BookModel, String>>() {
          		        @Override
          		        public void handle(CellEditEvent<BookModel, String> t) {
          		        	int pos = t.getTablePosition().getColumn();
          		            ((BookModel) t.getTableView().getItems().get(t.getTablePosition().getRow())).setField(pos, t.getNewValue());
          		        }
          		    }
          	);
    	}
    	
    	table.setItems(data);
    	table.setEditable(true);
	}
	
	
	public void onSearchBtn() {
		
	}
	
	public void onResetBtn() {
		data = FXCollections.observableArrayList(service.getAll());
		table.setItems(data);
	}
	
	public void onAddBtn() {
		MyUtil.popUp("AddBookForm");
	}
	public void onAdd2Btn() {
		
	}
	public void onXuatBtn() {
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildComboBox();
		buildTable();
		nowObj = this;
	}	
}
