package ru.ac.uniyar.databasescourse.tables;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SolutionsTable {
    private static final String solutionsTableName = "solutions",
                                studentsTableName = "students",
                                reviewersTableName = "reviewers";

    public static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS "+ solutionsTableName +
                        "(" +
                        "solutionID INT PRIMARY KEY," +
                        "studentID INT NOT NULL," +
                        "reviewerID INT NOT NULL," +
                        "score DOUBLE(2,1) NOT NULL," +
                        "hasPass ENUM('Yes', 'No')," +
                        "FOREIGN KEY (studentID) REFERENCES " + studentsTableName + "(studentID)," +
                        "FOREIGN KEY (reviewerID) REFERENCES " + reviewersTableName + "(reviewerID)" +
                        ");"
        );

        statement.close();
    }

    public static void insertTable() {}
}
