package ru.ac.uniyar.databasescourse.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewerDepartmentsTable {

    public static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE departments"
        )
    }
}
