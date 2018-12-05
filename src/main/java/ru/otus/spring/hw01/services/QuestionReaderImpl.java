package ru.otus.spring.hw01.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

/**
 * Reading questions from file
 *
 * @return  Iterable<CSVRecord>
 */

public class QuestionReaderImpl implements IQuestionReader {

    public QuestionReaderImpl(){};

    public Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException {
        String data = "data.csv";
        File dataFile = new File(this.getClass().getResource("/" + data).getFile());
        Reader in = new FileReader(dataFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        return records;
    }
}
