<%--
  Created by IntelliJ IDEA.
  User: TRUONGMAI
  Date: 11/29/2022
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List customer</title>

</head>
<body>
<h1>Customer list</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<form action="" method="get">
    <table>
        <tr>
            <td>
                <input type="text" name="search" placeholder="Search by name">
            </td>
            <td>
                <input type="submit" value="Search">
            </td>
        </tr>
    </table>
</form>
<form action="" method="get">
    <table>
        <tr>
            <td>
                <input type="submit" value="sort by country" name="sort">
            </td>
        </tr>
    </table>
</form>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${requestScope['customers']}" var="cus">
        <tr>
            <td>${cus.getId()}</td>
            <td>
                <a href="/customers?action=view&id=${cus.getId()}">
                        ${cus.getName()}
                </a>
            </td>
            <td>${cus.getEmail()}</td>
            <td>${cus.getAddress()}
            </td>
            <td>
                <a href="/customers?action=edit&id=${cus.getId()}">
                    Edit
                </a>
            </td>
            <td>
                <a href="/customers?action=delete&id=${cus.getId()}">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:forEach var="pageId" begin="1" end="${requestScope['totalPage']}">
    <a href="/customers?page=${pageId}">${pageId}</a>
</c:forEach>
</html>
