package first;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import first.dao.UserMapper;
import first.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void insert() {
		User user = new User();
		user.setName("liu");
		user.setAge(12);
		user.setManagerId(1087982257332887553L);
		user.setCreateTime(LocalDateTime.now());
		int rows = userMapper.insert(user);
		System.out.println("影响记录数：" + rows);

	}
}
