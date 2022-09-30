package ru.ac.uniyar.databasescourse.query;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMethods {

    public static void create(Statement statement) throws SQLException {
        String query = "CREATE DATABASE IF NOT EXISTS students;";
        statement.executeQuery(query);
        System.out.println("Database has been created.");
    }

    public static void use(Statement statement) throws SQLException {
        String query = "USE students;";
        statement.executeQuery(query);
        System.out.println("Database student used.");
    }
}
