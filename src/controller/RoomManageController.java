package controller;

import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;
import component.RoomComponent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.RoomModel;
import service.RoomModelService;

public class RoomManageController extends Controller {	
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
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildScrollPane();
	}
}
