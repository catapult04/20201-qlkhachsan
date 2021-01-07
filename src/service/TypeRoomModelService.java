package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TypeRoomModel;

public class TypeRoomModelService {
	
	
	public ObservableList<String> getTypes(){
		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			String sql = "select id from typeroom";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ObservableList<TypeRoomModel> getAll(){
		RoomModelService roomService = new RoomModelService();
		ObservableList<TypeRoomModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from typeroom";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				TypeRoomModel typeRoomModel = new TypeRoomModel(rs.getString(1), rs.getInt(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), roomService.countId(rs.getString(1)));
				list.add(typeRoomModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

