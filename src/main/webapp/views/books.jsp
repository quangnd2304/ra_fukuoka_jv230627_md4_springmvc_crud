<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 12/12/2023
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Book</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Title</th>
        <th>Description</th>
        <th>Price</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBook}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td><fmt:formatNumber value="${book.price}"/> VNĐ</td>
            <td>${book.status?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/bookController/initUpdate?bookId=${book.bookId}">Update</a>
                <a href="<%=request.getContextPath()%>/bookController/delete?bookId=${book.bookId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/bookController/initCreate">Create new book</a>
</body>
</html>
