<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 12/12/2023
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Book</title>
</head>
<body>
    <%--map với đối tượng bookNew trong modelMap--%>
    <form action="<%=request.getContextPath()%>/bookController/create" method="post">
        <label for="bookName">Book Name</label>
        <input type="text" id="bookName" name="bookName"/><br>
        <label for="title">Title</label>
        <input type="text" id="title" name="title"/><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description"/><br>
        <label for="price">Price</label>
        <input type="number" id="price" name="price"/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
        <input type="radio" id="inactive" name="status" value="false"/><label for="inactive">Inactive</label><br>
        <input type="submit" value="Create"/>
    </form>
</body>
</html>
