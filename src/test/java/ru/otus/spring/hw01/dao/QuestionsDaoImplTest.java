package ru.otus.spring.hw01.dao;

import org.junit.Test;
import ru.otus.spring.hw01.services.QuestionsReaderImpl;

import static org.junit.Assert.assertNotNull;

public class QuestionsDaoImplTest {
    @Test
    public void getQuestionsNotNull() throws Exception {
        QuestionsDao dao = new QuestionsDaoImpl(new QuestionsReaderImpl("data.csv"));

        assertNotNull(dao.getQuestions());
    }

}