package service;
import javafx.collections.FXCollections;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;
import model.RoomModel;

public class RoomModelService {
	public int countId(String id) {
		try {
			String sql = "select count(name) from room where typeroomId='" + id + "'";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			rs.next(); 
			return rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean addNew(RoomModel model) {
		try {
	        String query = "INSERT INTO room"
	                + " values (?, ?, ?)";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getName());
	        preparedStatement.setString(2, model.getTypeRoom());
	        preparedStatement.setString(3, model.getStatus());
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public ObservableList<RoomModel> getAll(){
		ObservableList<RoomModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from room order by name asc";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				RoomModel roomModel = new RoomModel(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(roomModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}	
