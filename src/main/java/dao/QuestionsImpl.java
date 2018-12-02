package dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class QuestionsImpl implements IQuestions {
    public Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException{
        Reader in = new FileReader("src/main/resources/data.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        return records;

    }
}
