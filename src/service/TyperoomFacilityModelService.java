package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TyperoomFacilityModel;

public class TyperoomFacilityModelService {
	public ObservableList<TyperoomFacilityModel> getAll(){
		ObservableList<TyperoomFacilityModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from typeroom-facility";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				TyperoomFacilityModel typeroomFacilityModel = new TyperoomFacilityModel(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(typeroomFacilityModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

