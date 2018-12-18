package ru.otus.spring.hw01.services;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Class to randomize questions order and returns right answer number
 *
 */

public class QuestionsRandomizerImpl implements QuestionsRandomizer {
    private Integer rightAnswer;

    /**
     * Randomizer
     * @param list This list with ansers for curtain quesion.
     *
     * @return TreeMap where Key is answer order number and Value is the answer itself
     */

    public Map<Integer, String>  randomize(List<String> list) {
        Map<Integer, String> questionsOrder = new TreeMap<Integer, String>();
        rightAnswer = 0;
        Integer counter = 0;
        Random r = new Random();
        int indx = r.nextInt(list.size());
        int listLength = list.size();

        for (String s : list){
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
        return questionsOrder;
    }

    /**
     * @return Right answer order number
     */
    public Integer getRightAnswer() {
        return rightAnswer;
    }
}
