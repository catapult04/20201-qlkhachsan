package model;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.paint.Color;

public class Model {
	public String oldId;
	public FontAwesomeIcon delIcon = new FontAwesomeIcon();
	public FontAwesomeIcon saveIcon = new FontAwesomeIcon();
	private JFXButton delBtn;
	private JFXButton saveBtn;
	
	
	public Model() {
		saveIcon.setSize("1.2em");
		saveIcon.setGlyphName("CHECK");
		saveIcon.setFill(Color.FORESTGREEN);
		
		delIcon.setSize("1.2em");
		delIcon.setGlyphName("TIMES");
		delIcon.setFill(Color.RED);
		
		
		delBtn = new JFXButton();
		saveBtn = new JFXButton();
		
		delBtn.setStyle("-fx-background-color: #87CEEB");
		delBtn.setGraphic(delIcon);
		delBtn.autosize();
		
		saveBtn.setStyle("-fx-background-color: #87CEEB");
		saveBtn.setGraphic(saveIcon);
		saveBtn.autosize();
	}
	
	public void setField(int order, String value) {}
	
	
	public JFXButton getDelBtn() {
		return delBtn;
	}
	public void setDelBtn(JFXButton delBtn) {
		this.delBtn = delBtn;
	}
	public JFXButton getSaveBtn() {
		return saveBtn;
	}
	public void setSaveBtn(JFXButton saveBtn) {
		this.saveBtn = saveBtn;
	}
}
