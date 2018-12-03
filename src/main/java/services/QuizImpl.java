package services;

import dao.IQuestions;
import dao.QuestionsImpl;

import java.util.*;

/**
 * Quiz workflow
 */

public class QuizImpl implements IQuiz {

    private int correctCounter = 0;
    Map<String, List<String>> questionsMap;


    public void userName(){
        UserNameImpl userName = new UserNameImpl();
        userName.getUserName();
    }

    public void collectQuestions() {
        questionsMap = new HashMap<String, List<String>>();
        IQuestions questions = new QuestionsImpl();
        questionsMap = questions.getQuestions();

    }

    public void getAnswer() {
        IQuestionsRandomizer questionsRandomizer = new QuestionsRandomizerImpl();
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
}
