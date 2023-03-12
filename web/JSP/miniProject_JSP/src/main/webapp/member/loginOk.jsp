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
<link rel="stylesheet" href="../css/logoStyle.css">
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
	<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>
	
	<h1><%=name%>님 안녕하세요.</h1>

	<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js'></script>
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
	<script>
	const container = document.querySelector(".container");

	document.body.addEventListener("mousemove", e => {
	  const x = e.clientX;
	  const y = e.clientY - 35;
	  gsap.to(container, {
	    y: y
	  });
	  gsap.to(".menu-mask", {
	    y: -y
	  });
	});
	</script>
</body>
</html>