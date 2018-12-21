package ru.otus.spring.hw01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.hw01.services.Quiz;
import ru.otus.spring.hw01.services.UserName;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        Quiz quiz = ctx.getBean(Quiz.class);
        UserName userName = ctx.getBean(UserName.class);
        userName.getUserName();
        quiz.run();

    }
}
