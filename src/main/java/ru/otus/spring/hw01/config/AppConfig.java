package ru.otus.spring.hw01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("app.properties")
public class AppConfig {

//    @Bean
//    QuestionsDao questionsDao (QuestionsReader questionsReader){
//        return new QuestionsDaoImpl(questionsReader);
//    }

//    @Bean
//    QuestionsReader questionsReader (@Value("${file.name}") String fileName){
//        return new QuestionsReaderImpl(fileName);
//    }


}
