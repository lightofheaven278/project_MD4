<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CaoThanhTung
  Date: 2023/11/13
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/categories.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Categories Management</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item" id="logo" >
                    <%--                    <img src="<c:url value="/resources/images/logo.png"/>" alt="Logo">--%>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/loginController/dashboard">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Management Site
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/categoriesController/getAll">
                            Category Management</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/productsController/getAll">
                            Product Management</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/accountsController/getAll">
                            Account Management</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/billController/getAll">
                            Bill Management</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h1 style="text-align: center">Categories Management</h1>
<br>
<div style="text-align: center">
    <form style="display: flex; justify-content: center; gap: 5px"
          action="<%=request.getContextPath()%>/categoriesController/searchCatalog" method="get">
        <button class="btn btn-primary" value="search" type="submit">Search</button>
        <label for="search"></label><input type="text" class="form-control" id="search" name="categoriesSearch"
                                           style="width: 250px">
    </form>
</div>
<div id="sortSelection">
    <label for="sortBy"></label>
    <select id="sortBy" name="sortBy" class="form-select" aria-label=".form-select-lg example"
            onchange="changeSortBy()">
        <option value="catalogName" ${sortBy.equals("catalogName")?'selected':''}>Catalog Name</option>
    </select>
    <select id="direction" name="direction" class="form-select" aria-label=".form-select-lg example"
            onchange="changeDirection()">
        <option value="ASC" ${direction.equals("ASC")?'selected':''}>ASC</option>
        <option value="DESC" ${direction.equals("DESC")?'selected':''}>DESC</option>
    </select>
</div>
<table id="table1" class="table" border="1">
    <thead>
    <tr>
        <th>Catalog ID</th>
        <th>Catalog Name</th>
        <th>Description</th>
        <th>Catalog Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categoriesList}" var="catalog">
        <tr>
            <td>${catalog.catalogId}</td>
            <td>${catalog.catalogName}</td>
            <td>${catalog.description}</td>
            <td>${catalog.catalogStatus?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/categoriesController/initUpdateCatalog?catalogId=${catalog.catalogId}">Update</a>
                <a href="<%=request.getContextPath()%>/categoriesController/deleteCatalog?catalogId=${catalog.catalogId}">
                    Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="<%=request.getContextPath()%>/categoriesController/initAddCatalog">Add new catalog</a><br>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <c:forEach items="${listPage}" var="page">
            <li class="page-item">
                <a class="page-link"
                   href="<%=request.getContextPath()%>/categoriesController/getAll?page=${page}">${page}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>
<script src="<%=request.getContextPath()%>/resources/js/categories.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
