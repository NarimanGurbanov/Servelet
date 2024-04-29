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
    <title>Insert</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<form class="container" action="index.jsp" method="POST">
    <div class="row">
        <div class="col-auto">
            <label for="name" class="form-label">name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="name" >
        </div>
        <div class="col-auto">
            <label for="surname" class="form-label">surname</label>
            <input type="text" class="form-control" name="surname" id="surname" placeholder="surname" >
        </div>
        <div class="col-auto">
            <label for="age" class="form-label">age</label>
            <input type="text" class="form-control" name="age" id="age" placeholder="age" >
        </div>
        <div class="col-auto">
            <label for="salary" class="form-label">salary</label>
            <input type="text" class="form-control" name="salary" id="salary" placeholder="salary">
        </div>
            <input type="hidden" name="command" value="insert">
    </div>
    <div class="row">
        <div class="col-3">
            <button type="submit" class="btn btn-primary mt-3" >SAVE</button>
        </div>

    </div>
</form>

</body>
</html>
