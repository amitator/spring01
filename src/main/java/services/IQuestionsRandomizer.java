package services;

import java.util.List;
import java.util.Map;

public interface IQuestionsRandomizer {
    Map<Integer, String>  randomize(List<String> entry);
    Integer getRightAnswer();
}
