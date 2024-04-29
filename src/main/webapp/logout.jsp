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
    <title>Login</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<form class="container" action="login" method="POST">
    <div class="row">
        <div class="col-auto">
            <label for="name" class="form-label">username</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="name" >
        </div>
        <div class="col-auto">
            <label for="password" class="form-label">password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="password" >
        </div>

    </div>
    <div class="row">
        <div class="col-3">
            <button type="submit" class="btn btn-primary mt-3" >LOGIN</button>
        </div>

    </div>
</form>

</body>
</html>
