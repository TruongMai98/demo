<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 11/29/2022
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customers</h1>
<p>
  <a href="/customers">Back to customer list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Customer information</legend>
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
        <input type="submit" value="Save">
      </td>
    </tr>
  </fieldset>
</form>
</body>
</html>
