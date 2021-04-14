<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Add User</h1>
<body>
<form action="${pageContext.request.contextPath}/actionController" method="post">
		Name: <input type="text" name="name" required="required"/><br/>
		Subject: <input type="text" name="subject" required="required"/><br/>
		<input type="hidden" name="form" value="addUserOperation">
		<input type="submit" value="Add User">
		</form>
</body>
</html>