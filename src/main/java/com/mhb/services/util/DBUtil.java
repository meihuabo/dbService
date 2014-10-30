package com.mhb.services.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	
	public static Connection getCurrentConnection() throws ClassNotFoundException, SQLException{
		String user = "root";
		String password = "mysql";
		String url = "jdbc:mysql://localhost:3306/jssd";
		String driver = "com.mysql.jdbc.Driver";
		Connection conn = DBUtil.getConntection(user, password, url, driver);
		return conn;
	}
	
	public static Connection getConntection(String user,String password,String url,String driver) throws ClassNotFoundException, SQLException{
		Connection con = null;
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	public static void closeConection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeStmt(Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
