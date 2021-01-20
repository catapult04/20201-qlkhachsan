package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BookModel;

public class BookModelService {
	public void checkIn(String id, Timestamp time) {
		try{
			 String sql = "update book set dateStart=? where id=?";
			 PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		        
		     preparedStatement.setString(2, id);
		     preparedStatement.setTimestamp(1, time);
		     
		     preparedStatement.execute();
		     preparedStatement.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<String> getAllId(){
		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			String sql = "select id from book";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean addNew(BookModel model) {
		try {
	        String query = "INSERT INTO book"
	                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getId());
	        preparedStatement.setString(2, model.getCustomerCmnd());
	        preparedStatement.setInt(3, model.getPeopleAmount());
	        preparedStatement.setString(4, model.getListRoom());
	        preparedStatement.setInt(5, model.getDeposit());
	        preparedStatement.setDate(6, model.getDateBook());
	        preparedStatement.setTimestamp(7, model.getDateStart());
	        preparedStatement.setTimestamp(8, model.getDateEnd());
	        preparedStatement.setString(9, model.getByHourDayMonth());
	        
	        preparedStatement.setInt(10, model.getRoomCost());
	        preparedStatement.setInt(11, model.getServiceCost());
	        preparedStatement.setTimestamp(12, model.getDateBill());
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean update(BookModel model, String oldId) {
		try {
	        String query = "update book set id=?, customerCmnd=?, peopleAmount=?, listRoom=?, deposit=?, dateBook=?, dateStart=?, dateEnd=?, byHourDayMonth=?, roomCost=?, serviceCost=?, dateBill=?  where cmnd=?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getId());
	        preparedStatement.setString(2, model.getCustomerCmnd());
	        preparedStatement.setInt(3, model.getPeopleAmount());
	        preparedStatement.setString(4, model.getListRoom());
	        preparedStatement.setInt(5, model.getDeposit());
	        preparedStatement.setDate(6, model.getDateBook());
	        preparedStatement.setTimestamp(7, model.getDateStart());
	        preparedStatement.setTimestamp(8, model.getDateEnd());
	        preparedStatement.setString(9, model.getByHourDayMonth());
	        
	        preparedStatement.setInt(10, model.getRoomCost());
	        preparedStatement.setInt(11, model.getServiceCost());
	        preparedStatement.setTimestamp(12, model.getDateBill());
	        
	        preparedStatement.setString(13, oldId);
	        
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
	        String sql = "delete from book where id='" + id + "'";
	        ConnectionService.conn.createStatement().execute(sql);
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
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

