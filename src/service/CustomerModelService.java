package service;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.CustomerModel;

public class CustomerModelService {
	public ObservableList<String> getAllCmnd() {
		ObservableList<String> list = FXCollections.observableArrayList(); 
		try {
			String sql = "select cmnd from customer";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getNameByCmnd(String cmnd) {
		try {
			String sql = "select name from customer where cmnd='" + cmnd +"'";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			rs.next();
			return rs.getString(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ObservableList<CustomerModel> search(String cmnd, String name, String sex, Date start, Date end, String phone, String address, String nationality) {
		ObservableList<CustomerModel> list = FXCollections.observableArrayList();
		try {
	        String query = "select * from customer where cmnd like ? and name like ? and sex like ? and birth>=? and birth<=? and phone like ? and address like ? and nationality like ?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, "%" + cmnd + "%");
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
	        preparedStatement.setString(8, "%" + nationality + "%");
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        CustomerModel model;
	        while(rs.next()) {
	        	model = new CustomerModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
	        	list.add(model);		
	        }
	        
	        preparedStatement.close();
	      
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
    }
	
	public boolean update(CustomerModel model, String oldId) {
		try {
	        String query = "update customer set cmnd=?, name=?, sex=?, birth=?, phone=?, address=?, nationality=? where cmnd=?";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getCmnd());
	        preparedStatement.setString(2, model.getName());
	        preparedStatement.setString(3, model.getSex());
	        preparedStatement.setDate(4, model.getBirth());
	        preparedStatement.setString(5, model.getPhone());
	        preparedStatement.setString(6, model.getAddress());
	        preparedStatement.setString(7, model.getNationality());
	        preparedStatement.setString(8, oldId);
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public boolean delete(String cmnd) {
		try {
	        String sql = "delete from customer where cmnd='" + cmnd + "'";
	        ConnectionService.conn.createStatement().execute(sql);
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNew(CustomerModel model) {
		try {
	        String query = "INSERT INTO customer"
	                + " values (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = ConnectionService.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        preparedStatement.setString(1, model.getCmnd());
	        preparedStatement.setString(2, model.getName());
	        preparedStatement.setString(3, model.getSex());
	        preparedStatement.setDate(4, model.getBirth());
	        preparedStatement.setString(5, model.getPhone());
	        preparedStatement.setString(6, model.getAddress());
	        preparedStatement.setString(7, model.getNationality());
	        
	        preparedStatement.execute();
	        preparedStatement.close();
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
	
	public ObservableList<CustomerModel> getAll(){
		ObservableList<CustomerModel> list = FXCollections.observableArrayList();
		try {
			String sql = "select * from customer";
			ResultSet rs = ConnectionService.conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				CustomerModel customerModel = new CustomerModel(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(customerModel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

