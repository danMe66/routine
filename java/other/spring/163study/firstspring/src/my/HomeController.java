package my;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//此处 @RestController 表面这个HelloController生成的是一个Rest格式的应答
@RestController
public class HomeController {

    // 请求路径
    @RequestMapping("/hello")
    public Student helloWord() {
        Student student = new Student();
        student.setId(101);
        student.setName("小明");
        return student;
    }

    @GetMapping("/query")
    public List<Student> query(@RequestParam("from") Integer n1, @RequestParam("to") Integer n2) {
        List<Student> results = new ArrayList<>();
        for (Student s : DemoDB.list) {
            if (s.getId() >= n1 && s.getId() <= n2) {
                results.add(s);
            }
        }
        return results;
    }

    @GetMapping("/list")
    public List<Student> list(Integer from, Integer to) {
        List<Student> results = new ArrayList<>();
        for (Student s : DemoDB.list) {
            if (s.getId() >= from && s.getId() <= to) {
                results.add(s);
            }
        }
        return results;
    }

    // form 表单形式传参
    @PostMapping("/formAdd")
    public Map<String, Object> formAdd(int id, String name) {
        Student student = new Student(id, name);
        DemoDB.list.add(student);
        System.out.println("添加了一条记录：" + name);

        Map<String, Object> results = new HashMap<>();
        results.put("error", 0);
        results.put("results", "ok");
        return results;
    }

    // json 形式传参
    @PostMapping("/jsonAdd")
    public Map<String, Object> jsonAdd(@RequestBody Student student) {
        DemoDB.list.add(student);
        System.out.println("添加了一条记录：" + student.getName());

        Map<String, Object> results = new HashMap<>();
        results.put("error", 0);// 错误码
        results.put("results", "ok");// 输出结果
        return results;
    }

    // URL 传参
    @GetMapping("/{id}/info")
    public String info(@PathVariable int id) {
        String results = null;
        for (Student s : DemoDB.list) {
            if (s.getId() == id) {
                break;
            }
        }
        results = "查到的用户为ID:" + id + "name为:" + DemoDB.list.get(id);
        return results;
    }

    // URL 传参
    @GetMapping("/{id}/remove")
    public String remove(@PathVariable int id) {
        String results = null;
        for (Student s : DemoDB.list) {
            if (s.getId() == id) {
                break;
            }
        }
        results = "查到的用户为ID:" + id + "name为:" + DemoDB.list.get(id);
        return results;
    }

}
