<%@ page import="com.example.educationsystemwebabb.Parametr" %>
<%@ page import="com.example.educationsystemwebabb.TeacherService" %>
<%@ page import="com.example.educationsystemwebabb.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: n.gurbanov
  Date: 4/7/2024
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<%
    Integer id = Parametr.parseInt(request.getParameter("id"));
    TeacherService teacherService = new TeacherService();
    Teacher foundTeacher = teacherService.findById(id);
%>
<form class="container" action="index.jsp" method="POST">
    <div class="row">
        <div class="col-auto">
            <label for="name" class="form-label">name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="name" value="<%=foundTeacher.getFirstName()%>" >
        </div>
        <div class="col-auto">
            <label for="surname" class="form-label">surname</label>
            <input type="text" class="form-control" name="surname" id="surname" placeholder="surname" value="<%=foundTeacher.getLastName()%>" >
        </div>
        <div class="col-auto">
            <label for="age" class="form-label">age</label>
            <input type="text" class="form-control" name="age" id="age" placeholder="age" value="<%=foundTeacher.getAge()%>">
        </div>
        <div class="col-auto">
            <label for="salary" class="form-label">salary</label>
            <input type="text" class="form-control" name="salary" id="salary" placeholder="salary" value="<%=foundTeacher.getSalary()%>">
        </div>
            <input type="hidden" name="id" value="<%=foundTeacher.getId()%>"/>
            <input type="hidden" name="command" value="update">
    </div>
    <div class="row">
        <div class="col-3">
            <button type="submit" class="btn btn-primary mt-3" >SAVE</button>
        </div>

    </div>
</form>

</body>
</html>
