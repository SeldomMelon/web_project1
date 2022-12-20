package com.example.web_project1;

import java.io.*;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
//        String lastName = request.getParameter("lastName");
//        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null){
            session.setAttribute("count", 1);
        }else  {
            session.setAttribute("count", count + 1);
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, " + count + "</h1>");
        out.println("<h1>" + new Date() + "</h1>");
        out.println("</body></html>");

//        response.sendRedirect("https://ya.ru");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/first-servlet.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }
    }
    public void destroy() {
    }
}