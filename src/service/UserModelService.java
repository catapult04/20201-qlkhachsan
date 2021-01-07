package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.UserModel;

public class UserModelService {
	public ObservableList<UserModel> search(String username, String name, String sex, Date start, Date end, String phone, String address, String type) {
		ObservableList<UserModel> list = FXCollections.observableArrayList();
		try {
	        String query = "select * from user where username like ? and name like ? and sex like ? and birth>=? and birth<=? and phone like ? and address like ? and type like? ";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, "%" + username + "%");
	        preparedStatement.setString(2, "%" + name + "%");
	        if(sex.equals("Tất cả")) {
	        	preparedStatement.setString(3, "%");
	        } else {
	        	preparedStatement.setString(3, "%" + sex + "%");
	        }
	        preparedStatement.setDate(4, start);
	        preparedStatement.setDate(5, end);
	        preparedStatement.setString(6, "%" + phone + "%");
	        preparedStatement.setString(7, "%" + address + "%");
	        preparedStatement.setString(8, "%" + type + "%");
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        UserModel model;
	        while(rs.next()) {
	        	model = new UserModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), 
	        			rs.getString(6), rs.getString(7), rs.getString(8));
	        	list.add(model);		
	        }
	        
	        preparedStatement.close();
	      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
    }
	
	public boolean update(UserModel model, String oldId) {
		try {
	        String query = "update user set username=?, name=?, sex=?, birth=?, phone=?, address=?, type=? where username=?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getUsername());
	        preparedStatement.setString(2, model.getName());
	        preparedStatement.setString(3, model.getSex());
	        preparedStatement.setDate(4,model.getBirth());
	        preparedStatement.setString(5, model.getPhone());
	        preparedStatement.setString(6, model.getAddress());
	        preparedStatement.setString(7, model.getType());
	        preparedStatement.setString(8, oldId);
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean delete(String username) {
		try {
	        String sql = "delete from User where username='" + username + "'";
	        ConnectionService.conn.createStatement().execute(sql);
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNew(UserModel model) {
		try {
	        String query = "INSERT INTO user"
	                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getUsername());
	        preparedStatement.setString(2, model.getPassword());
	        preparedStatement.setString(3, model.getName());
	        preparedStatement.setString(4, model.getSex());
	        preparedStatement.setDate(5, model.getBirth());
	        preparedStatement.setString(6, model.getPhone());
	        preparedStatement.setString(7, model.getAddress());
	        preparedStatement.setString(8, model.getType());
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public ObservableList<UserModel> getAll(){
		ObservableList<UserModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from user";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				UserModel model = new UserModel(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8));
				list.add(model);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String checkPassword(String name, String pass) {
		try {
			String sql = "select username, password, type from user where username='"+name+"'";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			rs.next();
			if(rs.getString(2).equals(pass)) {
				return rs.getString(3); //dang nhap dung
			} else {
				return "password"; //sai mat khau
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "username"; //sai ten dang nhap
		}
	}
}
