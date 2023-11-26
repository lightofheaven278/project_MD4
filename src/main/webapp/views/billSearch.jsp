<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caothanhtung
  Date: 2023/11/18
  Time: 22:15
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
  <tr>
    <td>${billSearch.billId}</td>
    <td>${billSearch.account.accId}</td>
    <td><fmt:formatDate value="${billSearch.created}" pattern="dd/MM/yyyy"/></td>
    <c:choose>
      <c:when test="${billSearch.billStatus == 1}">
        <td>Approved</td>
      </c:when>
      <c:when test="${billSearch.billStatus == 2}">
        <td>Transporting</td>
      </c:when>
      <c:when test="${billSearch.billStatus == 3}">
        <td>Received</td>
      </c:when>
      <c:otherwise>
        <td>Waiting</td>
      </c:otherwise>
    </c:choose>
    <td>
      <a href="<%=request.getContextPath()%>/billDetailsController/getAll?billId=${billSearch.billId}">Details</a>
      <a href="<%=request.getContextPath()%>/billController/initUpdateBill?billId=${billSearch.billId}">Update</a>
      <a href="<%=request.getContextPath()%>/billController/cancelBill?billId=${billSearch.billId}">Cancel</a>
    </td>
  </tr>
  </tbody>
</table>
<br>
<a href="<%=request.getContextPath()%>/productsController/initAddBill">Add new bill</a>
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link" href="#">Previous</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>

<script src="<%=request.getContextPath()%>/resources/js/categories.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
