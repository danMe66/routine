package pers.liudandan.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataAccess {

	public static void main(String[] args) {
		// 第一步：导包,将数据库驱动jar包拷贝到lib文件下
		// 第二部：加载驱动
		String connUrl = "jdbc:mysql://localhost/learning";
		String connUser = "root";
		String connPassword = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 第三步：数据驱动管理者或者连接对象
			Connection conn = DriverManager.getConnection(connUrl, connUser, connPassword);
			// 第四步：创建命令对象
			PreparedStatement cmd = conn.prepareStatement("select * from user");
			ResultSet res = cmd.executeQuery();
			System.out.print("ID" + " " + "姓名" + "\n");
			while (res.next()) {
				Integer id = res.getInt("id");
				String name = res.getString("name");
				System.out.print(id + " " + name + "\n");
			}
			// 第六步：释放数据库资源
			res.close();
			cmd.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
