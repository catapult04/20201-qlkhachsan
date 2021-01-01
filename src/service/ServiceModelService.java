package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ServiceModel;

public class ServiceModelService {
	public ObservableList<ServiceModel> getAll(){
		ObservableList<ServiceModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from service";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				ServiceModel serviceModel = new ServiceModel(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5));
				list.add(serviceModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

