package ru.otus.spring.hw01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw01.dao.QuestionsDao;
import ru.otus.spring.hw01.services.QuestionsReader;
import ru.otus.spring.hw01.services.Quiz;
import ru.otus.spring.hw01.services.UserName;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        Quiz quiz = context.getBean(Quiz.class);
        UserName userName = context.getBean(UserName.class);
        QuestionsReader reader = context.getBean(QuestionsReader.class);
        userName.getUserName();
        quiz.collectQuestions(reader);
        quiz.getAnswer();
        quiz.showResult();
    }
}
