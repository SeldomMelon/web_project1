package com.example.web_project1;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double a = Double.parseDouble((request.getParameter("a")));
        double b = Double.parseDouble((request.getParameter("b")));
        String operation = request.getParameter("operation");
        double result = 0;

        switch (operation) {
            case "adding" :
                result = a + b;
                break;
            case "subtracting" :
                result = a - b;
                break;
            case "multiplication" :
                result = a * b;
                break;
            case "division" :
                result = a / b;
                break;
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Result: " + result + "</h1>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}
