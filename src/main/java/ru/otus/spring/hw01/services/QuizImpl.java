package ru.otus.spring.hw01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw01.dao.QuestionsDao;
import ru.otus.spring.hw01.dao.QuestionsDaoImpl;

import java.util.*;

/**
 * Quiz workflow
 */

@Service
public class QuizImpl implements Quiz {

    @Autowired
    private UserNameImpl userName;

    @Autowired
    private MessageSource messageSource;

    private Locale locale = LocaleContextHolder.getLocale();

    private QuestionsReaderImpl reader;

    public QuizImpl(QuestionsReaderImpl reader){
        this.reader = reader;
    }

    private int correctCounter = 0;
    Map<String, List<String>> questionsMap;

    public void collectQuestions() {
        questionsMap = new HashMap<String, List<String>>();
        QuestionsDao questions = new QuestionsDaoImpl(reader);
        questionsMap = questions.getQuestions();

    }

    public void getAnswer() {
        QuestionsRandomizer questionsRandomizer = new QuestionsRandomizerImpl();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<String, List<String>> entry : questionsMap.entrySet()){
            System.out.println(entry.getKey());
            Map<Integer, String> questionsOrder = new TreeMap<Integer, String>();
            questionsOrder = questionsRandomizer.randomize(entry.getValue());
            int rightAnswer = questionsRandomizer.getRightAnswer();
            System.out.println("=========");
            for (Map.Entry<Integer, String> question : questionsOrder.entrySet() ){
                System.out.print(question.getKey() + 1);
                System.out.println(question.getValue());
            }
            System.out.print(messageSource.getMessage("your.answer", new String[]{""}, locale));
            int answer = scanner.nextInt();
            if (rightAnswer == answer) {
                correctCounter++;
            }
        }
    }

    public void showResult() {
        float score = (float)correctCounter/(float)questionsMap.size() * 100;
        System.out.print(messageSource.getMessage("your.score", new String[]{""}, locale) + score + "%");
    }

    public void run(){
        userName.getUserName();
        collectQuestions();
        getAnswer();
        showResult();
    }
}
