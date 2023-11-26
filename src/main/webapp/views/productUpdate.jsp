<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CaoThanhTung
  Date: 2023/11/14
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/ProductInit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Update Product</title>
</head>
<body>
<h2>Product Info Form</h2>
<br>
<form id="updateProductForm" action="<%=request.getContextPath()%>/productsController/updateProduct"
      enctype="multipart/form-data" method="post">
    <div>
        <label for="productId" class="form-label">Product Id</label>
        <input type="text" class="form-control" id="productId" name="productId"
               placeholder="Ex: P001" readonly value="${updateProduct.productId}">
    </div>
    <div>
        <label for="productName" class="form-label">Product Name</label>
        <input type="text" class="form-control" id="productName" name="productName"
               placeholder="Ex: Soccer ball" value="${updateProduct.productName}">
    </div>
    <div>
        <label for="price" class="form-label">Price</label>
        <input type="number" class="form-control" id="price" name="price" placeholder="Exp: 500.25"
               value="${updateProduct.price}">
    </div>
    <div>
        <label for="title" class="form-label">Title</label>
        <input type="text" class="form-control" id="title" name="title" placeholder="Exp: this is ball"
               value="${updateProduct.title}">
    </div>
    <div>
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" id="description" name="description" placeholder="Exp: high quality ball"
               value="${updateProduct.description}">
    </div>
    <div>
        <label for="image" class="form-label">Upload Image</label>
        <input type="file" class="form-control" id="image" name="productImage"
               value="${updateProduct.image}">
    </div>
    <div>
        <label for="otherImages" class="form-label">Upload Image</label>
        <input type="file" class="form-control" id="otherImages" name="otherImages"
               value="" multiple>
    </div>
    <div>
        <label for="unit" class="form-label">Unit</label>
        <input type="text" class="form-control" id="unit" name="unit" placeholder="Exp: kg/ton"
               value="${updateProduct.unit}">
    </div>
    <div>
        <label for="catalog">Choose Catalog</label>
        <select id="catalog" name="catalog.catalogId" class="form-select" aria-label=".form-select-lg example">
            <option value="${updateProduct.catalog.catalogId}">${updateProduct.catalog.catalogName}</option>
            <c:forEach items="${categoriesList}" var="catalog">
                <c:if test="${updateProduct.catalog.catalogId != catalog.catalogId}">
                    <option value="${catalog.catalogId}">${catalog.catalogName}</option>
                </c:if>
            </c:forEach>
        </select>
    </div>
    <label for="active">Product Status</label>
    <input type="radio" id="active" name="productStatus" ${updateProduct.productStatus?'checked':''} value="true">
    <label for="active">Active</label>
    <input type="radio" id="inactive" name="productStatus" ${updateProduct.productStatus?'':'checked'} value="false">
    <label for="inactive">Inactive</label><br>
    <br>
    <button type="submit" class="btn btn-primary" value="Update">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
