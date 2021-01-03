package service;
import javafx.collections.FXCollections;
import java.sql.ResultSet;
import javafx.collections.ObservableList;
import model.Book_ServiceModel;

public class Book_ServiceModelService {
	public ObservableList<Book_ServiceModel> getAll(){
		ObservableList<Book_ServiceModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from book-service";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				Book_ServiceModel billServiceModel = new Book_ServiceModel(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(billServiceModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}	

