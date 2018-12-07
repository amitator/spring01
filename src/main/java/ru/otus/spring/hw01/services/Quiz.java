package ru.otus.spring.hw01.services;

public interface Quiz {
    void collectQuestions(QuestionsReader reader);
    void getAnswer();
    void showResult();
}
