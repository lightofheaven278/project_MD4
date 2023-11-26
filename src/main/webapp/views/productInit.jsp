<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caothanhtung
  Date: 2023/11/14
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ProductInit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Add Product</title>
</head>
<body>
<h2>Product Info Form</h2>
<br>
<form id="formInitProduct" action="<%=request.getContextPath()%>/productsController/addNewProduct"
      enctype="multipart/form-data" method="post">
    <div>
        <label for="productId" class="form-label">Product ID</label>
        <input type="text" class="form-control" id="productId" name="productId"
               placeholder="Ex: P001">
    </div>
    <div>
        <label for="productName" class="form-label">Product Name</label>
        <input type="text" class="form-control" id="productName" name="productName"
               placeholder="Ex: Soccer ball">
    </div>
    <div>
        <label for="price" class="form-label">Price</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="Exp: 500.25">
    </div>
    <div>
        <label for="title" class="form-label">Title</label>
        <input type="text" class="form-control" id="title" name="title" placeholder="Exp: this is ball">
    </div>
    <div>
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" id="description" name="description"
               placeholder="Exp: high quality ball">
    </div>
    <div>
        <label for="productImage" class="form-label">Upload Image</label>
        <input type="file" class="form-control" id="productImage" name="productImage">
    </div>
    <div>
        <label for="otherImages" class="form-label">Upload Image</label>
        <input type="file" class="form-control" id="otherImages" name="otherImages" multiple>
    </div>
    <div>
        <label for="unit" class="form-label">Unit</label>
        <input type="text" class="form-control" id="unit" name="unit" placeholder="Exp: kg/ton">
    </div>
    <div>
        <label for="catalog">Choose Catalog</label>
        <select id="catalog" name="catalog.catalogId" class="form-select" aria-label=".form-select-lg example">
            <option value=""></option>
            <c:forEach items="${categoriesList}" var="catalog">
                <option value="${catalog.catalogId}">${catalog.catalogName}</option>
            </c:forEach>
        </select>
    </div>
    <label for="active">Product Status</label>
    <input type="radio" id="active" name="productStatus" checked value="true">
    <label for="active">Active</label>
    <input type="radio" id="inactive" name="productStatus" value="false">
    <label for="inactive">Inactive</label><br>
    <br>
    <button type="submit" class="btn btn-primary" value="Update">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
