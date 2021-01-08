package controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.RoomModel;
import model.ServiceModel;
import model.TypeRoomModel;
import service.RoomModelService;
import service.ServiceModelService;
import service.TypeRoomModelService;
import util.MyUtil;

public class TypeRoomManageController extends Controller {	
	private static TypeRoomModelService service = new TypeRoomModelService();
	public static ObservableList<TypeRoomModel> data = FXCollections.observableArrayList(service.getAll());
	@FXML private TableView table1, table2;
	@FXML private TableColumn<TypeRoomModel, String> c1,c2,c3,c4,c5;
	@FXML private TableColumn<TypeRoomModel, String> d1,d2, d31,d32,d33,d34,d35, d41,d42,d43,d44,d45, d5;
	
	public void buildTable1() {
    	c1.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getId()));
    	c2.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getMaxPeople())));
    	c3.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getDescription()));
    	c4.setCellValueFactory(new PropertyValueFactory<>("saveBtn"));
    	c5.setCellValueFactory(new PropertyValueFactory<>("delBtn"));
    	 
    	ObservableList<TableColumn<TypeRoomModel, String>> columns = table1.getColumns();
    	for(int i=0; i<3; i++) {
    		columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
    		columns.get(i).setOnEditCommit(
          			new EventHandler<CellEditEvent<TypeRoomModel, String>>() {
          		        @Override
          		        public void handle(CellEditEvent<TypeRoomModel, String> t) {
          		        	int pos = t.getTablePosition().getColumn();
          		            ((TypeRoomModel) t.getTableView().getItems().get(t.getTablePosition().getRow())).setField(pos, t.getNewValue());
          		        }
          		    }
          	);
    	}
    	
    	table1.setItems(data);
    	table1.setEditable(true);
	}
	public void buildTable2() {
		d1.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getId()));
    	d2.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getAmount())));
    	
    	d31.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getHourWeekdayPriceS())));
    	d32.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getHourWeekendPriceS())));
    	d33.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDayWeekdayPriceS())));
    	d34.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDayWeekendPriceS())));
    	d35.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getMonthPriceS())));
    	
    	d41.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getHourWeekdayPriceW())));
    	d42.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getHourWeekendPriceW())));
    	d43.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDayWeekdayPriceW())));
    	d44.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getDayWeekendPriceW())));
    	d45.setCellValueFactory(cell-> new SimpleStringProperty(String.valueOf(cell.getValue().getMonthPriceW())));
    	
    	d5.setCellValueFactory(new PropertyValueFactory<>("save2Btn"));
    	 
    	ObservableList<TableColumn<TypeRoomModel, String>> columns = FXCollections.observableArrayList(d31,d32,d33,d34,d35, d41,d42,d43,d44,d45);
    	for(int i=0; i<columns.size(); i++) {
    		columns.get(i).setCellFactory(TextFieldTableCell.forTableColumn());
    		columns.get(i).setOnEditCommit(
          			new EventHandler<CellEditEvent<TypeRoomModel, String>>() {
          		        @Override
          		        public void handle(CellEditEvent<TypeRoomModel, String> t) {
          		        	try {
          		        		int pos = t.getTablePosition().getColumn();
              		            ((TypeRoomModel) t.getTableView().getItems().get(t.getTablePosition().getRow())).setField(pos+1, t.getNewValue());
          		        	} catch(Exception e) {
          		        		MyUtil.fail("Vui lòng nhập số");
          		        	}
          		        }
          		    }
          	);
    	}
    	
    	table2.setItems(data);
    	table2.setEditable(true);
	}
	
	@FXML private JFXButton addBtn;
	@FXML private JFXButton xuatBtn;
	@FXML private JFXButton resetBtn;
	public void onAddBtn() {
		
	}
	
	public void onXuatBtn() {
		
		
	}
	
	public void onResetBtn() {
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildTable1();
		buildTable2();
	}
}
