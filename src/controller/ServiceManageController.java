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
import javafx.scene.control.ComboBox;
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
import model.ServiceModel;
import model.Model;
import model.RoomModel;
import service.ServiceModelService;
import service.RoomModelService;
import util.MyUtil;

public class ServiceManageController extends Controller {
	private ServiceModelService service = new ServiceModelService();
	public static ObservableList<ServiceModel> data;
	@FXML private TableView table;
	@FXML private TableColumn<ServiceModel, String> c1,c2,c3,c4,c5,c6,c7;	
	
	@FXML private TextField search1;
	@FXML private TextField search2;
	@FXML private ComboBox<String> search3;
	@FXML private TextField search4;
	@FXML private TextField search5;
	@FXML private TextField search6;
	
	@FXML private Button searchBtn;
	@FXML private Button resetBtn;
	@FXML private Button addBtn;
	@FXML private Button add2Btn;
	@FXML private Button xuatBtn;
	
	public void onSearchBtn() {
		int start, end;
		try {
			start = Integer.parseInt(search4.getText());
		} catch(Exception e) {
			start = 0;
		}
		try {
			end = Integer.parseInt(search5.getText());
		} catch(Exception e) {
			end = 99999999;
		}
		
		data = service.search(search1.getText(), search2.getText(), search3.getValue(), start, end, search6.getText());
		table.setItems(data);
	}
	
	public void onResetBtn() {
		search1.clear();
		search2.clear();
		search3.setValue("");
		search4.clear();
		search5.clear();
		search6.clear();
		buildComboBox();
		data = FXCollections.observableArrayList(service.getAll());
		table.setItems(data);
	}
	
	public void onAddBtn() {
		MyUtil.popUp("AddServiceForm");
	}
	
	public void onAdd2Btn() {
		
	}
	
	public void onXuatBtn() {
		
	}
	
	public void buildTable() {
		data = FXCollections.observableArrayList(service.getAll());
    	
    	c1.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getId()));
    	c2.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getName()));
    	c3.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getUnit()));
    	c4.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getPrice())));
    	c5.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getDescription()));
    	c6.setCellValueFactory(new PropertyValueFactory<>("saveBtn"));
    	c7.setCellValueFactory(new PropertyValueFactory<>("delBtn"));
    	 
    	ObservableList<TableColumn<ServiceModel, String>> columns = table.getColumns();
    	for(int i=0; i<5; i++) {
    		columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
    		columns.get(i).setOnEditCommit(
          			new EventHandler<CellEditEvent<ServiceModel, String>>() {
          		        @Override
          		        public void handle(CellEditEvent<ServiceModel, String> t) {
          		        	int pos = t.getTablePosition().getColumn();
          		            ((ServiceModel) t.getTableView().getItems().get(t.getTablePosition().getRow())).setField(pos, t.getNewValue());
          		        }
          		    }
          	);
    	}
    	
    	table.setItems(data);
    	table.setEditable(true);
	}
	public void buildComboBox() {
		search3.setItems(service.getUnits());
		search3.setOnAction(event -> {
			onSearchBtn();
		});
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		search3.setValue("");
		buildComboBox();
		buildTable();
	}
		
}
