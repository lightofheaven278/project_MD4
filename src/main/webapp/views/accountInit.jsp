<%--
  Created by IntelliJ IDEA.
  User: caothanhtung
  Date: 2023/11/14
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ProductInit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Add Account</title>
</head>
<body>
<h2>Account Info Form</h2>
<br>
<form id="formInitProduct" action="<%=request.getContextPath()%>/accountsController/addNewAccount" method="post">
    <div>
        <label for="email" class="form-label">Username</label>
        <input type="text" class="form-control" id="email" name="email"
               placeholder="Ex: tung@gmail.com">
    </div>
    <div>
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <div>
        <label for="created" class="form-label">Created Date</label>
        <input type="date" class="form-control" id="created" name="created" placeholder="EX: yyyy/MM/dd">
    </div>
    <div>
        <label for="permission">Choose Permission</label>
        <select id="permission" name="permission" class="form-select" aria-label=".form-select-lg example">
            <option value="1">Admin</option>
            <option value="0">User</option>
        </select>
    </div>
    <label for="active">Account Status</label>
    <input type="radio" id="active" name="accStatus" checked value="true">
    <label for="active">Active</label>
    <input type="radio" id="inactive" name="accStatus" value="false">
    <label for="inactive">Inactive</label><br>
    <br>
    <button type="submit" class="btn btn-primary" value="Add">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
