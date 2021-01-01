package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TypeRoomModel;

public class TypeRoomModelService {
	public ObservableList<TypeRoomModel> getAll(){
		ObservableList<TypeRoomModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from typeroom";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				TypeRoomModel typeRoomModel = new TypeRoomModel(rs.getString(1), rs.getInt(2), rs.getString(3));
				list.add(typeRoomModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

