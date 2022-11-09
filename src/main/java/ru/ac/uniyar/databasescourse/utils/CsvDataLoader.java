package ru.ac.uniyar.databasescourse.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ru.ac.uniyar.databasescourse.storage.Department;
import ru.ac.uniyar.databasescourse.storage.Reviewer;
import ru.ac.uniyar.databasescourse.storage.Solution;
import ru.ac.uniyar.databasescourse.storage.Student;
import ru.ac.uniyar.databasescourse.tables.DepartmentsTable;
import ru.ac.uniyar.databasescourse.tables.ReviewersTable;
import ru.ac.uniyar.databasescourse.tables.SolutionsTable;
import ru.ac.uniyar.databasescourse.tables.StudentsTable;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public class SomeCsvDataLoader {

        public static void insertDatabase(String fileName) throws IOException {
            try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withSkipLines(1).build()) {
                List<String[]> initialData = reader.readAll();

                insertStudentsData(initialData);
                insertReviewersData(initialData);
                insertDepartmentsData(initialData);
                insertSolutionsData(initialData);
            } catch (CsvException | SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private static void insertStudentsData(List<String[]> initialData) throws SQLException {
            HashSet<Student> students = new HashSet<>();
            initialData.forEach(reader ->
                students.add(
                        new Student(
                                Integer.parseInt(reader[0]),
                                reader[1],
                                reader[2]
                        )
                )
            );
            StudentsTable.insertData(students);
        }

        private static void insertReviewersData(List<String[]> initialData) throws SQLException {
            HashSet<Reviewer> reviewers = new HashSet<>();
            initialData.forEach(reader ->
                reviewers.add(
                        new Reviewer(
                                Integer.parseInt(reader[4]),
                                reader[5]
                        )
                )
            );
            ReviewersTable.insertData(reviewers);
        }

        private static void insertDepartmentsData(List<String[]> initialData) throws SQLException {
            HashSet<Department> departments = new HashSet<>();
            initialData.forEach(reader ->
                departments.add(
                        new Department(
                                Integer.parseInt(reader[4]),
                                reader[6]
                        )
                )
            );
            DepartmentsTable.insertData(departments);
        }

        private static void insertSolutionsData(List<String[]> initialData) throws SQLException {
            HashSet<Solution> solutions = new HashSet<>();
            initialData.forEach(reader ->
                solutions.add(
                        new Solution(
                                Integer.parseInt(reader[3]),
                                Integer.parseInt(reader[0]),
                                Integer.parseInt(reader[4]),
                                Double.parseDouble(reader[7]),
                                reader[8]
                        )
                )
            );
            SolutionsTable.insertTable(solutions);
        }
}