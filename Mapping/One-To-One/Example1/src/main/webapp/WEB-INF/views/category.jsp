<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Management</title>
</head>
<body>
	
	<div>
		<h2>Create New Category</h2>
		<p style="color:red;">${errorMessage}</p>
		<form:form action="${pageContext.request.contextPath}/categories/add" method="POST" modelAttribute="category">
			<table>
				<tr>
					<td><form:label path="categoryId">Category ID:</form:label></td>
					<td><form:input path="categoryId" readonly="true"/></td>
					<td></td>
				</tr>
				<tr>
					<td><form:label path="categoryName">Category Name:</form:label></td>
					<td><form:input type="text" path="categoryName" autofocus="autofocus"/></td>
					<td><form:errors path="categoryName" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form:form>
		<br>
		<table border="1">
			<tr>
				<td>ID</td>
				<td>CATEGORY NAME</td>
				<td>ACTIONS</td>
			</tr>
			<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>
					<a href="${pageContext.request.contextPath}/categories/${category.categoryId}/update">Update</a>
					|
					<a href="${pageContext.request.contextPath}/categories/${category.categoryId}/delete">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<h2><a href="publications">Adding Publication</a></h2>
	</div>
</body>
</html>