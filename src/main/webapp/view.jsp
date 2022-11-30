<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 11/29/2022
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>View customers</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <td>Id: ${requestScope["customer"].getId()}</td><br>
        <td>Name: ${requestScope["customer"].getName()}</td><br>
        <td>Email: ${requestScope["customer"].getEmail()}</td><br>
        <td>Address: ${requestScope["customer"].getAddress()}</td><br>
    </fieldset>
</form>
</body>
</html>
