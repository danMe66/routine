package my.demo.db;

import org.apache.ibatis.session.SqlSession;


public class TestDb {

	public static void main(String[] args)
	{
		try (SqlSession sqlSession = MyBatis.factory.openSession())
		{
			System.out.println("连接成功！");
		} catch (Exception e)
		{
			System.err.println("连接异常！");
		}
		System.out.println("Exit");

	}

}
