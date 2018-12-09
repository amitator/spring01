package ru.otus.spring.hw01.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("QuestionsRandomizerImplTest")
public class QuestionsRandomizerImplTest {
    private List<String> list = new ArrayList<String>();
    private Map<Integer, String> map = new TreeMap<Integer, String>();
    private QuestionsRandomizer randomizer = new QuestionsRandomizerImpl();

    @Before
    public void init(){
        list.add("Right answer");
        list.add("Wrong answer");
        list.add("Wrong answer");
        list.add("Wrong answer");
        map = randomizer.randomize(list);
    }

    @DisplayName("Randomize Answer Test")
    @Test
    public void randomizeAnswerTest() throws Exception {
        assertThat(map).hasEntrySatisfying(1, answer -> {
            assertThat(answer).contains("answer");
        });
    }

    @DisplayName("Randomize Number Test")
    @Test
    public void randomizeNumberTest() throws Exception {
        assertThat(map).containsKeys(0,1,2,3);
    }

    @Test
    public void getRightAnswer() throws Exception {
        assertThat(randomizer.getRightAnswer()).isBetween(0,3);
    }

}