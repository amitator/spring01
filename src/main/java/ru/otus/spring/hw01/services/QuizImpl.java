package ru.otus.spring.hw01.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw01.dao.QuestionsDao;

import java.util.*;

/**
 * Quiz workflow
 */

@Service
public class QuizImpl implements Quiz {

    private UserNameRequestService userName;

    private MessageSource messageSource;

    private BundleChoiceDependOnLocale bundle;

    private QuestionsDao questionsDao;

    public QuizImpl(MessageSource messageSource, UserNameRequestService userName, BundleChoiceDependOnLocale bundle, QuestionsDao questionsDao){
        this.messageSource = messageSource;
        this.userName = userName;
        this.bundle = bundle;
        this.questionsDao = questionsDao;
    }

    private int correctCounter = 0;
    Map<String, List<String>> questionsMap;

    public void collectQuestions() {
        questionsMap = new HashMap<String, List<String>>();
        questionsMap = questionsDao.getQuestions();

    }

    public void getAnswer() {
        QuestionsRandomizer questionsRandomizer = new QuestionsRandomizerImpl();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<String, List<String>> entry : questionsMap.entrySet()){
            System.out.println("\n" + entry.getKey());
            Map<Integer, String> questionsOrder = new TreeMap<Integer, String>();
            questionsOrder = questionsRandomizer.randomize(entry.getValue());
            int rightAnswer = questionsRandomizer.getRightAnswer();
            System.out.println("=========");
            for (Map.Entry<Integer, String> question : questionsOrder.entrySet() ){
                System.out.print(question.getKey() + 1);
                System.out.println(question.getValue());
            }
            System.out.print(messageSource.getMessage("your.answer", new String[]{""}, bundle.getLocale()));
            int answer = scanner.nextInt();
            if (rightAnswer == answer) {
                correctCounter++;
            }
        }
    }

    public void showResult() {
        float score = (float)correctCounter/(float)questionsMap.size() * 100;
        System.out.print("\n" + messageSource.getMessage("your.score", new String[]{""}, bundle.getLocale())
                + score + "%\n\n");
    }

    public void run(){
        userName.getUserName();
        collectQuestions();
        getAnswer();
        showResult();
    }
}
