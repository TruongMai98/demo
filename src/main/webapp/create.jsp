<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 11/29/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create customer</title>
</head>
<body>
<h1>Create customer</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" id="email">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" id="address">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/customers">
                        <input type="button" value="No">
                    </a>
                </td>
                <td>
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
