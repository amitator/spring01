package ru.otus.spring.hw01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.hw01.dao.QuestionsDao;
import ru.otus.spring.hw01.dao.QuestionsDaoImpl;
import ru.otus.spring.hw01.services.*;

@Configuration
@PropertySource("app.properties")
public class AppConfig {

    @Bean
    @Autowired
    QuestionsDao questionsDao (QuestionsReader questionsReader){
        return new QuestionsDaoImpl(questionsReader);
    }

    @Bean
    QuestionsReader questionsReader (@Value("${file.name}") String fileName){
        return new QuestionsReaderImpl(fileName);
    }

    @Bean
    QuestionsRandomizer questionsRandomizer(){
        return new QuestionsRandomizerImpl();
    }

    @Bean
    UserName userName(){
        return new UserNameImpl();
    }

    @Bean
    Quiz quiz(){
        return new QuizImpl();
    }
}
