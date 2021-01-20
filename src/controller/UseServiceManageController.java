package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Book_ServiceModel;
import model.RoomModel;
import model.ServiceModel;
import service.BookModelService;
import service.RoomModelService;
import service.ServiceModelService;

public class UseServiceManageController extends Controller {
	@FXML private ComboBox<String> comboBox1, comboBox2;
	@FXML private TextField tf;
	@FXML private Button thehienBtn, themBtn, xuatBtn, add2Btn;
	@FXML private Label label;
	
	@FXML private TableView table;
	@FXML private TableColumn<Book_ServiceModel, String> c1, c2, c3, c4, c5, c6;
	
	@FXML private TableView table1;
	@FXML private TableColumn<ServiceModel, String> d1, d2, d3, d4;
	
	public void onThehienBtn() {
		
	}
	public void onThemBtn() {
		
	}
	public void onXuatBtn() {
		
	}
	public void onAdd2Btn() {
		
	}
	
	public void buildTable() {
		
	}
	public void buildTable1() {
		ServiceModelService s = new ServiceModelService();
		ObservableList<ServiceModel> d = FXCollections.observableArrayList(s.getAll());
    	
    	d1.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getId()));
    	d2.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getName()));
    	d3.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getUnit()));
    	d4.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getPrice())));
    	 
    	table1.setItems(d);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BookModelService bookService = new BookModelService();
		ServiceModelService serviceService = new ServiceModelService();
		comboBox1.setItems(bookService.getAllId());
		comboBox2.setItems(serviceService.getAllId());
		comboBox2.setOnAction(event -> {
			label.setText(serviceService.getNameById(comboBox2.getValue()));
		});
		
		buildTable();
		buildTable1();
	}
		
}
