package service;

import java.sql.ResultSet;

public class UserModelService {
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
