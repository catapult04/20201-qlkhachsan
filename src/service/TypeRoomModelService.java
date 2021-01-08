package service;

import javafx.collections.FXCollections;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;
import model.TypeRoomModel;

public class TypeRoomModelService {
	public boolean update(TypeRoomModel model, String oldId) {
		try {
	        String query = "update typeroom set id=?, maxpeople=?, description=?, hourWeekdayPriceS=?, hourWeekendPriceS=?, dayWeekdayPriceS=?, dayWeekendPriceS=?, monthPriceS=?, hourWeekdayPriceW=?, hourWeekendPriceW=?, dayWeekdayPriceW=?, dayWeekendPriceW=?, monthPriceW=? where id=?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getId());
	        preparedStatement.setInt(2, model.getMaxPeople());
	        preparedStatement.setString(3, model.getDescription());
	        
	        preparedStatement.setInt(4, model.getHourWeekdayPriceS());
	        preparedStatement.setInt(5, model.getHourWeekendPriceS());
	        preparedStatement.setInt(6, model.getDayWeekdayPriceS());
	        preparedStatement.setInt(7, model.getDayWeekendPriceS());
	        preparedStatement.setInt(8, model.getMonthPriceS());
	        
	        preparedStatement.setInt(9, model.getHourWeekdayPriceW());
	        preparedStatement.setInt(10, model.getHourWeekendPriceW());
	        preparedStatement.setInt(11, model.getDayWeekdayPriceW());
	        preparedStatement.setInt(12, model.getDayWeekendPriceW());
	        preparedStatement.setInt(13, model.getMonthPriceW());
	        
	        preparedStatement.setString(14, oldId);
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean delete(String id) {
		try {
	        String sql = "delete from typeroom where id='" + id + "'";
	        ConnectionService.conn.createStatement().execute(sql);
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ObservableList<String> getTypes(){
		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			String sql = "select id from typeroom";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ObservableList<TypeRoomModel> getAll(){
		RoomModelService roomService = new RoomModelService();
		ObservableList<TypeRoomModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from typeroom";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				TypeRoomModel typeRoomModel = new TypeRoomModel(rs.getString(1), rs.getInt(2), rs.getString(3), 
						rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), roomService.countId(rs.getString(1)));
				list.add(typeRoomModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

