<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/2/2024
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách người dùng</h2>
<p>
    <a href="users?action=create">
        create new user
    </a>
</p>
<button><a href="/users">Xóa lọc</a></button>
<button><a href="/users?action=arrange">Sắp xếp</a></button>
<form method="post" action="/users">
    <input type="hidden" name="action" value="searchCountry">
    <input type="text" name="countryUser">
    <button type="submit">Tìm kiếm</button>
</form>
<form method="post">

    <table border="1px">
        <tr>
            <td>Stt</td>
            <td>Tên</td>
            <td>Email</td>
            <td>Tỉnh</td>
            <td>Sửa</td>
            <td>Xóa</td>
        </tr>
        <c:forEach items="${ds}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getNameUser()}</td>
                <td>${user.getEmailUser()}</td>
                <td>${user.getCountryUser()}</td>
                <td><a href="users?action=edit&id=${user.getId()}">sửa</a></td>
                <td><a href="users?action=delete&id=${user.getId()}">xóa</a></td>
            </tr>
        </c:forEach>
    </table>

</form>
</body>
</html>
