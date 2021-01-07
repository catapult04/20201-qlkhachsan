package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import application.MainQLKS;
import component.RoomComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CustomerModel;
import model.Model;
import model.RoomModel;
import service.CustomerModelService;
import service.RoomModelService;
import util.MyUtil;

public class CustomerManageController extends Controller {
	private CustomerModelService service = new CustomerModelService();
	public static ObservableList<CustomerModel> data;
	@FXML private TableView table;
	@FXML private TableColumn<CustomerModel, String> c1,c2,c3,c4,c5,c6,c7,c8,c9;	
	
	@FXML private TextField search1;
	@FXML private TextField search2;
	@FXML private TextField search3;
	@FXML private TextField search4;
	@FXML private TextField search5;
	@FXML private DatePicker datePicker1;
	@FXML private DatePicker datePicker2;
	
	@FXML private RadioButton radio1;
	@FXML private RadioButton radio2;
	@FXML private RadioButton radio3;
	@FXML private RadioButton radio4;
	private ToggleGroup group = new ToggleGroup();
	
	@FXML private Button searchBtn;
	@FXML private Button resetBtn;
	@FXML private Button addBtn;
	@FXML private Button add2Btn;
	@FXML private Button xuatBtn;
	
	public void onSearchBtn() {
		Date start, end;
		try {
			start = Date.valueOf(datePicker1.getValue());
		} catch(Exception e) {
			start = Date.valueOf("0001-1-1");
		}
		try {
			end = Date.valueOf(datePicker2.getValue());
		} catch(Exception e) {
			end = Date.valueOf("9999-1-1");
		}
		
		data = service.search(search1.getText(), search2.getText(), ((RadioButton)group.getSelectedToggle()).getText(), start, end, search3.getText(), search4.getText(), search5.getText());
		table.setItems(data);
	}
	
	public void onResetBtn() {
		search1.clear();
		search2.clear();
		search3.clear();
		search4.clear();
		search5.clear();
		radio1.setSelected(true);
		data = FXCollections.observableArrayList(service.getAll());
		table.setItems(data);
	}
	
	public void onAddBtn() {
		MyUtil.popUp("AddCustomerForm");
	}
	
	public void onAdd2Btn() {
		
	}
	
	public void onXuatBtn() {
		
	}
	
	public void buildTable() {
		data = FXCollections.observableArrayList(service.getAll());
    	
    	c1.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getCmnd()));
    	c2.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getName()));
    	c3.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getSex()));
    	c4.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getBirth())));
    	c5.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getPhone()));
    	c6.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getAddress()));
    	c7.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getNationality()));
    	c8.setCellValueFactory(new PropertyValueFactory<>("saveBtn"));
    	c9.setCellValueFactory(new PropertyValueFactory<>("delBtn"));
    	 
    	ObservableList<TableColumn<CustomerModel, String>> columns = table.getColumns();
    	for(int i=0; i<7; i++) {
    		columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
    		columns.get(i).setOnEditCommit(
          			new EventHandler<CellEditEvent<CustomerModel, String>>() {
          		        @Override
          		        public void handle(CellEditEvent<CustomerModel, String> t) {
          		        	int pos = t.getTablePosition().getColumn();
          		            ((CustomerModel) t.getTableView().getItems().get(t.getTablePosition().getRow())).setField(pos, t.getNewValue());
          		        }
          		    }
          	);
    	}
    	
    	table.setItems(data);
    	table.setEditable(true);
	}
	
	public void buildRadio() {
		radio1.setToggleGroup(group);
		radio2.setToggleGroup(group);
		radio3.setToggleGroup(group);
		radio4.setToggleGroup(group);
		radio1.setSelected(true);
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() { 
			@Override
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o1, Toggle o2) 
            { 
                onSearchBtn();
            }
        });
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildRadio();
		buildTable();
	}
		
}
