<%--
  Created by IntelliJ IDEA.
  User: thaojuice
  Date: 31/12/2021
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <title>Add Student</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Add New Student</h2>
  <form action="/students?action=create" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" name="name" class="form-control" id="name" placeholder="Enter name">
    </div>
    <div class="form-group">
      <label for="date-of-birth">Date of Birth:</label>
      <input type="date" name="dateOfBirth" class="form-control" id="date-of-birth">
    </div>
    <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" name="address" class="form-control" id="address" placeholder="Enter address">
    </div>
    <div class="form-group">
      <label for="phone-number">Phone number:</label>
      <input type="text" name="phoneNumber" class="form-control" id="phone-number" placeholder="Enter phone number">
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" name="email" class="form-control" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="class-room">Class room:</label>
      <select name="idClassroom" class="form-control" id="class-room">
        <c:forEach items='${requestScope["classrooms"]}' var="classroom">
          <option  value="${classroom.id}">${classroom.name}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-success">Add To Student List</button>
  </form>
</div>
</body>
</html>


