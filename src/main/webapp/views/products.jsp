<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caothanhtung
  Date: 2023/11/14
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/categories.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Products Management</title>
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
<h1 style="text-align: center">Products Management</h1>
<br>
<div style="text-align: center">
    <form style="display: flex; justify-content: center; gap: 5px"
          action="<%=request.getContextPath()%>/productsController/searchProduct" method="get">
        <button class="btn btn-primary" value="search" type="submit">Search</button>
        <label for="search"></label><input type="text" class="form-control" id="search" name="productSearch"
                                           style="width: 250px">
    </form>
</div>
<br>
<div id="sortSelection">
    <label for="sortBy"></label>
    <select id="sortBy" name="sortBy" class="form-select" aria-label=".form-select-lg example"
            onchange="changeSortBy()">
        <option value="productName" ${sortBy.equals("productName")?'selected':''}>Product Name</option>
        <option value="productId"  ${sortBy.equals("productId")?'selected':''}>Product ID</option>
        <option value="price"  ${sortBy.equals("price")?'selected':''}>Price</option>
    </select>
    <select id="direction" name="direction" class="form-select" aria-label=".form-select-lg example"
            onchange="changeDirection()">
        <option value="ASC" ${direction.equals("ASC")?'selected':''}>ASC</option>
        <option value="DESC" ${direction.equals("DESC")?'selected':''}>DESC</option>
    </select>
</div>
<table id="table1" class="table">
    <thead>
    <tr>
        <th scope="col">Product ID</th>
        <th scope="col">Product Name</th>
        <th scope="col">Price</th>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Image</th>
        <th scope="col">Unit</th>
        <th scope="col">Catalog Name</th>
        <th scope="col">Status</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.title}</td>
            <td>${product.description}</td>
            <td>
                <img src="${product.image}" alt="${product.productName}" height="50" width="50">
            </td>
            <td>${product.unit}</td>
            <td>${product.catalog.catalogName}</td>
            <td>${product.productStatus?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/productsController/initUpdateProduct?productId=${product.productId}">Update</a>
                <a href="<%=request.getContextPath()%>/productsController/deleteProduct?productId=${product.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="<%=request.getContextPath()%>/productsController/initAddProduct">Add new product</a>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <c:forEach items="${listPage}" var="page">
            <li class="page-item">
                <a class="page-link"
                   href="<%=request.getContextPath()%>/productsController/getAll?page=${page}">${page}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>

<script src="<%=request.getContextPath()%>/resources/js/categories.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
