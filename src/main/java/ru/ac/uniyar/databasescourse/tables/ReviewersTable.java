package ru.ac.uniyar.databasescourse.tables;

import ru.ac.uniyar.databasescourse.storage.Reviewer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class ReviewersTable {
    private static final String reviewersTableName = "reviewers";

    public static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS "+ reviewersTableName +
                        "(" +
                        "reviewerID INT PRIMARY KEY," +
                        "reviewerSurname VARCHAR(30) NOT NULL" +
                        ");"
        );
        statement.close();
    }

    public static void insertData(Connection connection, HashSet<Reviewer> reviewers) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + reviewersTableName +" (reviewerID, reviewerSurname) values (?, ?)"
        );

        for (Reviewer reviewer: reviewers) {
            preparedStatement.setInt(1, reviewer.getReviewerID());
            preparedStatement.setString(2, reviewer.getReviewerSurname());
        }
    }
}
