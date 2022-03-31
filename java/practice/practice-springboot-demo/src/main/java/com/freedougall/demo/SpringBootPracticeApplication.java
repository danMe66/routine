package com.freedougall.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootPracticeApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringBootPracticeApplication.class, args);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
    }

}
