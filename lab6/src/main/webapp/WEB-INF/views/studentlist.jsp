<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <title>index-fest</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container p-3 my-3 bg-primary text-white">
 <h1 style="text-align: center;">Great Learning College Of Engineering </h1>
 <hr style="background-color: orange; height: 1px;">
  <h3 style="text-align: center;">GL Festival 2022 </h3>
 <hr style="background-color: orange; height: 1px;">
 <p>
 <a href="list" class="btn btn-outline-warning btn-lg">Participants GL Fest </a>
 <a href="showForm" class="btn btn-outline-warning btn-lg">Add Participant</a>
  <a href="/logout" class="btn btn-outline-warning btn-lg">Logout</a>
 </p>
  <hr style="background-color: rgb(0,255,119); height: 1px;">
  <div class="container">
  <table class="table table-dark">
    <thead>
      <tr>
      	<th>S. No</th>
        <th>Name</th>
        <th>Department</th>
        <th>Country</th>
        <th>Action</th>
      </tr>
    </thead>
 	<c:forEach var="student" items="${students}" varStatus="c">
 	<tbody>
 	<tr>
 	<td>${c.count}</td>
 	<td>${student.name}</td>
 	<td>${student.department}</td>
 	<td>${student.country}</td>
 	<td><a  class="btn btn-success" href="edit?id=${student.id}">Edit</a> 
 	<a  class="btn btn-danger" href="delete?id=${student.id}"  	onclick="return confirm('Are you sure you want to delete this Student?');">Delete</a>
 	 </td>
 	</tr>
 	</tbody>
 	</c:forEach>
  </table>
  </div>
</div>

</body>
</html>