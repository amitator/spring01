package ru.otus.spring.hw01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw01.services.IQuiz;
import ru.otus.spring.hw01.services.IUserName;
import ru.otus.spring.hw01.services.QuizImpl;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        IQuiz quiz = context.getBean(IQuiz.class);
        IUserName userName = context.getBean(IUserName.class);

        userName.getUserName();
        quiz.collectQuestions();
        quiz.getAnswer();
        quiz.showResult();
    }
}
