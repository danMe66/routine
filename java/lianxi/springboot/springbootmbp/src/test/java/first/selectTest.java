package first;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import first.dao.UserMapper;
import first.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class selectTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        // 查询单条信息
        User user = userMapper.selectById(1094590409767661570L);
        System.err.println("查询结果：" + user);

    }
}
