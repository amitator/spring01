package ru.otus.spring.hw01.services;

import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface QuestionsReader {
    Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException;
}
