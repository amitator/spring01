import dao.IQuestions;
import dao.QuestionsImpl;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
//        String name = scanner.nextLine();


        Map<String, List<String>> map = new HashMap<String, List<String>>();
        IQuestions questions = new QuestionsImpl();
        try {
            Iterable<CSVRecord> records = questions.getQuestions();
            for (CSVRecord record : records) {
                List<String> list = new ArrayList<String>();
                String question = record.get(0);
                String correctAnswer = record.get(1);
                String nonCorrectOne = record.get(2);
                String nonCorrectTwo = record.get(3);
                String nonCorrectThree = record.get(4);
                list.add(correctAnswer);
                list.add(nonCorrectOne);
                list.add(nonCorrectTwo);
                list.add(nonCorrectThree);
                map.put(question, list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pointsCounter(map);
    }

    public static void pointsCounter(Map<String, List<String>> map){
        Scanner scanner = new Scanner(System.in);
        int correctCounter = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
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
//            System.out.println("Right answer: " + rightAnswer);
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();
            if (rightAnswer == answer) {
                correctCounter++;
            }
        }
        float score = (float)correctCounter/(float)map.size() * 100;
        System.out.println("Your score: " + score + "%");
    }
}
