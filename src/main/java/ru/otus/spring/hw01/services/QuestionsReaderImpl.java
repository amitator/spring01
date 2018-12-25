package ru.otus.spring.hw01.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Reading questions from file
 *
 * @return  Iterable<CSVRecord>
 */

@Service
public class QuestionsReaderImpl implements QuestionsReader {

    @Autowired
    private String selectBundleFile;

    public Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException {
        InputStream dataFile = this.getClass().getResourceAsStream("/" + selectBundleFile);
        Reader in = new InputStreamReader(dataFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        return records;
    }
}
