package ru.ac.uniyar.databasescourse.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connection;

    private static final String URL = String.format("jdbc:mysql://%s", System.getenv("HOST"));
    private static final String user = System.getenv("USER");
    private static final String password = System.getenv("PASSWORD");

    static {
        try {
            connection = createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
