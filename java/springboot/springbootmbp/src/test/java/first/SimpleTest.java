package first;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import first.dao.UserMapper;
import first.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void select() {
        List<User> list = userMapper.selectList(null);
        Assert.assertEquals(5, list.size());
        System.err.println("------开始打印------");
        list.forEach(System.out::println);
        System.err.println("------打印结束------");
    }
}
