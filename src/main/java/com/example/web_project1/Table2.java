package com.example.web_project1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "table2", value = "/table2")
public class Table2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/my_db",
                    "postgres", "postgres"
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from books");
            while (resultSet.next()) {
                pw.println(resultSet.getString("title") + " " + resultSet.getString("author"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
