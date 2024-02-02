<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/2/2024
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users" method="post">
    <h2>Form tạo mới</h2>
    <table>
        <tr>
            <td>name user</td>
            <td>  <input type="text" name="name_User"> </td>
        </tr>
        <tr>
            <td>email user</td>
            <td>  <input type="text" name="email_User"> </td>
        </tr>
        <tr>
            <td>country </td>
            <td> <input type="text" name="country_User"> </td>
        </tr>
        <tr>
            <td>
                <button type="submit">
                    create
                </button>
            </td>
        </tr>
    </table>



</form>
</body>
</html>
