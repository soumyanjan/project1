<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="project1.User"%>
<%@ page import="project1.connectorClass" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>User List</h1>
<body>
<table border="1">
				<thead>
					<th>Reg ID</th>
					<th>Name</th>
					<th>Subject</th>
					<th>Operation</th>
				</thead>
				<c:forEach items="${listUsers}" var="user">
			    <c:url var="updateURL" value="actionController">
				<c:param name="page" value="updateUser"></c:param>			
				<c:param name="regId" value="${user.regId}"></c:param>
				<c:param name="Name" value="${user.studentName}"></c:param>
				<c:param name="Subject" value="${user.subject}"></c:param>
				</c:url>
			
				<c:url var="deleteUser" value="actionController">
				<c:param name="page" value="deleteUser"></c:param>			
				<c:param name="regId" value="${user.regId}"></c:param>
				</c:url>			
 				<tr>
 				<td>${user.regId}</td>
 				<td>${user.studentName}</td>
 				<td>${user.subject}</td>
 			<td>
 				<a href="${updateURL}">Update</a>|
 				<a href="${deleteUser}"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
 				</td>
 				</tr>			
				</c:forEach>
			</table>

</body>
</html>