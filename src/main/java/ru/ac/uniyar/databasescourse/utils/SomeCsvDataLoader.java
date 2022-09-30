package ru.ac.uniyar.databasescourse.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ru.ac.uniyar.databasescourse.storage.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomeCsvDataLoader {
        public static List<Student> load(String fileName) throws IOException {
            List<Student> studentsList = new ArrayList<>();
            try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withSkipLines(1).build()) {
                List<String[]> readerList = reader.readAll();
                readerList.forEach(read -> studentsList.add(new Student(
                        read[0],
                        read[1],
                        Integer.parseInt(read[2]),
                        read[3],
                        Double.parseDouble(read[4]),
                        read[5],
                        read[6]
                )));
            } catch (CsvException e) {
                throw new RuntimeException(e);
            }
            return studentsList;
        }
}
