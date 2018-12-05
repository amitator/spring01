package ru.otus.spring.hw01.services;

import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IQuestionReader {
    Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException;
}
