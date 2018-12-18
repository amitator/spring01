package ru.otus.spring.hw01.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Reading questions from file
 *
 * @return  Iterable<CSVRecord>
 */

@Service
public class QuestionsReaderImpl implements QuestionsReader {

    private String fileName;

    public QuestionsReaderImpl(String fileName){
        this.fileName = fileName;
    }

    public Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException {
        File dataFile = new File(this.getClass().getResource("/" + fileName).getFile());
        Reader in = new FileReader(dataFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        return records;
    }
}
