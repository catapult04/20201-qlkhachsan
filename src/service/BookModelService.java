package service;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BookModel;

public class BookModelService {
	public ObservableList<BookModel> getAll(){
		ObservableList<BookModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from book";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				BookModel bookModel = new BookModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), 
						rs.getInt(5), rs.getDate(6), rs.getTimestamp(7), rs.getTimestamp(8), rs.getString(9), rs.getInt(10), 
						rs.getInt(11), rs.getTimestamp(12));
				list.add(bookModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

