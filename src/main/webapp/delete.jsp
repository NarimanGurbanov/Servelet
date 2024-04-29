<%--
  Created by IntelliJ IDEA.
  User: n.gurbanov
  Date: 4/7/2024
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<form action="index.jsp">
    Silmeye eminsiniz ?
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>
    <input type="hidden" name="command" value="delete"/>

    <button class="btn btn-primary" type="submit">YES</button>
    <a href="index.jsp" class="btn btn-danger">NO</a>

</form>
</body>
</html>
