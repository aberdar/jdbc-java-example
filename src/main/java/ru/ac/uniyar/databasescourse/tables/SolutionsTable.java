package ru.ac.uniyar.databasescourse.tables;

import ru.ac.uniyar.databasescourse.storage.Solution;
import ru.ac.uniyar.databasescourse.utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class SolutionsTable extends DatabaseConnection {
    private static final String solutionsTableName = "solutions",
                                studentsTableName = "students",
                                reviewersTableName = "reviewers";

    public static void createTable() throws SQLException {
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

    public static void insertTable(HashSet<Solution> solutions) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + solutionsTableName +
                        "(solutionID, studentID, reviewerID, score, hasPass) values (?, ?, ?, ?, ?);"
        );

        for (Solution solution: solutions) {
            preparedStatement.setInt(1, solution.getSolutionID());
            preparedStatement.setInt(2, solution.getStudentID());
            preparedStatement.setInt(3, solution.getReviewerID());
            preparedStatement.setDouble(4, solution.getScore());
            preparedStatement.setString(5, solution.getHasPass());
        }

        preparedStatement.close();
    }
}
