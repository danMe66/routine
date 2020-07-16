package first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import first.dao.UserMapper;
import first.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class selectListTest {

	@Autowired
	private UserMapper userMapper;

//	@Test
//	public void selectList() {
//		// 查询多条信息
//		List<Long> listids = Arrays.asList(1094590409767661570L, 1094592041087729666L);
//		List<User> userlist = userMapper.selectBatchIds(listids);
//		// 开始输出
//		System.err.println("开始查询");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectListByMap() {
//		Map<String, Object> columnMap = new HashMap<>();
//		columnMap.put("age", 28);
//		// 根据表字段查询
//		List<User> userlist = userMapper.selectByMap(columnMap);
//		// 开始输出
//		System.err.println("开始查询");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 1:名字中包含雨并且年龄小于40(name like '%雨%' and age<40)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.like("name", "雨").lt("age", 40);
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 2:名字中包含雨年并且龄大于等于20且小于等于40并且email不为空(name like '%雨%' and age between 20 and 40)
//		// and email is not null)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 3:名字为王姓或者年龄大于等于25，按照年龄降序排列，年龄相同按照id升序排列(name like '王%' or age>=25 order by age desc,id asc)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.likeRight("name", "王").or().ge("age", 25).orderByDesc("age").orderByAsc("id");
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 4:创建日期为2019年2月14日并且直属上级为名字为王姓（date_format(create_time,'%Y-%m-%d')='2019-02-14'
//		// and manager_id in (select id from user where name like '王%')）
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-02-14").inSql("manager_id",
//				"select id from user where name like '王%'");
//
////		queryWrapper.apply("date_format(create_time,'%Y-%m-%d')='2019-02-14' or true or true").inSql("manager_id",
////				"select id from user where name like '王%'");// 此处会SQL注入
//
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 5:名字为王姓并且（年龄小于40或邮箱不为空）(name like '王%' and (age<40 or email is not null))
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.likeRight("name", "王").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 6:名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）（name like '王%' or (age<40 and age>20 and email is not null)）
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.likeRight("name", "王").or(wq -> wq.lt("age", 40).gt("age", 20).isNotNull("email"));
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 7:年龄小于40或邮箱不为空）并且名字为王姓((age<40 or email is not null) and name like '王%')
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.nested(wq->wq.lt("age", 40).or().isNotNull("email")).likeRight("name", "王");
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 8:年龄为30、31、34、35 （age in (30、31、34、35)）
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.in("age", Arrays.asList(30, 31, 34, 35));
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 9:只返回满足条件的其中一条语句即可(limit 1)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.in("age", Arrays.asList(30, 31, 34, 35)).last("limit 1");// SQL注入风险
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		System.err.println("开始输出");
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		// 1:名字中包含雨并且年龄小于40(name like '%雨%' and age<40)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
////		queryWrapper.like("name", "雨").lt("age", 40);
////		queryWrapper.select("name","age").like("name", "雨").lt("age", 40);//查询指定字段
//		queryWrapper.like("name", "雨").lt("age", 40).select(User.class,
//				info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id"));
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapper() {
//		String name = "王";
//		String email = "";
//		condition(name, email);
//	}
//
//	private void condition(String name, String email) {
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
////		if (StringUtils.isNotEmpty(name)) {
////			queryWrapper.like("name", name);
////		}
////		if (StringUtils.isNotEmpty(email)) {
////			queryWrapper.like("email", email);
////		}
//
//		queryWrapper.like(StringUtils.isNotEmpty(name), "name", name).like(StringUtils.isNotEmpty(email), "email",
//				email);
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapperAllEq() {
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("name", "王天风");
//		queryWrapper.allEq(params);
//		List<User> userlist = userMapper.selectList(queryWrapper);
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapperMaps() {// 返回泛型map，可以去除字段值为null的参数
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.select("name", "age").like("name", "雨").lt("age", 40);// 查询指定字段不包含值为null的
//		List<Map<String, Object>> userlist = userMapper.selectMaps(queryWrapper);
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectByWrapperMaps() {// 返回泛型map，可以去除字段值为null的参数
//		// 11.按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄。并且只取年龄总和小于500的组(select avg(age)
//		// avg_age,min(age) min_age,max(age) max_age from user group by manager_id
//		// having sum(age) <500)
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.select("avg(age) avg_age", "min(age) min_age", "max(age) max_age").groupBy("manager_id")
//				.having("sum(age)<{0}", 500);
////		List<Map<String, Object>> userlist = userMapper.selectMaps(queryWrapper);
//		List<Object> userlist = userMapper.selectObjs(queryWrapper);// 只返回一列的时候用此方法
//		userlist.forEach(System.out::println);
//	}

//	@Test
//	public void selectCounts() {
//		// 返回总记录数
//		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//		queryWrapper.like("name", "雨");
//		Integer counts = userMapper.selectCount(queryWrapper);// 只返回一列的时候用此方法
//		System.out.println("总条数：" + counts);
//	}

	@Test
	public void selectLambda() {// Lambda方式
//		LambdaQueryWrapper<User> lambdaQueryWrapper = new QueryWrapper<User>().lambda();
//		LambdaQueryWrapper<User> lambdaQueryWrapper2 = new LambdaQueryWrapper<User>();
		LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
		lambdaQuery.like(User::getName, "雨");
//		List<User> userlist = userMapper.selectList(lambdaQuery);
		List<Map<String, Object>> userlist = userMapper.selectMaps(lambdaQuery);// 查询指定字段不包含值为null的
		userlist.forEach(System.out::println);
	}
}
