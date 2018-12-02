package dao;

import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IQuestions {
    Iterable<CSVRecord> getQuestions() throws FileNotFoundException, IOException;
}
