package ru.otus.spring.hw01.dao;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw01.services.QuestionsReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionsDaoImpl implements QuestionsDao {

    private QuestionsReader questionsReader;

    @Autowired
    public QuestionsDaoImpl(@Qualifier("questionsReaderImpl") QuestionsReader questions){
        this.questionsReader = questions;
    }

    public Map<String, List<String>> getQuestions() {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        try {
            Iterable<CSVRecord> records = questionsReader.getQuestions();
            for (CSVRecord record : records) {
                List<String> list = new ArrayList<String>();
                String question = record.get(0);
                for (int i = 1; i < record.size(); i++) {
                    list.add(record.get(i));
                }
                map.put(question, list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

}
