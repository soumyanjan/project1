<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<h1>Students</h1>
<body>



<ul>
    <li><a href="<%=request.getContextPath()%>/actionController?page=addUser">Add User</a></li>
   <li><a href="<%=request.getContextPath()%>/actionController?page=listusers">List User</a></li>
</ul>
</body>
</html>