package ru.ac.uniyar.databasescourse.query;

import ru.ac.uniyar.databasescourse.storage.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class StudentTable {

    public static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS students" +
                        "(" +
                        "studentID INT PRIMARY KEY," +
                        "studentName VARCHAR(30) NOT NULL," +
                        "studentSurname VARCHAR(30) NOT NULL" +
                        ");"
        );

        statement.close();
    }

    public static void insertData(Connection connection, HashSet<Student> students) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO students (studentID, studentName, studentSurname) values (?, ?, ?);"
        );

        for (Student student: students) {
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentSurname());
            preparedStatement.execute();
        }

        preparedStatement.close();
    }
}
