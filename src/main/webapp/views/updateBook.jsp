<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 12/12/2023
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/bookController/update" method="post">
  <label for="bookId">Book Id</label>
  <input type="text" id="bookId" name="bookId" value="${bookUpdate.bookId}" readonly/><br>
  <label for="bookName">Book Name</label>
  <input type="text" id="bookName" name="bookName" value="${bookUpdate.bookName}"/><br>
  <label for="title">Title</label>
  <input type="text" id="title" name="title" value="${bookUpdate.title}"/><br>
  <label for="description">Description</label>
  <input type="text" id="description" name="description" value="${bookUpdate.description}"/><br>
  <label for="price">Price</label>
  <input type="number" id="price" name="price" value="${bookUpdate.price}"/><br>
  <label for="active">Status</label>
  <input type="radio" id="active" name="status" value="true" ${bookUpdate.status?"checked":""}/><label for="active">Active</label>
  <input type="radio" id="inactive" name="status" value="false" ${bookUpdate.status?"":"checked"}/><label for="inactive">Inactive</label><br>
  <input type="submit" value="Update"/>
</form>
</body>
</html>
