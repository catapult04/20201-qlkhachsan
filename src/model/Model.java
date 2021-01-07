package model;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.paint.Color;

public class Model {
	public String oldId;
	public static FontAwesomeIcon delIcon = new FontAwesomeIcon();
	public static FontAwesomeIcon saveIcon = new FontAwesomeIcon();
	private JFXButton delBtn;
	private JFXButton saveBtn;
	
	static {
		saveIcon.setSize("1.2em");
		saveIcon.setGlyphName("CHECK");
		saveIcon.setFill(Color.FORESTGREEN);
		
		delIcon.setSize("1.2em");
		delIcon.setGlyphName("TIMES");
		delIcon.setFill(Color.RED);
	}
	
	public Model() {
		delBtn = new JFXButton();
		saveBtn = new JFXButton();
		
		delBtn.setStyle("-fx-background-color: #CCFF66");
		delBtn.setGraphic(delIcon);
		delBtn.autosize();
		
		saveBtn.setStyle("-fx-background-color: #CCFF66");
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
