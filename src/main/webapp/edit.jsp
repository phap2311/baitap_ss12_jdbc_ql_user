<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/2/2024
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users" method="post">
<table border="1px">
    <tr>
        <td>id</td>
        <td><input type="text" name="id" readonly value="${user.getId()}"></td>
    </tr>
    <tr>
        <td>name user</td>
        <td><input type="text" name="name_User" value="${user.getNameUser()}"></td>
    </tr>
    <tr>
        <td> email user</td>
         <td><input type="text" name="email_User" value="${user.getEmailUser()}"></td>
    </tr>
    <tr>
        <td>country user</td>
         <td><input type="text" name="country_User" value="${user.getCountryUser()}"></td>
    </tr>
<tr>
    <td>
        <button type="submit">Edit</button>
    </td>
</tr>
</table>

</form>
</body>
</html>
