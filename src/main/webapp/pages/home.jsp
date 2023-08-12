<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/add-customer-style.css" />
</head>
<body>
	<center>
		<h1 style="color: red; text-align: center;">Employee Registration
			Page</h1>
		<form:form method ="POST" modelAttribute="customer">
			<table>
				<tr>
					<th>Enter Name</th>
					<td><form:input path='name' /></td>
				</tr>
				<tr>
					<th>Enter Password</th>
					<td><form:input path='password' /></td>
				</tr>
				<tr>
					<th>Enter Email</th>
					<td><form:input path='email' /></td>
				</tr>
				<tr>
					<th>Enter Age</th>
					<td><form:input path='age' /></td>
				</tr>
				 
				<tr>
					<td></td>
					<td><input type='submit' value='register'></td>
				</tr>
			</table>
		</form:form>
	</center>
		<div style='clear;both;'>
		<p>
			<a href='${pageContext.request.contextPath}/customer/showPage'>Back to List</a>
		</p>
	</div>
</body>
</html>
