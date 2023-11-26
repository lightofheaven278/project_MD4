<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caothanhtung
  Date: 2023/11/16
  Time: 23:23
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
<h1 style="text-align: center">Bill Management</h1>
<br>
<div style="text-align: center">
    <form style="display: flex; justify-content: center; gap: 5px"
          action="<%=request.getContextPath()%>/productsController/searchProduct" method="get">
        <button class="btn btn-primary" value="search" type="submit">Search</button>
        <label for="search"></label><input type="text" class="form-control" id="search" name="billDetailSearch"
                                           style="width: 250px">
    </form>
</div>
<br>
<table id="table1" class="table">
    <thead>
    <tr>
        <th scope="col">Bill Detail ID</th>
        <th scope="col">Bill ID</th>
        <th scope="col">Product ID</th>
        <th scope="col">Imported Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Total Payment</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${billDetailList}" var="billDetail">
        <tr>
            <td>${billDetail.billDetailId}</td>
            <td>${billDetail.bill.billId}</td>
            <td>${billDetail.product.productId}</td>
            <td>${billDetail.price}</td>
            <td>${billDetail.quantity}</td>
            <td>${billDetail.totalPayment}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
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
