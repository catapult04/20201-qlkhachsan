package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerModel;

public class CustomerModelService {
	public ObservableList<CustomerModel> getAll(){
		ObservableList<CustomerModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from customer";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				CustomerModel customerModel = new CustomerModel(rs.getString(1), rs.getString(2), rs.getDate(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(customerModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

