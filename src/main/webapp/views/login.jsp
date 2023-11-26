<%--
  Created by IntelliJ IDEA.
  User: CaoThanhTung
  Date: 2023/11/16
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ProductInit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<h2 style="margin-top: 20px">Login</h2>
<br>
<form id="formInitProduct" action="<%=request.getContextPath()%>/loginController/checkPermission" method="post">
    <div>
        <label for="email" class="form-label">Username(Email)</label>
        <input type="text" class="form-control" id="email" name="email"
               placeholder="Ex: tung@gmail.com">
    </div>
    <div>
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <br>
    <button type="submit" class="btn btn-primary" value="Login">Login</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
