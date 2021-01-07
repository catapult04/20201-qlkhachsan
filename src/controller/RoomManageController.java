package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;

import component.RoomComponent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.RoomModel;
import service.RoomModelService;
import util.MyUtil;

public class RoomManageController extends Controller {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildScrollPane();
		buildToggleGroup();
	}
	
	
	@FXML private RadioButton radio1;
	@FXML private RadioButton radio2;
	@FXML private RadioButton radio3;
	@FXML private RadioButton radio4;
	@FXML private RadioButton radio5;
	@FXML private RadioButton radio6;
	private ToggleGroup statusGroup = new ToggleGroup();
	public void buildToggleGroup() {
		radio1.setToggleGroup(statusGroup);
		radio2.setToggleGroup(statusGroup);
		radio3.setToggleGroup(statusGroup);
		radio4.setToggleGroup(statusGroup);
		radio5.setToggleGroup(statusGroup);
		radio6.setToggleGroup(statusGroup);
		statusGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() { 
			@Override
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o1, Toggle o2) 
            { 
//                onSearchBtn();
            }
        });
	}
	
	
	@FXML private JFXButton addRoomBtn;
	public void onAddRoomBtn() {
		MyUtil.popUp("FormThemPhong");
	}
	
	
	@FXML private ScrollPane scrollPane;
	public void buildScrollPane() {
		RoomModelService roomModelService = new RoomModelService();
		ObservableList<RoomModel> roomModelList = roomModelService.getAll();
		int listsz = roomModelList.size();
		
		int layerId = Integer.parseInt(roomModelList.get(0).getName().substring(0,1)), i=0;
		VBox parent =  new VBox(); 
		parent.setSpacing(6);
		while(i<listsz) {
			HBox layer =  new HBox();
			layer.setSpacing(5);
			
			while(i<listsz && roomModelList.get(i).getName().substring(0, 1).equals(String.valueOf(layerId))) {
				RoomComponent com = new RoomComponent(roomModelList.get(i));
				layer.getChildren().add(com);
				i++;
			}
			parent.getChildren().add(layer);
			layerId++;
		}
		scrollPane.setContent(parent);
	}
	
	
}
