<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Publications Management</title>
</head>
<body>
	
	<div>
		<h2>Create New Publication</h2>
		<p style="color:red;">${errorMessage}</p>
		<form:form action="${pageContext.request.contextPath}/publications/add" method="POST" modelAttribute="publication">
			<table>
				<tr>
					<td><form:label path="pubId">Publication ID:</form:label></td>
					<td><form:input path="pubId" readonly="true"/></td>
					<td></td>
				</tr>
				<tr>
					<td><form:label path="content">Content:</form:label></td>
					<td><form:input type="text" path="content" autofocus="autofocus"/></td>
					<td><form:errors path="content" /></td>
				</tr>
				<tr>
					<td><form:label path="title">Title:</form:label></td>
					<td><form:input type="text" path="title" autofocus="autofocus"/></td>
					<td><form:errors path="title" /></td>
				</tr>
				<tr>
					<td><form:label path="category.categoryId"></form:label>Publication Type:</td>
					<td>
						<form:select path="category.categoryId">
							<option value="-1">Select a type</option>
							<c:forEach var="category" items="${categories}">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
						</form:select>
					</td>
					<td><form:errors path="content" /></td>
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
				<td>Content</td>
				<td>Title</td>
				<td>Action</td>
			</tr>
			<c:forEach var="publication" items="${publications}">
			<tr>
				<td>${publication.pubId}</td>
				<td>${publication.content}</td>
				<td>${publication.title}</td>
				<td>
					<a href="${pageContext.request.contextPath}/publications/${publication.pubId}/update">Update</a>
					|
					<a href="${pageContext.request.contextPath}/publications/${publication.pubId}/delete">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>