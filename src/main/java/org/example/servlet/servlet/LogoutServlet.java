package org.example.servlet.servlet;

import org.example.servlet.Teacher;
import org.example.servlet.TeacherService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final TeacherService teacherService = new TeacherService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        List<Teacher> list = teacherService.findTeacher(username, null, password);
        if (!list.isEmpty()) {
            final Teacher teacher = list.get(0);
            request.getSession().setAttribute("loggedInUser", teacher);
        }

        response.sendRedirect("alma");


    }
}