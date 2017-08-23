<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employees List</title>
	
	<style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
	
	<h2>List of Employees</h2>
	  
	<table>
		<tr>
			 <th>ID</th>
            <th>Full Name</th>
            <th>Joining Date</th>
            <th>Salary</th>
            <th>SSN</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
        <tr>
        	<td>${employee.id}</td>
        	<td>${employee.name}</td>
        	<td>${employee.joiningDate}</td>
        	<td>${employee.salary}</td>
        	<td>${employee.ssn}</td>
        	<td>
        		<a href="<c:url value='/edit-${employee.ssn}-employee' />">Update</a>
        		|
        		<a href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a>
        	</td>
        </tr>
        </c:forEach>
	</table>
	<br/>
    <a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>