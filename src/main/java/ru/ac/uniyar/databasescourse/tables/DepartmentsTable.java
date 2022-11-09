package ru.ac.uniyar.databasescourse.tables;

import ru.ac.uniyar.databasescourse.storage.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class DepartmentsTable {
    private static final String departmentsTableName = "departments";
    private static final String referencesTableName = "reviewers";

    public static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(
                "CREATE TABLE IF NOT EXISTS " + departmentsTableName +
                        "(" +
                        "reviewerID INT NOT NULL," +
                        "departmentName VARCHAR(50) NOT NULL," +
                        "FOREIGN KEY (reviewerID) REFERENCES " + referencesTableName + "(reviewerID)" +
                        ");"
        );
        statement.close();
    }

    public static void insertData(Connection connection, HashSet<Department> departments) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO " + departmentsTableName +" (reviewerID, departmentName) values (?, ?)"
        );

        for (Department department: departments) {
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());
        }
    }
}
