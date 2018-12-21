package ru.otus.spring.hw01.services;

import org.springframework.beans.factory.annotation.Autowired;
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
    private QuestionsReaderImpl reader;

    public QuizImpl(QuestionsReaderImpl reader){}

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
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();
            if (rightAnswer == answer) {
                correctCounter++;
            }
        }
    }

    public void showResult() {
        float score = (float)correctCounter/(float)questionsMap.size() * 100;
        System.out.println("Your score: " + score + "%");
    }

    public void run(){
        collectQuestions();
        getAnswer();
        showResult();
    }
}
