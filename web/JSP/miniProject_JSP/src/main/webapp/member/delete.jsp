<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="member.dao.MemberDAO" import="member.bean.MemberDTO"%>

<%
// Data
String name = null;
String id = null;

id = (String) session.getAttribute("id");

// DB
MemberDAO memberDAO = MemberDAO.getInstance();
int count = memberDAO.memberDelete(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<%
	if (count == 0) {
	%>
	<h3>회원 탈퇴 실패</h3>
	<input type='button' value='뒤로' onclick='history.go(-1)'>
	<%
	} else {
	%>
	<script>
		window.onload = function() {
			alert("회원 탈퇴 완료!!");
			location.href = 'loginForm.jsp';
		}

		// <body onload="pick()"> -> js on load function 이용
	</script>
	<%
	}
	%>


</body>
</html>