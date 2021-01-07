package service;

import javafx.collections.FXCollections;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.ObservableList;
import model.ServiceModel;

public class ServiceModelService {
	public ObservableList<ServiceModel> search(String id, String name, String unit, int start, int end, String des) {
		ObservableList<ServiceModel> list = FXCollections.observableArrayList();
		try {
	        String query = "select * from service where id like ? and name like ? and unit like ? and price>=? and price<=? and description like ?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, "%" + id + "%");
	        preparedStatement.setString(2, "%" + name + "%");
	        preparedStatement.setString(3, "%" + unit + "%");
            preparedStatement.setInt(4, start);
	        preparedStatement.setInt(5, end);
	        preparedStatement.setString(6, "%" + des + "%");
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        ServiceModel model;
	        while(rs.next()) {
	        	model = new ServiceModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
	        	list.add(model);		
	        }
	        
	        preparedStatement.close();
	      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
    }
	
	public boolean update(ServiceModel model, String oldId) {
		try {
	        String query = "update Service set id=?, name=?, unit=?, price=?, description=? where id=?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getId());
	        preparedStatement.setString(2, model.getName());
	        preparedStatement.setString(3, model.getUnit());
	        preparedStatement.setInt(4, model.getPrice());
	        preparedStatement.setString(5, model.getDescription());
	        preparedStatement.setString(6, oldId);
	        
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
	        String sql = "delete from service where id='" + id + "'";
	        ConnectionService.conn.createStatement().execute(sql);
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNew(ServiceModel model) {
		try {
	        String query = "INSERT INTO service"
	                + " values (?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getId());
	        preparedStatement.setString(2, model.getName());
	        preparedStatement.setString(3, model.getUnit());
	        preparedStatement.setInt(4, model.getPrice());
	        preparedStatement.setString(5, model.getDescription());
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public ObservableList<String> getUnits(){
		ObservableList<String> list = FXCollections.observableArrayList();
		try {
			String sql = "select distinct unit from service";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ObservableList<ServiceModel> getAll(){
		ObservableList<ServiceModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from service";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				ServiceModel serviceModel = new ServiceModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(serviceModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

