package dao;

import org.apache.commons.csv.CSVRecord;
import services.QuestionReaderImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsImpl implements IQuestions {

    QuestionReaderImpl questions = new QuestionReaderImpl();

    public Map<String, List<String>> getQuestions() {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        try {
            Iterable<CSVRecord> records = questions.getQuestions();
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
