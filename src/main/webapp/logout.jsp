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
    <title>Logout</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<form class="container" action="logout" method="POST">
    Are sure to logout ?
    <div class="row">
        <div class="col-3">
            <button type="submit" class="btn btn-primary mt-3" >YES</button>
            <a href="login" >NO</a>
        </div>

    </div>
</form>

</body>
</html>
