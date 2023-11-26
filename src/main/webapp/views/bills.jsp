<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: CaoThanhTung
  Date: 2023/11/16
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/resources/css/categories.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Bill Management</title>
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
                <li class="nav-item" id="logo">
                    <%--                    <img src="<c:url value="/resources/images/logo.png"/>" alt="Logo">--%>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"
                       href="<%=request.getContextPath()%>/loginController/dashboard">Home</a>
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
<h1 style="text-align: center">Bill Management</h1>
<br>
<div style="text-align: center">
    <form style="display: flex; justify-content: center; gap: 5px"
          action="<%=request.getContextPath()%>/billController/searchBill" method="get">
        <button class="btn btn-primary" value="search" type="submit">Search</button>
        <label for="search"></label><input type="text" class="form-control" id="search" name="billSearch"
                                           style="width: 250px">
    </form>
</div>
<br>
<div id="sortSelection">
    <label for="sortBy"></label>
    <select id="sortBy" name="sortBy" class="form-select" aria-label=".form-select-lg example"
            onchange="changeSortBy()">
        <option value="created" ${sortBy.equals("created")?'selected':''}>Created Date</option>
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
        <th scope="col">Bill ID</th>
        <th scope="col">Account ID</th>
        <th scope="col">Created Date</th>
        <th scope="col">Bill Status</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${billList}" var="bill">
        <tr>
            <td>${bill.billId}</td>
            <td>${bill.account.accId}</td>
            <td><fmt:formatDate value="${bill.created}" pattern="dd/MM/yyyy"/></td>
            <c:choose>
                <c:when test="${bill.billStatus == 1}">
                    <td>Approved</td>
                </c:when>
                <c:when test="${bill.billStatus == 2}">
                    <td>Transporting</td>
                </c:when>
                <c:when test="${bill.billStatus == 3}">
                    <td>Received</td>
                </c:when>
                <c:otherwise>
                    <td>Waiting</td>
                </c:otherwise>
            </c:choose>
            <td>
                <a href="<%=request.getContextPath()%>/billDetailsController/getAll?billId=${bill.billId}">Details</a>
                <a href="<%=request.getContextPath()%>/billController/initUpdateBill?billId=${bill.billId}">Update</a>
                <a href="<%=request.getContextPath()%>/billController/cancelBill?billId=${bill.billId}">Cancel</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="<%=request.getContextPath()%>/billController/initAddBill">Add new bill</a>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <c:forEach items="${listPage}" var="page">
            <li class="page-item">
                <a class="page-link"
                   href="<%=request.getContextPath()%>/billController/getAll?page=${page}">${page}
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
