
<%@ page import="java.util.List" %>
<%@ page import="org.example.servlet.TeacherService" %>
<%@ page import="org.example.servlet.Parametr" %>
<%@ page import="org.example.servlet.Teacher" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
    <h1>Teachers </h1>

    <%

        final String name = Parametr.get(request.getParameter("name"));
        final String surname = Parametr.get(request.getParameter("surname"));


    %>

    <form class="container">
       <div class="row">
           <div class="col-auto">
               <label for="name" class="form-label">name</label>
               <input type="text" class="form-control" name="name" id="name" placeholder="name" value="<%=name%>">
           </div>
           <div class="col-auto">
               <label for="surname" class="form-label">surname</label>
               <input type="text" class="form-control" name="surname" id="surname" placeholder="surname" value="<%=surname%>">
           </div>
           <div class="col-auto">
               <label for="age" class="form-label">age</label>
               <input type="text" class="form-control" name="age" id="age" placeholder="age" >
           </div>
           <div class="col-auto">
               <label for="salary" class="form-label">salary</label>
               <input type="text" class="form-control" name="salary" id="salary" placeholder="salary">
           </div>
           <div class="col-auto">
               <label for="university" class="form-label">university</label>
               <select class="form-select" id="university" name="university" name="university">
                   <option value="1">BDU</option>
                   <option value="2">ADNA</option>
               </select>
           </div>

       </div>
        <div class="row">
            <div class="col-1">
                <button type="submit" class="btn btn-primary mt-3" >Search</button>
            </div>


            <div class="col-1">
                <a type="submit" class="btn btn-primary mt-3" href="insert.jsp" >Insert</a>
            </div>

        </div>


    </form>


    <table class="table"
            style="width: 100%">
        <thead>
        <tr>
            <th >ID</th>
            <th >Name</th>
            <th >Surname</th>
            <th >Age</th>
            <th >Salary</th>
            <th >Actions<th>

        </tr>

        </thead>
        <tbody>

         <%
             List<Teacher> teachers = (List<Teacher>) request.getAttribute("teacherList");
             for (int i=0;i<teachers.size();i++) {
                 Teacher teacher = teachers.get(i);
         %>
            <tr <% if (i%2==0) out.println("class=\"table-secondary\"");%>>
                <td>
                    <%=teacher.getId()  %>
                </td>
                <td>
                    <%=teacher.getFirstName()  %>
                </td>
                <td>
                    <%=teacher.getLastName()  %>
                </td>
                <td>
                    <%=teacher.getAge()  %>
                </td>
                <td>
                    <%=teacher.getSalary()  %>
                </td>
                <td>
                    <a href="delete.jsp?id=<%=teacher.getId()%>" class= "btn btn-danger">Delete</a>
                    <a href="update.jsp?id=<%=teacher.getId()%>" class= "btn btn-info">Update</a>
                </td>

            </tr>
        <%
            }
        %>

        </tbody>
    </table>
</body>
</html>