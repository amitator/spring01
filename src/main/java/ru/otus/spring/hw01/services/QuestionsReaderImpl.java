package ru.otus.spring.hw01.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Locale;

/**
 * Reading questions from file
 *
 * @return  Iterable<CSVRecord>
 */

@Service
public class QuestionsReaderImpl implements QuestionsReader {

    private MessageSource messageSource;

    private String fileName;

    public QuestionsReaderImpl(MessageSource messageSource){
        this.messageSource = messageSource;
        Locale locale = LocaleContextHolder.getLocale();
        fileName = messageSource.getMessage("file.name", new String[]{""}, locale);
    }

    public Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException {
        InputStream dataFile = this.getClass().getResourceAsStream("/" + fileName);
        Reader in = new InputStreamReader(dataFile);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        return records;
    }
}
