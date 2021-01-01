package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BillServiceModel;

public class BillServiceModelService {
	public ObservableList<BillServiceModel> getAll(){
		ObservableList<BillServiceModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from bill-service";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				BillServiceModel billServiceModel = new BillServiceModel(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(billServiceModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}	

