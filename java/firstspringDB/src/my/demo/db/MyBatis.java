package my.demo.db;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatis {
    // 全局实例
    public static SqlSessionFactory factory;

    // 静态代码块：首次调用时初始化
    static {
        System.out.println("MyBatis factory 初始化 ...");

        // 静态代码块: 初始化 SqlSessionFactory 实例
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 显示地初始化
    public static SqlSessionFactory getInstance() {
        return factory;
    }
}
