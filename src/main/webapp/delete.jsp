<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 11/29/2022
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<form method="post">
    <h3>Are you sure?</h3>
<fieldset>
    <legend>Customer information</legend>
    <table>
        <tr>
            <td>Id</td>
            <td>
                <input type="text" name="id" id="id" value="${requestScope["customer"].getId()}" disabled>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" id="name" value="${requestScope["customer"].getName()}">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address" id="address" value="${requestScope["customer"].getAddress()}">
            </td>
        </tr>
        <tr>
            <td>
                <a href="/customers">
                    <input type="button" value="No">
                </a>
            </td>
            <td>
                <input type="submit" value="Yes">
            </td>
        </tr>
    </table>
</fieldset>
</form>
</body>
</html>
