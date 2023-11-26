<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CaoThanhTung
  Date: 2023/11/16
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ProductInit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Add Bill</title>
</head>
<body>
<h2>Bill Info Form</h2>
<br>
<form id="formInitProduct" action="<%=request.getContextPath()%>/billController/addNewBill" method="post">
    <div>
        <label for="account">Choose Account</label>
        <select id="account" name="account.accId" class="form-select" aria-label=".form-select-lg example">
            <option value=""></option>
            <c:forEach items="${accountList}" var="account">
                <option value="${account.accId}">${account.email}</option>
            </c:forEach>
        </select>
    </div>
    <label for="active">Bill Status</label>
    <input type="radio" id="active" name="billStatus" checked value="1">
    <label for="active">Active</label>
    <input type="radio" id="inactive" name="billStatus" value="2">
    <label for="inactive">Inactive</label><br>
    <br>
    <hr>
<%--    <h4>------------------------Bill Details---------------------</h4>--%>
    <div>
        <label for="product">Choose Product</label>
        <select id="product" name="product.productId" class="form-select" aria-label=".form-select-lg example">
            <option value=""></option>
            <c:forEach items="${productList}" var="product">
                <option value="${product.productId}">${product.productName}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <label for="price" class="form-label">Imported Price</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="EX: 20.5">
    </div>
    <div>
        <label for="quantity" class="form-label">Quantity</label>
        <input type="number" class="form-control" id="quantity" name="quantity" placeholder="EX: 10">
    </div>
    <br>
    <button type="submit" class="btn btn-primary" value="Add">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
