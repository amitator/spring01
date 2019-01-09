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

    private BundleChoiceDependOnLocale bundle;

    private String fileName;

    public void setBundle(BundleChoiceDependOnLocale bundle){
        this.bundle = bundle;
    }

    public QuestionsReaderImpl(BundleChoiceDependOnLocale bundle){
        this.bundle = bundle;
        fileName = bundle.selectBundleFile();
    }

    public Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException {
        InputStream dataFile = this.getClass().getResourceAsStream("/" + fileName);
        Reader in = new InputStreamReader(dataFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        return records;
    }
}
