package ru.ac.uniyar.databasescourse.query;

import ru.ac.uniyar.databasescourse.storage.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TableMethods {
    private static final String nameDB = "Students";

    public static void create(Statement statement) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Students" +
                "(" +
                    "name VARCHAR(20) NOT NULL ," +
                    "surname VARCHAR(20) NOT NULL ," +
                    "card INT NOT NULL ," +
                    "answer VARCHAR(100)," +
                    "score DOUBLE(2,1)," +
                    "review VARCHAR(30)," +
                    "has_pass VARCHAR(1)" +
                ")";
        statement.executeQuery(query);
        System.out.println("Table has been created.");
    }

    public static void drop(Statement statement, String tableName) throws SQLException {
        String query = "DROP TABLE " + tableName;
        statement.executeQuery(query);
        System.out.println("Table has been drop.");
    }

    public static void insert(Student student, Connection connection) throws SQLException {
        String query = "INSERT INTO " + nameDB +
                "(name, surname, card, answer, score, review, has_pass)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStudent = connection.prepareStatement(query);
        insertStudent.setString(1, student.getName());
        insertStudent.setString(2, student.getSurname());
        insertStudent.setInt(3, student.getCard());
        insertStudent.setString(4, student.getAnswer());
        insertStudent.setDouble(5, student.getScore());
        insertStudent.setString(6, student.getReview());
        insertStudent.setString(7, student.getHas_pass());
        insertStudent.execute();
    }
}