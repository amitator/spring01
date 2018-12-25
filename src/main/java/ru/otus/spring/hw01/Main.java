package ru.otus.spring.hw01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.hw01.services.Quiz;
import ru.otus.spring.hw01.services.UserName;

@RestController
@ComponentScan
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
public class Main {

    @Autowired
    private Quiz quiz;

    @Autowired
    private UserName userName;

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

    @RequestMapping("/")
    String home() {
        quiz.run();
        return "Hello World!";
    }
}
