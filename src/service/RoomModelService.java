package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.RoomModel;

public class RoomModelService {
	public ObservableList<RoomModel> getAll(){
		ObservableList<RoomModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by name asc";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				RoomModel roomModel = new RoomModel(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(roomModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}	
