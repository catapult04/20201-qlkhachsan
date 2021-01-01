package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FacilityModel;

public class FacilityModelService {
	public ObservableList<FacilityModel> getAll(){
		ObservableList<FacilityModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from facility";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				FacilityModel facilityModel = new FacilityModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(facilityModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

