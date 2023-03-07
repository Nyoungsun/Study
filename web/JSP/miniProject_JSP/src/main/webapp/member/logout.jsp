<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	session.removeAttribute("name");
	session.removeAttribute("id");
	
	session.invalidate();
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<h3> 로그아웃</h3>
</body>
<script>
	window.onload=function(){
		alert("로그아웃 되었습니다.");
		location.href='../index.jsp';
	}
	</script>
</html>