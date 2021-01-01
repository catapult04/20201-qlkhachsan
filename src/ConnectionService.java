package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionService {
	private static String dbURL = "jdbc:mysql://localhost:3306/qlkhachsandb";
	private static String username = "root";
	private static String password = "";
	public static Connection conn;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			if(conn != null)
				System.out.println("Kết nối thành công!\n");			
			else
				System.out.println("Kết nối thất bại!");
			return conn;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ConnectionService(){}
	
}
