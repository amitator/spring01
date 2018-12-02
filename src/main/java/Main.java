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
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            System.out.println(entry.getKey());
            for (String s : entry.getValue()){
                System.out.println(s);
            }
        }
    }
}
