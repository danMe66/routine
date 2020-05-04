package com.study.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataList {

	/**
	 * 获取数据列表
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet getList(String sql) {
		String connUrl = "jdbc:mysql://localhost/test";
		String connUser = "root";
		String connpassword = "root";
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connUrl, connUser, connpassword);
			PreparedStatement cmd = conn.prepareStatement(sql);
			res = cmd.executeQuery();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
