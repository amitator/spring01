package services;

import dao.IQuestions;
import dao.QuestionsImpl;

import java.util.*;

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
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<String, List<String>> entry : questionsMap.entrySet()){
            int rightAnswer = 0;
            System.out.println(entry.getKey());

            //Making random order of answers
            int listLength = entry.getValue().size();
            Random r = new Random();
            int indx = r.nextInt(listLength);
            Map<Integer, String> questionsOrder = new TreeMap<Integer, String>();
            Integer counter = 0;

            for (String s : entry.getValue()){
                while(true) {
                    if (!questionsOrder.containsKey(indx)) {
                        if (counter == 0) {
                            rightAnswer = indx + 1;
                        }
                        questionsOrder.put(indx, s);
                        counter++;
                        indx = r.nextInt(listLength);
                        break;
                    }
                    if (counter == listLength) {
                        break;
                    }
                    indx = r.nextInt(listLength);
                }
            }
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
