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
<title></title>
<style>
body {
	background-image: url("./img/cry.jpg");
	background-repeat: no-repeat;
	background-position: right top;
	background-color: #F9F8F3;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: maroon;
	text-decoration: none;
}

a:hover {
	color: fuchsia;
	text-decoration: underline;
}

a:active {
	color: cyan;
}
</style>
</head>
<body>
	<div style="text-align: center;">
		<h2>메인화면</h2>
		<h3>
			<%
			if (id == null) {
			%>
			<a href="./member/writeForm.jsp">회원가입</a>
			<a href="./member/loginForm.jsp">로그인</a>
			<%
			} else {
			%>
			<a href="./member/logout.jsp">로그아웃</a>
			<a href="./member/updateForm.jsp">회원정보수정</a>
			<a href="./member/deleteForm.jsp">회원탈퇴</a>
			<a href="./board/boardWriteForm.jsp">글쓰기</a>
			<%
			}
			%>
			<a href="./board/boardList.jsp?pg=1">목록</a>
		</h3>
	</div>
</body>
</html>