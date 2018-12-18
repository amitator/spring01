package ru.otus.spring.hw01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.hw01.config.AppConfig;
import ru.otus.spring.hw01.services.QuestionsReader;
import ru.otus.spring.hw01.services.Quiz;
import ru.otus.spring.hw01.services.UserName;

@ComponentScan(basePackages = "ru.otus.spring")
@Configuration
public class Main {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        Quiz quiz = ctx.getBean(Quiz.class);
        UserName userName = ctx.getBean(UserName.class);
        QuestionsReader reader = ctx.getBean(QuestionsReader.class);
        userName.getUserName();
        quiz.collectQuestions(reader);
        quiz.getAnswer();
        quiz.showResult();
    }
}
