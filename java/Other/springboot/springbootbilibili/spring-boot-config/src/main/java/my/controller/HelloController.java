package my.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(String msg) {
        return "Hello Word";
    }

    @RequestMapping("/sayHello")
    public String hi(String msg) {
        return "say hello," + name;
    }

}
