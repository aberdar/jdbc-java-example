package ru.ac.uniyar.databasescourse.tables;

import ru.ac.uniyar.databasescourse.storage.Student;
import ru.ac.uniyar.databasescourse.utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class StudentsTable extends DatabaseConnection {
    private static final String studentsTableName = "students";

    public static void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS "+ studentsTableName +
                        "(" +
                        "studentID INT PRIMARY KEY," +
                        "studentName VARCHAR(30) NOT NULL," +
                        "studentSurname VARCHAR(30) NOT NULL" +
                        ");"
        );
        statement.close();
    }

    public static void insertData(HashSet<Student> students) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + studentsTableName + "(studentID, studentName, studentSurname) values (?, ?, ?);"
        );

        for (Student student: students) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.execute();
        }

        preparedStatement.close();
    }
}
