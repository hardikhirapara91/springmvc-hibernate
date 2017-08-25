<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Manage Contacts</title>
	
	
	<link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<h2>Manage Contacts</h2>
		
		<form:form action="${pageContext.request.contextPath}/add" method="post" modelAttribute="contact">
			<form:input type="hidden" path="id" />
			<table>
				<tr>
					<td><form:label path="firstName">First Name:</form:label></td>
					<td><form:input name="firstName" path="firstName"/></td>
					<td><form:errors path="firstName" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name:</form:label></td>
					<td><form:input name="lastName" path="lastName"/></td>
					<td><form:errors path="lastName" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="telephone">Telephone:</form:label></td>
					<td><form:input name="telephone" path="telephone"/></td>
					<td><form:errors path="telephone" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="email">Email:</form:label></td>
					<td><form:input name="email" path="email"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="createdDate">Created Date:</form:label></td>
					<td><form:input name="createdDate" path="createdDate"/></td>
					<td><form:errors path="createdDate" cssClass="error"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<c:choose>
							<c:when test="${createContact}">
								<input type="submit" value="Create New Contact">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Update Contact">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>	
		</form:form>
		<br>
		<table id="customers">
			<tbody>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Telephone</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${contacts}" var="contact">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.firstName} ${contact.lastName}</td>
					<td>${contact.telephone}</td>
					<td>${contact.email}</td>
					<td>
						<a href="${pageContext.request.contextPath}/contact/${contact.id}">Update</a>
						|
						<a href="${pageContext.request.contextPath}/delete/${contact.id}">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>