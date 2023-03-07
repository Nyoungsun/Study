<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = (String) session.getAttribute("id");
String pw = request.getParameter("pw");
boolean exist = false;

if (pw != null) {
	MemberDAO memberDAO = MemberDAO.getInstance();
	exist = memberDAO.isexistPw(id, pw);
}

if (exist) {
	response.sendRedirect("delete.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<style>
div #check_pw {
	color: red;
	font-weight: bold;
	font-size: 12px;
}
</style>
</head>
<body>
	<form name="deleteForm" method="post" action="http://192.168.0.32:8080/MemberJSP/member/deleteForm.jsp">
		<div style="text-align: center;">
			비밀번호 입력: <input type="password" id="pw" name="pw"> <input
				type="button" value="검색" onClick="check()">
			<div id=check_pw>
				<%
				if (pw != null && !exist) {
				%>
				비밀번호가 다릅니다.
				<%
				}
				%>
			</div>
		</div>
	</form>
</body>
<script>
	function check() {
		document.getElementById("check_pw").value == "";

		if (document.getElementById("pw").value == "") {
			document.getElementById("check_pw").innerText = "비밀번호를 입력하세요.";
		} else {
			document.deleteForm.submit;
		}
</script>
</html>
