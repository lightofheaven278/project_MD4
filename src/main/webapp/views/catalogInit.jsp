<%--
  Created by IntelliJ IDEA.
  User: CaoThanhTung
  Date: 2023/11/13
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Add Catalog</title>
</head>
<body>
<h2>Catalog Info Form</h2>
<br>
<form action="<%=request.getContextPath()%>/categoriesController/addNewCatalog" method="post">
    <div class="col-4">
        <label for="catalogName" class="form-label">Catalog Name</label>
        <input type="text" class="form-control" id="catalogName" name="catalogName"
               placeholder="Ex: Washing Machine">
    </div>
    <div class="col-4">
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" id="description" name="description"
               placeholder="This is washing machine">
    </div>
    <label for="active">Catalog Status</label>
    <input type="radio" id="active" name="catalogStatus" checked value="true">
    <label for="active">Active</label>
    <input type="radio" id="inactive" name="catalogStatus" value="false">
    <label for="inactive">Inactive</label><br>
    <br>
    <button type="submit" class="btn btn-primary" value="Update">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
