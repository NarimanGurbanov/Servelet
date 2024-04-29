package org.example.servlet.servlet;

import org.example.servlet.Teacher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/login")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        final List<Teacher> savedTeachers = (List<Teacher> ) request.getSession().getAttribute("savedTeachers");
        PrintWriter out = response.getWriter();
        out.println(savedTeachers);

    }

    public void destroy() {
    }
}