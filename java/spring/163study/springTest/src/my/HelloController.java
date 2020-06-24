package my;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//此处 @RestController 表面这个HelloController生成的是一个Rest格式的应答
@RestController
public class HelloController {

	// 请求路径
	@RequestMapping("/hello")
	public Student helloWord() {

		Student student = new Student();
		student.setId(101);
		student.setName("小明");
		return student;
	}
}
