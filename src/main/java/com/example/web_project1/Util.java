package com.example.web_project1;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Util {
    public static ResultSet getTable() {
        ResultSet resultSet;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/my_db",
                    "postgres", "postgres"
            );
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from books");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public static void printTable (HttpServletResponse response, String numberOne, String numberTwo) {
        PrintWriter pwTable;
        try {
            pwTable = response.getWriter();
            ResultSet resultSet = Util.getTable();
            while (resultSet.next()) {
                pwTable.println(resultSet.getString(numberOne)+ " "  + resultSet.getString(numberTwo));
            }
        } catch (SQLException | IOException e) {
        throw new RuntimeException(e);
    }
}
}