<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 31/12/2021
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div class="container">
    <h2>Student List</h2>

    <form class="example" action="/students?action=search" method="post">
        <input type="text" placeholder="Search.." name="search">
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>

    <a href="/students?action=create">
        <button type="button" class="btn btn-success">Add Student</button>
    </a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Classroom</th>
            <th>Action</th>

        </tr>
        </thead>
        <c:forEach items='${requestScope["studentList"]}' var="student" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${student.name}</td>
                <td>${student.dateOfBirth}</td>
                <td>${student.address}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.email}</td>
                <td>${student.className}</td>
                <td><a href="/students?action=edit&&id=${student.getId()}">
                    <button type="button" class="btn btn-warning">Edit</button>
                </a>
                    <a href="/students?action=delete&&id=${student.getId()}">
                        <button type="button" class="btn btn-danger">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
