<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
String email = (String) session.getAttribute("email");

session.setAttribute("name", name);
session.setAttribute("id", id);
session.setAttribute("email", email);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<img src="../img/duck.png" width='50' height='50' onclick="location.href='../index.jsp'" style="cursor: pointer;">
	<h3><%=name%>님 로그인</h3>
	
</body>
</html>