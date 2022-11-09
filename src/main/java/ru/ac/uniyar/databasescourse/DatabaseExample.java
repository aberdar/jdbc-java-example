package ru.ac.uniyar.databasescourse;

import ru.ac.uniyar.databasescourse.storage.Student;
import ru.ac.uniyar.databasescourse.utils.SomeCsvDataLoader;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DatabaseExample {
    private static final String URL = String.format("jdbc:mariadb://%s", System.getenv("MARIADB_HOST"));
    private static final String user = System.getenv("MARIADB_USER");
    private static final String password = System.getenv("MARIADB_PASSWORD");

    public static void main(String[] args) {
        System.out.println("The work has started");

//        try (Connection conn = createConnection()) {
//            try (Statement smt = conn.createStatement()) {
//                DatabaseMethods.create(smt);
//                DatabaseMethods.use(smt);
//                TableMethods.create(smt);
//
//                List<Student> studentsList = SomeCsvDataLoader.load("./solutions.csv");
//                studentsList.forEach(read -> {
//                    try {
//                        TableMethods.insert(read, conn);
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            } catch (SQLException ex) {
//                System.out.printf("Can't create statement: %s\n", ex);
//            } catch (IOException ex) {
//                System.out.println("File not found.");
//            }
//        } catch (SQLException ex) {
//            System.out.printf("Can't create connection: %s\n", ex);
//        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}

