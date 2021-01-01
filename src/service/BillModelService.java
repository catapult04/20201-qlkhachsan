package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BillModel;

public class BillModelService {
	public ObservableList<BillModel> getAll(){
		ObservableList<BillModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from bill";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				BillModel billModel = new BillModel(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getTimestamp(4));
				list.add(billModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}	

