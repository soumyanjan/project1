<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update User</title>
</head>
<h1>update user</h1>
<body>
<form action="${pageContext.request.contextPath}/actionController" method="post">
		Name: <input type="text" name="name" value="${param.name }" required="required"/><br/>
		Subject: <input type="text" name="subject" value="${param.subject }" required="required"/><br/>
		<input type="hidden" name="regId" value="${param.regId }"/>
		<input type="hidden" name="form" value="updateUserOperation"/>
		<input type="submit" value="Update User"/>
</form>


</body>
</html>