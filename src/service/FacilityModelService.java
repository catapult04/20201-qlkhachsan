package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.FacilityModel;
import model.ServiceModel;

public class FacilityModelService {
	public ObservableList<FacilityModel> search(String id, String name, String unit, int start, int end, String des) {
		ObservableList<FacilityModel> list = FXCollections.observableArrayList();
		try {
	        String query = "select * from facility where id like ? and name like ? and unit like ? and price>=? and price<=? and description like ?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, "%" + id + "%");
	        preparedStatement.setString(2, "%" + name + "%");
	        preparedStatement.setString(3, "%" + unit + "%");
            preparedStatement.setInt(4, start);
	        preparedStatement.setInt(5, end);
	        preparedStatement.setString(6, "%" + des + "%");
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        FacilityModel model;
	        while(rs.next()) {
	        	model = new FacilityModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
	        	list.add(model);		
	        }
	        
	        preparedStatement.close();
	      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
    }
	
	public boolean update(FacilityModel model, String oldId) {
		try {
	        String query = "update facility set id=?, name=?, unit=?, price=?, description=? where id=?";
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
	        String sql = "delete from facility where id='" + id + "'";
	        ConnectionService.conn.createStatement().execute(sql);
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNew(FacilityModel model) {
		try {
	        String query = "INSERT INTO facility"
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
			String sql = "select distinct unit from facility";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ObservableList<FacilityModel> getAll(){
		ObservableList<FacilityModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from facility";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				FacilityModel facilityModel = new FacilityModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(facilityModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

