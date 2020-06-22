package pers.liudandan.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersList {
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet getList(String sql) {
		String connUrl = "jdbc:mysql://localhost/learning";
		String connUser = "root";
		String connPassword = "root";
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connUrl, connUser, connPassword);
			PreparedStatement cmd = conn.prepareStatement(sql);
			res = cmd.executeQuery();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
