<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 05/01/2022
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Edit Student Information</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Edit Student Information</h2>
    <h3>ARE YOU SURE?</h3>
    <form action="/students?action=delete" method="post">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="text" name="id" class="form-control" id="id" value="${student.getId()}">
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" name="name" class="form-control" id="name" value="${student.getName()}">
        </div>
        <div class="form-group">
            <label for="date-of-birth">Date of Birth:</label>
            <input type="date" name="dateOfBirth" class="form-control" id="date-of-birth"
                   value="${student.getDateOfBirth()}">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" name="address" class="form-control" id="address" value="${student.getAddress()}">
        </div>
        <div class="form-group">
            <label for="phone-number">Phone number:</label>
            <input type="text" name="phoneNumber" class="form-control" id="phone-number"
                   value="${student.getPhoneNumber()}">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" name="email" class="form-control" id="email" value="${student.getEmail()}">
        </div>
        <div class="form-group">
            <label for="class-room">Class room:</label>
            <select name="idClassroom" class="form-control" id="class-room">
                <c:forEach items='${requestScope["classrooms"]}' var="classroom">
                    <option value="${classroom.id}">${classroom.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Delete</button>
    </form>
    <a href="/students">
        <button class="btn btn-success">Back to Student List</button>
    </a>

</div>
</body>
</html>



