package ru.otus.spring.hw01.services;

import java.util.List;
import java.util.Map;

public interface IQuestionsRandomizer {
    Map<Integer, String>  randomize(List<String> entry);
    Integer getRightAnswer();
}
