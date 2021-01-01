package service;

import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.TyperoomPriceModel;

public class TyperoomPriceModelService {
	public ObservableList<TyperoomPriceModel> getAll(){
		ObservableList<TyperoomPriceModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from typeroom-price";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				TyperoomPriceModel typeroomPriceModel = new TyperoomPriceModel(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				list.add(typeroomPriceModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

