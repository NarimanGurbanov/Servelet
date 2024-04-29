package org.example.servlet.servlet;


import org.example.servlet.Parametr;
import org.example.servlet.Teacher;
import org.example.servlet.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/alma")
public class IndexServlet extends HttpServlet {

    private final TeacherService teacherService = new TeacherService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        final String name = Parametr.get(request.getParameter("name"));
        final String surname = Parametr.get(request.getParameter("surname"));

        List<Teacher> teachers = teacherService.findTeacher(name, surname,null);

        request.getSession().setAttribute("savedTeachers", teachers);

        request.setAttribute("teacherList", teachers);

        request.getRequestDispatcher("armud.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String name = Parametr.get(request.getParameter("name"));
        final String surname = Parametr.get(request.getParameter("surname"));
        final Integer age = Parametr.parseInt(request.getParameter("age"));
        final Double salary = Parametr.parseDouble(request.getParameter("salary"));

        final String command = Parametr.get(request.getParameter("command"));

        final Integer id = Parametr.parseInt(request.getParameter("id"));

        if (command.equals("insert")) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(name);
            teacher.setLastName(surname);
            teacher.setAge(age);
            teacher.setSalary(salary);
            teacherService.insertTeacher(teacher);
            response.sendRedirect("alma");
        } else if (command.equals("update")) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(name);
            teacher.setId(id);
            teacher.setLastName(surname);
            teacher.setAge(age);
            teacher.setSalary(salary);
            teacherService.updateTeacher(teacher);
            response.sendRedirect("alma");
        } else if  (command.equals("delete")) {
            teacherService.deleteTeacher(id);
            response.sendRedirect("alma");
        }
    }

}
